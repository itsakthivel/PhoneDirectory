package com.students.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;


public class JDBCConnection{
	Connection connection = null;
	
	public Connection getDBConnection(){
	
    try {
        // below two lines are used for connectivity.
       
    	Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3308/skctphonedirectory",
            "root", "");
         
       
        
    }
    catch (Exception exception) {
        System.out.println(exception);
    }
    return connection;
} // function ends

}
