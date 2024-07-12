package level3;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.Command;
import level3.model.Level3DAO;
import level3.model.Level3DTO;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스로직
		//DB에서 회원목록 조회해오기 -> 화면에 출력하게 request에 저장하기
		//회원목록조회 메소드 호출
		List<Level3DTO> list = new Level3DAO().getListOfLevel3();
		request.setAttribute("list", list);
	}

}
