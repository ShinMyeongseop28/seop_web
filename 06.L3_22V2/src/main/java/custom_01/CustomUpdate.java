package custom_01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.CustomDAO;
import model.CustomDTO;

public class CustomUpdate implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//화면에서 변경 입력한 정보를 수집
		CustomDTO dto = new CustomDTO();
		dto.setP_id(request.getParameter("p_id"));
		dto.setC_name(request.getParameter("c_name"));
		dto.setC_email(request.getParameter("c_email"));
		dto.setC_tel(request.getParameter("c_tel"));
		
		//수집된 정보로 DB에 변경 저장: 변경저장 메소드 호출
		new CustomDAO().updateCustom(dto);
	}

}
