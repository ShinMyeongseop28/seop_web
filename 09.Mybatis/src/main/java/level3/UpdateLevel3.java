package level3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import level3.model.Level3DAO;
import level3.model.Level3DTO;

public class UpdateLevel3 implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//화면에서 입력한 정보 수집하기 -> DB에 변경저장하기
		Level3DTO dto = new Level3DTO();
		dto.setC_email( request.getParameter("c_email"));
		dto.setC_name( request.getParameter("c_name") );
		dto.setC_tel( request.getParameter("c_tel") );
		dto.setP_id( request.getParameter("p_id") );
		dto.setP_pw( request.getParameter("p_pw") );
		
		new Level3DAO().updateLevel3(dto);
	}

}
