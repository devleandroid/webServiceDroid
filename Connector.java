package br.service.source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class Connector {

  static String UserName = "root";
	static String PassWord = "root";//EOeLWs3ekH
	static String Driver = "com.mysql.jdbc.Driver";
	static String Url = "jdbc:mysql://localhost:3306/dbhospital";//
	
	private static Connection con;
	
	//conexao com o banco de dados
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(Driver);
		return DriverManager.getConnection(Url ,UserName ,PassWord);
	}
	//fechando conexao dados 
	public static void closeConnection(Connection con, Statement stmt, ResultSet result) throws Exception{
		close(con, stmt, result);
	}
	//fechando banco de dados
	public static void close(Connection con, Statement stmt, ResultSet result) throws Exception {
		
		try {
			if (result != null)
				result.close();
			
			if (stmt != null) 
				stmt.close();
			
			if (con != null) 
				con.close();
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	//fechando driver de conexao
	public static void closeJDBC(final Connection con) throws SQLException{
		
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				throw new SQLException(e.getMessage());
			}
		}
	}
	//fechando statment
	public static void closeStatement(final Statement stmt)throws SQLException {
		
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				throw new SQLException(e.getMessage());
			}
		}
	}
	//fechando resultset
	public static void closeResultSet(final ResultSet result) throws SQLException {
		
		if (result != null) {
			try {
				result.close();
			} catch (Exception e) {
				throw new SQLException(e.getMessage());
			}
		}
	}
}
