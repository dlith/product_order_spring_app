package com.dzmitry.spring.products_order_app.dao;




import com.dzmitry.spring.products_order_app.entity.Product;
import java.util.List;

public interface ProductDAO {

    public List<Product> getAllProducts();
    public Product getProduct(int id);
    public void saveOrUpdateProduct(Product product);
}
