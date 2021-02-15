package com.mindtree.librarymanagement.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mindtree.librarymanagement.exception.ConnectionFailedException;

public class ConnectionUtility {
private static final String URL="jdbc:mysql://localhost:3306/db?autoReconnect=true&useSSL=false";
private static final String UserName="root";
private static final String password="QC733VjFkK98@e";
public static Connection getConnection() throws ConnectionFailedException {
	Connection con=null;
	try {
		con=DriverManager.getConnection(URL,UserName,password);
	} catch (SQLException e) {
		throw new ConnectionFailedException(e);
	}
	return con;
}
public static void closeResource(Connection con) throws ConnectionFailedException {
	if(con!=null) {
		try {
			con.close();
		} catch (SQLException e) {
			throw new ConnectionFailedException(e);
		}
	}
}
public static void closeResource(PreparedStatement con) throws ConnectionFailedException {
	if(con!=null) {
		try {
			con.close();
		} catch (SQLException e) {
			throw new ConnectionFailedException(e);
		}
	}
}
public static void closeResource(ResultSet con) throws ConnectionFailedException {
	if(con!=null) {
		try {
			con.close();
		} catch (SQLException e) {
			throw new ConnectionFailedException(e);
		}
	}
}
}
