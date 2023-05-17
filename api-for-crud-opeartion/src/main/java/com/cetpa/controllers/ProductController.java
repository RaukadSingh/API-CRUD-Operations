package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entities.Product;
import com.cetpa.services.ProductService;

@RestController
@RequestMapping("product-service")
//http://localhost:8080/product-service
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	//Api to create resource
	@PostMapping("create")
	//http://localhost:8080/product-service/create
	public ResponseEntity<Product> createResource(@RequestBody Product product)
	{
		productService.saveRecord(product);
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
	//Api to get all resources
	@GetMapping("list")
	//http://localhost:8080/product-service/list
	public ResponseEntity<List<Product>> getResourceList()
	{
		List<Product> productList=productService.getList();
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	}
	//Api to get resource by id
	@GetMapping("byid")
	//http://localhost:8080/product-service/byid?pid=101
	public ResponseEntity<Product> getResourceById(@RequestParam int pid)
	{
		Product product=productService.getRecord(pid);
		if(product==null)
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	//Api to get resource list by name
	@GetMapping("byname")
	//http://localhost:8080/product-service/byname?name=Laptop
	public ResponseEntity<List<Product>> getResourceListByName(@RequestParam String name)
	{
		List<Product> productList=productService.getListByName(name);
		if(productList.isEmpty())
		{
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	}
	//Api to get resource list by brand
	//http://localhost:8080/product-service/bybrand?brand=HP
	@GetMapping("bybrand")
	public ResponseEntity<List<Product>> getResourceListByBrand(@RequestParam String brand)
	{
		List<Product> productList=productService.getListByBrand(brand);
		if(productList.isEmpty())
		{
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	}
	//Api to get list of resource by price more than specified price
	@GetMapping("price-morethan")
	//http://localhost:8080/product-service/price-morethan?price=30000
	public ResponseEntity<List<Product>> getResourceListPriceMoreThan(@RequestParam int price)
	{
		List<Product> productList=productService.getListByPriceMoreThan(price);
		if(productList.isEmpty())
		{
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	}
	//Api to get list of resource by price less than specified price
	@GetMapping("price-lessthan")
	//http://localhost:8080/product-service/price-lessthan?price=30000
	public ResponseEntity<List<Product>> getResourceListPriceLessThan(@RequestParam int price)
	{
		List<Product> productList=productService.getListByPriceLessThan(price);
		if(productList.isEmpty())
		{
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	}
	//Api to get list of resource by price range
	@GetMapping("price-range")
	//http://localhost:8080/product-service/price-range?price1=50000&price2=100000
	public ResponseEntity<List<Product>> getResourceListPriceBetween(@RequestParam int price1,@RequestParam int price2)
	{
		List<Product> productList=productService.getListByPriceBetweenThan(price1,price2);
		if(productList.isEmpty())
		{
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	}
	//Api to delete resource by id
	@DeleteMapping("byid")
	//http://localhost:8080/product-service/byid?pid=107
	public ResponseEntity<Product> deleteResourceById(@RequestParam int pid)
	{
		Product product=productService.getRecord(pid);
		if(product==null)
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		productService.deleteById(pid);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	//Api to delete resource list by name
	@DeleteMapping("byname")
	//http://localhost:8080/product-service/byname?name=Mouse
	public ResponseEntity<List<Product>> deleteResourceListByName(@RequestParam String name)
	{
		List<Product> productList=productService.getListByName(name);
		if(productList.isEmpty())
		{
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
		productService.deleteByName(name);
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	}
}
