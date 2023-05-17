package com.cetpa.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cetpa.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> 
{
	List<Product> findByName(String name);
	List<Product> findByBrand(String brand);
	
	@Query("from Product where price>:arg")
	List<Product> findByPriceMoreThan(@Param("arg") int price);
	@Query("from Product where price<:arg")
	List<Product> findByPriceLessThan(@Param("arg") int price);
	@Query("from Product where price between :arg1 and :arg2")
	List<Product> findByPriceBetween(@Param("arg1") int price1,@Param("arg2") int price2);
	
	@Transactional
	@Modifying
	void deleteByName(String name);
}
