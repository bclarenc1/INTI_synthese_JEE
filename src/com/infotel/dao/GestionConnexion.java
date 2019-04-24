package com.infotel.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class GestionConnexion {

	private String url = "jdbc:postgresql://localhost:5432/syntheseJEE";
	private String user = "postgres";
	private String pwd = "intijee";
	private static Connection con;
	
	private GestionConnexion() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url,user,pwd);			
		} catch (Exception e) {
			System.out.println("Connection to SyntheseJEE failed");
		}
	}

	public static Connection getInstance() {
		if (con==null) {new GestionConnexion();}
		return con;
	}
	
}
