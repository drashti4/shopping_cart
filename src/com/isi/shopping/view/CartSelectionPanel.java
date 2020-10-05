package com.isi.shopping.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.ListModel;

import com.isi.shopping.model.Product;

public class CartSelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int DefaultSpace = 20;
	private static final Dimension DefaultSpaceDimension = new Dimension(DefaultSpace, DefaultSpace);

	private final CartProductsListPanel cartProductsListPanel;
	private final TotalPanel totalPanel;

	public CartSelectionPanel() {
		cartProductsListPanel = new CartProductsListPanel();
		totalPanel = new TotalPanel(this);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(DefaultSpace, DefaultSpace, DefaultSpace, DefaultSpace));

		this.add(Box.createVerticalGlue());
		this.add(cartProductsListPanel);
		this.add(Box.createRigidArea(DefaultSpaceDimension));
		this.add(totalPanel);
		this.add(Box.createVerticalGlue());
	}

	public ListModel<Product> getAllCartItems() {
		return cartProductsListPanel.getAllCartItem();
	}
	

	public CartProductsListPanel getCartProductsListPanel() {
		return cartProductsListPanel;
	}

	public TotalPanel getCartPanel() {
		return totalPanel;
	}

	public void calculateTotal() {
		totalPanel.calculateTotal();
	}

	public Product getSelectedCartItem() {
		return cartProductsListPanel.getSelectedCartItem();
	}

	public int getSelectedCartItemIndex() {
		return cartProductsListPanel.getSelectedCartItemIndex();
	}

	public boolean addItemInCart(Product item) {
		return cartProductsListPanel.addItemInList(item, getAllCartItems());
	}

	public void removeItemFromCart(int index, Product item, int quantity) {
		cartProductsListPanel.removeItemFromList(index, item, quantity);
	}

	public void clearCart() {
		cartProductsListPanel.clearCart();
	}
}
