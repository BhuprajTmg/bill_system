import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.*;

public class userPannel  implements ActionListener {

	JFrame j;
	JLabel lbl_counter, lbl_costumer_id, lbl_scno, background, lbl_transaction_pin;
	JLabel customer_lbl, unit_lbl, per_lbl, total_lbl, first_lbl, last_lbl, consumed_lbl, lbl_Your_Balance, total_your_lbl, lbl_nea_counter, nea_counter, in_word;
	JComboBox choose;
	JPasswordField txt_transaction_pin;
	JTextField txt_unit_consumed, txt_costumer_id, lbl_Balance;
	Font fon1, fon2, fon3, fon4;
	JButton btn_proceed, btn_exit, btn_account, btn_delete, btn_update;
	String first_name;
	int your_amount;
	int final_amount;
	int sum;
	String account_number;
	String password;

	public userPannel(String first_name, String password) {
		this.first_name = first_name;
		this.password = password;

		j = new JFrame();
		fon1 = new Font("times new roman", Font.BOLD, 24);

		fon2 = new Font("times new roman", Font.BOLD, 18);

		fon3 = new Font("times new roman", Font.TRUETYPE_FONT, 12);

		fon4 = new Font("times new roman", Font.BOLD, 35);
		displayAmount();
		lbl_counter = new JLabel("NEA Counter");
		lbl_counter.setForeground(Color.GREEN);
		lbl_counter.setFont(new Font("times new roman", Font.BOLD, 24));
		lbl_counter.setBounds(100, 390, 350, 40);
		j.add(lbl_counter);

		//Drop down box;
		String counter[] = {"Achham", "Arghakhachi", "Baglung", "Balaju", "Baneshwor", "Bardibas", "Belauri", "Bhaktapur", "Butwal", "Cabahil", "Dharan", "Dhankuta", "Fikka", "Gorkha", "Hetauda", "Illam", "Ithari", "Jajarkot", "Kalikot", "Lahan", "Lamjung", "Mirchiya", "Naxal", "Parsi", "Rolpa", "Surkhet", "Tatopani", "Udayapur(Gaighat)", "Vurigaun", "Yadukuwa"};
		choose = new JComboBox(counter);

		choose.setBounds(100, 440, 500, 40);
		j.add(choose);

		lbl_scno = new JLabel("Unit Consumed");
		lbl_scno.setForeground(Color.GREEN);
		lbl_scno.setFont(new Font("times new roman", Font.BOLD, 24));
		lbl_scno.setBounds(100, 490, 350, 40);
		j.add(lbl_scno);


		txt_unit_consumed = new JTextField();
		txt_unit_consumed.setForeground(Color.black);
		txt_unit_consumed.setBackground(Color.lightGray);
		txt_unit_consumed.setFont(new Font("times new roman", Font.BOLD, 24));
		txt_unit_consumed.setBounds(100, 540, 500, 40);
		j.add(txt_unit_consumed);

		lbl_costumer_id = new JLabel("Costumer Id");
		lbl_costumer_id.setForeground(Color.GREEN);
		lbl_costumer_id.setFont(new Font("times new roman", Font.BOLD, 24));
		lbl_costumer_id.setBounds(100, 585, 350, 40);
		j.add(lbl_costumer_id);

		txt_costumer_id = new JTextField();
		txt_costumer_id.setForeground(Color.black);
		txt_costumer_id.setBackground(Color.lightGray);
		txt_costumer_id.setFont(new Font("times new roman", Font.BOLD, 24));
		txt_costumer_id.setBounds(100, 630, 500, 40);
		j.add(txt_costumer_id);

		lbl_transaction_pin = new JLabel("Enter Your Transaction Pin :");
		lbl_transaction_pin.setForeground(Color.GREEN);
		lbl_transaction_pin.setFont(new Font("times new roman", Font.BOLD, 24));
		lbl_transaction_pin.setBounds(100, 690, 350, 40);
		j.add(lbl_transaction_pin);

		txt_transaction_pin = new JPasswordField();
		txt_transaction_pin.setForeground(Color.black);
		txt_transaction_pin.setBackground(Color.lightGray);
		txt_transaction_pin.setFont(new Font("times new roman", Font.BOLD, 24));
		txt_transaction_pin.setBounds(398, 690, 202, 40);
		j.add(txt_transaction_pin);

		btn_proceed = new JButton("Proceed");
		btn_proceed.setForeground(Color.blue);
		btn_proceed.setFont(fon2);
		btn_proceed.addActionListener(this);
		btn_proceed.setBounds(695, 520, 202, 40);
		j.add(btn_proceed);

		btn_account = new JButton("My Account");
		btn_account.setForeground(Color.blue);
		btn_account.setFont(fon2);
		btn_account.addActionListener(this);
		btn_account.setBounds(695, 440, 202, 40);
		j.add(btn_account);

		btn_delete = new JButton("Delete");
		btn_delete.setForeground(Color.blue);
		btn_delete.setFont(fon2);
		btn_delete.setBounds(695, 598, 202, 40);
		btn_delete.addActionListener(this);
		j.add(btn_delete);

		btn_update = new JButton("Update Data");
		btn_update.setForeground(Color.blue);
		btn_update.setFont(fon2);
		btn_update.setBounds(695, 675, 202, 40);
		btn_update.addActionListener(this);
		j.add(btn_update);


		// Setting the background of the window.
		ImageIcon background_ing = new ImageIcon("C:\\epay.png");
		Image img = background_ing.getImage();
		Image tem_img = img.getScaledInstance(1545, 1074, Image.SCALE_SMOOTH);
		background_ing = new ImageIcon(tem_img);
		JLabel background = new JLabel("", background_ing, JLabel.LEFT);

		JLabel bill_title = new JLabel("NEPAL");
		bill_title.setBounds(1200, 379, 400, 50);
		bill_title.setForeground(Color.red);
		bill_title.setFont(fon4);
		j.add(bill_title);

		JLabel bill_sub_title = new JLabel("ELECTRICITY AUTHORITY");
		bill_sub_title.setBounds(1145, 430, 400, 50);
		bill_sub_title.setForeground(Color.red);
		bill_sub_title.setFont(fon2);
		j.add(bill_sub_title);

		JLabel bill_sub_title2 = new JLabel("Distribution & Costumer Services");
		bill_sub_title2.setBounds(1175, 450, 400, 50);
		bill_sub_title2.setForeground(Color.red);
		bill_sub_title2.setFont(fon3);
		j.add(bill_sub_title2);

		JLabel dot = new JLabel("------------------------------------------------------------------------------------------------");
		dot.setBounds(1066, 469, 650, 30);
		dot.setFont(fon3);
		j.add(dot);

		JLabel electric_bill = new JLabel("ELECTRIC BILL");
		electric_bill.setBounds(1185, 480, 400, 50);
		electric_bill.setFont(fon2);
		electric_bill.setForeground(Color.red);
		j.add(electric_bill);

		JLabel dot1 = new JLabel("------------------------------------------------------------------------------------------------");
		dot1.setBounds(1066, 507, 650, 30);
		dot1.setFont(fon3);
		j.add(dot1);

		JLabel customer_name = new JLabel(" Customer Name: ");
		customer_name.setBounds(1070, 520, 300, 60);
		customer_name.setForeground(Color.red);
		customer_name.setFont(fon2);
		j.add(customer_name);

		//Setting the nana as dummy so to get the Users First name from database.
		first_lbl = new JLabel();
		first_lbl.setBounds(1218, 520, 200, 60);
		first_lbl.setFont(fon2);
		first_lbl.setForeground(Color.blue);
		first_lbl.setText("NaNa");
		j.add(first_lbl);

		//Setting the nana as dummy so to get the Users Last name from database.

		last_lbl = new JLabel();
		last_lbl.setBounds(1303, 520, 200, 60);
		last_lbl.setFont(fon2);
		last_lbl.setForeground(Color.blue);
		last_lbl.setText("NaNa");
		j.add(last_lbl);

		nea_counter = new JLabel("NEA Counter: ");
		nea_counter.setBounds(1073, 556, 200, 60);
		nea_counter.setFont(fon2);
		nea_counter.setForeground(Color.red);
		j.add(nea_counter);


		lbl_nea_counter = new JLabel();
		lbl_nea_counter.setBounds(1218, 556, 200, 60);
		lbl_nea_counter.setFont(fon2);
		lbl_nea_counter.setForeground(Color.blue);
		lbl_nea_counter.setText("NaNa");
		j.add(lbl_nea_counter);


		JLabel customer_id = new JLabel("Customer ID : ");
		customer_id.setBounds(1073, 592, 200, 60);
		customer_id.setFont(fon2);
		customer_id.setForeground(Color.red);
		j.add(customer_id);


		customer_lbl = new JLabel();
		customer_lbl.setBounds(1220, 592, 200, 60);
		customer_lbl.setFont(fon2);
		customer_lbl.setForeground(Color.blue);
		customer_lbl.setText("NaNa");
		j.add(customer_lbl);

		JLabel unit_cons = new JLabel("Unit Consumed: ");
		unit_cons.setBounds(1073, 628, 200, 60);
		unit_cons.setFont(fon2);
		unit_cons.setForeground(Color.red);
		j.add(unit_cons);

		consumed_lbl = new JLabel();
		consumed_lbl.setBounds(1220, 625, 200, 60);
		consumed_lbl.setFont(fon2);
		consumed_lbl.setForeground(Color.blue);
		consumed_lbl.setText("NaNa");
		j.add(consumed_lbl);

		JLabel dot3 = new JLabel("------------------------------------------------------------------------------------------------");
		dot3.setBounds(1066, 665, 650, 30);
		dot3.setFont(fon3);
		j.add(dot3);

		JLabel total = new JLabel("Total Amount: ");
		total.setBounds(1073, 675, 200, 60);
		total.setForeground(Color.red);
		total.setFont(fon2);
		j.add(total);

		total_lbl = new JLabel();
		total_lbl.setBounds(1220, 675, 200, 60);
		total_lbl.setFont(fon2);
		total_lbl.setForeground(Color.blue);
		total_lbl.setText("NaNa");
		j.add(total_lbl);

		in_word = new JLabel();
		in_word.setBounds(1084, 710, 400, 60);
		in_word.setFont(fon2);
		in_word.setForeground(Color.red);
		in_word.setText("");
		j.add(in_word);

		lbl_transaction_pin = new JLabel("Enter Your Transaction Pin :");
		lbl_transaction_pin.setForeground(Color.GREEN);
		lbl_transaction_pin.setFont(new Font("times new roman", Font.BOLD, 24));
		lbl_transaction_pin.setBounds(100, 690, 350, 40);
		j.add(lbl_transaction_pin);

		lbl_Your_Balance = new JLabel("Your Balance :");
		lbl_Your_Balance.setBounds(100, 330, 350, 40);
		lbl_Your_Balance.setFont(fon1);
		lbl_Your_Balance.setForeground(Color.BLACK);
		j.add(lbl_Your_Balance);

		total_your_lbl = new JLabel();
		total_your_lbl.setBounds(270, 330, 200, 40);
		total_your_lbl.setFont(fon2);
		total_your_lbl.setForeground(Color.black);
		String value = String.valueOf(your_amount);
		total_your_lbl.setText(value);
		j.add(total_your_lbl);

		displayName();
		background.setBounds(0, 0, 1920, 1080);
		j.add(background);
		j.setSize(1920, 1080);
		j.setLayout(null);
		j.setVisible(true);


	}

