package com.niit.ApnagharBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.OrderDetailsDao;
import com.niit.model.Billing;
import com.niit.model.OrderDetails;
import com.niit.model.Shipping;



public class OrderDetailsTestCase {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ApnagharBackend");
		context.refresh();
		OrderDetailsDao orderDetailsDAO=(OrderDetailsDao)context.getBean("orderDetailsDAO");
		OrderDetails orderDetails;
		Billing billing=new Billing();
		Shipping shipping=new Shipping();
				billing.setHouse_locality("a11");
				billing.setCity("delhi");
				billing.setState("new delhi");
				billing.setPincode(000000);
				billing.setPay_mode("COD");
				shipping.setName("User");
				shipping.setMobile("0000000000");
				shipping.setHouse_locality("a11");
				shipping.setCity("delhi");
				shipping.setState("new delhi");
				shipping.setPincode(000000);
				
				orderDetails=new OrderDetails();
				orderDetails.setCart_id(1001);
				orderDetails.setOrder_id(1111111);
				orderDetails.setBilling(billing);
				orderDetails.setShipping(shipping);
				orderDetails.setUsername("TestUser");
				orderDetailsDAO.insertOrderDetails(orderDetails);
				System.out.println("Order Details inserted");
				
				orderDetails=orderDetailsDAO.getOrderDetails("TestUser", 1001);
				System.out.println("Order Details retrieve");
				System.out.println("Order Id = "+orderDetails.getOrder_id());
				
				orderDetailsDAO.deleteOrderDetails("TestUser");
				System.out.println("Order Details Deleted");
				context.close();
	}
}
