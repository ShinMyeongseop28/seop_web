package level5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.Command;
import level5.model.Level5DAO;
import level5.model.Level5DTO;

public class UpdateLevel5 implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 비지니스 로직
		// 화면에서 입력한 정보로 DB에 변경 저장하기
		Level5DTO dto = new Level5DTO();
		dto.setCode(request.getParameter("code"));
		dto.setMaker(request.getParameter("maker"));
		
		new Level5DAO().updateCode(dto);
	}

}
