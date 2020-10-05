package com.isi.shopping.controller;

import java.util.HashMap;

import javax.swing.event.ListSelectionEvent;

import com.isi.shopping.model.Product;
import com.isi.shopping.view.ProductPanel;
import com.isi.shopping.view.ProductSelectionPanel;
import com.isi.shopping.view.ProductsListPanel;

public class ProductSelectionController 
{
	
	private final HashMap<Integer, Product> products;
	private Product selectedProduct;
	
	private final ProductsListPanel productsListPanel;
	private final ProductPanel productPanel;
	
	
	public ProductSelectionController(HashMap<Integer, Product> products, ProductSelectionPanel productSelectionPanel)	
	{
		this.products =  products;
		productsListPanel = productSelectionPanel.getProductsListPanel();
		productPanel = productSelectionPanel.getProductPanel();	
		productsListPanel.addListSelectionListener(this::selectionChanged);
	}
	
	private void selectionChanged(ListSelectionEvent e)
	{
		if (selectedProduct != null)
			selectedProduct.removeProductListener(productPanel);
		
		Integer productId = productsListPanel.getSelectedProductId();
		if (products.containsKey(productId))
		{
			selectedProduct = products.get(productId);
			
			productPanel.updateProductId(selectedProduct.getProductId());
			productPanel.updateProductName(selectedProduct.getName());
			productPanel.updateProductCategory(selectedProduct.getCategory());
			productPanel.updateProductDescription(selectedProduct.getDescription());
			productPanel.updateProductQuantity(selectedProduct.getQuantity());
			productPanel.updateProductPrice(selectedProduct.getPrice());
			productPanel.updateProductDiscount(selectedProduct.getDiscount());
			
			selectedProduct.addProductListener(productPanel);
		}
		else
		{
			selectedProduct = null;
			
			productPanel.updateProductId(null);
			productPanel.updateProductName(null);
			productPanel.updateProductCategory(null);
			productPanel.updateProductDescription(null);
			productPanel.updateProductQuantity(null);
			productPanel.updateProductPrice(null);
			productPanel.updateProductDiscount(null);
		}
	}
}
