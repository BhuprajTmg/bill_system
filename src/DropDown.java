import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class DropDown {
	JFrame j;
	JComboBox cb;
	
	public DropDown(){
		j = new JFrame();
		   
	    String country[]={"India","Aus","U.S.A","England","Newzealand"};        
	    JComboBox cb=new JComboBox(country);    
	    cb.setBounds(50, 50,90,20);
//	    
	    j.add(cb);        
	    j.setLayout(null);    
	    j.setSize(400,500);    
	    j.setVisible(true); 
	
	
	}    
public static void main(String[] args) {
	new DropDown();
}

}
