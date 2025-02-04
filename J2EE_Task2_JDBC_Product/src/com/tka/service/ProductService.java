package com.tka.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.tka.config.JDBC_Config;
import com.tka.entity.Product;

public class ProductService {
	public String addProduct(Product product) {
		try {
			//get connection
			Connection conn = JDBC_Config.getConnectionToDB();
			
			//write sql query
			String QUERY = "INSERT INTO productinformation VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(QUERY);
			
			//execute query
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setInt(3, product.getProductQuantity());
			ps.setDouble(4, product.getProductPrice());
			ps.setString(5, product.getProductManufacturingDate());
			ps.setString(6, product.getProductExpiryDate());
			ps.executeUpdate();
			
			return "Product added successfully";
		} catch (Exception e) {
			System.out.println("Some error occured : "+e);
		}
		return "Product already exists";
	}
	
	public String deleteProduct(int productId) {
		
		return null;
	}
	
	public Object getProductById(int productId) {
		
		return null;
	}
	
	public String updateProduct(Product product) {
		
		return null;
	}
	
	public Object getAllProducts() {
		
		return null;
	}
	
	public Object getAllProducts_Asc(String columnName) {
		
		return null;
	}
	
	public Object getProductByName(String productName) {
		
		return null;
	}
	
	public Object getProductsGreaterThanSpecifiedPrice(double specifiedPrice) {
		
		return null;
	}
	
	//parameter to hoga but aur detail mai puchna padega sir se ki kaisa pattern accept karna hai
	public Object getProductsByNamePattern() {
		
		return null;
	}
	
	public Object getProductsWithinPriceRange(double low, double high) {
		
		return null;
	}
	
	public Object getMaxPriceProduct() {
		
		return null;
	}
}
