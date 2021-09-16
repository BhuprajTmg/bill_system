import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyAccount implements ActionListener {
    JFrame j;
    JButton btn_c_account, btn_deposit;
    JLabel heading, lbl_account_number, lbl_password, heading_two, lbl_amount;
    JTextField txt_amount, txt_account_number;
    Font fon1, fon2, fon3;
    JPasswordField txt_password;
    int final_amount;
    String username;

    public MyAccount(String username) {
        this.username = username;
        j = new JFrame();

        //setting the font size (f1 and f2)
        fon1 = new Font("arial", Font.BOLD, 24);

        fon2 = new Font("arial", Font.BOLD, 18);

        fon3 = new Font("arial", Font.TRUETYPE_FONT, 12);


        heading = new JLabel("My Account");
        heading.setFont(fon1);
        heading.setForeground(Color.BLACK);
        heading.setBounds(590, 244, 350, 40);
        j.add(heading);

        heading_two = new JLabel("Good health is not something we can buy. Your diet is your account.");
        heading_two.setFont(fon3);
        heading_two.setForeground(Color.BLACK);
        heading_two.setBounds(590, 274, 350, 40);
        j.add(heading_two);

        lbl_account_number = new JLabel("Account No.");
        lbl_account_number.setForeground(Color.blue);
        lbl_account_number.setFont(fon2);
        lbl_account_number.setBounds(590, 330, 350, 40);
        j.add(lbl_account_number);

        txt_account_number = new JTextField();
        txt_account_number.setForeground(Color.black);
        txt_account_number.setFont(fon3);
        txt_account_number.setBounds(590, 370, 350, 40);
        j.add(txt_account_number);

        lbl_amount = new JLabel("Enter Amount ");
        lbl_amount.setForeground(Color.blue);
        lbl_amount.setFont(fon2);
        lbl_amount.setBounds(590, 415, 350, 40);
        j.add(lbl_amount);

        txt_amount = new JTextField();
        txt_amount.setForeground(Color.black);
        txt_amount.setFont(fon3);
        txt_amount.setBounds(590, 455, 350, 40);
        j.add(txt_amount);


        lbl_password = new JLabel("Password");
        lbl_password.setForeground(Color.blue);
        lbl_password.setFont(fon2);
        lbl_password.setBounds(590, 495, 350, 40);
        j.add(lbl_password);

        txt_password = new JPasswordField();
        txt_password.setForeground(Color.black);
        txt_password.setFont(fon3);
        txt_password.setBounds(590, 535, 350, 40);
        j.add(txt_password);


        btn_deposit = new JButton("Deposit");
        btn_deposit.setForeground(Color.blue);
        btn_deposit.setFont(fon2);
        btn_deposit.addActionListener(this);
        btn_deposit.setBounds(590, 610, 160, 40);
        j.add(btn_deposit);

        btn_c_account = new JButton("Create Ac.");
        btn_c_account.setForeground(Color.blue);
        btn_c_account.setFont(fon2);
        btn_c_account.addActionListener(this);
        btn_c_account.setBounds(780, 610, 160, 40);
        j.add(btn_c_account);

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

    public static void main(String[] args) {
        new MyAccount("uma");
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String depo_amount = txt_amount.getText();
        String account = txt_account_number.getText();
        String password = txt_password.getText();


        if (e.getSource()==btn_c_account){
            new CreateAccount();
            j.dispose();
        }

        try{
            DbConnection db = new DbConnection();
            String query = "Select amount from Account where password = '"+password+"' ";

            ResultSet rs = db.select(query);
            while(rs.next()){
                this.final_amount = rs.getInt("amount");
            }
        }catch (Exception exc){
            exc.printStackTrace();
        }

        int d_amunt = Integer.parseInt(depo_amount);

        int new_amount = final_amount + d_amunt ;

        String Final_d_a = String.valueOf(new_amount);


        if(e.getSource()==btn_deposit){
            if (depo_amount.equals("") || account.equals("") || password.equals("")){
                JOptionPane.showMessageDialog(j,"Fill up the empty space.","My account",JOptionPane.PLAIN_MESSAGE);
            }
            else {
                try {
                    DbConnection db = new DbConnection();

                    String query = "update Account SET amount = '"+Final_d_a+"' where password = '"+password+"' ";

                    db.update(query);

                    System.out.println("data is updated.");

                    JOptionPane.showMessageDialog(j,"Your amount has been deposited successfully","My account",JOptionPane.PLAIN_MESSAGE);
                    new userPannel(username,password);
                    j.dispose();

                }catch (Exception rel) {
                    rel.printStackTrace();
                }
            }


        }else if(e.getSource() ==btn_c_account){


        }

    }
}





