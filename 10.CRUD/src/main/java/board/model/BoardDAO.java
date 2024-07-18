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
	public BoardDTO getOneBoard(int numb) {
		return sql.selectOne("board.getOneBoard", numb);
	}
	
	//게시판 수정
	public int updateBoard(BoardDTO dto) {
		return sql.update("board.updateBoard", dto);
	}
	
	//게시판 삭제
	public int deleteBoard(int numb) {
		return sql.delete("board.deleteBoard", numb);
	}
	
	//게시판 추가
	public int insertBoard(BoardDTO dto) {
		return sql.insert("board.insertBoard", dto);
	}
}
