package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	PreparedStatement psmt = null;
	Connection conn = null;
	int cnt = 0;
	ResultSet rs = null;
	String name = null;
	
	public void conn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "hr";
			String db_pw = "hr";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);

	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void close() {
		try {
			if(rs != null){
				rs.close();
			}
			
			if(psmt != null){
				psmt.close();			
			}
			
			if(conn != null){
				conn.close();			
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	
	}
	
	public int join(DTO dto) {
		conn();
		try {
			String sql = "insert into model1 values(?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getName());

			cnt = psmt.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close();
		}
		
		return cnt;
	}
	
	public String login(DTO dto) {
		conn();
		try {
			String sql = "select * from model1 where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
		    rs = psmt.executeQuery();
			
			if(rs.next()){
				name = rs.getString("name");
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return name;
	}
	
	
	
	
}
