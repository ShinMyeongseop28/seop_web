package customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import customer.model.CustomerDAO;

public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//선택한 고객정보를 DB에서 삭제하기 - 고객정보 삭제 메소드 호출
		int id = Integer.parseInt(request.getParameter("id"));
		new CustomerDAO().deleteCustomer(id);
	}

}
