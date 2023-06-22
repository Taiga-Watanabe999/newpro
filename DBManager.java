package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	
	private static String url= "jdbc:mysql://127.0.0.1/商品管理?useUnicode=true&characterEncording=cp932";
	private static String user = "root";
	private static String password = "admin";
	
	public static  Connection getConnection()throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = null;
		connection = DriverManager.getConnection(url, user, password);
		return connection; 
	}
}
