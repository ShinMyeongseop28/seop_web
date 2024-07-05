package l5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.CodeDAO;
import model.CodeDTO;

public class CodeInsert implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//화면에서 입력한 정보로 DB에 신규삽입저장
		CodeDTO dto = new CodeDTO();
		dto.setCode(request.getParameter("code"));
		dto.setMaker(request.getParameter("maker"));
		
		CodeDAO dao = new CodeDAO();
		dao.registerCode(dto);
	}

}
