package com.niit.ApnagharBackend;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.HomeProductsDao;
import com.niit.dao.ProductDao;
import com.niit.model.HomeProducts;



public class HomeProductsTestCase {
	public static void main(String[] args) {
	
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit.ApnagharBackend");
	context.refresh();
	HomeProductsDao homeProductsDAO=(HomeProductsDao)context.getBean("homeProductsDAO");
	ProductDao productDAO=(ProductDao)context.getBean("productDAO");
	HomeProducts homeProducts;
			int srNo=1;
			try{for(int j=1;j<3;j++){
				for(int l=1;l<3;l++){
					for(int k=1;k<5;k++){
			homeProducts=new HomeProducts();
			homeProducts.setSrNo(srNo++);
			homeProducts.setBarNumber(j*100+l);
			homeProducts.setProduct(productDAO.getProductDetails().get(0));
			homeProductsDAO.insertOrUpdateHomeProducts(homeProducts);
			}}}
			System.out.println("Home Products Added");
			}
			catch(Exception e)
			{
				System.out.println("Add a product first");
			}
			
			homeProducts=homeProductsDAO.getHomeProducts(2);
			System.out.println("Home Product Retrieve");
			System.out.println(homeProducts.getBarNumber()+" "+homeProducts.getProduct().getPro_name());
			
			List<HomeProducts> list=homeProductsDAO.getHomeProductsList();
			System.out.println("Home Products list Retrieve");
			for(HomeProducts item:list)
				System.out.println(item.getBarNumber()+" "+item.getProduct().getPro_name());
				
			context.close();
	}
}