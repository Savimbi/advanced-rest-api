package com.dudosa.restfullapi.restapp.repository;

import com.dudosa.restfullapi.restapp.entity.OrderEntity;
import com.packt.modern.api.model.NewOrder;

import java.util.Optional;

public interface OrderRepositoryExt {
    Optional<OrderEntity> insert(NewOrder m);
}
