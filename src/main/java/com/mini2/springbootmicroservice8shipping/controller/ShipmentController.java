package com.mini2.springbootmicroservice8shipping.controller;

import com.mini2.springbootmicroservice8shipping.dto.ShipmentDto;
import com.mini2.springbootmicroservice8shipping.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/shipment")
public class ShipmentController {
    @Autowired
    private ShipmentService shipmentService;

    @GetMapping
    public ResponseEntity<List<ShipmentDto>> getShipments() {
        List<ShipmentDto> body = shipmentService.findAll();
        return new ResponseEntity<List<ShipmentDto>>(body, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addShipment(@RequestBody ShipmentDto shipmentDto) {
        return new ResponseEntity<>(shipmentService.addShipment(shipmentDto), HttpStatus.CREATED);
    }

    @PostMapping("{shipmentId}")
    public ResponseEntity<?> updateShipment(@PathVariable("shipmentId") Long shipmentId, @RequestBody ShipmentDto shipmentDto) {
        return new ResponseEntity<>(shipmentService.updateShipment(shipmentId, shipmentDto), HttpStatus.OK);
    }
}
