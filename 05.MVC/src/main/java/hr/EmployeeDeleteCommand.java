package hr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.HrDAO;

public class EmployeeDeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스로직
		//DB에서 해당 사원정보를 삭제
		//DB연결 -> 삭제메소드 호출
		int id = Integer.parseInt(request.getParameter("id"));
		HrDAO dao = new HrDAO();
		dao.deleteEmployee(id);
		
	}

}
