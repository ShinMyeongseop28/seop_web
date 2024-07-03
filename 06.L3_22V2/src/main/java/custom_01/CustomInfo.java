package custom_01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.CustomDAO;
import model.CustomDTO;

public class CustomInfo implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스로직
		//화면에서 선택한 회원의 정보를 DB에서 조회해오기
		CustomDAO dao = new CustomDAO();
		CustomDTO dto = dao.getOneCustom(request.getParameter("id"));
		
		// -> 화면에 출력할 수 있도록 request에 attribute로 저장하기
		request.setAttribute("dto", dto);
	}

}
