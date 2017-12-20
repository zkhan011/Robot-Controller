/*
 * Copyright (c) The openTCS Authors.
 *
 * This program is free software and subject to the MIT license. (For details,
 * see the licensing information (LICENSE.txt) you should have received with
 * this copy of the software.)
 */
package org.opentcs.virtualvehicle;

import org.opentcs.data.model.Vehicle;

public class SerialCommunicationFactory {
    private static final SerialCommunication SERIAL_COMMUNICATION = new SerialCommunication();
    private static Byte vehicleId = 0;
        
    
    public SerialCommunicationFactory(LoopbackCommunicationAdapter CommunicationAdapter){        
        synchronized(SERIAL_COMMUNICATION){
          SerialCommunication.connectToCommunicationAdapter(vehicleId, CommunicationAdapter); 
        }
        try{
          //Change the com port when needed
          SERIAL_COMMUNICATION.connect("COM6");
        } catch (Exception e){
          System.out.println("Error");
        }
    }

  public  SerialCommunication getSerialCommunication() {
    return SERIAL_COMMUNICATION;
  }    
    
}
