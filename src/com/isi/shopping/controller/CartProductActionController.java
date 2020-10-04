package com.isi.shopping.controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.isi.shopping.view.CartSelectionPanel;
import com.isi.shopping.view.ProductControlButtons;
import com.isi.shopping.view.ProductSelectionPanel;

public class CartProductActionController {
	
	private final ProductSelectionPanel productSelectionPanel;
	CartSelectionPanel cartSelectionPanel;
	ProductControlButtons productControlButtons;
	
	public CartProductActionController(ProductSelectionPanel productSelectionPanel, ProductControlButtons productControlButtons, CartSelectionPanel cartSelectionPanel)	
	{
		this.productSelectionPanel = productSelectionPanel;
		this.productControlButtons = productControlButtons;
		this.cartSelectionPanel = cartSelectionPanel;
		productControlButtons.addAddProductListener(this::addToCart);
	productControlButtons.addRemoveProductListener(this::removeFromCart);
		productControlButtons.addClearCartListener(this::clearCart);
	}
	
	private void clearCart(ActionEvent e) {
		cartSelectionPanel.clearCart();
	}
	private void removeFromCart(ActionEvent e) {
		if(cartSelectionPanel.getSelectedCartItem()!=null) {
		cartSelectionPanel.removeItemFromCart(cartSelectionPanel.getSelectedCartItemIndex(),cartSelectionPanel.getSelectedCartItem(),productControlButtons.getQuantityValue());
		cartSelectionPanel.calculateTotal();
		}else {
			JOptionPane.showMessageDialog(null, "Select Item from cart list");
		}
		
		
	}
	private void addToCart(ActionEvent e)
	{	
		cartSelectionPanel.addItemInCart(productSelectionPanel.getSelectedProduct());
		cartSelectionPanel.calculateTotal();
	/*	Integer productId = productsListPanel.getSelectedProductId();
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
		}*/
	}
}
