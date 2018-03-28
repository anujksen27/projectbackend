package com.niit.dao;


import java.util.List;

import com.niit.model.Supplier;


public interface SupplierDao
{
	public void insertOrUpdateSupplier(Supplier supplier);
	public Supplier getSupplier(int sup_id);
	public List<Supplier> getSupplierDetails();
	public void deleteSupplier(Supplier supplier);
	public List<Supplier> retrieve();
	
}

