/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printerepsonpos;

import java.util.logging.Level;
import java.util.logging.Logger;
import jpos.*;
import jpos.util.JposPropertiesConst;

/**
 *
 * @author jorgequiguango
 */
public class PrinterEpsonPos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.setProperty(JposPropertiesConst.JPOS_POPULATOR_FILE_PROP_NAME, "C:\\epson\\Jpos.xml");
//        System.setProperty(JposPropertiesConst.JPOS_POPULATOR_FILE_PROP_NAME, "/app/JavaPos/jpos.xml");
        POSPrinterControl114 ptr = (POSPrinterControl114) new POSPrinter();
//        POSPrinterControl113 ptr = (jpos.POSPrinterControl113) new POSPrinter();
//                POSPrinter ptr = new POSPrinter();
        

        try {
            //Open the device.
            
            //Use the name of the device that connected with your computer.
            ptr.open("POSPrinter");

            //Get the exclusive control right for the opened device.
            //Then the device is disable from other application.
            ptr.claim(1000);

            //Enable the device.
            ptr.setDeviceEnabled(true);

            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "Hello JavaPOS\n");
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\n");
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\n");
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\n");
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\n");
            ptr.printNormal(POSPrinterConst.PTR_S_RECEIPT, "\n");

            ptr.setDeviceEnabled(false);

            //Release the device exclusive control right.
            ptr.release();

            //Finish using the device.
            ptr.close();
        } catch (JposException ex) {
            Logger.getLogger(PrinterEpsonPos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
