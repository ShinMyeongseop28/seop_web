package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CodeDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//제조사정보 등록
	public void registerCode(CodeDTO dto) {
		conn();
		String sql = "insert into product_code (code, maker) "
				+ "values (?, ?) ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getCode());
			ps.setString(2, dto.getMaker());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			disconn();
		}
		
	}
	
	//제조사 정보 조회
	public CodeDTO getOneMaker(String code) {
		conn();
		CodeDTO dto = null;
		String sql = "select * from product_code where code = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			rs = ps.executeQuery();
			if( rs.next() ) {
				dto = new CodeDTO();
				dto.setCode(rs.getString("code"));
				dto.setMaker(rs.getString("maker"));
				dto.setReg_date(rs.getDate("reg_date"));
			}
		} catch (SQLException e) {
		} finally {
			disconn();
		}
		return dto;
	}
	
	//제조사 수정 저장
	public void codeUpdate(CodeDTO dto) {
		conn();
		
		String sql = "update product_code set maker = ?, "
				+ " reg_date = sysdate where code = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getMaker());
			ps.setString(2, dto.getCode());
			ps.executeUpdate();
		} catch (SQLException e) {
		} finally {
			disconn();
		}
		
	}
	
	private void conn() {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/hr");
			conn = ds.getConnection();
		} catch (Exception e) {
		}
	}
	
	private void disconn() {
		if(rs!=null) {
			try { rs.close(); } catch (SQLException e) {}
		}
		if(ps!=null) {
			try { ps.close(); } catch (SQLException e) {}
		}
		if(conn!=null) {
			try { conn.close(); } catch (SQLException e) {}
		}
	}
}
