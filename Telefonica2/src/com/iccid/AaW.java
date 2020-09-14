package com.iccid;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class AaW {
	public static void main(String args[]) {
		Iccid obj = new Iccid();
	}


}

class Iccid extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	static JFrame f;

	static JTextField l,l1,l2;
	
	static JLabel Region, Quantity;
	//main function
	Iccid() {
		
		// create a frame
		f = new JFrame("Buscar Iccid");

		try {
			// set look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// create a textfield and location
		l = new JTextField(50);
		l.setBounds(160, 20, 100, 20);
	//	 l.setLayout(new FlowLayout(FlowLayout.RIGHT));
		l1= new JTextField(40);
		 l2= new JTextField(50);
		 l2.setBounds(250,250, 150,120);
		 
		 //create Label
		 Region = new JLabel("Region");
		Region.setLocation(100, 20);
		 Region.setLayout(new FlowLayout(FlowLayout.CENTER));
		 Region.setLabelFor(l);
		 
		 Quantity = new JLabel("Quantity");
		 Quantity.setLocation(100, 130);
		 Region.setSize(100, 50);
		 Region.setLabelFor(l2);
		 
	
		 

		// set the textfield to non editable
	//	l2.setEditable(false);
		
		
		// create  buttons and some operators
				JButton b,b1;
				
				// create operator buttons
				b = new JButton("Buscar");
				b1= new JButton("Copiar");	
				
				// create a panel
				JPanel p = new JPanel();
				p.setLayout(null);
				
				b.addActionListener(this);
				b1.addActionListener(this);
			
				
				// add elements to panel
				p.add(l);
				p.add(l1);
				p.add(b);
				p.add(b1);
				p.add(Region);
				p.add(Quantity);
				p.add(l2);
				
			
				// set Background of panel
				p.setBackground(Color.white);
				
				
				
				// add panel to frame
				f.add(p);

				f.setSize(600, 620);
				f.show(true);
				   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			}
				
				
				
		
	

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		
		
	}

	
	 
}