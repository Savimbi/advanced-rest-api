package com.dudosa.restfullapi.restapp.repository;

import com.dudosa.restfullapi.restapp.entity.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderItemRepository extends CrudRepository<OrderItemEntity, UUID> {
}
