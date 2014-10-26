package com.shike.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.shike.util.Global;

public class TryDAO extends BaseDAO {

	private static InitialContext context = null;
	private DataSource dataSource = null;

//	private static final String createFaKuaidiOrder = "insert into fa_kuaidi_order(user_id, order_id, book_address) values (?, ?, ?)";
//	private static final String queryFaKuaidiOrder = "select * from fa_kuaidi_order where user_id=?";
	private static final String queryTry = "select try_id from try";
	public TryDAO() {
		try {
			if (context == null) {
				context = new InitialContext();
			}
			dataSource = (DataSource) context
					.lookup(Global.datasource_url);
		} catch (NamingException e2) {
			e2.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
		}
		return conn;
	}
	
	public int test() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		int result = 1000;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(queryTry);
			rst = pstmt.executeQuery();
			if(rst.next()) {
				result = rst.getInt("try_id");
				System.out.println("result=" + result);
			}
			
		} catch (Exception se) {
			se.printStackTrace();
		} finally {
			releaseSource(conn, pstmt, rst);
		}
		
		return result;
	}

}
