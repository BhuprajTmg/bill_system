
	import javax.swing.JFrame;
	import javax.swing.JInternalFrame;
	import javax.swing.JDesktopPane;
	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JPanel;

	import java.awt.*;
	import java.awt.event.*;
public class CreateInternalFrame {

		JFrame frame;
		JInternalFrame inner1, inner2, inner3, inner4, inner5, inner6;
		JButton button;
		JPanel panel;
		JLabel lable;
		JDesktopPane desktop = new JDesktopPane();	
		boolean resizable = true, closable = true, maximizable = true,
		iconifiable = true;
		int pos = 25;
		int width = 200, height = 100; 
		
		public void createMainFrameGUI()
		{
			frame = new JFrame("Main Frame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
			frame.setLayout(new BorderLayout());		
			button = new JButton("Create Frames");
			panel = new JPanel();
			button.setBounds(50, 150, 100, 20);
			button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					createInternalFrameGUI();
				}
			}
			);
			panel.add(button);		
			frame.add(panel);		
			frame.setVisible(true);
			frame.setSize(400, 300);		
		}
		
		public void createInternalFrameGUI()
		{
			inner1 = new JInternalFrame();
			inner1.setBounds(0, 0, width, height);
			
			
			
			inner1.setVisible(true);
			
			desktop.add(inner1);
			frame.add(desktop);
			frame.setContentPane(desktop);
			desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		}
		public static void main(String args[])
		{
			CreateInternalFrame cif = new CreateInternalFrame();
			cif.createMainFrameGUI();
		}
	}

