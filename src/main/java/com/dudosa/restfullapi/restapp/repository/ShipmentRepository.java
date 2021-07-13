package com.dudosa.restfullapi.restapp.repository;

import com.dudosa.restfullapi.restapp.entity.ShipmentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ShipmentRepository extends CrudRepository<ShipmentEntity, UUID> {
}
