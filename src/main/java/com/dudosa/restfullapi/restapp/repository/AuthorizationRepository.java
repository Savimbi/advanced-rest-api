package com.dudosa.restfullapi.restapp.repository;

import com.dudosa.restfullapi.restapp.entity.AuthorizationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AuthorizationRepository extends CrudRepository<AuthorizationEntity, UUID> {
}
