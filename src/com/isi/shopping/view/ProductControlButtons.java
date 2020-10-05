package com.isi.shopping.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProductControlButtons extends JPanel {
	private static final long serialVersionUID = 1L;

	private static final int DefaultSpace = 20;
	private static final Dimension LargeSpaceDimension = new Dimension(DefaultSpace * 2, DefaultSpace * 2);
	private static final Dimension SmallSpaceDimension = new Dimension(DefaultSpace / 2, DefaultSpace / 2);
	private JLabel quantityLabel;
	private JTextField quantityTextField;
	private JButton addProductButton;
	private JButton removeProductButton;
	private JButton clearCartButton;

	public ProductControlButtons() {
		quantityLabel = new JLabel("Enter Quantity");
		quantityTextField = new JTextField(10);
		quantityTextField.setMaximumSize(new Dimension(150, 20));

		addProductButton = new JButton("Add Product");
		removeProductButton = new JButton("Remove Product");
		clearCartButton = new JButton("Clear Cart");

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(DefaultSpace, DefaultSpace, DefaultSpace, DefaultSpace));

		this.add(createaddRemoveProductPanel());
		this.add(Box.createRigidArea(new Dimension(20, 20)));
	}

	private JPanel createaddRemoveProductPanel() {
		JPanel productControlsPanel = new JPanel();
		productControlsPanel.setLayout(new BoxLayout(productControlsPanel, BoxLayout.Y_AXIS));
		productControlsPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(),
				BorderFactory.createEmptyBorder(DefaultSpace, DefaultSpace, DefaultSpace, DefaultSpace)));
		productControlsPanel.setAlignmentX(0.5f);
		productControlsPanel.add(quantityLabel);
		productControlsPanel.add(Box.createRigidArea(SmallSpaceDimension));
		productControlsPanel.add(quantityTextField);
		productControlsPanel.add(Box.createRigidArea(SmallSpaceDimension));
		productControlsPanel.add(addProductButton);
		productControlsPanel.add(Box.createRigidArea(SmallSpaceDimension));
		productControlsPanel.add(removeProductButton);
		productControlsPanel.add(Box.createRigidArea(SmallSpaceDimension));
		productControlsPanel.add(clearCartButton);
		return productControlsPanel;
	}

	public int getQuantityValue() {
		if (quantityTextField.getText().trim().equals("")) {
			return 1;
		} else {
			return Integer.parseInt(quantityTextField.getText().trim());
		}
	}

	public void addAddProductListener(ActionListener listener) {
		addProductButton.addActionListener(listener);
	}

	public void addRemoveProductListener(ActionListener listener) {
		removeProductButton.addActionListener(listener);
	}

	public void addClearCartListener(ActionListener listener) {
		clearCartButton.addActionListener(listener);
	}

}
