package com.mini2.springbootmicroservice8shipping.service;

import com.mini2.springbootmicroservice8shipping.dto.ShipmentDto;
import com.mini2.springbootmicroservice8shipping.model.Shipment;
import com.mini2.springbootmicroservice8shipping.model.ShipmentStatus;
import com.mini2.springbootmicroservice8shipping.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService{

    @Autowired
    private final ShipmentRepository shipmentRepository;

    public static ShipmentDto getShipmentDto(Shipment shipment) {
        ShipmentDto shipmentDto = new ShipmentDto(shipment);
        return shipmentDto;
    }

    @Override
    public List<ShipmentDto> findAll() {
        List<Shipment> shipments = shipmentRepository.findAll();
        List<ShipmentDto> shipmentDtos = new ArrayList<>();
        for (Shipment shipment: shipments) {
            ShipmentDto shipmentDto = getShipmentDto(shipment);
            shipmentDtos.add(shipmentDto);
        }
        return shipmentDtos;
    }

    public static Shipment getShipment(ShipmentDto shipmentDto) {
        Shipment shipment = new Shipment(shipmentDto);
        return shipment;
    }

    @Override
    public Shipment addShipment(ShipmentDto shipmentDto) {
        Shipment shipment = getShipment(shipmentDto);
        shipment.setShipmentTime(LocalDateTime.now());
        shipment.setIsDelivered(false);
        shipment.setShipmentStatus(ShipmentStatus.PREPARING);
        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment updateShipment(Long shipmentId, ShipmentDto shipmentDto) {
        Shipment shipment = getShipment(shipmentDto);
        shipment.setId(shipmentId);
        shipment.setIsDelivered(true);
        shipment.setShipmentStatus(ShipmentStatus.DELIVERED);
        return shipmentRepository.save(shipment);
    }
}
