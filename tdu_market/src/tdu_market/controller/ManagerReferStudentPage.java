package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.StudentGetInfo;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class ManagerReferStudentPage
 */
@WebServlet("/tdu_market/controller/ManagerReferStudentPage")
public class ManagerReferStudentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerReferStudentPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ManagerReferStudentPage is non implementation!");//ログイン状態の検証

		StudentInfoManager student = new StudentInfoManager();

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}
		//セッションからメールアドレスを取得
		String mailAddress = ControllerUtil.getMailAddress(request, response);

		//DBから学生情報を取得する
		StudentGetInfo studentInfo = student.getStudentInfo(mailAddress);
		//jspに情報を投げる。
		request.setAttribute("studentInfo", studentInfo);

		//遷移
		ControllerUtil.translatePage("/tdu_market/Admin/reference_student_detal_by_admin.jsp", request, response);


	}


}
