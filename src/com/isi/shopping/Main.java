package com.isi.shopping;

import java.awt.Container;
import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.isi.shopping.controller.CartProductActionController;
import com.isi.shopping.controller.ProductSelectionController;
import com.isi.shopping.model.Product;
import com.isi.shopping.view.TotalPanel;
import com.isi.shopping.view.CartProductsListPanel;
import com.isi.shopping.view.CartSelectionPanel;
import com.isi.shopping.view.ProductControlButtons;
import com.isi.shopping.view.ProductSelectionPanel;

public class Main {

	public static void main(String[] args) {
		setSystemLookAndFeel();

		// LoginWindow login = new LoginWindow();
		// login.setVisible(false);

		Product[] productsArray = createProductsArray();
		//ProductCart[] dynamicProductArray = createDynamicProductsArray();
		CartSelectionPanel cartSelectionPanel = new CartSelectionPanel();
		HashMap<Integer, Product> products = createBooksHashMap(productsArray);
		ProductControlButtons productControlButtons = new ProductControlButtons();
		ProductSelectionPanel productSelectionPanel = new ProductSelectionPanel(productsArray, productControlButtons);
		ProductSelectionController productSelectionController = new ProductSelectionController(products,
				productSelectionPanel);
		
		CartProductActionController cartProductActionController = new CartProductActionController(productSelectionPanel, productControlButtons, cartSelectionPanel);
		
		//HashMap<Integer, ProductCart> dynamicProducts = createBooksHashMap(dynamicProductArray);
		

		JFrame window = createLibraryWindow(productSelectionPanel, productControlButtons, cartSelectionPanel);

		window.setVisible(true);
	}

	private static Product[] createProductsArray() {
		Product[] productsArray = new Product[] { new Product("Apple", "Fruit", "Small red Apple", 1.12, 20, 0.00),
				new Product("Mango", "Fruit", "Organic green Mango", 2.00, 25, 0.00),
				new Product("Orange", "Fruit", "Indian Orange", 1.50, 30, 0.00),
				new Product("Pumpkin", "Vegetable", "Maxican veg", 2.00, 15, 0.00),
				new Product("Zucchini", "Vegetable", "Small greenish-white", 1.00, 17, 0.00) };
		return productsArray;
	}
	/*private static ProductCart[] createDynamicProductsArray() {
		ProductCart[] dynamicProductsArray = new ProductCart[] { new ProductCart("Apple2", "Fruit", "Small red Apple", 1.12, 20, 0.00),
				new ProductCart("Mango2", "Fruit", "Organic green Mango", 2.00, 25, 0.00),
				new ProductCart("Orange2", "Fruit", "Indian Orange", 1.50, 30, 0.00),
				new ProductCart("Pumpkin2", "Vegetable", "Maxican veg", 2.00, 15, 0.00),
				new ProductCart("Zucchini2", "Vegetable", "Small greenish-white", 1.00, 17, 0.00) };
		return dynamicProductsArray;
	}*/

	private static HashMap<Integer, Product> createBooksHashMap(Product[] productsArray) {
		//// HashMap of books
		////// Use a book's reference number (key) to access the book (value)
		////// Iteration over elements is not guaranteed to be in consistent order

		HashMap<Integer, Product> products = new HashMap<Integer, Product>();
		for (Product product : productsArray)
			products.put(product.getProductId(), product);
		return products;
	}

	private static JFrame createLibraryWindow(ProductSelectionPanel productSelectionPanel,
			ProductControlButtons productControlButtons, CartSelectionPanel cartSelectionPanel) {
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		contentPane.add(Box.createHorizontalGlue());
		contentPane.add(productSelectionPanel);
		contentPane.add(Box.createRigidArea(new Dimension(20, 20)));
		contentPane.add(productControlButtons);
		contentPane.add(Box.createHorizontalGlue());
		contentPane.add(cartSelectionPanel);

		return createWindow("Shopping App", contentPane);
	}

	private static JFrame createWindow(String title, Container contentPane) {
		JFrame window = new JFrame(title);

		window.setContentPane(contentPane);
		window.setSize(800, 800);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		return window;
	}

	private static void setSystemLookAndFeel() {
		try {
			String className = UIManager.getSystemLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
		}
	}

}
