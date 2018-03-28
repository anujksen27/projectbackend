package com.niit.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HomeProducts {
	@Id
	private int srNo;
	@ManyToOne
	private Product product;
	private int barNumber;
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getBarNumber() {
		return barNumber;
	}
	public void setBarNumber(int barNumber) {
		this.barNumber = barNumber;
	}
	
}
