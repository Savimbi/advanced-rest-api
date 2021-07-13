package com.dudosa.restfullapi.restapp.repository;

import com.dudosa.restfullapi.restapp.entity.CardEntity;
import com.dudosa.restfullapi.restapp.entity.CartEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface CardRepository extends CrudRepository<CardEntity, UUID> {
}
