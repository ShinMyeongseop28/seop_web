package level5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.Command;
import level5.model.Level5DAO;
import level5.model.Level5DTO;

public class DeleteLevel5 implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//선택한 제품코드 정보를 DB에서 삭제하기
		new Level5DAO().deleteCode(request.getParameter("code"));
	}

}
