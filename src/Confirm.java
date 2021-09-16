import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Confirm implements ActionListener {
    JFrame j;
    Connection con;
    JFrame data;
    JLabel lbl_heading, lbl_username, lbl_password,lbl_login;
    JTextField txt_username;
    JPasswordField txt_password;
    JButton btn_confirm;
    Font fon1, fon2,fon3;

    public Confirm(){
        j = new JFrame();
        data = new JFrame();
        fon1 = new Font("arial",Font.BOLD, 24);

        fon2 = new Font("arial",Font.BOLD, 18);

        fon3 = new Font("arial",Font.TRUETYPE_FONT, 12);


        lbl_heading = new JLabel(" CONFIRMATION ");
        lbl_heading.setForeground(Color.BLACK);
        lbl_heading.setFont(fon1);
        lbl_heading.setBounds(590,270,400,30);
        j.add(lbl_heading);

        lbl_login = new JLabel("Confirm Your Transaction ");
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

        btn_confirm = new JButton(" Confirm ");
        btn_confirm.setForeground(Color.BLUE);
        btn_confirm.setFont(fon2);
        btn_confirm.addActionListener(this);
        btn_confirm.setBounds(590,555,140,44);
        j.add(btn_confirm);

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

    }public static void main(String[] args){
        new Confirm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn_confirm){

        }
    }
}
