package customer.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MybatisFactory;

public class CustomerDAO {
	private SqlSession sql; //쿼리실행 기능을 가진 클래스
	
	public CustomerDAO() {
		sql = MybatisFactory.getInstance();
	}
	
//	private void connect() {
//		SqlSessionFactory factory = MybatisFactory.getInstance();
//		sql = factory.openSession(true);
//	}
	
	//CRUD: Create, Read, Update, Delete
	
	//신규고객등록
	public int registerCustomer(CustomerDTO dto) {
		return 0;
	}
	//고객정보 변경저장
	public int updateCustomer(CustomerDTO dto) {
		return sql.update("customer.updateCustomer", dto);
	}
	
	//고객정보 삭제
	public int deleteCustomer(int id) {
		return 0;
	}
	
	//고객정보 조회
	public CustomerDTO getOneCustomer(int id) {
//		connect();
		CustomerDTO dto = sql.selectOne("customer.getOneCustomer", id);
		
		return dto;
	}
	
	//고객목록조회
	public List<CustomerDTO> getListOfCustomer() {
//		connect();
		List<CustomerDTO> list = sql.selectList("customer.getListOfCustomer");
		return list;
	}
}
