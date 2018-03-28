package com.niit.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pro_id;
	private String pro_name, pro_desc;
	private int pro_quantity,pro_price;
	private String pro_imagename;
	
	public String getPro_imagename() {
		return pro_imagename;
	}
	public void setPro_imagename(String pro_imagename) {
		this.pro_imagename = pro_imagename;
	}
	@ManyToOne
	private Supplier supplier;
	@ManyToOne
	private Category category;
	
	@Transient
	private MultipartFile pro_image;
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public MultipartFile getPro_image() {
		return pro_image;
	}
	public void setPro_image(MultipartFile pro_image) {
		this.pro_image = pro_image;
	}
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_desc() {
		return pro_desc;
	}
	public void setPro_desc(String pro_desc) {
		this.pro_desc = pro_desc;
	}
	public int getPro_quantity() {
		return pro_quantity;
	}
	public void setPro_quantity(int pro_quantity) {
		this.pro_quantity = pro_quantity;
	}
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	
}
		
