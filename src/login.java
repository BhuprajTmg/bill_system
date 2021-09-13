import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class login implements ActionListener{
	
	JFrame j;
	Connection con;
	JFrame data;
	JLabel lbl_heading, lbl_username, lbl_password,lbl_login;
	JTextField txt_username;
	JPasswordField txt_password;
	JButton btn_login, btn_register,btn_signup;
	Font fon1, fon2,fon3;	
	public login() {
		
		j = new JFrame();
		data = new JFrame();
		fon1 = new Font("arial",Font.BOLD, 24);
		
		fon2 = new Font("arial",Font.BOLD, 18);
		
		fon3 = new Font("arial",Font.TRUETYPE_FONT, 12);
		
		
		lbl_heading = new JLabel("Login");
		lbl_heading.setForeground(Color.BLACK);
		lbl_heading.setFont(fon1);
		lbl_heading.setBounds(590,270,155,30);
		j.add(lbl_heading);
		
		lbl_login = new JLabel("Login with your data that you entered during your regestration.");
		lbl_login.setForeground(Color.black);
		lbl_login.setFont(fon3);
		lbl_login.setBounds(590,290,350,40);
		j.add(lbl_login);
		
		
		lbl_username = new JLabel("Username :");
		lbl_username.setForeground(Color.blue);
		lbl_username.setFont(fon2);
		lbl_username.setBounds(590,336,150,40);
		j.add(lbl_username);
		
		
		
		txt_username = new JTextField();
		txt_username.setForeground(Color.black);
		txt_username.setFont(fon2);
		txt_username.setBounds(590,383,250,36);
		j.add(txt_username);
		
		lbl_password = new JLabel("Password :");
		lbl_password.setForeground(Color.blue);
		lbl_password.setFont(fon2);
		lbl_password.setBounds(590,425,150,40);		
		j.add(lbl_password);
		
		txt_password = new JPasswordField();
		txt_password.setForeground(Color.black);
		txt_password.setFont(fon2);
		txt_password.setBounds(590,470,250,36);
		j.add(txt_password);
		
		btn_login = new JButton(" LOGIN ");
		btn_login.setForeground(Color.BLUE);
		btn_login.setFont(fon2);
		btn_login.addActionListener(this);
		btn_login.setBounds(590,555,140,44);
		j.add(btn_login);
//		
//		btn_register = new JButton(" CANCEL ");
//		btn_register.setForeground(Color.green);
//		btn_register.setFont(fon2);
//		
//		j.add(btn_register);
//		
		btn_signup = new JButton(" Sign up ! ");
		btn_signup.setForeground(Color.BLUE);
		btn_signup.setFont(fon2);
		btn_signup.setBounds(812,555,140,44);
		btn_signup.addActionListener(this);
		j.add(btn_signup);
		
		
		ImageIcon sec_backgroung = new ImageIcon("C:\\data.png");
		JLabel back_ground = new JLabel("",sec_backgroung,JLabel.CENTER);
		back_ground.setBounds(580,250,400,400);
		j.add(back_ground);
		
//		ImageIcon background_ing = new ImageIcon("C:\\top.png");
//		JLabel background = new JLabel("",background_ing,JLabel.CENTER);
//		background.setBounds(0,0,1920,1080);
//		j.add(background);
		
		// Setting the background of the window.
		ImageIcon background_ing = new ImageIcon("C:\\top.png");
		Image img = background_ing.getImage();
		Image tem_img = img.getScaledInstance(1545,1074, Image.SCALE_SMOOTH);
		background_ing = new ImageIcon(tem_img);
		JLabel background = new JLabel("",background_ing,JLabel.LEFT);
				
		background.setBounds(0,0,1920,1080);
		j.add(background);
		
		
		
		
		j.setSize(1920,1080);
		j.setLayout(null);
		j.setVisible(true);
	}
public static void main(String[] args) {
	new login();
}
public void actionPerformed(ActionEvent e) {
	String user = txt_username.getText();
	String pass = txt_password.getText();
	
	
	if (e.getSource()==btn_signup) {
		new Register();
		}
	if (e.getSource()==btn_login) {
		// Open a connection
		try {
		DbConnection db = new DbConnection();
		String query = "Select first_name,password from register_credential where first_name='"+user+"' and  password='"+pass+"'";
		ResultSet rs = db.select(query);
		if(rs.next()) {
			JOptionPane.showMessageDialog(j, "Login SuccessFul...");
			new userPannel();  
			j.dispose();
		}else {
			JOptionPane.showMessageDialog(j, "Login SuccessFully Failed...");
		}
		}catch(SQLException throwables) {
			throwables.printStackTrace();
		}
		
	}
		
	
}}






