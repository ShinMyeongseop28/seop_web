package level5;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.Command;
import level5.model.Level5DAO;
import level5.model.Level5DTO;

public class SearchLevel5 implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		//입력한 제품코드 정보 조회해오기 - DAO의 정보조회 메소드 호출
		Level5DTO dto = new Level5DAO().getOneCode(request.getParameter("code"));
		
		//화면에 출력할 수 있게 request에 저장하기
		request.setAttribute("dto", dto);
		request.setAttribute("code", request.getParameter("code"));
		request.setAttribute("today", 
				new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	}

}
