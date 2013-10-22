/*
 *  This program recibes the data from the serial wire(the simulator)
 *  and displays it on the screen
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bikeproject.model;

import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ibr
 */

/*
 Here its kept an array of BikeData.
 If there is any change in the array this class, notyfies this change to the
 listeners (the view), calling this method "propertySupport.firePropertyChange"
 */
public class BikeDataListBean implements Serializable {

    private BikeData bikeData;
    public static final String PROP_BIKEDATA = "bikeData";
    /*On each position of the ArrayList is kept an object of the BikeData class,
      The size of the ArrayList is dinamic, and its first position is 0
     */
    public ArrayList<BikeData> bikeDataList = new ArrayList<BikeData>();
    public static final String PROP_BIKEDATALIST = "bikeDataList";



    /**
     * Get the value of bikeDataList
     *
     * @return the value of bikeDataList
     */
    public ArrayList<BikeData> getBikeDataList() {
        return bikeDataList;
    }

    /**
     * Set the value of bikeDataList
     *
     * @param bikeDataList new value of bikeDataList
     */
    public void setBikeDataList(ArrayList<BikeData> bikeDataList) {
        ArrayList<BikeData> oldBikeDataList = this.bikeDataList;
        this.bikeDataList = bikeDataList;
   /* Whit this, all the listeners are informed of the change in bikeDataList */
        propertySupport.firePropertyChange(PROP_BIKEDATALIST, oldBikeDataList, bikeDataList);

        //Here we can make a bucle and call firePropertyChange whit every BikeData item
        // from the BikeDataListBean
    }

    /**
     * Get the value of bikeData
     *
     * @return the value of bikeData
     */
    public BikeData getBikeData() {
        return bikeData;
    }


    private PropertyChangeSupport propertySupport;//posicion cambiada
    /**
     * Set the value of bikeData
     *
     * @param bikeData new value of bikeData
     *
     */
    public void setBikeData(BikeData bikeData) {
        BikeData oldBikeData = this.bikeData;
        this.bikeData = bikeData;
        /* Whit this, all the listeners are informed of the change in BikeData */
        propertySupport.firePropertyChange(PROP_BIKEDATA, oldBikeData, bikeData);
    }


    public BikeDataListBean() {
        /* Here it's created an object of the PropertyChangeSupport class, to 
           make it we need the Bean (the object of the BikeDataListBean), that
           is represented by "this"
         */
        propertySupport = new PropertyChangeSupport(this);
    }

    /* Add a new element of BikeData to the array list, and updates the new
       value of BikeData*/
    public void addBikeData(BikeData bikeData) {
        this.bikeDataList.add(bikeData);
        this.setBikeData(bikeData);
    }

/*Erase all the Data from the BikeDataLisBean*/
    public void EraseBikeDataListBeand(){
        this.bikeDataList.clear();

    }

    /*Add a Listener to the Bound Property of the Bean */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    /*Remove Listener to the Bound Property of the Bean */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}
