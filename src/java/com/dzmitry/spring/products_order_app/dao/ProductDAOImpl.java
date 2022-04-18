package com.dzmitry.spring.products_order_app.dao;

import com.dzmitry.spring.products_order_app.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getAllProducts() {
        return sessionFactory.getCurrentSession().createQuery("from Product ", Product.class).getResultList();
    }

    @Override
    public Product getProduct(int id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    public void saveOrUpdateProduct(Product product) {
        System.out.println(product);
        if(product.getId()>0){
            sessionFactory.getCurrentSession()
                    .createQuery("update Product set name = '" + product.getName() + "'," +
                            " description = '" + product.getDescription() + "', " +
                            " price = " + product.getPrice() + "where id = " + product.getId()).executeUpdate();
        }else {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(product);
        }
    }
}
