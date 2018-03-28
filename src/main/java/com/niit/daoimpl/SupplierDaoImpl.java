package com.niit.daoimpl;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.SupplierDao;
import com.niit.model.Supplier;

@Repository
public class SupplierDaoImpl implements SupplierDao{
	
		@Autowired
		SessionFactory sessionFactory;
		
		public SupplierDaoImpl(SessionFactory sessionFactory){
			this.sessionFactory=sessionFactory;
		}
		
		@Transactional
		public void insertOrUpdateSupplier(Supplier supplier)
		{
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(supplier);
		}
		
		public Supplier getSupplier(int sup_id)
		{
			Session session=sessionFactory.openSession();
			Supplier supplier=session.get(Supplier.class,sup_id);
			session.close();
			return supplier;
		}
		
		@Transactional
		public List<Supplier> retrieve()
		{
			Session session = sessionFactory.openSession();
			//session.beginTransaction();
			List<Supplier> li = session.createQuery("from Supplier").list();
			//session.getTransaction().commit();
			return li;
		}
		
		public List<Supplier> getSupplierDetails()
		{
			Session session=sessionFactory.openSession();
			List<Supplier> list=session.createQuery("from Supplier").list();
			session.close();
			return list;
		}
		
		@Transactional
		public void deleteSupplier(Supplier supplier)
		{
			sessionFactory.getCurrentSession().delete(supplier);
		}
		
}


