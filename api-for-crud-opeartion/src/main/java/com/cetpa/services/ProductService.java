package com.cetpa.services;

import java.util.List;

import com.cetpa.entities.Product;

public interface ProductService 
{
	void saveRecord(Product product);
	List<Product> getList();
	Product getRecord(int pid);
	List<Product> getListByName(String name);
	List<Product> getListByBrand(String brand);
	List<Product> getListByPriceMoreThan(int price);
	List<Product> getListByPriceLessThan(int price);
	List<Product> getListByPriceBetweenThan(int price1, int price2);
	void deleteById(int pid);
	void deleteByName(String name);
}
