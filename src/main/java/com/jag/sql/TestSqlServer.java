package com.jag.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSqlServer {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String user = "sa";
			String password = "vanceinfo";
			String url = "jdbc:microsoft:sqlserver://192.168.0.118:1433;DatabaseName=geta_for_test";

			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("OK");
			Statement s = conn.createStatement();
			String sql1 = "select count(*) from d_ta_clients";
			ResultSet rs = s.executeQuery(sql1);
			if(rs.next()) {
				System.out.println(rs.getString(1));
			}
		}
		catch (Exception e) {
			System.err.println(e);
		}
		finally {
			try {
				conn.close();
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

}
