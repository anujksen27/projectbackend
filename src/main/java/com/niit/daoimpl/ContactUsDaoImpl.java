package com.niit.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ContactUsDao;
import com.niit.model.ContactUs;

@Repository
public class ContactUsDaoImpl implements ContactUsDao {
	@Autowired
	SessionFactory sessionFactory;
	public ContactUsDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertOrUpdateContactUs(ContactUs contactUs)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(contactUs);
	}
}
