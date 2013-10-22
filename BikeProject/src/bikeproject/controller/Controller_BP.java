/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bikeproject.controller;

import bikeproject.model.BikeDataListBean;
import bikeproject.model.M_Receiver_BP;
import bikeproject.model.SaveRestore_FileChooser;
import java.io.File;

/**
 *
 * @author user
 */
public class Controller_BP {

     BikeDataListBean bikeDataListBean;
     M_Receiver_BP m_receiver;
     File myFile; //here we keep the file to be written or read
     SaveRestore_FileChooser frameFileChooser;//Frame that contains the filChooser

   public Controller_BP (BikeDataListBean bikeDataListBean) {

          this.bikeDataListBean = bikeDataListBean;
          frameFileChooser = new SaveRestore_FileChooser(myFile,this.bikeDataListBean);

    }
/*Save Data calling frameFileChooser*/
   public void SaveData(){
       frameFileChooser.FileChooser_Save();

   }
/*Open Data calling frameFileChooser*/
   public void OpenData(){

       frameFileChooser.FileChooser_Open();
   }

   /*Erase BikeDataListBean  bikeDataListBean.EraseBikeDataListBeand*/
    public void EraseBikeDataListBean(){
         bikeDataListBean.EraseBikeDataListBeand();
   }



}
