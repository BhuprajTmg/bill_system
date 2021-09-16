import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccount implements ActionListener {
    JFrame j;
    JButton btn_create;
    JLabel heading,heading_two,lbl_account;
    JTextField txt_account;
    Font fon1,fon2,fon3;
    JLabel lbl_password;
    JPasswordField txt_password;
    public CreateAccount(){
        j = new JFrame();

        //setting the font size (f1 and f2)
        fon1 = new Font("arial",Font.BOLD, 24);

        fon2 = new Font("arial",Font.BOLD, 18);

        fon3 = new Font("arial",Font.TRUETYPE_FONT, 12);


        heading = new JLabel("Create Account");
        heading.setFont(fon1);
        heading.setForeground(Color.BLACK);
        heading.setBounds(590,260,350,40);
        j.add(heading);

        heading_two = new JLabel("Want To Create Account Fill Out The Form!");
        heading_two.setFont(fon3);
        heading_two.setForeground(Color.BLACK);
        heading_two.setBounds(590,295,350,40);
        j.add(heading_two);


        lbl_account = new JLabel("Set Account Number");
        lbl_account.setForeground(Color.blue);
        lbl_account.setFont(fon2);
        lbl_account.setBounds(590,360,350,40);
        j.add(lbl_account);

        txt_account = new JTextField();
        txt_account.setForeground(Color.black);
        txt_account.setFont(fon3);
        txt_account.setBounds(590,400,350,40);
        j.add(txt_account);

        lbl_password = new JLabel("Password");
        lbl_password.setForeground(Color.blue);
        lbl_password.setFont(fon2);
        lbl_password.setBounds(590,440,350,40);
        j.add(lbl_password);

        txt_password = new JPasswordField();
        txt_password.setForeground(Color.black);
        txt_password.setFont(fon3);
        txt_password.setBounds(590,480,350,40);
        j.add(txt_password);

        btn_create = new JButton(" Create ");
        btn_create.setForeground(Color.blue);
        btn_create.setFont(fon2);
        btn_create.addActionListener(this);
        btn_create.setBounds(690,565,150,40);
        j.add(btn_create);


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


        j.setSize(1920,1080);
        j.setLayout(null);
        j.setVisible(true);

    }
//    public static void main(String[] args){
//        new CreateAccount();
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String account_no = txt_account.getText();
        String password = txt_password.getText();

        Users user = new Users();
        user.setAccount_no(account_no);
        user.setPassword(password);

        if (e.getSource()==btn_create){
            System.out.println("database Connected");
            DbConnection db = new DbConnection();
            String query =  "INSERT INTO Account(account_number,password) VALUES('"+user.getAccount_no()+"','"+user.getPassword()+"')";
            db.insert(query);
        }
        JOptionPane.showMessageDialog(j, "Your Account has been created successfully");
//        new MyAccount();
        j.dispose();
        }


    }

