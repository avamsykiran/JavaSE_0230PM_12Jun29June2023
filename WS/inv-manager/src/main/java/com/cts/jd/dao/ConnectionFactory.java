package com.cts.jd.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private Connection con;
	private String url;
	private String uid;
	private String pwd;
	
	private static ConnectionFactory instance; 
	
	private ConnectionFactory() throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.load(new FileInputStream("app.properties"));
		url = props.getProperty("url");
		uid = props.getProperty("uid");
		pwd = props.getProperty("pwd");
	}
	
	public Connection getConnection() throws SQLException {
		
		if(con==null || con.isClosed()) {
			con = DriverManager.getConnection(url,uid,pwd);
		}
		
		return con;
	}
	
	public static ConnectionFactory getInstance() throws FileNotFoundException, IOException {
		if(instance==null) {
			instance=new ConnectionFactory();
		}
		return instance;
	}
}
