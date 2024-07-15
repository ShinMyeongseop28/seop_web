package level3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.Command;
import level3.model.Level3DAO;
import level3.model.Level3DTO;

public class InsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//화면에서 입력한 정보수집 -> DB에 신규저장메소드 호출
		Level3DTO dto = new Level3DTO();
		dto.setC_email(request.getParameter("c_email"));
		dto.setC_name(request.getParameter("c_name"));
		dto.setC_tel(request.getParameter("c_tel"));
		dto.setP_pw(request.getParameter("p_pw"));
		dto.setP_id(request.getParameter("p_id"));
		
		new Level3DAO().registerLevel3(dto);
	}

}
