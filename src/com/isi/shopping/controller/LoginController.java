package com.isi.shopping.controller;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.isi.shopping.model.Product;
import com.isi.shopping.model.User;
import com.isi.shopping.view.CartSelectionPanel;
import com.isi.shopping.view.LoginWindow;
import com.isi.shopping.view.ProductControlButtons;
import com.isi.shopping.view.ProductSelectionPanel;

public class LoginController {

	private LoginWindow loginWindow;
	private User user;
	int input;
	private static JFrame window;

	public LoginController(LoginWindow loginWindow) {

		setSystemLookAndFeel();
		this.loginWindow = loginWindow;
		loginWindow.addLoginListener((ActionEvent e) -> login());
	}

	private void login() {
		user = new User();

		Product[] productsArray = createProductsArray();

		CartSelectionPanel cartSelectionPanel = new CartSelectionPanel();
		HashMap<Integer, Product> products = createBooksHashMap(productsArray);
		ProductControlButtons productControlButtons = new ProductControlButtons();
		ProductSelectionPanel productSelectionPanel = new ProductSelectionPanel(productsArray, productControlButtons);
		ProductSelectionController productSelectionController = new ProductSelectionController(products,
				productSelectionPanel);

		CartProductActionController cartProductActionController = new CartProductActionController(productSelectionPanel,
				productControlButtons, cartSelectionPanel);

		boolean success = user.validateUser(loginWindow.getUserName(), loginWindow.getPassword());
		if (success) {
			window = createProductWindow(productSelectionPanel, productControlButtons, cartSelectionPanel);
			window.setVisible(true);
			loginWindow.dispose();
		} else {
			loginWindow.setErrorMessage();
		}
	}

	public static JFrame getCurrentWindow() {
		return window;
	}

	private static Product[] createProductsArray() {
		Product[] productsArray = new Product[] { new Product("Apple", "Fruit", "Small red Apple", 1.12, 20, 0.00),
				new Product("Mango", "Fruit", "Organic green Mango", 2.00, 25, 0.00),
				new Product("Orange", "Fruit", "Indian Orange", 1.50, 30, 0.00),
				new Product("Pumpkin", "Vegetable", "Maxican veg", 2.00, 15, 0.00),
				new Product("Zucchini", "Vegetable", "Small greenish-white", 1.00, 17, 0.00) };
		return productsArray;
	}

	private static HashMap<Integer, Product> createBooksHashMap(Product[] productsArray) {
		HashMap<Integer, Product> products = new HashMap<Integer, Product>();
		for (Product product : productsArray)
			products.put(product.getProductId(), product);
		return products;
	}

	private static JFrame createProductWindow(ProductSelectionPanel productSelectionPanel,
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
		window.setSize(1000, 800);
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
