package com.dzmitry.spring.products_order_app.dao;

import com.dzmitry.spring.products_order_app.entity.Order;

import java.util.List;

public interface OrderDAO {

    public List<Order> getAllOrders();
    public Order getOrder(int id);
    public void saveOrUpdateOrder(Order order);
    public void deleteOrder(int id);
}
