package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.StudentGetInfo;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class ReferStudentPage
 */
@WebServlet("/tdu_market/controller/ReferStudentPage")
public class ReferStudentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReferStudentPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ReferStudentPage is non implementation!");

		StudentInfoManager student = new StudentInfoManager();
		//ログイン状態の検証
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}
		//セッションからメールアドレスを取得
		String mailAddress = ControllerUtil.getMailAddress(request, response);

		//DBから学生情報を取得する
		StudentGetInfo studentInfo = student.getStudentInfo(mailAddress);
		//jspに情報を投げる。

		HttpSession session = request.getSession();
		session.setAttribute("studentInfo", studentInfo);
		System.out.println(studentInfo.getIconImageBinary());
		//遷移
		ControllerUtil.translatePage("/tdu_market/Student/reference_profile_student.jsp", request, response);

	}


}
