package com.dudosa.restfullapi.restapp.repository;

import com.dudosa.restfullapi.restapp.entity.PaymentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PaymentRepository extends CrudRepository<PaymentEntity, UUID> {
}
