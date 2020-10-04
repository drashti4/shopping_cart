package com.isi.shopping.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class LoginWindow extends JFrame
{
	private static final long serialVersionUID = 1L;

	private JLabel welcomeTitleLabel;
	private JLabel userNameLabel;
	private JLabel passwordLabel;
	private JTextField userNameField;
	private JTextField passwordField;
	private JButton loginButton;
	private JButton cancelButton;
	private JLabel messageLabel;
	
	private JPanel TitlePanel;
	private JPanel loginPanel;
	private JPanel buttonsPanel;
	private JPanel messagePanel;
	private JPanel contentPane;
	
	public LoginWindow()
	{
		super("Login");
		
		createComponents();
		initializeContainers();
		addComponentsToContainers();
		
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	private void createComponents()
	{
		welcomeTitleLabel = new JLabel("E-Shopping");
		userNameLabel = new JLabel("UserName");
		passwordLabel = new JLabel("Password");
		userNameField = new JTextField(25);
		userNameField.setMaximumSize(new Dimension(100, userNameField.getMaximumSize().height));
		passwordField = new JTextField(25);
		passwordField.setMaximumSize(new Dimension(100, passwordField.getMaximumSize().height));
		loginButton = new JButton("Login");
		cancelButton = new JButton("Cancel");
		messageLabel = new JLabel("Message appears here");
	}
	private void addComponentsToContainers() {
		// TODO Auto-generated method stub

		Dimension rigidAreaWidth = new Dimension(25, 25);
		
		TitlePanel.add(welcomeTitleLabel);
		TitlePanel.add(Box.createRigidArea(rigidAreaWidth));
		TitlePanel.add(welcomeTitleLabel);
		
		loginPanel.add(userNameLabel);
		loginPanel.add(Box.createRigidArea(rigidAreaWidth));
		loginPanel.add(userNameField);
		loginPanel.add(Box.createRigidArea(rigidAreaWidth));
		
		loginPanel.add(passwordLabel);
		loginPanel.add(Box.createRigidArea(rigidAreaWidth));
		loginPanel.add(passwordField);
		loginPanel.add(Box.createRigidArea(rigidAreaWidth));
		
		buttonsPanel.add(loginButton);
		buttonsPanel.add(Box.createRigidArea(rigidAreaWidth));
		buttonsPanel.add(cancelButton);
		
		messagePanel.add(messageLabel);
		
		contentPane.add(TitlePanel);
		contentPane.add(Box.createRigidArea(rigidAreaWidth));
		contentPane.add(loginPanel);
		contentPane.add(Box.createRigidArea(rigidAreaWidth));
		contentPane.add(buttonsPanel);
		contentPane.add(Box.createRigidArea(rigidAreaWidth));
		contentPane.add(messagePanel);
	
	}
	private void initializeContainers() {
		// TODO Auto-generated method stub
		TitlePanel = new JPanel();
		TitlePanel.setLayout(new BoxLayout(TitlePanel, BoxLayout.X_AXIS));
		
		loginPanel = new JPanel();
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.X_AXIS));
		
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
		
		messagePanel = new JPanel();
		messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.X_AXIS));
		
		contentPane = (JPanel)getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	
	}
}
