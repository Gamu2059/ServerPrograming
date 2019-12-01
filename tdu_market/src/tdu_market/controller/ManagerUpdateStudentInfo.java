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

@WebServlet("/tdu_market/controller/ManagerUpdateStudentInfo")
@MultipartConfig(maxFileSize = 1024 * 1024)
public class ManagerUpdateStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		//編集対象の学生メールアドレスを取得する
		final String mailAddress = request.getParameter("mailAddress");
		//変更するデータを取得する
		Part part = request.getPart("iconImageURL");
		String name = request.getParameter("displayName");
		String departmentID = request.getParameter("departmentID");
		String selfIntroduction = request.getParameter("selfIntroduction");
		InputStream is = part.getInputStream();

		//学科IDをStringからlongに変換する
		long subjectID = -1;
		try {
			subjectID = Integer.parseInt(departmentID);
		} catch (NumberFormatException e) {

		}

		//パスワードがnullでも更新できなければならない。

		StudentUpdateInfo updateInfo = new StudentUpdateInfo(mailAddress, pass1, name, subjectID, intro, is);
		StudentInfoManager student = new StudentInfoManager();
		ReturnInfo updateResult = student.updateStudentInfo(updateInfo);

		if (updateResult.isSuccess()) {
			session.setAttribute("errorInfo", null);
		} else {
			session.setAttribute("errorInfo", updateResult.getMsg());
		}

		ControllerUtil.translatePage(JspPath.edit_student_by_admin, request, response);
	}

}
