package com.dudosa.restfullapi.restapp.repository;

import com.dudosa.restfullapi.restapp.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AddressRepository extends CrudRepository<AddressEntity, UUID> {
}
