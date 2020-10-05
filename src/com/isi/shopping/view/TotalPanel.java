package com.isi.shopping.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListModel;

import com.isi.shopping.model.Product;

public class TotalPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int DefaultSpace = 10;
	private static final Dimension DefaultSpaceDimension = new Dimension(DefaultSpace, DefaultSpace);
	private static final Dimension HalfSpaceDimension = new Dimension(DefaultSpace / 2, DefaultSpace / 2);

	private final JLabel subTotalAmountLabel;

	private final JLabel taxAmountLabel;
	private final JLabel totalAmountLabel;
	private final JLabel discountAmountLabel;
	private final JButton checkoutButton;
	private final JButton logoutButton;
	private final CartSelectionPanel cartSelectionPanel;

	public TotalPanel(CartSelectionPanel cartSelectionPanel) {

		this.cartSelectionPanel = cartSelectionPanel;
		subTotalAmountLabel = new JLabel("$0.0");
		taxAmountLabel = new JLabel("$0.0");
		totalAmountLabel = new JLabel("$0.0");
		discountAmountLabel = new JLabel("$0.0");
		checkoutButton = new JButton("Checkout");
		logoutButton = new JButton("Logout");

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(),
				BorderFactory.createEmptyBorder(DefaultSpace, DefaultSpace, DefaultSpace, DefaultSpace)));
		this.setAlignmentX(0.5f);

		this.add(createHorizontalLabelsPanel("Subtotal #", subTotalAmountLabel));
		this.add(createHalfSpaceRigidArea());
		this.add(createHorizontalLabelsPanel("Tax", taxAmountLabel));
		this.add(createHalfSpaceRigidArea());
		this.add(createHorizontalLabelsPanel("Discount", discountAmountLabel));
		this.add(createHalfSpaceRigidArea());
		this.add(createHorizontalLabelsPanel("FinalTotal", totalAmountLabel));
		this.add(createHalfSpaceRigidArea());
		this.add(checkoutButton);
		this.add(createHalfSpaceRigidArea());
		this.add(logoutButton);
	}

	public void calculateTotal() {
		ListModel<Product> items = cartSelectionPanel.getAllCartItems();
		double total = 0;
		if (items != null) {
			for (int i = 0; i < items.getSize(); i++) {
				System.out.println(items.getElementAt(i).getName() + " : " + items.getElementAt(i).getBroughtQuantity()
						+ " : " + items.getElementAt(i).getPrice());
				total += items.getElementAt(i).getBroughtQuantity() * items.getElementAt(i).getPrice();
				System.out.println("Total is " + total);
			}
			setSubTotalLabel(total);
		}
	}

	private void setSubTotalLabel(double amount) {
		subTotalAmountLabel.setText(String.valueOf(amount));
	}

	private Component createHalfSpaceRigidArea() {
		return Box.createRigidArea(HalfSpaceDimension);
	}

	private JPanel createHorizontalLabelsPanel(String title, JLabel label) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setAlignmentX(0);

		JLabel titleLabel = new JLabel(title);

		panel.add(titleLabel);
		panel.add(Box.createRigidArea(DefaultSpaceDimension));
		panel.add(label);

		applyFixedWidth(titleLabel, 80);
		applyFixedWidth(label, 200);

		return panel;
	}

	private void applyFixedWidth(Component component, int width) {
		component.setMinimumSize(new Dimension(width, component.getMinimumSize().height));
		component.setPreferredSize(new Dimension(width, component.getPreferredSize().height));
		component.setMaximumSize(new Dimension(width, component.getMaximumSize().height));
	}

	public void addCheckoutButtonListener(ActionListener listner) {
		checkoutButton.addActionListener(listner);
	}

	public void addLogoutListener(ActionListener listener) {
		logoutButton.addActionListener(listener);
	}
}
