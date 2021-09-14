import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete implements ActionListener {

    JFrame j;
    JButton btn_register,btn_Delete;
    JLabel heading,lbl_fname,lbl_lname,lbl_contact,lbl_password,heading_two,Heading_three,lbl_pin,lbl_customer_id;
    JTextField txt_fname, txt_lname,txt_contact,txt_pin,txt_customer_id;
    Font fon1,fon2,fon3;
    JLabel fname_l,lname_l;
    JPasswordField txt_password;
    public Delete() {

        j = new JFrame();

        //setting the font size (f1 and f2)
        fon1 = new Font("arial",Font.BOLD, 24);

        fon2 = new Font("arial",Font.BOLD, 18);

        fon3 = new Font("arial",Font.TRUETYPE_FONT, 12);


        heading = new JLabel("Delete Account");
        heading.setFont(fon1);
        heading.setForeground(Color.red);
        heading.setBounds(675,244,350,40);
        j.add(heading);

        heading_two = new JLabel("Delete Your Account !!! ");
        heading_two.setFont(fon3);
        heading_two.setForeground(Color.black);
        heading_two.setBounds(698,268,350,40);
        j.add(heading_two);


        Heading_three = new JLabel("Confirm Your Account ! !!");
        Heading_three.setFont(fon2);
        Heading_three.setForeground(Color.GRAY);
        Heading_three.setBounds(650,330,350,40);
        j.add(Heading_three);

//        lbl_fname = new JLabel("First Name");
//        lbl_fname.setForeground(Color.blue);
//        lbl_fname.setFont(fon2);
//        lbl_fname.setBounds(590,315,350,40);
//        j.add(lbl_fname);
//
//        txt_fname = new JTextField();
//        txt_fname.setForeground(Color.black);
//        txt_fname.setFont(fon3);
//        txt_fname.setBounds(590,347,350,40);
//        j.add(txt_fname);
//
//
//        lbl_lname = new JLabel("Last Name");
//        lbl_lname.setForeground(Color.blue);
//        lbl_lname.setFont(fon2);
//        lbl_lname.setBounds(590,385,350,40);
//        j.add(lbl_lname);
//
//        txt_lname = new JTextField();
//        txt_lname.setForeground(Color.black);
//        txt_lname.setFont(fon3);
//        txt_lname.setBounds(590,420,350,40);
//        j.add(txt_lname);

        lbl_customer_id = new JLabel("Costumer ID");
        lbl_customer_id.setForeground(Color.blue);
        lbl_customer_id.setFont(fon2);
        lbl_customer_id.setBounds(590,385,350,40);
        j.add(lbl_customer_id);

        txt_customer_id = new JTextField();
        txt_customer_id.setForeground(Color.black);
        txt_customer_id.setFont(fon3);
        txt_customer_id.setBounds(590,420,350,40);
        j.add(txt_customer_id);


        lbl_password = new JLabel("Password ");
        lbl_password.setForeground(Color.blue);
        lbl_password.setFont(fon2);
        lbl_password.setBounds(590,455,350,40);
        j.add(lbl_password);

        txt_password = new JPasswordField();
        txt_password.setForeground(Color.black);
        txt_password.setFont(fon3);
        txt_password.setBounds(590,489,350,40);
        j.add(txt_password);

//        lbl_pin = new JLabel("Transaction Pin");
//        lbl_pin.setForeground(Color.blue);
//        lbl_pin.setFont(fon2);
//        lbl_pin.setBounds(590,528,150,40);
//        j.add(lbl_pin);
//
//        txt_pin = new JPasswordField();
//        txt_pin.setForeground(Color.black);
//        txt_pin.setFont(fon3);
//        txt_pin.setBounds(590,564,165,40);
//        j.add(txt_pin);

        btn_Delete = new JButton(" DELETE ");
        btn_Delete.setForeground(Color.blue);
        btn_Delete.setFont(fon2);
        btn_Delete.setBounds(690,580,150,40);
        btn_Delete.addActionListener(this);
        j.add(btn_Delete);


        ImageIcon sec_backgroung = new ImageIcon("C:\\register.png");
        JLabel back_ground = new JLabel("",sec_backgroung,JLabel.CENTER);
        back_ground.setBounds(580,240,400,450);
        j.add(back_ground);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        String customerid = txt_customer_id.getText();
        String password = txt_password.getText();

        if (e.getSource() == btn_Delete) {
            try {
                DbConnection db = new DbConnection();
//                String query = "Delete * from register_credential where customerid='" + customerid + "' and password='" + password + "'";
                String sql = "DELETE FROM register_credential where password='"+password+"'";
                int rs = db.delete(sql);
                JOptionPane.showMessageDialog(j, "Youe Account has been deleted sucessfully.");
                new login();
                j.dispose();

            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
        else{
            JOptionPane.showMessageDialog(j, "Password do not match try again.");
        }
    }
}
