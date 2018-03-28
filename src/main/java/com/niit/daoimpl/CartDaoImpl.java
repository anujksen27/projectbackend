package com.niit.daoimpl;

	import java.util.List;


	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.query.Query;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartDao;
import com.niit.model.Cart;

	
	@Repository
	public class CartDaoImpl implements CartDao{
		@Autowired
		SessionFactory sessionFactory;
		public CartDaoImpl(SessionFactory sessionFactory){
			this.sessionFactory=sessionFactory;
		}
		@Transactional
		public void insertOrUpdateCart(Cart cart)
		{
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(cart);
		}

		public Cart getCartItem(int cart_item_id)
		{
			Session session=sessionFactory.openSession();
			Cart cart=session.get(Cart.class,cart_item_id);
			session.close();
			return cart;
		}
		
		public List<Cart> getCartItems(String username)
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Cart where username=:username and status='N'");
			query.setParameter("username",username);
			List<Cart> list=query.list();
			session.close();
			return list;
		}
		
		@Transactional
		public void deleteCartItem(Cart cart)
		{
			sessionFactory.getCurrentSession().delete(cart);
		}
		
		public List<Cart> getPurchasedCartItems(String username)
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Cart where username=:username and status='Y'");
			query.setParameter("username",username);
			List<Cart> list=query.list();
			session.close();
			return list;
		}
		
		@Transactional
		public void cartFinal(String username)
		{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Cart where username=:username and status='N'");
			query.setParameter("username",username);
			List<Cart> list=query.list();
			for(Cart cart:list){
				cart.setStatus("Y");
				session.saveOrUpdate(cart);
			}
		}

		
	

	
	
	
	
}
