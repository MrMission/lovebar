package com.shike.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO{        

    public BaseDAO() {
            
    }
    
    public Connection getConnection() {
            return null;
    }

    public void releaseSource(Connection conn, Statement stmt, ResultSet rs) {
        try {
                if(rs != null) {
                        rs.close();
                        rs = null;
                }
                if (conn != null) {
                            conn.close();
                            conn = null;
                    }
                    if (stmt != null) {
                            stmt.close();
                            stmt = null;
                    }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
