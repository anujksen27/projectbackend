package com.niit.dao;


import java.util.List;

import com.niit.model.Cart;


public interface CartDao {
	public void insertOrUpdateCart(Cart cart);
	public Cart getCartItem(int cart_item_id);
	public List<Cart> getCartItems(String username);
	public void deleteCartItem(Cart cart);
	public List<Cart> getPurchasedCartItems(String username);
	public void cartFinal(String username);
}
