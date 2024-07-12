package level3.model;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybatisFactory;

public class Level3DAO {
	private SqlSession sql;
	
	public Level3DAO() {
		sql = MybatisFactory.getHrInstance();		
	}
	//CRUD
	//회원신규등록
	public int registerLevel3(Level3DTO dto) {
		return 0;
	}
	
	//회원목록조회
	public List<Level3DTO> getListOfLevel3() {
		return sql.selectList("getListOfLeverl3");
	}
	
	//회원정보조회
	public Level3DTO getOneLevel3(String p_id) {
		return null;
	}
	
	//회원정보수정
	public void name() {
		
	}

}
