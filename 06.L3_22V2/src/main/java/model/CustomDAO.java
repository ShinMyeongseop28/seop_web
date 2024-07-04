package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CustomDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//신규회원저장
	public void registerCustom(CustomDTO dto) {
		connect();
		
		String sql = "insert into custom_01 "
				+"( p_id, p_pw, c_name, c_email, c_tel) "
				+"values (?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getP_id());
			ps.setString(2, dto.getP_pw());
			ps.setString(3, dto.getC_name());
			ps.setString(4, dto.getC_email());
			ps.setString(5, dto.getC_tel());
			ps.executeUpdate();
			
		} catch (SQLException e) {
		} finally {
			disconn();
		}
	}
	
	//선택한 회원정보조회
	public CustomDTO getOneCustom(String id){
		connect();
		
		CustomDTO dto = null;
		String sql = "select * from custom_01 "
				+ "where p_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new CustomDTO();
				dto.setC_email(rs.getString("c_email"));
				dto.setC_name(rs.getString("c_name"));
				dto.setC_tel(rs.getString("c_tel"));
				dto.setP_id(rs.getString("p_id"));
				dto.setP_pw(rs.getString("p_pw"));
			}
			
		} catch (SQLException e) {
		} finally {
			disconn();
		}
		return dto;
	}
	
	//회원목록조회
	public ArrayList<CustomDTO> getListOfCustom() {
		connect();
		
		ArrayList<CustomDTO> list = new ArrayList<CustomDTO>();
		String sql = "select * from custom_01";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				CustomDTO dto = new CustomDTO();
				dto.setC_email(rs.getString("c_email"));
				dto.setC_name(rs.getString("c_name"));
				dto.setC_tel(rs.getString("c_tel"));
				dto.setP_id(rs.getString("p_id"));
				dto.setP_pw(rs.getString("p_pw"));
				list.add(dto);
			}
			
		} catch (SQLException e) {
		} finally {
			disconn();
		}
		return list;
	}

	// 회원정보변경저장
	public void updateCustom(CustomDTO dto) {
		connect();

		String sql = "update custom_01 set c_name = ?, "
				+ "p_pw = ?, c_email = ?, c_tel = ? where P_id = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getC_name());
			ps.setString(2, dto.getP_pw());
			ps.setString(3, dto.getC_email());
			ps.setString(4, dto.getC_tel());
			ps.setString(5, dto.getP_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			disconn();
		}

	}
	
	// 회원정보 삭제
	public void deleteCustom(String p_id) {
		connect();
		
		String sql = "delete from custom_01 where p_id = ?";
		
	try {
		ps = conn.prepareStatement(sql);
		ps.setString(1, p_id);
		ps.executeQuery();
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	} finally {
		disconn();
	}
		
	}
	
	private void connect() {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/hr");
			conn = ds.getConnection();
				
		} catch (Exception e) {
		}
	}
		
	private void disconn() {
		if(rs!=null) {
			try {rs.close();}catch (Exception e) {}
		}
		if(ps!=null) {
			try {ps.close();}catch (Exception e) {}
		}
		if(conn!=null) {
			try {conn.close();}catch (Exception e) {}
		}
	}
}
