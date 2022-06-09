package com.mini2.springbootmicroservice8shipping.service;

import com.mini2.springbootmicroservice8shipping.dto.ShipmentDto;
import com.mini2.springbootmicroservice8shipping.model.Shipment;

import java.util.List;

public interface ShipmentService {
    List<ShipmentDto> findAll();

    Shipment addShipment(ShipmentDto shipmentDto);

    Shipment updateShipment(Long shipmentId, ShipmentDto shipmentDto);
}
