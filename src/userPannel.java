import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class userPannel implements ActionListener {
	
	JFrame j;
	JLabel lbl_counter,lbl_costumer_id,lbl_scno,background,lbl_transaction_pin;
	JLabel customer_lbl,unit_lbl,per_lbl,total_lbl,first_lbl,last_lbl;
	JComboBox choose;
	JLabel fname_l,lname_l;
	JPasswordField txt_transaction_pin;
	JTextField txt_unit_consumed,txt_costumer_id;
	Font fon1,fon2,fon3;
	JButton btn_proceed,btn_exit,btn_cancle,btn_bill,btn_update;
	String first_name;
	public userPannel(String first_name) {
		this.first_name = first_name;
		j = new JFrame();
		fon1 = new Font("arial",Font.BOLD, 24);
		
		fon2 = new Font("arial",Font.BOLD, 18);
		
		fon3 = new Font("arial",Font.TRUETYPE_FONT, 12);
	
		lbl_counter = new JLabel("NEA Counter");
		lbl_counter.setForeground(Color.GREEN);
		lbl_counter.setFont(new Font("times new roman",Font.BOLD,24));
		lbl_counter.setBounds(100,390,350,40);
		j.add(lbl_counter);
	
		//Drop down box;
		String counter[] = {"Achham","Arghakhachi","Baglung","Balaju","Baneshwor","Bardibas","Belauri","Bhaktapur","Butwal","Cabahil","Dharan","Dhankuta","Fikka","Gorkha","Hetauda","Illam","Ithari","Jajarkot","Kalikot","Lahan","Lamjung","Mirchiya","Naxal","Parsi","Rolpa","Surkhet","Tatopani","Udayapur(Gaighat)","Vurigaun","Yadukuwa"};
		JComboBox choose=new JComboBox(counter);    
	    choose.setBounds(100, 440,500,40);
	    j.add(choose); 
	    
	    lbl_scno = new JLabel("Unit Consumed");
	    lbl_scno.setForeground(Color.GREEN);
	    lbl_scno.setFont(new Font("times new roman",Font.BOLD,24));
	    lbl_scno.setBounds(100,490,350,40);
		j.add(lbl_scno);


		txt_unit_consumed = new JTextField();
		txt_unit_consumed.setForeground(Color.black);
		txt_unit_consumed.setBackground(Color.lightGray);
		txt_unit_consumed.setFont(new Font("times new roman",Font.BOLD,24));
		txt_unit_consumed.setBounds(100,540,500,40);
		j.add(txt_unit_consumed);
	
		lbl_costumer_id = new JLabel("Costumer Id");
		lbl_costumer_id.setForeground(Color.GREEN);
		lbl_costumer_id.setFont(new Font("times new roman",Font.BOLD,24));
		lbl_costumer_id.setBounds(100,585,350,40);
		j.add(lbl_costumer_id);
		
		txt_costumer_id = new JTextField();
		txt_costumer_id.setForeground(Color.black);
		txt_costumer_id.setBackground(Color.lightGray);
		txt_costumer_id.setFont(new Font("times new roman",Font.BOLD,24));
		txt_costumer_id.setBounds(100,630,500,40);
		j.add(txt_costumer_id);
		
		lbl_transaction_pin= new JLabel("Enter Your Transaction Pin :");
		lbl_transaction_pin.setForeground(Color.GREEN);
		lbl_transaction_pin.setFont(new Font("times new roman",Font.BOLD,24));
		lbl_transaction_pin.setBounds(100,690,350,40);
		j.add(lbl_transaction_pin);
		
		txt_transaction_pin = new JPasswordField();
		txt_transaction_pin.setForeground(Color.black);
		txt_transaction_pin.setBackground(Color.lightGray);
		txt_transaction_pin.setFont(new Font("times new roman",Font.BOLD,24));
		txt_transaction_pin.setBounds(398,690,202,40);
		j.add(txt_transaction_pin);
		
	    btn_proceed = new JButton("Proceed");
	    btn_proceed.setForeground(Color.blue);
	    btn_proceed.setFont(fon2);
		btn_proceed.addActionListener(this);
	    btn_proceed.setBounds(695,440,202,40);
		j.add(btn_proceed);
		
		btn_cancle = new JButton("Cancel");
		btn_cancle.setForeground(Color.blue);
		btn_cancle.setFont(fon2);
		btn_cancle.setBounds(695,520,202,40);
		j.add(btn_cancle);
		
		btn_bill = new JButton("Bill");
		btn_bill.setForeground(Color.blue);
		btn_bill.setFont(fon2);
		btn_bill.setBounds(695,598,202,40);
		btn_bill.addActionListener(this);
		j.add(btn_bill);

		btn_update = new JButton("Updata Pin");
		btn_update.setForeground(Color.blue);
		btn_update.setFont(fon2);
		btn_update.setBounds(695,675,202,40);
		btn_update.addActionListener(this);
		j.add(btn_update);
	    
	    
	    
	 // Setting the background of the window.
		
		
	    ImageIcon background_ing = new ImageIcon("C:\\p.png");
		Image img = background_ing.getImage();
		Image tem_img = img.getScaledInstance(1545,1074, Image.SCALE_SMOOTH);
		background_ing = new ImageIcon(tem_img);
		JLabel background = new JLabel("",background_ing,JLabel.LEFT);

		JLabel bill_title = new JLabel("Costumer Electricity Bill");
		bill_title.setBounds(1100,370,400,50);
		bill_title.setFont(fon1);
		j.add(bill_title);

		JLabel dash_start = new JLabel("############################################################");
//
//		fname_l = new JLabel();
//		fname_l.setBounds(100,100,200,60);
//		fname_l.setFont(fon2);
//		j.add(fname_l);

		dash_start.setBounds(1066,420,650,30);
		dash_start.setFont(fon3);
		j.add(dash_start);

		JLabel customer_name = new JLabel(" Customer    Name ");
		customer_name.setBounds(1100,430,300,60);
		customer_name.setFont(fon1);
		j.add(customer_name);

		first_lbl = new JLabel();
		first_lbl.setBounds(1120,470,200,60);
		first_lbl.setFont(fon2);
		first_lbl.setText("NaNa");
		j.add(first_lbl);

		last_lbl = new JLabel();
		last_lbl.setBounds(1250,470,200,60);
		last_lbl.setFont(fon2);
		last_lbl.setText("NaNa");
		j.add(last_lbl);



		JLabel customer_id = new JLabel("Customer id: ");
		customer_id.setBounds(1100,510,200,60);
		customer_id.setFont(fon2);
		j.add(customer_id);


		customer_lbl = new JLabel();
		customer_lbl.setBounds(1250,510,200,60);
		customer_lbl.setFont(fon2);
		customer_lbl.setText("NaNa");
		j.add(customer_lbl);

		JLabel unit_cons = new JLabel("Unit Consumed: ");
		unit_cons.setBounds(1100,545,200,60);
		unit_cons.setFont(fon2);
		j.add(unit_cons);

		unit_lbl = new JLabel();
		unit_lbl.setBounds(1250,545,200,60);
		unit_lbl.setFont(fon2);
		unit_lbl.setText("NaNa");
		j.add(unit_lbl);

		JLabel per_unit = new JLabel("Unit Per Charge: ");
		per_unit.setBounds(1100,580,200,60);
		per_unit.setFont(fon2);
		j.add(per_unit);

		per_lbl = new JLabel( );
		per_lbl.setBounds(1250,580,200,60);
		per_lbl.setFont(fon2);
		per_lbl.setText("NaNa");
		j.add(per_lbl);

		JLabel dot = new JLabel("------------------------------------------------------------------------------------------------");
		dot.setBounds(1066,620,650,30);
		dot.setFont(fon3);
		j.add(dot);

		JLabel total = new JLabel("Total Amount: ");
		total.setBounds(1100,640,200,60);
		total.setFont(fon2);
		j.add(total);

		total_lbl = new JLabel( );
		total_lbl.setBounds(1250,640,200,60);
		total_lbl.setFont(fon2);
		total_lbl.setText("NaNa");
		j.add(total_lbl);


		JLabel dash_end = new JLabel("############################################################");
		dash_end.setBounds(1066,720,650,30);
		dash_end.setFont(fon3);
		j.add(dash_end);

		displayName();
		background.setBounds(0,0,1920,1080);
		j.add(background);
		j.setSize(1920,1080);
		j.setLayout(null);
		j.setVisible(true);
		
	}
	public void displayName(){
		try {
			DbConnection db = new DbConnection();
			String query = "Select first_name,last_name from register_credential where first_name='" + this.first_name + "'";
			ResultSet rs = db.select(query);
			while (rs.next()){
				String first=rs.getString("first_name");
				String last = rs.getString("last_name");
				first_lbl.setText(first);
				last_lbl.setText(last);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
@Override
public void actionPerformed(ActionEvent e) {
	String customer = txt_costumer_id.getText();
	String unit_consumed = txt_unit_consumed.getText();
	String transaction_pin = txt_transaction_pin.getText();

	int per_unit = 6;
	float sum;
		if (e.getSource()== btn_bill) {
		
		txt_costumer_id.getText();
		System.out.println(txt_costumer_id.getText());
	}

	else if (e.getSource()==btn_proceed) {

			try {
				DbConnection db = new DbConnection();
				String query = "Select t_pin from register_credential where t_pin='" + transaction_pin + "'";
				ResultSet rs = db.select(query);
				if (rs.next()) {
					JOptionPane.showMessageDialog(j, "Transaction Completed Sucessfully");
					int total_unit = Integer.parseInt(unit_consumed);
					sum = per_unit * total_unit;
					String per_unit_change = String.valueOf(per_unit);
					String sum_unit = String.valueOf(sum);
					customer_lbl.setText(customer);
					unit_lbl.setText(unit_consumed);
					per_lbl.setText(per_unit_change);
					total_lbl.setText(sum_unit);

				} else {
					JOptionPane.showMessageDialog(j, "Wong Transaction pin, Try again");
				}
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}

		}


	}
	
}
	
	


