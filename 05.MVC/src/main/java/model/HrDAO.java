package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.jasper.tagplugins.jstl.core.Catch;

public class HrDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//신규사원정보 저장
	public void insertEmployee(EmployeeDTO dto) {
		connect();
		
		String sql = "insert into employees"
				+ "(employee_id, last_name, first_name, email, job_id, hire_date) "
				+ "values ( employees_seq.nextval, ?, ?, ?, ?, ? )";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getLast_name());
			ps.setString(2, dto.getFirst_name());
			ps.setString(3, dto.getEmail());
			ps.setString(4, dto.getJob_id());
			ps.setString(5, dto.getHire_date());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			disconnect();
		}
		
	}
	
	//사원정보 변경저장
	public void updateEmployee(EmployeeDTO dto) {
		connect();
		
		String sql = "update employees set last_name = ?,"
				+ " first_name = ? where employee_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getLast_name());
			ps.setString(2, dto.getFirst_name());
			ps.setInt(3, dto.getEmployee_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			disconnect();
		}
		
	}
	
	//사원정보조회
	public EmployeeDTO getOneEmployee(int employee_id) {
		connect();
		
		EmployeeDTO dto = null;
		String sql = "select * from employees where employee_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, employee_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new EmployeeDTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			disconnect();
		}
		return dto;
		
	} 
	
	//사원정보삭제
	public int deleteEmployee(int employee_id) {
		connect();
		
		int dml = 0;
		String sql = "delete from employees where employee_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, employee_id);
			//ps.executeQuery();	//select 쿼리실행
			dml = ps.executeUpdate();	//insert, update, delete 쿼리실행
			
		} catch (SQLException e) {
		} finally {
			disconnect();
		}
		return dml;
	}
	
	//사원목록조회
	public ArrayList<EmployeeDTO> listOfEmployee() {
		connect();
		
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		String sql = "select * from employees";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); //select
			//ps.executeUpdate(); //insert,update,delete
			while(rs.next() ) {
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmployee_id( rs.getInt("employee_id"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setFirst_name(rs.getString("first_name"));
				list.add(dto);
			}
		}catch (Exception e) {
		}finally {
			disconnect();
		}
		return list;
	}
	
	private void connect() {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/hr");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void disconnect() {
		if( rs!=null ) {
			try { rs.close(); }catch (Exception e) {}
		}
		if( ps!=null ) {
			try { ps.close(); }catch (Exception e) {}
		}
		if( ps!=null ) {
			try { conn.close(); }catch (Exception e) {}
		}
		
	}
		
}
