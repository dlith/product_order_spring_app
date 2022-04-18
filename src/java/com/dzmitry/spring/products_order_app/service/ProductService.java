package com.dzmitry.spring.products_order_app.service;

import com.dzmitry.spring.products_order_app.entity.Product;
import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();
    public Product getProduct(int id);
    public void saveOrUpdateProduct(Product product);
    public void deleteProduct(int id);
}
