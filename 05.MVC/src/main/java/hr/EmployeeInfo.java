package hr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.EmployeeDTO;
import model.HrDAO;

public class EmployeeInfo implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//DB에서 선택한 사원정보를 조회해오기
		//DB연결 -> 사원정보메소드호출
		int id = Integer.parseInt(request.getParameter("id"));
		EmployeeDTO dto = new HrDAO().getOneEmployee(id);
		
		//조회해온 정보를 화면에 출력할 수 있도록 request영역에 담기
		request.setAttribute("dto", dto);
	}

}
