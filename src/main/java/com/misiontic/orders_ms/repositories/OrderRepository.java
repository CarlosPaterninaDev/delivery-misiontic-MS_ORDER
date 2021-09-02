package com.misiontic.orders_ms.repositories;

import com.misiontic.orders_ms.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findOrderByIdUser(String idUser);

}
