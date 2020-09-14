package com.iccid;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class UserForm extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame("Buscar ICCID");
		JLabel Region = new JLabel("Region");
		JTextField reg_input = new JTextField(20);
		Region.setLabelFor(reg_input);
		reg_input.setBounds(50,50, 150,20);
		
		JLabel Quantity = new JLabel("Quantity");
		 JTextField quan_input = new JTextField(20);
		 Quantity.setLabelFor(quan_input);
		 quan_input.setBounds(50,50, 150,20);
		
		 
		 JPanel panel = new JPanel();
	        panel.setLayout(new SpringLayout());
	        panel.setSize(500, 500);
	        panel.add(Region);
	        panel.add(reg_input);
	        panel.add(Quantity);
	        panel.add(quan_input);
	        
	        
		/*
		 * SpringUtilities.makeCompactGrid(panel, 2, 2, //rows, cols 6, 6, //initX,
		 * initY 6, 6); //xPad, yPad
		 */	 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(300, 100);
	        frame.getContentPane().add(panel);
	        frame.setVisible(true);
		
	}

}
