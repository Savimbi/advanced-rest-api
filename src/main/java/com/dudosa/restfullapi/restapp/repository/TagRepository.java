package com.dudosa.restfullapi.restapp.repository;

import com.dudosa.restfullapi.restapp.entity.TagEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TagRepository extends CrudRepository<TagEntity, UUID> {
}
