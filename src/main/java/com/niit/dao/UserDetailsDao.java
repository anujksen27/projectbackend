package com.niit.dao;

import com.niit.model.UserDetails;

public interface UserDetailsDao {
	public void insertOrUpdateUserDetails(UserDetails userDetails);
	public UserDetails getUserDetails(String username);
	
}
