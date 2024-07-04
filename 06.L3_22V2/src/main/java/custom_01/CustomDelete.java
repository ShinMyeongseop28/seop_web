package custom_01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.CustomDAO;

public class CustomDelete implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스로직
		//선택한 회원정보를 DB에서 삭제: DAO의 삭제처리 메소드 호출
		CustomDAO dao = new CustomDAO();
		dao.deleteCustom(request.getParameter("id"));
	}

}
