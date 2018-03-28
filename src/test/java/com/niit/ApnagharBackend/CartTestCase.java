package com.niit.ApnagharBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDao;
import com.niit.model.Cart;


public class CartTestCase {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ApnagharBackend");
		context.refresh();
		CartDao cartDAO=(CartDao)context.getBean("cartDAO");
		Cart cart;
		cart=new Cart();
				cart.setCart_id(1001);
				cart.setUsername("TestUser");
				cart.setProd_name("Kenstar");
				cart.setProd_id(2);
				cart.setPrice(14000);
				cart.setQuantity(3);
				cart.setStatus("N");
				
				cartDAO.insertOrUpdateCart(cart);		
				System.out.println("Cart Inserted");
				
				cart=cartDAO.getCartItem(cart.getCart_item_id());
				System.out.println(cart.getUsername()+" cart item retrieve");
				
				cart.setQuantity(2);
				cartDAO.insertOrUpdateCart(cart);		
				System.out.println("Cart item Quantity Updated");
				
				List<Cart>list=cartDAO.getCartItems(cart.getUsername());
				System.out.println(list.get(0).getUsername()+" cart item list retrieve and status = "+list.get(0).getStatus());
				
				cartDAO.cartFinal(cart.getUsername());
				System.out.println("Item Status change to Y");
				
				list=cartDAO.getPurchasedCartItems(cart.getUsername());
				System.out.println(list.get(0).getUsername()+" cart purchased item list retrieve and status = "+list.get(0).getStatus());
				
				cartDAO.deleteCartItem(cart);		
				System.out.println("Cart Item Deleted");
				
				context.close();
}

}
