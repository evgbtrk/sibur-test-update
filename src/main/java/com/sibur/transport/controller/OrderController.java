package com.sibur.transport.controller;

import com.sibur.transport.dto.OrderDTO;
import com.sibur.transport.mapper.OrderMapper;
import com.sibur.transport.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {
    OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders().stream().map(OrderMapper.MAPPER::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody OrderDTO orderDTO) {
        System.out.println(orderDTO);
        System.out.println(OrderMapper.MAPPER.toEntity(orderDTO));
        return orderService.createOrder(OrderMapper.MAPPER.toEntity(orderDTO));
    }

    // todo: Разобраться, как возвращать ошибки клиенту
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        try {
            orderService.deleteById(id);
        } catch (ChangeSetPersister.NotFoundException e) {
            System.out.println("not found");
        }
    }

    @PutMapping("/appoint/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable("id") Long id, @RequestBody OrderDTO orderDTO) {
        try {
            System.out.println(orderDTO);
            orderService.appoint(id, OrderMapper.MAPPER.toEntity(orderDTO));
        } catch (ChangeSetPersister.NotFoundException e) {
            e.printStackTrace();
        }
    }
}