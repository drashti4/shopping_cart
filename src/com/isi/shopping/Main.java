package com.isi.shopping;

import com.isi.shopping.controller.LoginController;
import com.isi.shopping.view.LoginWindow;

public class Main {

	public static void main(String[] args) {
		LoginWindow login = new LoginWindow();
		LoginController loginController = new LoginController(login);
		login.setVisible(true);
	}
}