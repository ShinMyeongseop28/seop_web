package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDTO;
import common.Command;

public class UpdateBoard implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//게시판 수정 정보를 DB에 저장하기
		//화면에서 변경입력한 정보 수집하기 -> 변경저장 메소드 호출
		BoardDTO dto = new BoardDTO();
		dto.setNumb(Integer.parseInt(request.getParameter("numb")));
		dto.setSubject(request.getParameter("subject"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setContent(request.getParameter("content"));
		dto.setPassword(request.getParameter("password"));
		
		new BoardDAO().updateBoard(dto);
	}

}
