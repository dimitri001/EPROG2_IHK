/*
 *  This program recibes the data from the serial wire(the simulator)
 *  and displays it on the screen
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * To install the javax.comm "Java Communications API"
 * whatch the Lesson Mar 17
 */
package bma.serial;

import java.io.*;
import java.util.*;
import javax.comm.*;

/**
 * This class acts as a wrapper around the JAVA IO serial classes.
 * It simplifies communication of # terminated strings.
 * Baudrate = 19200 bits/sec.
 *
 * @author Lars Mortensen/Ole Christensen
 * @version 23-7-2004.
 */
public class SerialFrame implements SerialPortEventListener {

    private FrameEventListener frameEventListener;
    private Enumeration portList;
    private CommPortIdentifier portId;
    private SerialPort serialPort;
    private InputStream inputStream;
    private OutputStream outputStream;
    private String frame;
    private final char STOP_CHAR = '#';
    private final int BAUDRATE = 19200;

    /**
     * Constructs a new SerialFrame instance and opens the port given in the
     * argument port.
     * @param port The port to use for communication (COM1, COM2 etc.)
     * @throws java.util.TooManyListenersException
     */
    public SerialFrame(String port) throws TooManyListenersException {
        portList = CommPortIdentifier.getPortIdentifiers();
        frame = "";
        while (portList.hasMoreElements()) {
            portId = (CommPortIdentifier) portList.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                if (portId.getName().equals(port)) {
                    try {
                        serialPort = (SerialPort) portId.open("", 500);
                        serialPort.setSerialPortParams(
                                BAUDRATE,
                                SerialPort.DATABITS_8,
                                SerialPort.STOPBITS_1,
                                SerialPort.PARITY_NONE);
                        inputStream = serialPort.getInputStream();
                        serialPort.addEventListener(this);
                        serialPort.notifyOnDataAvailable(true);
                    } catch (PortInUseException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (UnsupportedCommOperationException e) {
                        e.printStackTrace();
                    } catch (TooManyListenersException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * Close the port after transmission.
     */
    public void closePort() {
        serialPort.close();
    }

    /**
     * Adds a FrameEventListener to this instance.
     * Only one listener is allowed per port.
     * @param fel The Listener
     * @throws TooManyListenersException
     */
    public void addFrameEventListener(FrameEventListener fel) throws
            TooManyListenersException {
        if (fel == null) {
            return;
        }
        if (frameEventListener != null) {
            throw new TooManyListenersException("Only one listener allowed");
        } else {
            frameEventListener = fel;
        }
    }

    /**
     * Implementation of the SerialPortEventListener method
     * This method receives data from the serial port and sends the received
     * byte Array in a FrameEvent to a FrameEventListener that has registered
     * using addFrameEventListener
     * @param event Event object.
     */
    public void serialEvent(SerialPortEvent event) {
        switch (event.getEventType()) {
            case SerialPortEvent.DATA_AVAILABLE:
                byte[] readBuffer = new byte[20];
                int numBytes = 0;
                int size = 0;
                try {
                    while (inputStream.available() > 0) {
                        numBytes = inputStream.read(readBuffer);
                    }
                    String str = new String(readBuffer);
                    // check for 0 when the transmitter is closed.
                    if (str.charAt(0) == '\u0000') {
                        break;
                    }

                    frame = frame + str.substring(0, numBytes);
                    for (int i = 0; i < frame.length(); i++) {
                    /*Here we look for the STOP_CHAR*/
                        if (frame.charAt(i) == STOP_CHAR) {
                        /* Here we copy the frame whitout the STOP_CAR*/
                            frame = frame.substring(0, size);
                            String temp = frame;
                            frame = "";
                            if (frameEventListener != null) {
                            /*Here is created a new FrameEvent whit an object
                             of this class and whit the string received "temp" */
                                FrameEvent frameEvent = new FrameEvent(this, temp);
                                frameEventListener.frameReady(frameEvent);
                            }
                            break;
                        }
                        size++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.err.println("EVENT TYPE : " + event.getEventType());
                break;
        }
    }

    /**
     * Sends a frame to the serial port.
     * Adds a termination char to the string
     * @param str The string to be sent.
     */
    public void sendFrame(String str) {
        str = str + STOP_CHAR;
        try {
            outputStream = serialPort.getOutputStream();
            outputStream.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

