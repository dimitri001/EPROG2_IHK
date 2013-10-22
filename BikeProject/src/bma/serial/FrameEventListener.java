/*
 *   This program recibes the data from the serial wire(the simulator)
 *  and displays it on the screen
 *
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bma.serial;

/**
 * The listener interface for receiving FrameEvent's.
 * The class that is interested in processing a FrameEvent implements this
 * interface, and the object created with that class is registered with a
 * SerialFrame instance using the addFrameEventListener method.
 * When the action event occurs, that object's frameReady method is invoked.
 *
 * @author Lars Mortensen
 * @version 23-7-2004
 */
public interface FrameEventListener
        extends java.util.EventListener {

    public void frameReady(FrameEvent be);
}

