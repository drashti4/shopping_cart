package com.isi.shopping.view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;

import com.isi.shopping.model.Product;

public class ProductsListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int DefaultSpace = 10;

	private final JList<Product> productsList;

	public ProductsListPanel(Product[] products) {
		productsList = createProductsList(products);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setAlignmentX(0.5f);
		this.add(productsList);
	}

	private JList<Product> createProductsList(Product[] products) {
		JList<Product> productsList = new JList<Product>(products);
		productsList.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(),
				BorderFactory.createEmptyBorder(DefaultSpace, DefaultSpace, DefaultSpace, DefaultSpace)));
		productsList.setFixedCellHeight(24);
		return productsList;
	}

	public Integer getSelectedProductId() {
		int selectedBookIndex = productsList.getSelectedIndex();
		if (selectedBookIndex >= 0) {
			return productsList.getModel().getElementAt(selectedBookIndex).getProductId();
		}
		return null;
	}
	
	public int getSelectedItemId() {
		System.out.println("Selected Item index is "+productsList.getSelectedIndex()) ;
		return productsList.getSelectedIndex();
	}
	public Product getSelectedProduct() {
		return productsList.getSelectedValue();
	}

	public void addListSelectionListener(ListSelectionListener listener) {
		productsList.addListSelectionListener(listener);
	}
}
