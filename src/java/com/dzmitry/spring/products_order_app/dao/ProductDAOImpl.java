package com.dzmitry.spring.products_order_app.dao;

import com.dzmitry.spring.products_order_app.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getAllProducts() {
        return sessionFactory.getCurrentSession().createQuery(" from Product ", Product.class).getResultList();
    }

    @Override
    public Product getProduct(int id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    public void saveOrUpdateProduct(Product product) {
        if(product.getCreated() == null){
            product.setCreated(sdf.format(new Timestamp(System.currentTimeMillis())));
        }
        if(product.getId() > 1){
            product.setModified(sdf.format(new Timestamp(System.currentTimeMillis())));
        }
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
    }

    @Override
    public void deleteProduct(int id) {
        sessionFactory.getCurrentSession().createQuery("delete from Product  where id = " + id).executeUpdate();
    }
}
