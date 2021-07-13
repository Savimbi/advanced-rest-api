package com.dudosa.restfullapi.restapp.repository;

import com.dudosa.restfullapi.restapp.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<ProductEntity, UUID> {
}
