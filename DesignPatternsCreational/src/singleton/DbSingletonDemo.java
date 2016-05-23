package singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingletonDemo {

	public static void main(String args[]) {
		
		long timeBefore = 0;
		long timeAfter = 0;
		
		timeBefore = System.currentTimeMillis();
		DbSingleton instance = DbSingleton.getInstance();
		timeAfter = System.currentTimeMillis();
		
		System.out.println(timeAfter - timeBefore);
		
		Connection conn = instance.getConnection();
		
		Statement sta;
		try {
			sta = conn.createStatement();
			int count = sta.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20), City VARCHAR(20))");
			System.out.println("Table created.");
			sta.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		timeBefore = System.currentTimeMillis();
		instance = DbSingleton.getInstance();
		timeAfter = System.currentTimeMillis();
		
		System.out.println(timeAfter - timeBefore);
	}
	
}
