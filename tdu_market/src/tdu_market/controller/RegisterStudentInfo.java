package tdu_market.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import tdu_market.dto.ReturnInfo;
import tdu_market.dto.StudentUpdateInfo;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

@WebServlet("/tdu_market/controller/RegisterStudentInfo")
@MultipartConfig(maxFileSize = 1024 * 1024)
public class RegisterStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		//入力フォームの必要事項が入力されているかチェック
		//ここではjsp側でしているため、していない
		String mailAddress = ControllerUtil.getMailAddress(request, response);
		String pass1 = request.getParameter("nonHashedPassword1");
		String pass2 = request.getParameter("nonHashedPassword2");
		String name = request.getParameter("displayName");
		String intro = request.getParameter("selfIntroduction");
		Part part = request.getPart("iconImageURL");
		InputStream is = part.getInputStream();

		if (pass1 == null || pass2 == null) {
			session.setAttribute("errorInfo", "パスワードを入力して下さい。");
			ControllerUtil.translatePage(JspPath.create_student_account, request, response);
			return;
		}

		if (!pass1.equals(pass2)) {
			session.setAttribute("errorInfo", "パスワードが一致しません。");
			ControllerUtil.translatePage(JspPath.create_student_account, request, response);
			return;
		}

		// 学生は仮登録時点で所属学科が確定するので subjectID = -1
		StudentUpdateInfo studentInfo = new StudentUpdateInfo(mailAddress, pass1, name, -1, intro, is);
		StudentInfoManager student = new StudentInfoManager();
		ReturnInfo createResult = student.updateStudentInfo(studentInfo);

		if (createResult.isSuccess()) {

			TopPage topPage = new TopPage();
			topPage.doGet(request, response);
		} else {

			session.setAttribute("errorInfo", createResult.getMsg());
			ControllerUtil.translatePage(JspPath.create_student_account, request, response);
		}
	}
}
