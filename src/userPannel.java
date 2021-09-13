import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class userPannel implements ActionListener {
	
	JFrame j;
	JLabel lbl_counter,lbl_costumer_id,lbl_scno,background,lbl_transaction_pin;
	JComboBox choose;
	JTextField txt_sc_no,txt_costumer_id,txt_transaction_pin;
	Font fon1,fon2,fon3;
	JButton btn_proceed,btn_exit,btn_cancle,btn_bill;
	public userPannel() {
		
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
		
		
		txt_sc_no = new JTextField();
		txt_sc_no.setForeground(Color.black);
		txt_sc_no.setBackground(Color.lightGray);
		txt_sc_no.setFont(new Font("times new roman",Font.BOLD,24));
		txt_sc_no.setBounds(100,540,500,40);
		j.add(txt_sc_no);
	
		lbl_costumer_id = new JLabel("Cotumer Id");
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
		
		txt_transaction_pin = new JTextField();
		txt_transaction_pin.setForeground(Color.black);
		txt_transaction_pin.setBackground(Color.lightGray);
		txt_transaction_pin.setFont(new Font("times new roman",Font.BOLD,24));
		txt_transaction_pin.setBounds(398,690,202,40);
		j.add(txt_transaction_pin);
		
	    btn_proceed = new JButton("Proceed");
	    btn_proceed.setForeground(Color.blue);
	    btn_proceed.setFont(fon2);
	    btn_proceed.setBounds(695,500,202,40);
		j.add(btn_proceed);
		
		btn_cancle = new JButton("Cancel");
		btn_cancle.setForeground(Color.blue);
		btn_cancle.setFont(fon2);
		btn_cancle.setBounds(695,590,202,40);
		j.add(btn_cancle);
		
		btn_bill = new JButton("Bill");
		btn_bill.setForeground(Color.blue);
		btn_bill.setFont(fon2);
		btn_bill.setBounds(695,675,202,40);
		btn_bill.addActionListener(this);
		j.add(btn_bill);
	    
	    
	    
	 // Setting the background of the window.
		
		
	    ImageIcon background_ing = new ImageIcon("C:\\p.png");
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
@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource()== btn_bill) {
		
		txt_costumer_id.getText();
		System.out.println(txt_costumer_id.getText());
		
		
	}
	
}
	
	

}
