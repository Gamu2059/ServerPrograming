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
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class SigninStudentPage
 */

@WebServlet("/tdu_market/controller/SigninStudentPage")
public class SigninStudentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SigninStudentPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("SigninStudentPage is non implementation!");

/*不要なサーブレット
		//ログイン状態の検証
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}
		//遷移
		ControllerUtil.translatePage("/tdu_market/Student/student_top.jsp", request, response);

	
	*/
	}
}
