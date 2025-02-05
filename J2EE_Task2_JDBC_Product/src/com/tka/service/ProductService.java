package com.tka.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import com.tka.config.JDBC_Config;
import com.tka.entity.Product;

public class ProductService {
	public String addProduct(Product product) {
		try {
			//get connection
			Connection conn = JDBC_Config.getConnectionToDB();
			
			//write sql query
			String QUERY = "INSERT INTO productinformation(product_id,product_name,product_quantity,product_price,product_manufacturing_date,product_expiry_date) VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(QUERY);
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setInt(3, product.getProductQuantity());
			ps.setDouble(4, product.getProductPrice());
			ps.setString(5, product.getProductManufacturingDate());
			ps.setString(6, product.getProductExpiryDate());
			
			//execute query
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				return "Product added successfully";
			}
		}
		catch (SQLIntegrityConstraintViolationException e) {
			return "Product already exists";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "Something went wrong";
		}
		return null;
	}
	
	public String deleteProduct(int productId) {
		try {
			//get connection
			Connection connection = JDBC_Config.getConnectionToDB();
			
			//write query
			/*Checking whether the product already exists*/
			String checkProduct = "SELECT * FROM productinformation WHERE product_id = ?";
			PreparedStatement ps1 = connection.prepareStatement(checkProduct);
			ps1.setInt(1, productId);
			//execute query
			ResultSet rs = ps1.executeQuery();
			int a = 10/0;
			if(rs.next()) {
				//write query
				String productToBeDeleted = "DELETE FROM productinformation WHERE product_id=?";
				PreparedStatement ps2 = connection.prepareStatement(productToBeDeleted);
				ps2.setInt(1, productId);
				//execute query
				int rowsAffected = ps2.executeUpdate();
				
				if(rowsAffected > 0) {
					return "Product deleted successfully";
				}
			} else {
				return "Product doesn't exists! Can't delete product";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Something went wrong";
		}
		return null;
	}
	
	public Object getProductById(int productId) {
		try {
			//get connection
			Connection connection = JDBC_Config.getConnectionToDB();
			
			//write query
			String getProduct = "SELECT * FROM productinformation WHERE product_id = ?";
			PreparedStatement ps = connection.prepareStatement(getProduct);
			ps.setInt(1,productId);
			
			//execute query
			ResultSet rs = ps.executeQuery();
			
			//process the result i.e if the product exists then return that product
			if(rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductQuantity(rs.getInt("product_quantity"));
				product.setProductPrice(rs.getDouble("product_price"));
				product.setProductManufacturingDate(rs.getString("product_manufacturing_date"));
				product.setProductExpiryDate(rs.getString("product_expiry_date"));
				
				return product;
			} else {
				return "Product doesn't exists";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Something went wrong";
		}
	}
	
	public String updateProduct(Product product) {
		try {
			//get connection
			Connection connection = JDBC_Config.getConnectionToDB();
			
			//Check whether the product exists or not
			Object obj = getProductById(product.getProductId());
			if(obj instanceof Product) {
				//write query
				String updateQuery = "UPDATE productinformation  SET product_name=?, product_quantity=?,product_price=?,product_manufacturing_date=?,product_expiry_date=? WHERE product_id = ?";
				PreparedStatement ps = connection.prepareStatement(updateQuery);
				ps.setString(1, product.getProductName());
				ps.setInt(2, product.getProductQuantity());
				ps.setDouble(3, product.getProductPrice());
				ps.setString(4,product.getProductManufacturingDate());
				ps.setString(5,product.getProductExpiryDate());
				ps.setInt(6, product.getProductId());
				
				//execute query
				int rowsAffected = ps.executeUpdate();
				
				if(rowsAffected>0) {
					return "Updated successfully";
				}
			} else {
				return "Product doesn't exists! Can't update";
			}
			//execute query
		} catch (Exception e) {
			e.printStackTrace();
			return "Something went wrong";
		}
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
