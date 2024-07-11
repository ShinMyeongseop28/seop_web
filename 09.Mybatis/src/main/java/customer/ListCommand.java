package customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.Command;
import customer.model.CustomerDAO;
import customer.model.CustomerDTO;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//DB에서 고객목록을 조회해오기: 목록조회 메소드 호출(DB연결 -> 조회)
		List<CustomerDTO> list= new CustomerDAO().getListOfCustomer();
		
		//화면에 출력할 수 있도록 request에 저장하기
		request.setAttribute("list", list);
	}

}
