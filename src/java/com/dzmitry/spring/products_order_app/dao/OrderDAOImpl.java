package com.dzmitry.spring.products_order_app.dao;

import com.dzmitry.spring.products_order_app.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> getAllOrders() {
        return sessionFactory.getCurrentSession().createQuery(" from Order ", Order.class).getResultList();
    }

    @Override
    public Order getOrder(int id) {
        return sessionFactory.getCurrentSession().get(Order.class, id);
    }

    @Override
    public void saveOrUpdateOrder(Order order) {
        if(order.getCreated() == null){
            order.setCreated(ProductDAOImpl.sdf.format(new Timestamp(System.currentTimeMillis())));
        }
        if(order.getId() > 1){
            order.setModified(ProductDAOImpl.sdf.format(new Timestamp(System.currentTimeMillis())));
        }
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(order);
    }

    @Override
    public void deleteOrder(int id) {
        sessionFactory.getCurrentSession().createQuery("delete from Order  where id = " + id).executeUpdate();
    }
}
