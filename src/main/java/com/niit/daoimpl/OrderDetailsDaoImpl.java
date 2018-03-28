package com.niit.daoimpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.OrderDetailsDao;
import com.niit.model.OrderDetails;


@Repository
public class OrderDetailsDaoImpl implements OrderDetailsDao{
	@Autowired
	SessionFactory sessionFactory;
	public OrderDetailsDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertOrderDetails(OrderDetails orderDetails)
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(orderDetails.getShipping());
		session.save(orderDetails.getBilling());
		session.save(orderDetails);
		}
	
	public OrderDetails getOrderDetails(String username,int cart_id)
	{
		Session session=sessionFactory.openSession();
		Query q=session.createQuery("from OrderDetails where username=:username and cart_id=:cart_id");
		q.setParameter("username", username);
		q.setParameter("cart_id", cart_id);
		List<OrderDetails> list=q.list();
		session.close();
		OrderDetails orderDetails=null;
		for(OrderDetails item:list)
			orderDetails=item;
		return orderDetails;
	}
	
	@Transactional
	public void deleteOrderDetails(String username)
	{
		Session session=sessionFactory.openSession();
		Query q=session.createQuery("from OrderDetails where username=:username");
		q.setParameter("username", username);
		List<OrderDetails> list=q.list();
		session.close();
		for(OrderDetails item:list){
		sessionFactory.getCurrentSession().delete(item.getBilling());
		sessionFactory.getCurrentSession().delete(item.getShipping());
		sessionFactory.getCurrentSession().delete(item);		
		}
	}
	
}

