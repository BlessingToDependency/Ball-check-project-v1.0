package org.great;

import java.sql.*;


public class DBManager {

	private static Connection con;

	public DBManager() {
	}

	public static Connection getCon() {
		if (con == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			}

			try {
				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:orcl", "emp_zy",
						"oracle");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}


	public static void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		con = null;
	}

	public static void closePreparedStatement(PreparedStatement pstm) {
		if (pstm != null) {
			try {
				pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			pstm = null;
		}
		
	}

	public static void closeStatement(Statement stm) {
		if (stm != null) {
			try {
				stm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stm = null;
		}
		
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
	
	}

	public static void main(String[] args) {
		Connection c = DBManager.getCon();
		if (c != null) {
			System.out.print("ok");
		} else {
			System.out.print("fail");
		}
	}
}
