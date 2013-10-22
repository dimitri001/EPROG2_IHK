/*
 *   This program recibes the data from the serial wire(the simulator)
 *  and displays it on the screen
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bma.serial;

import java.util.*;

/**
 * An event indicating that a dataframe has been received
 * The event is passed to a FrameEventListener object that has registered to
 * receive such events using the SerialFrame's addFrameEventListener method.
 *
 * @author Ole Christensen
 * @version 23-7-2004
 */
public class FrameEvent extends EventObject {

    private String dataString;

    public FrameEvent(Object o, String data) {
        super(o);
        dataString = data;
    }

    /**
     * Gets the data string from the frame.
     * @return The data string
     */
    public String getData() {
        return dataString;
    }
}

