package com.iccid;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BuscarIccidDBConnection {

	// static String region;
	static int y;
	static int x ;
	Statement smt;

	ArrayList<String> dataValue = new ArrayList<>();
	public BuscarIccidDBConnection()  throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("Driver Loaded...");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//10.129.229.178:1521/slrc", "cpm", "7aveiro");
		System.out.println("Connected....");
		smt = conn.createStatement();

	}
	
	public ArrayList<String> getBuscalccid(int y, int x) throws SQLException {
		
	//	ResultSet iccid = smt.executeQuery("SELECT ICCID, STATUS_CODE,ID_HLR , IMSI, MSISDN FROM GSIM.SIMCARD@GSIM G WHERE 1=1 AND ID_HLR =" + y + " AND STATUS_CODE = '07' AND KIT_TYPE = 0 AND MSISDN = '000000000000' AND NOT EXISTS (SELECT IMSI FROM slr_clients S WHERE S.IMSI = G.IMSI)");
        
		
		ResultSet iccid = smt.executeQuery("SELECT ICCID, IMSI FROM GSIM.SIMCARD@GSIM G WHERE 1=1 AND ID_HLR =" + y + " AND STATUS_CODE = '07' AND KIT_TYPE = 0 AND MSISDN = '000000000000' AND NOT EXISTS (SELECT IMSI FROM slr_clients S WHERE S.IMSI = G.IMSI)");
		ResultSetMetaData rsmd = iccid.getMetaData();
		int columnCount = rsmd.getColumnCount();

		System.out.println(columnCount);

		for (int j = 1; j <= x; j++) {
			outerloop: while (iccid.next()) {
				for (int i = 1; i <= columnCount; i++) {
					if (i > 1)
						System.out.print(",  ");
					String columnValue = iccid.getString(i);
					dataValue.add(columnValue);
					 System.out.print(rsmd.getColumnName(i) + " " + columnValue);
				//	System.out.print(columnValue);
					// System.out.println(iccid.getString(i));

				}
				// i
				System.out.println("\n");
				break outerloop;
			}
		}		
		return dataValue;
	}
}
