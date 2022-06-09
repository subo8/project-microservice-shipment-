package com.mini2.springbootmicroservice8shipping.repository;

import com.mini2.springbootmicroservice8shipping.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
