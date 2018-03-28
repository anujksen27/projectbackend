package com.niit.ApnagharBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDao;
import com.niit.model.Supplier;



public class SupplierTestCase {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ApnagharBackend");
		context.refresh();
		SupplierDao supplierDAO=(SupplierDao)context.getBean("supplierDAO");
		Supplier supplier;
				supplier=new Supplier();
				supplier.setSup_name("ABCD");
				supplier.setSup_address("India");
				
				supplierDAO.insertOrUpdateSupplier(supplier);		
				System.out.println("Supplier Inserted");
				
				supplier=supplierDAO.getSupplier(supplier.getSup_id());
				System.out.println(supplier.getSup_name()+" supplier data retrieve");
				
				List<Supplier> list = supplierDAO.getSupplierDetails();
				System.out.println("Supplier List Retrieve");
				for(Supplier item:list)
					System.out.println(item.getSup_id()+" "+item.getSup_name());
							
				supplierDAO.deleteSupplier(supplier);		
				System.out.println("Supplier deleted");
				
				context.close();
		}

}
