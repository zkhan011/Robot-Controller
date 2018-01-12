/*
 * Copyright (c) The openTCS Authors.
 *
 * This program is free software and subject to the MIT license. (For details,
 * see the licensing information (LICENSE.txt) you should have received with
 * this copy of the software.)
 */
package org.opentcs.virtualvehicle;

import org.opentcs.access.Kernel;
import org.opentcs.access.to.order.DestinationCreationTO;
import org.opentcs.access.to.order.TransportOrderCreationTO;
import org.opentcs.data.order.DriveOrder;
import org.opentcs.data.order.TransportOrder;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.opentcs.data.model.Vehicle;

/**
 *
 * @author Heshan
 */
public class TransportOrderCreator {

  Kernel kernal;

  public TransportOrderCreator() {

  }

  public void setKernel(Kernel kernel){
      this.kernal = kernel;
  }

  public void createTransportOrderByLocation(String locationName, String operation){
      // List of destinations the transport order the vehicle is supposed to to travel to
      List<DestinationCreationTO> destinations = new LinkedList<>();

      destinations.add(new DestinationCreationTO(locationName,operation));
      TransportOrderCreationTO orderTo = new TransportOrderCreationTO("External transport order-"+ UUID.randomUUID(),destinations);
      TransportOrder newOrder = kernal.createTransportOrder(orderTo);
      kernal.activateTransportOrder(newOrder.getReference());
  }
  
  public void createTransportOrderByLocation(Vehicle vehicle, String locationName, String operation){
    List<DestinationCreationTO> destinations = new LinkedList<>();
    destinations.add(new DestinationCreationTO(locationName,operation));
    TransportOrderCreationTO orderTo = new TransportOrderCreationTO("External transport order-" + UUID.randomUUID(), destinations).setIntendedVehicleName(vehicle.getName());
    TransportOrder newOrder = kernal.createTransportOrder(orderTo);
    kernal.activateTransportOrder(newOrder.getReference());
  }

  public void createTransportOrderByPoint(String pointName){
      // List of destination the transport order the vehicle is supposed to travel to
      List<DestinationCreationTO> destinations = new LinkedList<>();
      destinations.add(new DestinationCreationTO(pointName, DriveOrder.Destination.OP_MOVE));

      // Todo: check wether we have the explicitly set the vehicle for this to work as in the example
      TransportOrderCreationTO orderTO = new TransportOrderCreationTO("External transport order-"+ UUID.randomUUID(), destinations);

      TransportOrder newOrder = kernal.createTransportOrder(orderTO);
      kernal.activateTransportOrder(newOrder.getReference());
  }
}