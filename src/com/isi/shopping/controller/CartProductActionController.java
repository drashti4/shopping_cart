package com.isi.shopping.controller;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

import com.isi.shopping.model.Product;
import com.isi.shopping.view.CartSelectionPanel;
import com.isi.shopping.view.LoginWindow;
import com.isi.shopping.view.ProductControlButtons;
import com.isi.shopping.view.ProductSelectionPanel;
import com.isi.shopping.view.TotalPanel;

public class CartProductActionController {

	private final ProductSelectionPanel productSelectionPanel;
	CartSelectionPanel cartSelectionPanel;
	ProductControlButtons productControlButtons;
	TotalPanel totalPanel;

	public CartProductActionController(ProductSelectionPanel productSelectionPanel,
			ProductControlButtons productControlButtons, CartSelectionPanel cartSelectionPanel) {

		this.productSelectionPanel = productSelectionPanel;
		this.productControlButtons = productControlButtons;
		this.cartSelectionPanel = cartSelectionPanel;

		productControlButtons.addAddProductListener(this::addToCart);
		productControlButtons.addRemoveProductListener(this::removeFromCart);
		productControlButtons.addClearCartListener(this::clearCart);
		cartSelectionPanel.getCartPanel().addCheckoutButtonListener(this::checkOut);
		cartSelectionPanel.getCartPanel().addLogoutListener(this::logout);

	}

	private void logout(ActionEvent e) {
		JFrame window = new LoginWindow();
		window.setVisible(true);
		LoginController.getCurrentWindow().dispose();
	}

	private void clearCart(ActionEvent e) {
		cartSelectionPanel.clearCart();
	}

	private void checkOut(ActionEvent e) {

		ListModel<Product> cartProduct = cartSelectionPanel.getAllCartItems();
		if (cartProduct != null) {

			for (int i = 0; i < cartProduct.getSize(); i++) {

				cartProduct.getElementAt(i).setQuantity(
						cartProduct.getElementAt(i).getQuantity() - cartProduct.getElementAt(i).getBroughtQuantity());
				cartSelectionPanel.clearCart();
			}
		}
	}

	private void removeFromCart(ActionEvent e) {
		if (cartSelectionPanel.getSelectedCartItem() != null) {
			cartSelectionPanel.removeItemFromCart(cartSelectionPanel.getSelectedCartItemIndex(),
					cartSelectionPanel.getSelectedCartItem(), productControlButtons.getQuantityValue());
			cartSelectionPanel.calculateTotal();
		} else {
			JOptionPane.showMessageDialog(null, "Select Item from cart list");
		}
	}

	private void addToCart(ActionEvent e) {
		cartSelectionPanel.addItemInCart(productSelectionPanel.getSelectedProduct());
		cartSelectionPanel.calculateTotal();
	}
}
