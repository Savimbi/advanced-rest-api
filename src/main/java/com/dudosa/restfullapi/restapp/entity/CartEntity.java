package com.dudosa.restfullapi.restapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


@Data
@Setter
@Getter
@Entity
@Table(name = "cart")
public class CartEntity {
    @Id
    @GeneratedValue
    @Column(name= "ID", updatable = false, nullable = false)
    private UUID id;
    @OneToOne
    @JoinColumn(name ="USER_ID", referencedColumnName = "ID")
    private UserEntity user;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name ="CART_ITEM",
            joinColumns = @JoinColumn(name = "CARD_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    private List<ItemEntity> items = Collections.emptyList();

}
