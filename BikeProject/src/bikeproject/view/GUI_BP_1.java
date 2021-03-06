/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUI_BP_1.java
 *
 * Created on 17-may-2009, 20:13:30
 */

package bikeproject.view;

import bikeproject.model.SaveRestore_FileChooser;
import java.awt.Graphics;
import java.awt.image.*;
import org.jfree.data.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;



import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.*;

import bikeproject.controller.Controller_BP;
import bikeproject.model.*;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class GUI_BP_1 extends javax.swing.JFrame implements PropertyChangeListener {

        /*Here we keep the image of the pulse and speed graphics*/
        BufferedImage frame_pulse = null;
        BufferedImage frame_speed = null;



        /* Boolean vars to show the Pulse or Speed graphics */
        boolean show_pulse = false;
        boolean show_speed = false;
        
        BikeData gui_bikeData = new BikeData();


        //Graphics g;

        XYSeries seriesPulse = new XYSeries("Pulse");//Series for the pulse
        XYSeries seriesSpeed = new XYSeries("Speed");//Series for the Speed


        int counter_sec = 0; /* is a counter, everytime that new data is receive
                                this is incremented in 1 unit*/

        M_Receiver_BP m_Receiver_BP;
        Controller_BP controller_BP;
    /** Creates new form GUI_BP_1 */
    public GUI_BP_1(Controller_BP controller_BP,M_Receiver_BP m_Receiver_BP ) {
        this.controller_BP = controller_BP;
        this.m_Receiver_BP = m_Receiver_BP;
        initComponents();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_Frame = new javax.swing.JFrame();
        button_Save = new javax.swing.JButton();
        button_Open_Data = new javax.swing.JButton();
        button_Show_Pulse = new javax.swing.JButton();
        button_Show_Speed = new javax.swing.JButton();
        button_Start = new javax.swing.JButton();
        button_Stop = new javax.swing.JButton();
        Reset = new javax.swing.JButton();

        javax.swing.GroupLayout main_FrameLayout = new javax.swing.GroupLayout(main_Frame.getContentPane());
        main_Frame.getContentPane().setLayout(main_FrameLayout);
        main_FrameLayout.setHorizontalGroup(
            main_FrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        main_FrameLayout.setVerticalGroup(
            main_FrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bike Project (BMA)");

        button_Save.setText("Save");
        button_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_SaveActionPerformed(evt);
            }
        });

        button_Open_Data.setText("Open Data");
        button_Open_Data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_Open_DataActionPerformed(evt);
            }
        });

        button_Show_Pulse.setText("Show_Pulse");
        button_Show_Pulse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_Show_PulseActionPerformed(evt);
            }
        });

        button_Show_Speed.setText("Show_Speed");
        button_Show_Speed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_Show_SpeedActionPerformed(evt);
            }
        });

        button_Start.setText("Start");
        button_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_StartActionPerformed(evt);
            }
        });

        button_Stop.setText("Stop");
        button_Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_StopActionPerformed(evt);
            }
        });

        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(button_Save)
                .addGap(35, 35, 35)
                .addComponent(button_Open_Data)
                .addGap(63, 63, 63)
                .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(446, Short.MAX_VALUE)
                .addComponent(button_Start)
                .addGap(18, 18, 18)
                .addComponent(button_Stop)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(450, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_Show_Pulse)
                    .addComponent(button_Show_Speed))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(button_Show_Pulse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(button_Show_Speed)
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Stop)
                    .addComponent(button_Start))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Save)
                    .addComponent(button_Open_Data)
                    .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_SaveActionPerformed
        // TODO add your handling code here:
        controller_BP.SaveData();
        //frameFileChooser.FileChooser_Save();

}//GEN-LAST:event_button_SaveActionPerformed

    private void button_StopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_StopActionPerformed
     /*Here we close the prot to not receive data*/
        m_Receiver_BP.closePort();
}//GEN-LAST:event_button_StopActionPerformed

    private void button_Open_DataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_Open_DataActionPerformed
        // TODO add your handling code here:
                //frameFileChooser.FileChooser_Open();
                //this.ResetPulseSpeed();
                controller_BP.OpenData();
}//GEN-LAST:event_button_Open_DataActionPerformed

    private void button_Show_PulseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_Show_PulseActionPerformed

        /* Put the contrary value in the boolean show_pulse  */
        show_pulse = !show_pulse ;
        this.UpdateImages();

    }//GEN-LAST:event_button_Show_PulseActionPerformed

    private void button_Show_SpeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_Show_SpeedActionPerformed

        /* Put the contrary value in the boolean show_pulse  */
        show_speed = !show_speed ;
        this.UpdateImages();
    }//GEN-LAST:event_button_Show_SpeedActionPerformed

    private void button_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_StartActionPerformed
        /*Here we open the prot to start receiveng the data from the simulator */
        try {
               m_Receiver_BP.openPort();
              } catch (TooManyListenersException ex) {
                  Logger.getLogger(GUI_BP_1.class.getName()).log(Level.SEVERE, null, ex);
               }
    }//GEN-LAST:event_button_StartActionPerformed

  /* Reset all the data, the BikeDataListBean and the grapchis of the Pulse and Speed  */
    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        // TODO add your handling code here:

                this.ResetPulseSpeed();
                this.controller_BP.EraseBikeDataListBean();
                this.counter_sec= 0;

                this.UpdateImages();
    }//GEN-LAST:event_ResetActionPerformed

    public void ResetPulseSpeed() {
            //Erase all the data that we show on the user interface
                seriesPulse.clear();
                seriesSpeed.clear();

            //Put zero in the first coordinates of the seriesPulse and seriesSpeed
              /*/  seriesPulse.add(0,0);
                seriesSpeed.add(0,0);
                */
    }



    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @SuppressWarnings("empty-statement")
            public void run() {

            String port = "COM8";/*This port is used by the transmitter*/

            /* Here it`s made the instance for the Modell */
            BikeDataListBean bikeDataListBean = new BikeDataListBean();
            M_Receiver_BP m_Receiver_BP = new M_Receiver_BP(port, bikeDataListBean);

            /* Here it`s made the instance for the control */
            Controller_BP controller_BP = new Controller_BP(bikeDataListBean);

            /*Here it's made the instance for the view */
            GUI_BP_1 gui_BP = new GUI_BP_1(controller_BP,m_Receiver_BP);

            /*Here it's added the GUI_BP like a Listener to the properties of
              bikeDataListBean */
             bikeDataListBean.addPropertyChangeListener(gui_BP);

             gui_BP.setVisible(true);

        
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Reset;
    private javax.swing.JButton button_Open_Data;
    private javax.swing.JButton button_Save;
    private javax.swing.JButton button_Show_Pulse;
    private javax.swing.JButton button_Show_Speed;
    private javax.swing.JButton button_Start;
    private javax.swing.JButton button_Stop;
    private javax.swing.JFrame main_Frame;
    // End of variables declaration//GEN-END:variables

 public BufferedImage createImagePulse() {

  //seriesSpeed.add(x,y)
    int x =counter_sec;
    int y = gui_bikeData.getPulse();

    if ((gui_bikeData.getSpeed()) <= 0)
    {
        x=0;
        y=0;
    }

    seriesPulse.add(x,y);
    //seriesPulse.add(25,23);

    XYDataset dataSet = new XYSeriesCollection(seriesPulse);

    JFreeChart chart = ChartFactory.createXYLineChart(
      "Pulse", // Tittle of the graphic
      "Time", // Caption of axis X
      "Pulse", // Caption of axis Y
      dataSet,
      PlotOrientation.VERTICAL,
      false,
      false,
      false
      );

    // Here we define the size of the image X,Y
    BufferedImage image = chart.createBufferedImage(350, 200);

    return image;

  }


  public BufferedImage createImageSpeed() {
    //XYSeries series = new XYSeries("Speed");
    //seriesSpeed.add(x,y)
    int x =counter_sec;
    int y = gui_bikeData.getSpeed();

    if ((gui_bikeData.getSpeed()) <= 0)
    {
        x=0;
        y=0;
    }

    seriesSpeed.add(x,y);
    //seriesSpeed.remove(0);
    //seriesSpeed.add(25,23);

    XYDataset dataSet = new XYSeriesCollection(seriesSpeed);

    JFreeChart chart = ChartFactory.createXYLineChart(
      "Speed", // Tittle of the graphic
      "Time", // Caption of axis X
      "Km", // Caption of axis Y
      dataSet,
      PlotOrientation.VERTICAL,
      false,
      false,
      false
      );

    // Here we define the size of the image X,Y
    BufferedImage image = chart.createBufferedImage(350, 200);

    return image;

  }

  public void UpdateImages()
  {
      repaint();// calls to paint
      System.out.println( "Image updated" );
      
  }

/*Here we ove */
   @Override
  
  public void paint(Graphics g)
  {
     

   if(show_pulse)
   {
     frame_pulse = this.createImagePulse();
    g.drawImage(frame_pulse,30,30,null);
   }

   if(show_speed )
   {
        frame_speed = this.createImageSpeed();
    g.drawImage(frame_speed,30,240,null);
   }
  }



    /*
     Here is the implementation of the function propertyChange from the
     PropertyChangeListener, this is an abastract method.

     */
       public void propertyChange(PropertyChangeEvent evt) {
        /*BikeData is specified en bma.model */
        this.gui_bikeData = (BikeData) evt.getNewValue();

        System.out.print( "Pulso recibido = " + this.gui_bikeData.getPulse()+ " ");
        System.out.println( "Speed recibida = " + this.gui_bikeData.getSpeed()+ " ");
        System.out.println( "counter_sec = " + this.counter_sec);
        this.UpdateImages();

        this.counter_sec = this.counter_sec +1;
    }


}


