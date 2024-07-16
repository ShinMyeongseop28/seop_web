package level5;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.Command;
import level5.model.Level5DAO;
import level5.model.Level5DTO;

public class ListLevel5 implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 비지니스로직
		// DB에서 제품코드목록 조회해오기 
		List<Level5DTO> list = new Level5DAO().getListOfCode();
		
		// 화면에 출력할 수 있게 request에 저장하기
		request.setAttribute("list", list);
	}

}
