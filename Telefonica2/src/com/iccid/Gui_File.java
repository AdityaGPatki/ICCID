package com.iccid;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
 class Gui_file
{
	public static void main(String args[])
	{
		Test t= new Test();
		//t.labl();
	}
}

class Test extends Frame implements ActionListener
{
	Label Ent_pth,labl_update;
	TextField pth_gt_tf;
	Button btn_strt,btn_fld_fle,btn_cls;
	Panel pnl,pnl_btn,pnl_txt;
	public Test()
	{
		super("Folder Stacking");
		setLayout(new FlowLayout());
		//setLayout(new GridLayout(2,3));
		setSize(200,400);
		
		pnl_txt=new Panel();
		pnl_txt.setLayout(new GridLayout(1,2,3,3));
		Ent_pth=new Label("Enter Path");
		pnl_txt.add(Ent_pth);
		pth_gt_tf=new TextField("",20);
		pnl_txt.add(pth_gt_tf);
		add(pnl_txt);
		
		pnl_btn=new Panel();
		pnl_btn.setLayout(new GridLayout(1,3));
		btn_strt=new Button("File_to_foldr");
		pnl_btn.add(btn_strt);
		btn_strt.addActionListener(this);
		
		btn_fld_fle =new Button("Foldr_to_file");
		pnl_btn.add(btn_fld_fle);
		btn_fld_fle.addActionListener(this);
				
		btn_cls =new Button("Close");
		pnl_btn.add(btn_cls);
		btn_cls.addActionListener(this);
		add(pnl_btn);
		
		int WIDTH=100;
		pnl=new Panel();
		pnl.setLayout(new GridLayout(1,1));
		labl_update=new Label("man");
		labl_update.setAlignment(Label.WIDTH);
		pnl.add(labl_update);
		add(pnl);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str;
		str=ae.getActionCommand();
		if(str.equals("Close"))
		{
			this.dispose();
		}
		if(str.equals("File_to_foldr"))
		{
			
			int i;
			String path_g=pth_gt_tf.getText();
			if(path_g.equals(""))
			{
				pth_gt_tf.setText("Fill this first");
			}
			else
			{
			//File f=new File(args[0]);
				File f=new File(path_g);
				String ar[]=f.list();
				String pd;
				int pos,lnt;
			
				for(i=0;i<ar.length;i++)
				{	
					labl_update.setText(ar[i]);				
					
					String pat;
					//pat=args[0];
					pat=path_g;
					pat=pat.concat("/");
					pat=pat.concat(ar[i]);
					File fil=new File(pat);			
					if(fil.isFile())
					{
						//System.out.println(ar[i]);
						lnt=ar[i].length();
						pos=ar[i].lastIndexOf('.');
				
						//System.out.println(" SubString of"+ar[i]+ " is: " +ar[i].substring(pos,lnt));
						pd=ar[i].substring(pos+1,lnt);
				
						String folder_path;
						//folder_path=args[0];
						folder_path=path_g;
						folder_path=folder_path.concat("/");
						folder_path=folder_path.concat(pd);
						File fld=new File(folder_path);
						
						//System.out.println("Folder_path: "+fld);			
						if(fld.isDirectory())
						{
							//System.out.println("File already Exist...");
							//++i;
						}	
						else
						{
							fld.mkdir();
						}
						//.out.println("Folder name: " +fld);
						//System.out.println("Path : "+args[0]);
						//System.out.println("File name: " +ar[i]);
						//String path=args[0];
						String path=path_g;
						String path1,path2;
						String fil_1,fol_1;
						fil_1=ar[i];
						//fil_1=fil_1.concat("/");
						//fol_1=fol_1.concat("/");
						//path1=path.concat("/ar[i]");
						path=path.concat("/");
						path1=path.concat(fil_1);
						File f_fil=new File(path1);
				
						fol_1=pd;
						path2=path.concat("/");
						path2=path2.concat(pd);
						path2=path2.concat("/");
						path2=path2.concat(fil_1);
						File f_fol=new File(path2);
				
						//System.out.println("f_fil " +f_fil);
						//System.out.println("F_ol: " +f_fol);
				
						f_fil.renameTo(f_fol);
				
						//File f_fil=new File("C:/projv/bok1.pdf");
						//File f_fol=new File("C:/projv/xyz/bok1.pdf");
						//f1.renameTo(f);
				
						//System.out.println("Index of a is " +ar[1].indexOf('d'));
						//System.out.println(ar[1]);
						}
					else if(f.isDirectory())
					{
						//System.out.println("Not a file..");
					}
	
				}
				//pd=ar[1].substring(4,7);
				//System.out.println(pd);
				//File fld=new File(pd);
				//fld.mkdir();	

			}
		}
		if(str.equals("Foldr_to_file"))
		{
			String path_g=pth_gt_tf.getText();
			if(path_g.equals(""))
			{
				pth_gt_tf.setText("Fill this");
			}
			else
			{
				int i,j;
				//File f=new File(args[0]);
				File f=new File(path_g);
				String ar[]=f.list();
				String pd,path_fld,path_fil;
				int pos,lnt;
				for(i=0;i<ar.length;i++)
				{
					labl_update.setText(ar[i]);
					int lnth;
					String fld,fld_path;
					lnth=ar[i].length();
					//fld1=ar[i].substring(0,lnth);
					fld=ar[i].substring(0,lnth);	
					//fld_path=args[0];
					fld_path=path_g;
					fld_path=fld_path.concat("/");
					fld_path=fld_path.concat(fld);
					
					File fd=new File(fld_path);
					//System.out.println("Folder is 1: " +fld);
					//System.out.println("Folder is 2: " +fld_path);
					if(fd.isDirectory())
					{
						//System.out.println("Mandeep:" );
						//System.out.println("Folder is : " +ar[i]);
						File nfd=new File(fld_path);
						String ar2[]=nfd.list();
						for(j=0;j<ar2.length;j++)
						{
							//System.out.println("File is : " +ar2[j]);
							//path_fld=args[0];
							path_fld=path_g;
							path_fld=path_fld.concat("/");
							path_fld=path_fld.concat(fld);
							path_fld=path_fld.concat("/");
							path_fld=path_fld.concat(ar2[j]);
							//System.out.println("path fold : " +path_fld);
							File folder=new File(path_fld);
							//path_fil=args[0];
							path_fil=path_g;
							path_fil=path_fil.concat("/");
							path_fil=path_fil.concat(ar2[j]);
							//System.out.println("path_file : " +path_fil);
							File file=new File(path_fil);
							folder.renameTo(file);
							fd.delete();
						}
						
					}	
				}
			}
		}
			
	}
}
	