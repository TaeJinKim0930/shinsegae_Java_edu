package libs;

import java.sql.*;

public abstract class ObjectDBIO {

	/**
	 * v0.0.1, 2023-12-18, TJ
	 * Fields:: oracle DB -> mysql DB
	 * databaseName added + added tail of jdbc_url
	 * open() : Class.forName : oracle DB -> mysql DB
 	 */
	private Connection conn = null;
	private final String databaseName = "ssg_db";
	private String jdbc_url = "jdbc:mysql://localhost:3306/" + databaseName;
	private String db_id = "root";
	private String db_pwd = "2023ssg";
	
	// Setter
	public void setDb_id(String db_id) {
		this.db_id = db_id;
	}

	public void setDb_pwd(String db_pwd) {
		this.db_pwd = db_pwd;
	}

	public void setJdbc_url(String jdbc_url) {
		this.jdbc_url = jdbc_url;
	}
	
	// DB Connect
	private boolean open() {
		try{
			// v0.0.1: oracle DB -> mysql DB
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbc_url, db_id, db_pwd);
			System.out.println("DB Connection Success");
			return true;
		} 
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} 
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// DB Disconnect
	protected boolean close() {
		try {
			conn.close();
			System.out.println("DB connection Successfully closed");
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 *  Execute sql query + resultSet
	 * @param strSql : sql query to execute
	 * @param rs : Object that stores result of SELECT
	 * @return rs
	 */
	protected ResultSet execute(String strSql, ResultSet rs)
	{		
		try {
			open();
			Statement stObj = conn.createStatement();
			rs = stObj.executeQuery(strSql);
			//close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	// Execute sql query
	protected void execute(String strSql)
	{		
		try {
			open();
			Statement stObj = conn.createStatement();
			stObj.executeQuery(strSql);
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
