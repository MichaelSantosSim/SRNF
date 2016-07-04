package br.com.srnf.notafiscal.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static String status = "Not Connected";
	
	public static java.sql.Connection getConnection(){
		Connection connection = null;
		try{
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);

			String serverName = "localhost";
			String myDataBase = "SURNF";
			String url = "jdbc:mysql://" + serverName + "/" + myDataBase + "?useSSL=false";
			String username = "root";
			String password = "password";
			connection = DriverManager.getConnection(url, username, password);
			
			if(connection != null){
				status = "Connected";
			}else{
				status = "Failed to Connect";
			}
			return connection;
		}catch(ClassNotFoundException e){
			status = "Driver not found: ";
			System.out.println("DBConnection.getConnection: " + e.getMessage());
			return null;
		}catch (SQLException e) {
			status = "Could not find Database";
			System.out.println("DBConnection.getConnection: " + e.getMessage());
			return null;
		}
	}
	
	public static java.sql.Statement getStatement() throws SQLException{
		return getConnection().createStatement();
	}
	
	public static String status(){
		return status;
	}
	
	public static boolean closeConnection(){
		try{
			getConnection().close();
			status = "Closed";
			return true;
		}catch(SQLException e){
			System.out.println("DBConnection.closeConnection: " + e.getMessage());
			return false;
		}
	}
	
	public static java.sql.Connection restartConnection(){
		closeConnection();
		return getConnection();
	}
}
