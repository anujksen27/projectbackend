package com.niit.daoimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDao;
import com.niit.model.Category;
import com.niit.model.Product;
@Repository
public class ProductDaoImpl implements ProductDao{
		@Autowired
		SessionFactory sessionFactory;
		public ProductDaoImpl(SessionFactory sessionFactory){
			this.sessionFactory=sessionFactory;
		}
		
		@Transactional
		public void insertOrUpdateProduct(Product product)
		{
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(product);
		}
		
		public Product getProduct(int prod_id)
		{
			Session session=sessionFactory.openSession();
			Product product=session.get(Product.class,prod_id);
			session.close();
			return product;
		}
		
		public List<Product> retrieve()
		{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<Product> li = session.createQuery("from Product").list();
			session.getTransaction().commit();
			return li;
		}
		
		public List<Product> getProductDetails()
		{
			Session session=sessionFactory.openSession();
			List<Product> list=session.createQuery("from Product").list();
			session.close();
			return list;
		}
		
		public List<Product> getProductCatWise(Category category)
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Product where category=:category");
			query.setParameter("category", category);
			List<Product> list=query.list();
			session.close();
			return list;
		}
		
		@Transactional
		public void deleteProduct(Product product)
		{
			sessionFactory.getCurrentSession().delete(product);
		}
		
}


