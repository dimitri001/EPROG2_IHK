/*
 *   This program recibes the data from the serial wire(the simulator)
 *  and displays it on the screen
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bikeproject.model;
import java.io.Serializable;
/**
 *
 * @author ibr
 * This class contains all the data that we use in the simulation
 * the pulse, speed and gear
 */

public class BikeData implements Serializable{

    private int pulse;
    private int speed;
    private int gear;

    public BikeData(int pulse, int speed, int gear) {
        this.pulse = pulse;
        this.speed = speed;
        this.gear = gear;
    }

    /**
     * Get the value of gear
     *
     * @return the value of gear
     */
    public int getGear() {
        return gear;
    }

    /**
     * Set the value of gear
     *
     * @param gear new value of gear
     */
    public void setGear(int gear) {
        this.gear = gear;
    }


    /**
     * Get the value of speed
     *
     * @return the value of speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Set the value of speed
     *
     * @param speed new value of speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Get the value of pulse
     *
     * @return the value of pulse
     */
    public int getPulse() {
        return pulse;
    }

    /**
     * Set the value of pulse
     *
     * @param pulse new value of pulse
     */
    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public BikeData() {
    }

}
