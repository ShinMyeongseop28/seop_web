package l5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.CodeDAO;
import model.CodeDTO;

public class CodeUpdate implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//화면에서 변경 입력한 정보를 수집
		CodeDTO dto = new CodeDTO();
		dto.setCode(request.getParameter("code"));
		dto.setMaker(request.getParameter("maker"));		
		//수집된 정보로 DB에 변경 저장: 변경저장 메소드 호출
		new CodeDAO().codeUpdate(dto);
	}
}
