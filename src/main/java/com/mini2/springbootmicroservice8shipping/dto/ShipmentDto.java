package com.mini2.springbootmicroservice8shipping.dto;

import com.mini2.springbootmicroservice8shipping.model.Shipment;
import com.mini2.springbootmicroservice8shipping.model.ShipmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShipmentDto {
    private Long id;
    private Long orderId;
    private Boolean isDelivered;
    private ShipmentStatus shipmentStatus;
    private LocalDateTime shipmentTime;

    public ShipmentDto(Shipment shipment) {
        this.setId(shipment.getId());
        this.setOrderId(shipment.getOrderId());
        this.setIsDelivered(shipment.getIsDelivered());
        this.setShipmentStatus(shipment.getShipmentStatus());
        this.setShipmentTime(shipment.getShipmentTime());
    }
}
