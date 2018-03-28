package com.niit.dao;


import java.util.List;


import com.niit.model.Category;
import com.niit.model.Product;


public interface ProductDao 
{
	public void insertOrUpdateProduct(Product product);
	public Product getProduct(int prod_id);
	public List<Product> getProductDetails();
	public List<Product> getProductCatWise(Category category);
	public void deleteProduct(Product product);
	public List<Product> retrieve();
	
	
}
