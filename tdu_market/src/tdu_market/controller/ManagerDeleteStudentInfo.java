package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;

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

		// 自分ではなく、削除対象の学生のメールアドレスを取得
		String studentMailAddress = (String)request.getParameter("delete_student_mailaddress");
		System.out.println(studentMailAddress);

		StudentInfoManager student = new StudentInfoManager();
		student.deleteStudentInfo(studentMailAddress);

		// リストページに遷移
		ReferStudentListPage referStudentListPage = new ReferStudentListPage();
		referStudentListPage.doGet(request, response);
	}
}
