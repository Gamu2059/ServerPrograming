package tdu_market.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import tdu_market.dto.StudentUpdateInfo;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class RegisterStudentInfo
 */
@WebServlet("/tdu_market/controller/RegisterStudentInfo")
@MultipartConfig(maxFileSize = 1024 * 1024)
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentInfoManager student = new StudentInfoManager();
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}

		request.setCharacterEncoding("UTF-8");

		//入力フォームの必要事項が入力されているかチェック
		//ここではjsp側でしているため、していない
		String mailAddress = ControllerUtil.getMailAddress(request, response);
		String password = request.getParameter("nonHashedPassword");
		String name = request.getParameter("displayName");
		String intro = request.getParameter("selfIntroduction");
		Part part = request.getPart("iconImageURL");
		InputStream is = part.getInputStream();

		// 学生は仮登録時点で所属学科が確定するので subjectID = -1
		// TODO urlは後々に変更する
		StudentUpdateInfo studentInfo = new StudentUpdateInfo(mailAddress, password, name, -1, intro, is);

		//アカウントの仮登録状態を登録済みに、各種情報を入力されたものに変更。
		student.updateStudentInfo(studentInfo);

		//遷移
		TopPage topPage = new TopPage();
		topPage.doGet(request, response);
	}
}
