package tdu_market.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.ReturnInfo;
import tdu_market.dto.StudentGetInfo;
import tdu_market.entity_manager.StudentInfoManager;

/**
 * Servlet implementation class EditStudentPage
 */
@WebServlet("/EditStudentPage")
public class EditStudentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditStudentPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("EditStudentPage is non implementation!");
		HttpSession session = request.getSession();
		String mailAddress = (String)session.getAttribute("mailaddress");
		StudentInfoManager student = new StudentInfoManager();
		ReturnInfo loginResult = student.existMailAddress(mailAddress);
		if(!loginResult.isSuccess()) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);		
		}

		//DBから学生情報を取得する
		StudentGetInfo studentInfo = student.getStudentInfo(mailAddress);
		//取得した情報をviewに適用
		request.setAttribute("mailaddress",studentInfo.getMailAddress());
		request.setAttribute("displayName",studentInfo.getDisplayName());
		request.setAttribute("departmentID",studentInfo.getDepartmentID());
		request.setAttribute("selfIntroduction",studentInfo.getSelfIntroduction());
		request.setAttribute("iconImageURL",studentInfo.getIconImageURL());

	}
}



