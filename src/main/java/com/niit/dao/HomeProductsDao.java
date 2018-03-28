package com.niit.dao;


import java.util.List;

import com.niit.model.HomeProducts;


public interface HomeProductsDao {
	public void insertOrUpdateHomeProducts(HomeProducts homeProducts);
	public List<HomeProducts> getHomeProductsList();
	public HomeProducts getHomeProducts(int srNo);

}

