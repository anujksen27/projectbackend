package com.niit.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sup_id;
	private String sup_name,sup_address;
	public int getSup_id() {
		return sup_id;
	}
	public void setSup_id(int sup_id) {
		this.sup_id = sup_id;
	}
	public String getSup_name() {
		return sup_name;
	}
	public void setSup_name(String sup_name) {
		this.sup_name = sup_name;
	}
	public String getSup_address() {
		return sup_address;
	}
	public void setSup_address(String sup_address) {
		this.sup_address = sup_address;
	}

}
