package com.mini2.springbootmicroservice8shipping.model;

import com.mini2.springbootmicroservice8shipping.dto.ShipmentDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shipment")
@Data
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipment_id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "is_delivered")
    private Boolean isDelivered;

    @Enumerated(EnumType.STRING)
    @Column(name = "shipment_status")
    private ShipmentStatus shipmentStatus;

    @Column(name = "shipment_time", nullable = false)
    private LocalDateTime shipmentTime;

    public Shipment() {}

    public Shipment(ShipmentDto shipmentDto) {
        this.shipmentTime = LocalDateTime.now();
        this.orderId = shipmentDto.getOrderId();
        this.isDelivered = shipmentDto.getIsDelivered();
    }
}
