import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;
public class Bill extends JFrame implements ActionListener{
    JTextField txtdata;
    JButton calbtn = new JButton("Calculate");

    public Bill()
    {
        JPanel myPanel = new JPanel();
        add(myPanel);
        myPanel.setLayout(new GridLayout(3, 2));
        myPanel.add(calbtn);
        calbtn.addActionListener(this);
        txtdata = new JTextField();
        myPanel.add(txtdata);
    }
    public static void main(String args[])
    {
    	Bill g = new Bill();
        g.setLocation(10, 10);
        g.setSize(300, 300);
        g.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		{
	        if (e.getSource() == calbtn) {
	            String data = txtdata.getText(); //perform your operation
	            System.out.println(data);
	        }
	    }
	}
}
	
	
	


