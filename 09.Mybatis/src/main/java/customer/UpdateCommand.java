package customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.Command;
import customer.model.CustomerDAO;
import customer.model.CustomerDTO;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스로직
		//화면에서 변경입력한 정보로 DB에 변경저장
		//화면에서 변경입력한 정보 수집하기 -> 변경저장 메소드 호출
		CustomerDTO dto = new CustomerDTO();
		dto.setEmail(request.getParameter("email"));
		dto.setGender(request.getParameter("gender"));
		dto.setId(Integer.parseInt(request.getParameter("id")));
		dto.setName(request.getParameter("name"));
		dto.setPhone(request.getParameter("phone"));
		
		new CustomerDAO().updateCustomer(dto);
		
	}

}
