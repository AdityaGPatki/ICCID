package com.iccid;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BuscarIccidDBConnection {

	// static String region;
	Statement smt;

	ArrayList<String> dataValue = new ArrayList<>();

	public BuscarIccidDBConnection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("Driver Loaded...");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//10.129.229.178:1521/slrc", "cpm", "7aveiro");
		System.out.println("Connected....");
		smt = conn.createStatement();

	}

	public ResultSet getBuscalccid(int x, int y) throws SQLException {

		ResultSet resultsetIccid = smt.executeQuery("SELECT ICCID, IMSI FROM GSIM.SIMCARD@GSIM G WHERE 1=1 AND ID_HLR =" + y + " AND STATUS_CODE = '07' AND KIT_TYPE = 0 AND MSISDN = '000000000000' AND NOT EXISTS (SELECT IMSI FROM slr_clients S WHERE S.IMSI = G.IMSI)");
		return resultsetIccid;
	}
}
