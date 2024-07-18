package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import common.Command;

public class DeleteBoard implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//게시판 정보를 DB에서 삭제하기
		int numb = Integer.parseInt(request.getParameter("id"));
		new BoardDAO().deleteBoard(numb);
	}

}
