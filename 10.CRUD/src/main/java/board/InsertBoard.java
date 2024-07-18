package board;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardDTO;
import common.Command;

public class InsertBoard implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//화면에서 입력한 정보 수집 -> DB에 신규저장메소드 호출
		BoardDTO dto = new BoardDTO();
//		dto.setNumb(Integer.parseInt(request.getParameter("numb")));
		dto.setSubject(request.getParameter("subject"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setNalja(Date.valueOf(request.getParameter("nalja")));
		dto.setContent(request.getParameter("content"));
		dto.setPassword(request.getParameter("password"));
		
		new BoardDAO().insertBoard(dto);
	}

}
