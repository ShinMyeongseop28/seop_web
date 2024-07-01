package hr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.EmployeeDTO;
import model.HrDAO;

public class EmployeeInsert implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//화면에서 입력한 정보로 DB에 신규저장
		//1.정보수집
		EmployeeDTO dto = new EmployeeDTO();
		dto.setFirst_name(request.getParameter("first_name"));
		dto.setLast_name(request.getParameter("last_name"));
		dto.setEmail(request.getParameter("email"));
		dto.setJob_id(request.getParameter("job_id").toUpperCase());
		dto.setHire_date(request.getParameter("hire_date"));
		System.out.println();
		
		//2.DB연결해 저장메소드 호출 
		new HrDAO().insertEmployee(dto);
	}

}
