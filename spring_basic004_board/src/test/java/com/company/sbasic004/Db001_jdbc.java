package com.company.sbasic004;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class Db001_jdbc {
	@Test
	public void test_jdbc() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db0?useSSL=false", "root", "1234");
			if(conn !=null) {
				System.out.println("jdbc 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}//end class
