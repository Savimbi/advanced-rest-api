package com.dudosa.restfullapi.restapp.repository;

import com.dudosa.restfullapi.restapp.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {
}
