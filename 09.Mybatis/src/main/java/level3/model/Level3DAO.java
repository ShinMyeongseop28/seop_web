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
		return sql.insert("level3.registerLevel3", dto);
	}
	
	//회원목록조회
	public List<Level3DTO> getListOfLevel3() {
		return sql.selectList("level3.getListOfLevel3");
	}
	
	//회원정보조회
	public Level3DTO getOneLevel3(String p_id) {
		return sql.selectOne("level3.getOneLevel3", p_id);
	}
	
	//회원정보수정
	public int updateLevel3(Level3DTO dto) {
		return sql.update("level3.updateLevel3", dto);
	}
	
	//회원정보삭제
	public int deleteLevel3(String p_id) {
		return sql.delete("level3.deleteLevel3", p_id);
	}

}
