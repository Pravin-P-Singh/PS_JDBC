package com.tka.utility;

import java.util.Scanner;

import com.tka.entity.Product;

public class ProductUtility {
	
	static Scanner sc = new Scanner(System.in);
	static int productId;
	static int productQuantity;
	static String productName;
	static double productPrice;
	static String productManufacturingDate;
	static String productExpiryDate;
	
	public static Product createProduct() {
		System.out.println("Enter the product id : ");
		productId = sc.nextInt();

		System.out.println("Enter the product quantity : ");
		productQuantity = sc.nextInt();
		
		System.out.println("Enter the product name : ");
		productName = sc.next();
		
		System.out.println("Enter the product price : ");
		productPrice = sc.nextDouble();
		
		System.out.println("Enter the product manufacturing date : ");
		productManufacturingDate = sc.next();

		System.out.println("Enter the product expiry date : ");
		productExpiryDate = sc.next();

		return new Product(productId,productName,productQuantity,productPrice,productManufacturingDate,productExpiryDate);
	}
}
