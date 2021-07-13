package com.dudosa.restfullapi.restapp.service;

import com.dudosa.restfullapi.restapp.entity.ItemEntity;
import com.dudosa.restfullapi.restapp.entity.ProductEntity;
import com.packt.modern.api.model.Item;

import java.util.*;
import java.util.stream.Collectors;

public class ItemServiceImpl implements ItemService{
    @Override
    public ItemEntity toEntity(Item m) {
        ItemEntity e = new ItemEntity();
        e.setProduct(new ProductEntity()
                .setId(UUID.fromString(m.getId())))
                .setPrice(m.getUnitPrice()).setQuantity(m.getQuantity());

        return e;
    }

    @Override
    public List<ItemEntity> toEntityList(List<Item> items) {
        if (Objects.isNull(items)){
            return Collections.emptyList();
        }
        return items.stream().map(m -> toEntity(m)).collect(Collectors.toList());
    }

    @Override
    public Item toModel(ItemEntity e) {
        Item m = new Item();
        m.id(e.getProduct().getId().toString()).unitPrice(e.getPrice()).quantity(e.getQuantity());
        return m;
    }

    @Override
    public List<Item> toModelList(List<ItemEntity> items) {
        if (Objects.isNull(items)){
            return  Collections.emptyList();
        }
        return items.stream().map(e -> toModel(e)).collect(Collectors.toList());
    }
}
