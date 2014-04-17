package client.view;

import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import client.controller.CreateUserController;
import client.controller.DeleteUserController;
import client.controller.LogonController;
import client.model.UserContainer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class DeleteUserPanel extends JPanel {
	private UserContainer currentUser;
	
	private JTextField userNameField;	
	private JLabel lblUsername;	
	private JButton btnSubmit;
	private DeleteUserController controller;
	private String username;
	
	public DeleteUserPanel(UserContainer _currentUser) {
		currentUser = _currentUser;
		
		//Username
		lblUsername = new JLabel("Username:");
		userNameField = new JTextField();
		//Submit Button
		btnSubmit = new JButton("Delete");
		//Controller
		controller = new DeleteUserController();

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = userNameField.getText();
				try {
					controller.deleteUser(username);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//Panel setup
		setupPanel();
		
	}
	
	private void setupPanel(){
		//setBackground(SystemColor.textHighlight);
		setLayout(null);
		
		//Username Label
		lblUsername.setBounds(30, 36, 72, 16);
		lblUsername.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.add(lblUsername);
		//Username		
		userNameField.setBounds(107, 30, 149, 28);
		userNameField.setColumns(10);
		userNameField.setText("Enter Username");
		this.add(userNameField);		
		
		//Button		
		btnSubmit.setBounds(107, 83, 88, 29);
		add(btnSubmit);				
	}
}

