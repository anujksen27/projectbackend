package com.niit.daoimpl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDetailsDao;
import com.niit.model.UserDetails;


@Repository
public class UserDetailsDaoImpl implements UserDetailsDao{
	@Autowired
	SessionFactory sessionFactory;
	public UserDetailsDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertOrUpdateUserDetails(UserDetails userDetails)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(userDetails);
	}
	
	public UserDetails getUserDetails(String username)
	{
		Session session=sessionFactory.openSession();
		UserDetails userDetails=session.get(UserDetails.class,username);
		session.close();
		return userDetails;
	}
	

}
