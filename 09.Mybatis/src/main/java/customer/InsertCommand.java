package customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.Command;
import customer.model.CustomerDAO;
import customer.model.CustomerDTO;

public class InsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//화면에서 입력한 정보로 DB에 신규삽입저장하기
		//화면에서 입력한 정보수집하기 -> 신규저장 메소드 호출
		CustomerDTO dto = new CustomerDTO();
		dto.setEmail(request.getParameter("email"));
		dto.setGender(request.getParameter("gender"));
		dto.setName(request.getParameter("name"));
		dto.setPhone(request.getParameter("phone"));
		
		new CustomerDAO().registerCustomer(dto);
	}

}
