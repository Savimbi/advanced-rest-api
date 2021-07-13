package com.dudosa.restfullapi.restapp.repository;

import com.dudosa.restfullapi.restapp.entity.CartEntity;
import com.dudosa.restfullapi.restapp.entity.ItemEntity;
import com.dudosa.restfullapi.restapp.entity.OrderEntity;
import com.dudosa.restfullapi.restapp.entity.OrderItemEntity;
import com.dudosa.restfullapi.restapp.exceptions.ResourceNotFoundException;
import com.dudosa.restfullapi.restapp.service.ItemService;
import com.packt.modern.api.model.NewOrder;
import com.packt.modern.api.model.Order;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Data
@Setter
@Getter
@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepositoryExt{
    @PersistenceContext
    private EntityManager em;

    private ItemRepository itemRepo;
    private AddressRepository addressRepo;
    private CartRepository cRepo;
    private OrderItemRepository oiRepo;
    private ItemService itemService;


    @Override
    public Optional<OrderEntity> insert(NewOrder m) {
        Iterable<ItemEntity> dbItems = itemRepo.findByCustomerId(m.getCustomerId());
        List<ItemEntity> items = StreamSupport.stream(dbItems.spliterator(), false).collect(toList());

        if(items.size() < 1){
            throw  new ResourceNotFoundException(String
            .format("There is no item found in customer's (ID:  %s) cart.", m.getCustomerId()));
        }

        BigDecimal total = BigDecimal.ZERO;
         for (ItemEntity i : items){
             total = (BigDecimal.valueOf(i.getQuantity()).multiply(i.getPrice())).add(total);
         }

        Timestamp orderDate = Timestamp.from(Instant.now());
         em.createNativeQuery("""
                 INSERT INTO ecomm.orders(address_id, card_id, customer_id, order_date, total, status)
                 VALUES(?,?,?,?,?,?)
                 """)
                 .setParameter(1, m.getAddress().getId())
                 .setParameter(2, m.getCard().getId())
                 .setParameter(3, m.getCustomerId())
                 .setParameter(4, orderDate)
                 .setParameter(5, total)
                 .setParameter(6, Order.StatusEnum.CREATED.getValue())
                 .executeUpdate();

         Optional<CartEntity> oCart = cRepo.findByCustomerId(UUID.fromString(m.getCustomerId()));
         CartEntity cart = oCart.orElseThrow(() -> new ResourceNotFoundException(String.format("Cart not found " +
                         "for given (ID: %s)", m.getCustomerId())));
         itemRepo.deleteCartItemJoinById(cart.getItems().stream().map(i-> i.getId()).collect(toList()), cart.getId());
         OrderEntity entity = (OrderEntity) em.createNativeQuery("""
                 SELECT O.* FROM ecomm.orders o where o.customer_id = ? AND o.order_date >= ? """, OrderEntity.class)
                 .setParameter(1, m.getCustomerId())
                 .setParameter(2, OffsetDateTime.ofInstant(orderDate.toInstant(), ZoneId.of("Z")).truncatedTo(
                         ChronoUnit.MICROS))
                 .getSingleResult();
        oiRepo.saveAll(cart.getItems().stream()
                .map(i -> new OrderItemEntity()
                .setOrderId(entity.getId())
                .setItemId(entity.getId()))
                .collect(toList()));

        return Optional.of(entity);
    }
}
