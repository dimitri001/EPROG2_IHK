/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bikeproject.model;
import bma.serial.FrameEvent;
import bma.serial.FrameEventListener;
import bma.serial.SerialFrame;
import java.util.TooManyListenersException;

/**
 *
 * @author user
 */
public class M_Receiver_BP implements FrameEventListener {

    private String port;
    private SerialFrame serialFrame = null;
    private String receivedData = "";/*Here it`s kept the data received */

    private String dataStringFormat = "p\\d+s\\d+g\\d+";
    /* p = pulse
     * s = speed
     * g = gear
     * \\d is the space reserved for the int value */
    private BikeDataListBean bikeDataListBean;



    public M_Receiver_BP(String port, BikeDataListBean bikeDataListBean) {
        this.port = port;
        this.bikeDataListBean = bikeDataListBean;
    }

    /**
     * Opens the specified serial port for receiving data.
     * @param port String - The serial port eg. "COM1".
     * @throws TooManyListenersException
     */
    public void openPort() throws TooManyListenersException {
        if (serialFrame == null) {
            serialFrame = new SerialFrame(port);/*Create a serialFrame with the
            specified port */
            serialFrame.addFrameEventListener(this); /* Whit "this" we make that
             an object from this class be a new "FrameEventListener"
             Every event in the serialFrame will be notified to the object of this
             class, everytime that a notificaation appears, is called the method
             "frameReady" from the object of this class
             */
        }
    }

    /**
     * Closes the opened serial port.
     */
    public void closePort() {
        if (serialFrame != null) {
            serialFrame.closePort();
            serialFrame = null;
        }
    }

    /**
     * Returns the String received at the previously opened serial port.
     * @return String - The data received at the serial port.
     */
    public String getReceivedData() {
        return receivedData;
    }

    /**
     * This is the implementation for the interface "FrameEventListener"
     * The method called by the SerialFrame object when a SerialEvent is generated.
     * @param be FrameEvent - The related event created by the SerialFrame object
     * encapsulating the event information.
     */
    public void frameReady(FrameEvent be) {
        receivedData = be.getData();
        String[] dataStringPSG = Parser.parseString(dataStringFormat, receivedData);
        if (dataStringPSG != null) {
            int pulse = Integer.parseInt(dataStringPSG[0]);
            int speed = Integer.parseInt(dataStringPSG[1]);
            int gear = Integer.parseInt(dataStringPSG[2]);
            bikeDataListBean.addBikeData(new BikeData(pulse, speed, gear));
        }
    }


    


}
