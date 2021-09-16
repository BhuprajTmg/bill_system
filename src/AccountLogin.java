import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class AccountLogin implements ActionListener {
    JFrame j;
    JButton btn_c_account, btn_login;
    JLabel heading, lbl_account_number, lbl_password, heading_two, lbl_amount;
    JTextField txt_amount, txt_account_number;
    Font fon1, fon2, fon3;
    JPasswordField txt_password;
    int final_amount;
    String username;
    public AccountLogin(String username) {
        this.username = username;
        j = new JFrame();

        //setting the font size (f1 and f2)
        fon1 = new Font("arial", Font.BOLD, 24);

        fon2 = new Font("arial", Font.BOLD, 18);

        fon3 = new Font("arial", Font.TRUETYPE_FONT, 12);


        heading = new JLabel("Login Your Account");
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

        lbl_password = new JLabel("Password");
        lbl_password.setForeground(Color.blue);
        lbl_password.setFont(fon2);
        lbl_password.setBounds(590, 415, 350, 40);
        j.add(lbl_password);

        txt_password = new JPasswordField();
        txt_password.setForeground(Color.black);
        txt_password.setFont(fon3);
        txt_password.setBounds(590, 455, 350, 40);
        j.add(txt_password);

        btn_login = new JButton("Login");
        btn_login.setForeground(Color.blue);
        btn_login.setFont(fon2);
        btn_login.addActionListener(this);
        btn_login.setBounds(590, 580, 160, 40);
        j.add(btn_login);

        btn_c_account = new JButton("Create Ac.");
        btn_c_account.setForeground(Color.blue);
        btn_c_account.setFont(fon2);
        btn_c_account.addActionListener(this);
        btn_c_account.setBounds(780, 580, 160, 40);
        j.add(btn_c_account);

        ImageIcon sec_backgroung = new ImageIcon("C:\\data.png");
        JLabel back_ground = new JLabel("",sec_backgroung,JLabel.CENTER);
        back_ground.setBounds(580,250,400,400);
        j.add(back_ground);

        // Setting the background of the window.
        ImageIcon background_ing = new ImageIcon("C:\\top.png");
        Image img = background_ing.getImage();
        Image tem_img = img.getScaledInstance(1545,1074, Image.SCALE_SMOOTH);
        background_ing = new ImageIcon(tem_img);
        JLabel background = new JLabel("",background_ing,JLabel.LEFT);

        background.setBounds(0,0,1920,1080);
        j.add(background);

        j.setSize(1920, 1080);
        j.setLayout(null);
        j.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {


        String ac_number = txt_account_number.getText();
        String password = txt_password.getText();


        if (e.getSource()==btn_login) {
            if(Objects.equals(ac_number, "") || Objects.equals(password, "")){
                JOptionPane.showMessageDialog(j,"Fill Up The Empty Spaces.","Account Login",JOptionPane.PLAIN_MESSAGE);

            }
            else {
                // Open a connection
                try {
                    DbConnection db = new DbConnection();
                    String query = "Select account_number,password from Account where account_number='"+ac_number+"' and  password='"+password+"'";
                    ResultSet rs = db.select(query);
                    if(rs.next()) {
                        JOptionPane.showMessageDialog(j, "Login Successful ");
                        new userPannel(username,password);
                        j.dispose();

                    }else
                    {
                        JOptionPane.showMessageDialog(j, "No Data Found In Database");
                    }
                }catch(SQLException throwables) {
                    throwables.printStackTrace();
                }

            }

        }
        else if (e.getSource()==btn_c_account){
            new CreateAccount();
        }

    }
}
