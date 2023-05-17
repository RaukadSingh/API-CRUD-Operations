package com.cetpa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entities.Product;
import com.cetpa.repositories.ProductRepository;
import com.cetpa.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService 
{
	@Autowired
	private ProductRepository productRepository;

	public void saveRecord(Product product) 
	{
		productRepository.save(product);
	}
	public List<Product> getList() 
	{
		return productRepository.findAll();
	}
	public Product getRecord(int pid) 
	{
		return productRepository.findById(pid).orElse(null);
	}
	public List<Product> getListByName(String name) 
	{
		return productRepository.findByName(name);
	}
	public List<Product> getListByBrand(String brand) 
	{
		return productRepository.findByBrand(brand);
	}
	public List<Product> getListByPriceMoreThan(int price) 
	{
		return productRepository.findByPriceMoreThan(price);
	}
	public List<Product> getListByPriceLessThan(int price) 
	{
		return productRepository.findByPriceLessThan(price);
	}
	public List<Product> getListByPriceBetweenThan(int price1, int price2) 
	{
		return productRepository.findByPriceBetween(price1, price2);
	}
	public void deleteById(int pid) 
	{
		productRepository.deleteById(pid);
	}
	public void deleteByName(String name) 
	{
		productRepository.deleteByName(name);
	}
}
