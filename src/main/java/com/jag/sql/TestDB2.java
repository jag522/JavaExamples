package com.jag.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

public class TestDB2 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			String driver = "com.ibm.db2.jcc.DB2Driver";
			String user = "sndbusr";
			String password = "Jsu39asd";
			String url = "jdbc:db2://192.168.40.5:60004/devdb";

			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("OK");
			Statement s = conn.createStatement();
			
			PreparedStatement ps = conn.prepareStatement("update rep_test_jag set field1=?,field2=?, field3=? where id=?");
			ps.setObject(1, "");
			ps.setObject(2, null);
			ps.setObject(3, new Timestamp(System.currentTimeMillis()));
			ps.setObject(4, "3");
			ps.addBatch();
			
			ps.setObject(1, "field2");
			ps.setInt(2, 2);
			ps.setObject(3, new Timestamp(System.currentTimeMillis()));
			ps.setObject(4, "2");
			ps.addBatch();
//			String sql1 = "select count(*) from zst_role";
//			ResultSet rs = s.executeQuery(sql1);
//			if(rs.next()) {
//				System.out.println(rs.getString(1));
//			}
			int[] result1 = ps.executeBatch();
			System.out.println(result1);
			
			ps.setObject(1, "field1");
			ps.setInt(2, 1);
			ps.setObject(3, new Timestamp(System.currentTimeMillis()));
			ps.setObject(4, "1");
			ps.addBatch();
			
			int[] result2 = ps.executeBatch();
			
			System.out.println(result2);
			
//			String sql2 = "insert into XACTIVITYSN (id,activityname,sn) values(1,'22','33')";
//			s.execute(sql2);
		}
		catch (ClassNotFoundException e) {
		}
		catch (SQLException e) {
			System.err.println(e);
			System.out.println("SQLState:" + e.getSQLState());
			System.out.println("ErrorCode:" + e.getErrorCode());
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
