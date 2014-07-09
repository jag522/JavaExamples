package com.jag.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDB2For40610Error {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            String driver = "com.ibm.db2.jcc.DB2Driver";
            String user = "favorite";
            String password = "favorite";
            String url = "jdbc:db2://10.19.95.200:60000/fisdb";

            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("OK");
            //PreparedStatement ps = conn.prepareStatement("MERGE INTO SHOP_FAVORITE8 A USING TABLE (VALUES(?,?,?,?)) AS B (SHOP_ID, CUST_NUM, CHANNEL, ENTRANCE) ON (A.CUST_NUM = B.CUST_NUM AND A.SHOP_ID = B.SHOP_ID) WHEN MATCHED THEN UPDATE SET A.DELETE_FLAG = 0 , A.UPDATE_TIME =CURRENT TIMESTAMP WHEN NOT MATCHED THEN INSERT (SHOP_ID,CUST_NUM,CHANNEL,ENTRANCE) VALUES(?,?,?,?)");
            //PreparedStatement ps = conn.prepareStatement("MERGE INTO SHOP_FAVORITE8 A USING TABLE (VALUES(CAST(? AS VARCHAR(20)) AS SHOP_ID,CAST(? AS VARCHAR(16)) AS CUST_NUM,CAST(? AS INTEGER) AS CHANNEL, CAST(? AS VARCHAR(32)) AS ENTRANCE) AS B (SHOP_ID, CUST_NUM, CHANNEL, ENTRANCE) ON (A.CUST_NUM = B.CUST_NUM AND A.SHOP_ID = B.SHOP_ID) WHEN MATCHED THEN UPDATE SET A.DELETE_FLAG = 0 , A.UPDATE_TIME =CURRENT TIMESTAMP WHEN NOT MATCHED THEN INSERT (SHOP_ID,CUST_NUM,CHANNEL,ENTRANCE) VALUES(CAST(? AS VARCHAR(20)) AS SHOP_ID,CAST(? AS VARCHAR(16)) AS CUST_NUM,CAST(? AS INTEGER) AS CHANNEL, CAST(? AS VARCHAR(32)) AS ENTRANCE)");
            
            //PreparedStatement ps = conn.prepareStatement("MERGE INTO SHOP_FAVORITE8 A USING (SELECT ? AS SHOP_ID,? AS CUST_NUM,CAST(? AS SMALLINT) AS CHANNEL, CAST(? AS VARCHAR(32)) AS ENTRANCE FROM SYSIBM.SYSDUMMY1) AS B ON (A.CUST_NUM = B.CUST_NUM AND A.SHOP_ID = B.SHOP_ID) WHEN MATCHED THEN UPDATE SET A.DELETE_FLAG=0 , A.UPDATE_TIME=CURRENT TIMESTAMP");
            PreparedStatement ps = conn.prepareStatement("MERGE INTO SHOP_FAVORITE8 A USING (SELECT ? AS SHOP_ID,? AS CUST_NUM, CAST(? AS SMALLINT) AS CHANNEL, CAST(? AS VARCHAR(32)) AS ENTRANCE FROM SYSIBM.SYSDUMMY1) AS B ON (A.CUST_NUM = B.CUST_NUM AND A.SHOP_ID = B.SHOP_ID) WHEN MATCHED THEN UPDATE SET A.DELETE_FLAG=0 , A.UPDATE_TIME=CURRENT TIMESTAMP");            
            //PreparedStatement ps = conn.prepareStatement("UPDATE SHOP_FAVORITE8 SET CHANNEL=?,ENTRANCE=?,UPDATE_TIME=CURRENT TIMESTAMP WHERE SHOP_ID=? AND CUST_NUM=?");
//            ps.setObject(1, 1);
//            ps.setString(2, "productDetail");
//            ps.setString(3, "70055001");
//            ps.setString(4, "6001727438");
            
            ps.setObject(1, "70055001");
            ps.setObject(2, "6001727438");
            ps.setObject(3, "1");
            ps.setObject(4, "productDetail");
            
//            ps.setString(5, "70055001");
//            ps.setString(6, "6001727438");
//            ps.setShort(7, (short)1);
//            ps.setString(8, "productDetail");

            boolean result1 = ps.execute();
            System.out.println(result1);

        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
            System.err.println(e);
            System.out.println("SQLState:" + e.getSQLState());
            System.out.println("ErrorCode:" + e.getErrorCode());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

}
