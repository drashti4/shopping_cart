package com.isi.shopping.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

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
		userNameLabel = new JLabel("UserName");
		passwordLabel = new JLabel("Password");
		userNameField = new JTextField(25);
		userNameField.setMaximumSize(new Dimension(100, userNameField.getMaximumSize().height));
		passwordField = new JTextField(25);
		passwordField.setMaximumSize(new Dimension(100, passwordField.getMaximumSize().height));
		loginButton = new JButton("Login Here");
		cancelButton = new JButton("Cancel");
		messageLabel = new JLabel("Message appears here");
	}
	private void addComponentsToContainers() {
		Dimension rigidAreaWidth = new Dimension(25, 25);
		
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
	
	public void setErrorMessage() {
		messageLabel.setText("Invalid Credential");
		
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
	
	public String getUserName() {
		return userNameField.getText();
	}
	
	public String getPassword() {
		return passwordField.getText();
	}

	public void addLoginListener(ActionListener listener)
	{
		loginButton.addActionListener(listener);
	}
	
	public void removeLoginListener(ActionListener listener)
	{
		loginButton.removeActionListener(listener);
	}
}
