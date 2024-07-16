package level5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.Command;
import level5.model.Level5DAO;
import level5.model.Level5DTO;

public class InsertLevel5 implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//화면에서 입력한 정보수집
		Level5DTO dto = new Level5DTO();
		dto.setCode(request.getParameter("code"));
		dto.setMaker(request.getParameter("maker"));
		
		//DB에 신규저장처리 - 신규저장메소드 호출
		new Level5DAO().registerCode(dto);
	}

}
