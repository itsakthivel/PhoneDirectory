package com.students.dbutil;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class JDBCConnection{
	Connection connection = null;
	private Properties prop = null;
	
	//ResourceBundle rb = ResourceBundle.getBundle("src.main.resources.application");
	
	public Connection getDBConnection(){
		 InputStream is = null;
	
    try {
    	this.prop= new Properties();
    	is=this.getClass().getResourceAsStream("/application.properties");
    	prop.load(is);
    	
        // below two lines are used for connectivity. 
    	Class.forName(prop.getProperty("spring.datasource.driver-class-name"));
        connection = DriverManager.getConnection(
        		prop.getProperty("spring.datasource.url"),
            prop.getProperty("spring.datasource.username"), prop.getProperty("spring.datasource.password"));
         
       
        
    }
    catch (Exception exception) {
        exception.printStackTrace();
    }
    return connection;
} // function ends

}
