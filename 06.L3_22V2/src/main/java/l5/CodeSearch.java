package l5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.CodeDAO;
import model.CodeDTO;

public class CodeSearch implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//화면에서 입력한 코드의 정보를 DB에서 조회해와서
		//결과화면에 출력할 수 있게 request에 저장
		CodeDAO dao = new CodeDAO();
		CodeDTO dto = dao.getOneMaker(request.getParameter("code"));
		
		request.setAttribute("dto", dto);
	}

}
