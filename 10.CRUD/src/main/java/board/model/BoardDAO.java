package board.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybatisFactory;

public class BoardDAO {
	private SqlSession sql;
	
	public BoardDAO() {
		sql = MybatisFactory.getHanulInstance();
	}
	
	//CRUD
	//게시판 전체 조회
	public List<BoardDTO> getListOfBoard() {
		return sql.selectList("board.getListOfBoard");
	}
	
	//게시판 세부내용 조회
	
	//게시판 수정
	
	//게시판 삭제
	
	//게시판 추가

}
