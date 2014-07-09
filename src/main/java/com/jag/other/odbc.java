package com.jag.other;
import java.sql.*; 
import java.util.*; 
public class odbc { 
public static void main(String args[]){ 

try 
{ 

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
Properties prop = new Properties(); 
prop.put("user", ""); 
prop.put("password",""); 
prop.put("charSet","gb2312"); 

Connection conn=DriverManager.getConnection("jdbc:odbc:chinese",prop); 
Statement stmt=conn.createStatement(); 
stmt.execute(args[0]); 

} 

catch(ClassNotFoundException e) 
{ 
// JOptionPane.showMessageDialog(null,"Unable To Load The Driver Class","Login Message", JOptionPane.ERROR_MESSAGE); 

} 
catch(SQLException e) 
{ 
e.printStackTrace(); 
System.out.println(e.getErrorCode()); 
} 

} 
} 