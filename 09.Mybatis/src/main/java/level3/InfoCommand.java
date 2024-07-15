package level3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.Command;
import level3.model.Level3DAO;
import level3.model.Level3DTO;

public class InfoCommand implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//선택한 회원정보를 DB에서 조회해오기
		Level3DTO dto = new Level3DAO().getOneLevel3(request.getParameter("id"));
		
		//화면에 출력할 수 있게 request에 저장하기
		request.setAttribute("dto", dto);
		
	}
}
