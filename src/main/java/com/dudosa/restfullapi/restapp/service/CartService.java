package com.dudosa.restfullapi.restapp.service;

import com.dudosa.restfullapi.restapp.entity.CartEntity;
import com.packt.modern.api.model.Item;

import javax.validation.Valid;
import java.util.List;

public interface CartService {
    public List<Item> addCartItemsByCustomerId(String customerId, @Valid Item item);
    public List<Item> addOrReplaceItemsByCustomerId(String customerId, @Valid Item item);
    public void deleteCart(String customerId);
    public void deleteItemFromCart(String customerId, String itemId);
    public CartEntity getCartByCustomerId(String customerId);
    public List<Item> getCartItemsByCustomerId(String customerId);
    public Item getCartItemsId(String customerId, String itemId);



}
