package client.view;

import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import client.controller.ChangePasswordController;
import client.controller.Controller;
import client.model.UserContainer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class ChangePasswordPanel extends JPanel {
	private JPasswordField txtPassword_1;	
	private JLabel lblPassword_1;
	private JPasswordField txtPassword_2;
	private JLabel lblPassword_2;
	private JButton btnSubmit;
	boolean passwordsEqual;
	String password_1, password_2;
	private ChangePasswordController controller;
	
	// Need to add user container
	//public ChangePasswordPanel(String user) {
	public ChangePasswordPanel(final JFrame mainFrame, final UserContainer user) {
		//Password 1
		lblPassword_1 = new JLabel("Password:");
		txtPassword_1 = new JPasswordField();
		
		//Password 2
		lblPassword_2 = new JLabel("Re-Enter Password:");
		txtPassword_2 = new JPasswordField();		
		
		//Submit button
		btnSubmit = new JButton("Submit");
		//Button Handle
		controller = new ChangePasswordController();
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				password_1 = new String(txtPassword_1.getPassword());
				password_2 = new String(txtPassword_2.getPassword());
				
				passwordsEqual = controller.checkPasswords(password_1, password_2);
				if (passwordsEqual){
					try {
						user.password = password_1;
						mainFrame.dispose();
						controller.changePassword(user);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
				}				
			}
		});

		
		mainFrame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				Controller homeScreen = new Controller(user);
				mainFrame.dispose();
				homeScreen.showFrame();
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//Panel setup
		setupPanel();
		
	}
	
	private void setupPanel(){
		//setBackground(SystemColor.textHighlight);
		setLayout(null);
		
		//Username Label
		lblPassword_1.setBounds(30, 36, 72, 16);
		lblPassword_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.add(lblPassword_1);
		//Username		
		txtPassword_1.setBounds(187, 30, 149, 28);
		this.add(txtPassword_1);		
		
		//Password Label
		lblPassword_2.setBounds(30, 69, 145, 16);
		lblPassword_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.add(lblPassword_2);
		//Password		
		txtPassword_2.setBounds(187, 63, 149, 28);
		this.add(txtPassword_2);
		
		//Button		
		btnSubmit.setBounds(136, 114, 88, 29);
		this.add(btnSubmit);	
		
		

		
	}
}
