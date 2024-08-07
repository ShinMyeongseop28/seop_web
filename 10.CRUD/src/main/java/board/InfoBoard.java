package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDTO;
import common.Command;

public class InfoBoard implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//선택한 게시판 정보를 DB에서 조회해오기
		int numb = Integer.parseInt(request.getParameter("id"));
		BoardDTO dto = new BoardDAO().getOneBoard(numb);
		
		//조회수 증가값을 DB에서 조회해오기
		new BoardDAO().increaseCheckNum(dto);
		
		//조회수가 1 증가된 값을 DB에 새로 담기
		dto = new BoardDAO().getOneBoard(numb);
		
		//화면에 출력할 수 있게 request에 저장하기
		request.setAttribute("dto", dto);
		
	}

}
