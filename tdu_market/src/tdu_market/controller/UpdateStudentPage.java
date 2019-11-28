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

@WebServlet("/tdu_market/controller/UpdateStudentPage")
@MultipartConfig(maxFileSize = 1024 * 1024)
public class UpdateStudentPage extends HttpServlet {
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

		if (!pass1.equals(pass2)) {
			session.setAttribute("errorInfo", "パスワードが一致しません。");
			ControllerUtil.translatePage(JspPath.edit_profile_student, request, response);
			return;
		}

		// 学生自身は所属学科を変更できないため、subjectID = -1
		StudentUpdateInfo updateInfo = new StudentUpdateInfo(mailAddress,pass1,name,-1,intro,is);
		StudentInfoManager student = new StudentInfoManager();
		ReturnInfo updateResult = student.updateStudentInfo(updateInfo);


		if (updateResult.isSuccess()) {
			session.setAttribute("errorInfo", null);
		} else {
			session.setAttribute("errorInfo", updateResult.getMsg());
		}

		ControllerUtil.translatePage(JspPath.edit_profile_student, request, response);
	}
}
