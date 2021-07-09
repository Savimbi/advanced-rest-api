package com.dudosa.restfullapi.restapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.UUID;

@Data
@Setter
@Getter
@Entity
@Table(name = "authorization")
public class AuthorizationEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @Column(name="AUTHORIZED")
    private boolean authorized;

    @Column(name="TIME")
    private Timestamp time;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "ERROR")
    private String error;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "id")
    private OrderEntity orderEntity;
}
