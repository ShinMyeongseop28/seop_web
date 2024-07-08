package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CustomerDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//CRUD: Create, Read, Update, Delete
	//신규고객등록
	public void registerCustomer(CustomerDTO dto) {
		
	}

	//고객목록 조회
	public ArrayList<CustomerDTO> getListOfCustomer() {
		//DB연결 -> DB table에서 목록조회
		// : return타입 - ArrayList<DTO> : select
		conn();
		
		ArrayList<CustomerDTO> list = new ArrayList<CustomerDTO>();
		String sql = "select * from customer";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// select : executeQuery
			// insert/update/delete : executeUpdate
			while( rs.next()) {
				CustomerDTO dto = new CustomerDTO();
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				list.add(dto);
			}
			
		} catch (SQLException e) {
		} finally {
			disconn();
		}
		return list;
	}
		
	//고객정보 한 건 조회
	public CustomerDTO getOneCustomer(int id) {
		
		return null;
		
	}
	//고객정보 수정 저장
	public void updateCustomer(CustomerDTO dto) {
		
	}
	//고객정보 삭제
	public void deleteCustomer(int id) {
		
	}
	
	//자원회수 - DB연결개체 반납
	private void disconn() {
		if( rs != null ) {
			try{ rs.close(); }catch(Exception e) {}
		}
		if( ps != null ) {
			try{ ps.close(); }catch(Exception e) {}
		}
		if( conn != null ) {
			try{ conn.close(); }catch(Exception e) {}
		}
	}
	
	//DB연결
	private void conn() {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/hanul");
			conn = ds.getConnection();
			
		} catch (Exception e) {
		}
	}

}
