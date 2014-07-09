package com.jag.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestOracle {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String user = "test";
			String password = "test";
			String url = "jdbc:oracle:thin:@192.168.0.100:1521:jag522";

			Class.forName(driver);

			conn = DriverManager.getConnection(url, user, password);

			Statement s = conn.createStatement();
			

			String sql1 = "select sysdate from dual";
			String sql2 = "select name from article_class where id=1";
			String sql3 = "update article_class set name='2' where id=1";
			String sql4 = "select name from article_class where id=?";
			String sql5 = "update article_class set name='2' where id=?";

			PreparedStatement pstmt = conn.prepareStatement(sql4);
			pstmt.setString(1,"1");
			ResultSet rs2 = pstmt.executeQuery();
			if(rs2.next()) {
				System.out.println(rs2.getString(1));
			}
			rs2.close();
//			pstmt.close();
			pstmt = conn.prepareStatement(sql5);
			pstmt.setString(1,"1");
			int d = pstmt.executeUpdate();
			System.out.println("rows number:" + d);
			
//			ResultSet rs = s.executeQuery(sql1);
//			if(rs.next()) {
//				System.out.println(rs.getString(1));
//			}
//			rs = s.executeQuery(sql2);
//			if(rs.next()) {
//				System.out.println(rs.getString(1));
//			}
//			s.executeUpdate(sql3);
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
