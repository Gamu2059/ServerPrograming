package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

@WebServlet("/tdu_market/controller/ManagerDeleteStudentInfo")
public class ManagerDeleteStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ログイン状態の検証
		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		HttpSession session = request.getSession();

		// 自分ではなく、削除対象の学生のメールアドレスを取得
		String studentMailAddress = (String)request.getParameter("delete_student_mailaddress");

		StudentInfoManager student = new StudentInfoManager();
		student.deleteStudentInfo(studentMailAddress);

		// 不要になるはずなので、すぐにセッションから情報を削除
		session.removeAttribute("delete_student_mailaddress");

		ControllerUtil.translatePage(JspPath.reference_student_list, request, response);
	}
}
