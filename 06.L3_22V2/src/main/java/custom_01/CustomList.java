package custom_01;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.CustomDAO;
import model.CustomDTO;

public class CustomList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스로직
		//DB에서 회원목록 조회해오기 -> 화면에서 출력할 수 있게 request에 담기
		CustomDAO dao = new CustomDAO();
		ArrayList<CustomDTO> list = dao.getListOfCustom();
		
		request.setAttribute("list", list);
		
	}

}
