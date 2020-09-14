package com.iccid;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;
	import java.sql.SQLException;
	import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;

	public class BuscarIccid {
	
		//static String region;
		static int y=11;
		static int x=10;

		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver Loaded");
			
			Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@//10.129.229.178:1521/slrc", "cpm", "7aveiro");
			System.out.println("Connected");
			Statement smt=conn.createStatement();
			
			ResultSet iccid =	smt.executeQuery("SELECT ICCID, STATUS_CODE,ID_HLR , IMSI, MSISDN FROM GSIM.SIMCARD@GSIM G WHERE 1=1 AND ID_HLR ="+ y +" AND STATUS_CODE = '07' AND KIT_TYPE = 0 AND MSISDN = '000000000000' AND NOT EXISTS (SELECT IMSI FROM slr_clients S WHERE S.IMSI = G.IMSI)");
				//ResultSet iccid =	smt.executeQuery("Insert into adminprov2_10.inv_nbr_pool( msisdn, min_msisdn, dig7, area_code, status_number, id_parcel,date_import, date_status_change, category_msisdn, nbr_internal)Values('11995054252','11995054252', 0, 11, 0, -999999999,TO_DATE('03/12/2009 13:24:39','MM/DD/YYYY HH24:MI:SS'),TO_DATE('03/20/2009 12:20:03','MM/DD/YYYY HH24:MI:SS'),3,'Y')");
				//ResultSet iccid1 =	smt.executeQuery("commit");
			ResultSetMetaData rsmd = iccid.getMetaData();
			
			int columnCount = rsmd.getColumnCount();
			
			System.out.println(columnCount);
		
			for(int j=1; j<=x; j++) {
				outerloop:
			while(iccid.next()){
				for (int i = 1; i <=columnCount ; i++ ) {
					if (i > 1)
					System.out.print(",  ");
					String columnValue = iccid.getString(i);
					System.out.print(rsmd.getColumnName(i) + " "+columnValue);
					//System.out.println(iccid.getString(i));
					
				}
				//i
	      System.out.println("\n");
	      break outerloop;
		}
			

		}
     

	}}


