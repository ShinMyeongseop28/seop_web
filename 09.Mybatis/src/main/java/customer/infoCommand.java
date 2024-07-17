package customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import customer.model.CustomerDAO;
import customer.model.CustomerDTO;

public class infoCommand implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//선택한 고객정보를 DB에서 조회해오기 -> 고객정보조회 메소드 호출
		int id = Integer.parseInt(request.getParameter("id"));
		CustomerDTO dto = new CustomerDAO().getOneCustomer(id);
		//화면에 출력할 수 있게 request에 저장하기
		request.setAttribute("dto", dto);
	}
}
