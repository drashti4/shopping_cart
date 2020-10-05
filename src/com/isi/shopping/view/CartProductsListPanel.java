package com.isi.shopping.view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionListener;

import com.isi.shopping.model.Product;

public class CartProductsListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int DefaultSpace = 10;

	private final JList<Product> cartProductsList;
	DefaultListModel<Product> model = new DefaultListModel<Product>();;

	public CartProductsListPanel() {

		cartProductsList = createCartProductsList();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setAlignmentX(0.5f);
		this.add(cartProductsList);
	}

	private JList<Product> createCartProductsList() {
		JList<Product> cartProductsList = new JList<Product>(model);
		cartProductsList.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(),
				BorderFactory.createEmptyBorder(DefaultSpace, DefaultSpace, DefaultSpace, DefaultSpace)));
		cartProductsList.setFixedCellHeight(24);
		return cartProductsList;
	}

	public ListModel<Product> getAllCartItem() {
		return cartProductsList.getModel();
	}

	public boolean addItemInList(Product item, ListModel<Product> existItems) {
		if (item != null) {
			for (int i = 0; i < existItems.getSize(); i++) {
				if (existItems.getElementAt(i).getName().equals(item.getName())) {
					return true;
				}
			}
			model.addElement(item);
			return true;
		}
		return false;
	}

	public boolean clearCart() {
		if (!model.isEmpty()) {
			model.clear();
			return true;
		}
		return false;
	}

	public int getSelectedCartItemIndex() {
		return cartProductsList.getSelectedIndex();
	}

	public void removeItemFromList(int id, Product item, int quantity) {
		if (item != null) {
			System.out.println(item.getName() + " Existing removed quantity " + item.getBroughtQuantity() + " : entered quantity " + quantity);

			int finalQuantity = item.getBroughtQuantity() - quantity;
			if (finalQuantity < 0) {
				finalQuantity = 0;
			}

			item.removeBroughQuantity(finalQuantity);

			if (item.getBroughtQuantity() <= 0) {
				model.remove(id);
			}
			System.out.println(item.getName() + " removed updated quantity " + item.getBroughtQuantity());
		}
	}

	public void addListSelectionListener(ListSelectionListener listener) {
		cartProductsList.addListSelectionListener(listener);
	}

	public Product getSelectedCartItem() {
		return cartProductsList.getSelectedValue();
	}
}
