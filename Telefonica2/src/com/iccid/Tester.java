package com.iccid;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//1st step  
public class Tester implements ActionListener{  
	
	final static TextField tf=new TextField();  
	
    public static void main(String[] args) {  
    Frame f=new Frame("Buscar ICCID");      
    tf.setBounds(50,50, 150,20);  
    Button b=new Button("Click Here");  
    b.setBounds(50,100,60,30);  
    //2nd step  
    b.addActionListener(null);  
    f.add(b);f.add(tf);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);   
}  

@Override
public void actionPerformed(ActionEvent e) {
	 tf.setText("Result");  
}  
}  