	public void displayName() {

		try {
			DbConnection db = new DbConnection();
			String query = "Select first_name,last_name from register_credential where first_name='" + this.first_name + "'";
			ResultSet rs = db.select(query);
			while (rs.next()) {

				String first = rs.getString("first_name");
				String last = rs.getString("last_name");
				first_lbl.setText(first);
				last_lbl.setText(last);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String ac_no = account_number;
		String customer = txt_costumer_id.getText();
		String unit_consumed = txt_unit_consumed.getText();
		String transaction_pin = txt_transaction_pin.getText();
		String total = total_lbl.getText();
		String dd = Objects.requireNonNull(choose.getSelectedItem()).toString();

		Users u = new Users();
		u.setCustomer(customer);
		u.setUnit_consumed(unit_consumed);
		u.setTransaction_pin(transaction_pin);
		u.setTotal(total);
		u.setDd(dd);


		System.out.println(total);
		int per_uni = 6;


		if (e.getSource() == btn_account) {
			new MyAccount(first_name);
			j.dispose();

		} else if (e.getSource() == btn_update) {
			new Update();
			j.dispose();
		} else if (e.getSource() == btn_delete) {
			new Delete();
			j.dispose();
		} else if (e.getSource() == btn_proceed) {
			if (Objects.equals(customer, "") && Objects.equals(unit_consumed, "") && Objects.equals(transaction_pin, "")) {
				JOptionPane.showMessageDialog(j, "Fill up the empty Space");
			} else {
				try {
					DbConnection db = new DbConnection();
					String query = "Select t_pin from register_credential where  t_pin='" + u.getTransaction_pin() + "' and customer_id ='" + u.getCustomer() + "'";
					ResultSet rs = db.select(query);

					if (rs.next()) {
						JOptionPane.showMessageDialog(j, "Transaction Completed Sucessfully");
						int total_unit = Integer.parseInt(unit_consumed);
						sum = per_uni * total_unit;
						this.your_amount = this.your_amount - sum;
						System.out.println(sum);
						String per_unit_change = String.valueOf(per_uni);
						String sum_unit = String.valueOf(sum);
						customer_lbl.setText(customer);
						consumed_lbl.setText(unit_consumed);
						consumed_lbl.setText(per_unit_change);
						lbl_nea_counter.setText(dd);
						total_lbl.setText(sum_unit);
						total_your_lbl.setText(String.valueOf(this.your_amount));
						in_word.setText("Rs. " + sum + " has been deduced successfully.");
						txt_costumer_id.setText("");
						txt_unit_consumed.setText("");
						txt_transaction_pin.setText("");
						try {

							String query1 = "update Account SET amount = '" + this.your_amount + "' where account_number = '" + ac_no + "' ";

							db.update(query1);

							System.out.println("data is updated.");

						} catch (Exception rel) {
							rel.printStackTrace();
						}


					} else {
						JOptionPane.showMessageDialog(j, "Wrong Customer id or Transaction pin, Try again");

					}

				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}

			}


		}
	}
		public void displayAmount() {
			try {
				DbConnection db = new DbConnection();
				String query = "Select amount from Account where password = '" + this.password + "' ";

				ResultSet rs = db.select(query);
				while (rs.next()) {
					this.your_amount = rs.getInt("amount");
				}
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}






