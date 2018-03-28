package com.niit.ApnagharBackend;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;



public class ProductTestCase {

	public static void main(String[] args) {		
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit.ApnagharBackend");
	context.refresh();
	ProductDao productDAO=(ProductDao)context.getBean("productDAO");
	Product product;
	SupplierDao supplierDAO=(SupplierDao)context.getBean("supplierDAO");
	Supplier supplier;
	CategoryDao categoryDAO=(CategoryDao)context.getBean("categoryDAO");
	Category category;
			product=new Product();
			product.setPro_name("Vivo v5");
			product.setPro_desc("5' screen, 4g enabled, dual sim");
			product.setPro_price(5000);
			product.setPro_quantity(4);
			category=categoryDAO.getCategory(1);
			supplier=supplierDAO.getSupplier(1);
			product.setCategory(category);
			product.setSupplier(supplier);
			
			productDAO.insertOrUpdateProduct(product);		
			System.out.println("Product Inserted");
			
			product=productDAO.getProduct(product.getPro_id());		
			System.out.println(product.getPro_name()+" data retrieve");
			
			List<Product> list = productDAO.getProductDetails();
			System.out.println("Product List Retrieve");
			for(Product item:list)
				System.out.println(item.getPro_id()+" "+item.getPro_name());
			
			list = productDAO.getProductCatWise(category);
			System.out.println("Product List Per Category Retrieve");
			for(Product item:list)
				System.out.println(item.getPro_id()+" "+item.getPro_name());
			
			productDAO.deleteProduct(product);		
			System.out.println("Product Deleted");
			
			context.close();


	}

}
