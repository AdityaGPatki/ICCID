package com.iccid;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Practice extends Frame implements ActionListener {
	Label Region,Quantity;
	TextField reg_input, quan_input;
	Button Buscar;
	Panel pnl;
      public Practice()
                   {
  	   super("Search Iccid");
 	 setLayout(new FlowLayout());
      setSize(200,400);
      pnl=new Panel();
      pnl.setLayout(new GridLayout(1,2,3,3));
      Region=new Label("Region");
      pnl.add(Region);
         
                   }
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
