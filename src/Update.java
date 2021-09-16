import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Update implements ActionListener {
    JFrame j;
    JButton btn_Update;
    JLabel heading,lbl_fname,lbl_lname,lbl_contact,lbl_password,heading_two,lbl_pin,lbl_customer_id;
    JTextField txt_fname, txt_lname,txt_contact,txt_pin,txt_customer_id;
    Font fon1,fon2,fon3;
    JPasswordField txt_password;
    public Update() {

        j = new JFrame();

        //setting the font size (f1 and f2)
        fon1 = new Font("arial", Font.BOLD, 24);

        fon2 = new Font("arial", Font.BOLD, 18);

        fon3 = new Font("arial", Font.TRUETYPE_FONT, 12);


        heading = new JLabel("Update Details");
        heading.setFont(fon1);
        heading.setForeground(Color.BLACK);
        heading.setBounds(590, 244, 350, 40);
        j.add(heading);

        heading_two = new JLabel("Update your details by filling out the form!");
        heading_two.setFont(fon3);
        heading_two.setForeground(Color.BLACK);
        heading_two.setBounds(590, 268, 350, 40);
        j.add(heading_two);

        lbl_fname = new JLabel("First Name");
        lbl_fname.setForeground(Color.blue);
        lbl_fname.setFont(fon2);
        lbl_fname.setBounds(590, 315, 350, 40);
        j.add(lbl_fname);

        txt_fname = new JTextField();
        txt_fname.setForeground(Color.black);
        txt_fname.setFont(fon3);
        txt_fname.setBounds(590, 347, 350, 40);
        j.add(txt_fname);


        lbl_lname = new JLabel("Last Name");
        lbl_lname.setForeground(Color.blue);
        lbl_lname.setFont(fon2);
        lbl_lname.setBounds(590, 385, 350, 40);
        j.add(lbl_lname);

        txt_lname = new JTextField();
        txt_lname.setForeground(Color.black);
        txt_lname.setFont(fon3);
        txt_lname.setBounds(590, 420, 350, 40);
        j.add(txt_lname);


        lbl_password = new JLabel("Password ");
        lbl_password.setForeground(Color.blue);
        lbl_password.setFont(fon2);
        lbl_password.setBounds(590, 455, 350, 40);
        j.add(lbl_password);

        txt_password = new JPasswordField();
        txt_password.setForeground(Color.black);
        txt_password.setFont(fon3);
        txt_password.setBounds(590, 489, 350, 40);
        j.add(txt_password);

        lbl_pin = new JLabel("Transaction Pin");
        lbl_pin.setForeground(Color.blue);
        lbl_pin.setFont(fon2);
        lbl_pin.setBounds(590, 528, 150, 40);
        j.add(lbl_pin);

        txt_pin = new JPasswordField();
        txt_pin.setForeground(Color.black);
        txt_pin.setFont(fon3);
        txt_pin.setBounds(590, 564, 165, 40);
        j.add(txt_pin);

        lbl_customer_id = new JLabel("Costumer ID");
        lbl_customer_id.setForeground(Color.blue);
        lbl_customer_id.setFont(fon2);
        lbl_customer_id.setBounds(770, 528, 350, 40);
        j.add(lbl_customer_id);

        txt_customer_id = new JTextField();
        txt_customer_id.setForeground(Color.black);
        txt_customer_id.setFont(fon3);
        txt_customer_id.setBounds(770, 564, 170, 40);
        j.add(txt_customer_id);

        btn_Update = new JButton(" Update ");
        btn_Update.setForeground(Color.blue);
        btn_Update.setFont(fon2);
        btn_Update.addActionListener(this);
        btn_Update.setBounds(700, 625, 150, 40);
        j.add(btn_Update);


        ImageIcon sec_backgroung = new ImageIcon("C:\\register.png");
        JLabel back_ground = new JLabel("", sec_backgroung, JLabel.CENTER);
        back_ground.setBounds(580, 240, 400, 450);
        j.add(back_ground);

        // Setting the background of the window.
        ImageIcon background_ing = new ImageIcon("C:\\top.png");
        Image img = background_ing.getImage();
        Image tem_img = img.getScaledInstance(1545, 1074, Image.SCALE_SMOOTH);
        background_ing = new ImageIcon(tem_img);
        JLabel background = new JLabel("", background_ing, JLabel.LEFT);

        background.setBounds(0, 0, 1920, 1080);
        j.add(background);

        j.setSize(1920, 1080);
        j.setLayout(null);
        j.setVisible(true);

        }
public static void main(String[] args){
        new Update();
}
    @Override
    public void actionPerformed(ActionEvent e) {
        String customerid = txt_customer_id.getText();
        String firstname = txt_fname.getText();
        String lastname = txt_lname.getText();
        String password = txt_password.getText();
        String transaction_pin = txt_pin.getText();

        if (e.getSource()==btn_Update){
            if (customerid.equals("") || firstname.equals("") || lastname.equals("") || password.equals("") || transaction_pin.equals("")){
                JOptionPane.showMessageDialog(j,"Fill up all the empty spaces.","Update Data",JOptionPane.PLAIN_MESSAGE);

            }else {
                try {
                    DbConnection db = new DbConnection();

//                    update updateIfConditionDemo set UserAge =if(UserAge =23,26,UserAge);

                    String query = "update register_credential set first_name = '"+firstname+"',last_name= '"+lastname+"',password='"+password+"', t_pin = '"+transaction_pin+"' where customer_id='"+customerid+"' ";
                    int rs = db.update(query);


                    JOptionPane.showMessageDialog(j,"Your data is updated successfully");
                    j.dispose();
                    new login();
                }catch (Exception rel) {
                    rel.printStackTrace();
                }

            }
        }


    }
}