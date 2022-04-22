package com.dzmitry.spring.products_order_app.service;


import com.dzmitry.spring.products_order_app.dao.OrderDAO;
import com.dzmitry.spring.products_order_app.dao.ProductDAO;
import com.dzmitry.spring.products_order_app.entity.Order;
import com.dzmitry.spring.products_order_app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private OrderDAO orderDAO;

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    @Transactional
    public Product getProduct(int id) {
        return productDAO.getProduct(id);
    }

    @Override
    @Transactional
    public void saveOrUpdateProduct(Product product) {
        productDAO.saveOrUpdateProduct(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
    }

    @Override
    @Transactional
    public List<Order> getAllOrders(){
        return orderDAO.getAllOrders();
    }

    @Override
    @Transactional
    public Order getOrder(int id) {
        return orderDAO.getOrder(id);
    }
}
