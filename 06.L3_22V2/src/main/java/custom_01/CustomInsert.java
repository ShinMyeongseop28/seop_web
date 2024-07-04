package custom_01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.CustomDAO;
import model.CustomDTO;

public class CustomInsert implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//화면에서 입력한 정보로 DB에 신규저장
		//입력한 정보수집(DTO) -> DAO의 신규저장 메소드 호출
		CustomDTO dto = new CustomDTO();
		dto.setC_email(request.getParameter("c_email"));
		dto.setC_name(request.getParameter("c_name"));
		dto.setC_tel(request.getParameter("c_tel"));
		dto.setP_id(request.getParameter("p_id"));
		dto.setP_pw(request.getParameter("p_pw"));
		
		CustomDAO dao = new CustomDAO();
		dao.registerCustom(dto);
	}

}
