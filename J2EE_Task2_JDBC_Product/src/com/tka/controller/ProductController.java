package com.tka.controller;

import java.util.Scanner;

import com.tka.entity.Product;
import com.tka.service.ProductService;
import com.tka.utility.ProductUtility;

public class ProductController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Get perticular Product By Id");
            System.out.println("4. Update Particular Product");
            System.out.println("5. Retrieve All Products");
            System.out.println("6. Retrieve All Products in Ascending Order");
            System.out.println("7. Retrieve Product by Product Name");
            System.out.println("8. Retrieve Products whose Price is more Than given Price");
            System.out.println("9. Retrieve Products as per given pattern");
            System.out.println("10. Retrieve Products Within Price Range");
            System.out.println("11. Retrieve maximum product price");
            System.out.println("Press 0 for Terminate application");
            System.out.println("SELECT OPERATION");
            choice = sc.nextInt();
            
            ProductService productService = new ProductService(); 
            switch(choice) {
	            case 1 : {
	            	Product product = ProductUtility.createProduct();
	            	String message = productService.addProduct(product);
	            	System.out.println(message);
	            	break;
	            }
	            case 2 : {
	            	
	            	break;
	            }
	            case 3 : {
	            	
	            	break;
	            }
	            case 4 : {
	            	
	            	break;
	            }
	            case 5 : {
	            	
	            	break;
	            }
	            case 6 : {
	            	
	            	break;
	            }
	            case 7 : {
	            	
	            	break;
	            }
	            case 8 : {
	            	
	            	break;
	            }
	            case 9 : {
	            	
	            	break;
	            }
	            case 10 : {
	            	
	            	break;
	            }
	            case 11 : {
	            	
	            	break;
	            }
	            default : {
	            	System.out.println("Enter a valid choice");
	            }
            }
            
		} while (true);
	}
}
