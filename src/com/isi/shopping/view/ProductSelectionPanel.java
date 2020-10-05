package com.isi.shopping.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.isi.shopping.model.Product;

public class ProductSelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int DefaultSpace = 20;
	private static final Dimension DefaultSpaceDimension = new Dimension(DefaultSpace, DefaultSpace);

	private final ProductsListPanel productsListPanel;
	private final ProductPanel productPanel;
	private final ProductControlButtons productControlButtons;

	public ProductSelectionPanel(Product[] products, ProductControlButtons productControlButtons) {
		productsListPanel = new ProductsListPanel(products);
		productPanel = new ProductPanel();
		this.productControlButtons = productControlButtons;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(DefaultSpace, DefaultSpace, DefaultSpace, DefaultSpace));

		this.add(Box.createVerticalGlue());
		this.add(productsListPanel);
		this.add(Box.createRigidArea(DefaultSpaceDimension));
		this.add(productPanel);
		this.add(Box.createVerticalGlue());
	}

	public ProductsListPanel getProductsListPanel() {
		return productsListPanel;
	}

	public ProductPanel getProductPanel() {
		return productPanel;
	}

	public Integer getSelectedItemId() {
		return productsListPanel.getSelectedItemId();
	}

	public Product getSelectedProduct() {

		if (productsListPanel.getSelectedProduct().getQuantity() < productControlButtons.getQuantityValue()) {
			JOptionPane.showMessageDialog(null, "Quantity is not enough.");
			return null;
		} else {
			productsListPanel.getSelectedProduct().setBroughtQuantity(productControlButtons.getQuantityValue());
		}
	
		return productsListPanel.getSelectedProduct();
	}

}
