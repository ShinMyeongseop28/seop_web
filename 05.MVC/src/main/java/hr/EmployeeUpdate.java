package hr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.EmployeeDTO;
import model.HrDAO;

public class EmployeeUpdate implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//화면에서 변경입력한 정보를 수집
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
		dto.setLast_name(request.getParameter("last_name"));
		dto.setFirst_name(request.getParameter("first_name"));
		
		//수집된 정보로 DB에 변경 저장: 변경저장 메소드 호출
		new HrDAO().updateEmployee(dto);
	}

}
