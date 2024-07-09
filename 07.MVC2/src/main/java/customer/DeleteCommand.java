package customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.Command;
import model.CustomerDAO;

public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//선택한 고객정보를 DB에서 삭제: DAO의 메소드 호출
		CustomerDAO dao = new CustomerDAO();
		dao.deleteCustomer(Integer.valueOf(request.getParameter("id")));
	}

}
