package com.niit.daoimpl;


	import java.util.List;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.HomeProductsDao;
import com.niit.model.HomeProducts;

	@Repository
	public class HomeProductsDaoImpl implements HomeProductsDao{
		@Autowired
		SessionFactory sessionFactory;
		public HomeProductsDaoImpl(SessionFactory sessionFactory){
			this.sessionFactory=sessionFactory;
		}
		
		@Transactional
		public void insertOrUpdateHomeProducts(HomeProducts homeProducts)
		{
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(homeProducts);
		}
		
		public List<HomeProducts> getHomeProductsList()
		{
			Session session=sessionFactory.openSession();
			List<HomeProducts> list=session.createQuery("from HomeProducts").list();
			session.close();
			return list;
		}
		
		public HomeProducts getHomeProducts(int srNo)
		{
			Session session=sessionFactory.openSession();
			HomeProducts homeProduct=session.get(HomeProducts.class,srNo);
			session.close();
			return homeProduct;
		}
		
	









}
