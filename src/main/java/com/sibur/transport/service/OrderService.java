package com.sibur.transport.service;

import com.sibur.transport.entity.Driver;
import com.sibur.transport.entity.Order;
import com.sibur.transport.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Long createOrder(Order order) {
        order.setDriver(new Driver());
        return orderRepository.save(order).getId();
    }

    public void deleteById(Long id) throws ChangeSetPersister.NotFoundException {
        orderRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        orderRepository.deleteById(id);
    }

    public void appoint(Long id, Order order) throws ChangeSetPersister.NotFoundException {
        Order order1 = orderRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        order1.setDriver(order.getDriver());
        order1.setVehicle(order.getVehicle());
        order1.setProvider(order.getProvider());
        order1.setStatus("IN_WORK");
        orderRepository.save(order1);
    }
}
