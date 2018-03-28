package com.niit.dao;


import java.util.List;

import com.niit.model.Category;
import com.niit.model.Supplier;


public interface CategoryDao {
	public void insertOrUpdateCategory(Category category);
	public Category getCategory(int catid);
	public List<Category> getCategoryDetails();
	public void deleteCategory(Category category);
	public List<Category> retrieve();
	
}

