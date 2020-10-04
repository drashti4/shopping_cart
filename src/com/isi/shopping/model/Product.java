package com.isi.shopping.model;

import java.util.ArrayList;

import com.isi.shopping.interfaces.IProductListener;

public class Product 
{
	static int nextProductId = 101;
	
	private final int productId;
	private final String name;
	private final String category;
	private final String description;
	private final double price;
	
	private int quantity;
	private int broughtQuantity;
	
	private double discount;
	
	ArrayList<Product> productslist = new ArrayList<Product>();
	private ArrayList<IProductListener> listeners;
	
	
//	public void addProduct(String name, String category, String description, double price, int quantity, double discount)
//	{
//		//Product product = new Product(name, category);
//		
//		productslist.add(name);-
//		
//	}
	public Product( String name, String category, String description, double price, int quantity, double discount)
	{
		productId = Product.nextProductId++;
		this.broughtQuantity = 0;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		
		this.discount = discount;
		
		listeners = new ArrayList<IProductListener>();
	}
	
	////getters
	public int getProductId() { return productId; }
	public String getName(){ return name; }
	public String getCategory(){ return category; }
	public String getDescription(){ return description; }
	public double getPrice(){ return price;	}
	public int getQuantity() { return quantity; }
	public double getDiscount(){ return discount; }
	public int getBroughtQuantity() {
		return broughtQuantity;
	}
	public void setBroughtQuantity(int updatedQuantity) {
		this.broughtQuantity+=updatedQuantity;
	}
	
	public void removeBroughQuantity(int updateQuantity) {
		this.broughtQuantity=updateQuantity;
	}
	
	////setters
	//private void setName(){ }
	
	////otherMethods
	public void addProductListener(IProductListener listener)
	{
		listeners.add(listener);
	}
	
	public void removeProductListener(IProductListener listener)
	{
		listeners.remove(listener);
	}

	@Override
	public String toString() 
	{
		/*return "Product id: " + productId + ", Name: " + name +
				", Category: " + category + ", Description: "
				+ description + ", Price: " + price + 
				", Quantity: " +quantity+ ", Discount: " + 
				discount;*/
		return "-> " + name;
	}
}
