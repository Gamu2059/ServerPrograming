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
import tdu_market.util.JspPath;

@WebServlet("/tdu_market/controller/ManagerReferStudentPage")
public class ManagerReferStudentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		/*String mailAddress = ControllerUtil.getMailAddress(request, response);*/
		//学生のメールアドレスを取得
		String mailAddress = request.getParameter("mailAddress");

		StudentInfoManager student = new StudentInfoManager();

		// 運営側であっても、原則として仮登録状態のアカウントの取得はしない(はず)
		StudentGetInfo studentInfo = student.getStudentInfo(mailAddress, false);

		HttpSession session = request.getSession();
		session.setAttribute("studentInfo", studentInfo);

		ControllerUtil.translatePage(JspPath.reference_student_detail_by_admin, request, response);
	}
}
