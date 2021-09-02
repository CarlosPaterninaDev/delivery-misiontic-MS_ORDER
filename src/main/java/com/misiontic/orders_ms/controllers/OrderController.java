package com.misiontic.orders_ms.controllers;

import com.misiontic.orders_ms.exceptions.AccountNotFoundException;
import com.misiontic.orders_ms.exceptions.InsufficientBalanceException;
import com.misiontic.orders_ms.models.Account;
import com.misiontic.orders_ms.models.Order;
import com.misiontic.orders_ms.repositories.AccountRepository;
import com.misiontic.orders_ms.repositories.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class OrderController {

    private final AccountRepository accountRepository;
    private final OrderRepository orderRepository;

    public OrderController(AccountRepository accountRepository, OrderRepository orderRepository) {
        this.accountRepository = accountRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/newOrder")
    Order newOrder(@RequestBody Order order){
        Account accountUser = accountRepository.findById(order.getIdUser()).orElse(null);

        if (accountUser == null)
            throw new AccountNotFoundException("No se encontro una cuenta con el userId: " + order.getIdUser());

        if(accountUser.getBalance() < order.getTotal())
            throw new InsufficientBalanceException("Saldo Insuficiente");

        accountUser.setBalance(accountUser.getBalance() - order.getTotal());
        accountUser.setLastChange(new Date());
        accountRepository.save(accountUser);


        order.setDateOrder(new Date());
        return orderRepository.save(order);

    }


    @GetMapping("/orders/{idUser}")
    List<Order> userOrder(@PathVariable String idUser){
        Account userAccount = accountRepository.findById(idUser).orElse(null);
        if (userAccount == null)
            throw new AccountNotFoundException("No se encontro una cuenta con el userId: " + idUser);

        return orderRepository.findOrderByIdUser(idUser);


    }
}
