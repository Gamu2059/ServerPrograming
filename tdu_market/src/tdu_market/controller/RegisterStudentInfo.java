package tdu_market.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tdu_market.dto.StudentUpdateInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.entity_manager.StudentInfoManager;

/**
 * Servlet implementation class RegisterStudentInfo
 */
@WebServlet("/RegisterStudentInfo")
public class RegisterStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterStudentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String mailAddress = (String)session.getAttribute("mailaddress");
		StudentInfoManager student = new StudentInfoManager();
		ReturnInfo loginResult = student.existMailAddress(mailAddress);

		if(!loginResult.isSuccess()) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);		
		}

		//入力フォームの必要事項が入力されているかチェック
		//ここではjsp側でしているため、していない
		//
		
		StudentUpdateInfo studentInfo = new StudentUpdateInfo(request.getParameter("mailaddress"), request.getParameter("nonHashedPassword"), request.getParameter("displayName"), Integer.valueOf(request.getParameter("departmentValue")).longValue(), request.getParameter("selfIntroduction"), request.getParameter("iconImageURL"));
		
		//アカウントの仮登録状態を登録済みに、各種情報を入力されたものに変更。
		student.makeStudentInfoRegistered(studentInfo);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);		
	}

}
