package tdu_market.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tdu_market.dto.StudentUpdateInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class RegisterStudentInfo
 */
@WebServlet("/tdu_market/controller/RegisterStudentInfo")
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
	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	
		StudentInfoManager student = new StudentInfoManager();
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}

		//入力フォームの必要事項が入力されているかチェック
		//ここではjsp側でしているため、していない
		//
		
		StudentUpdateInfo studentInfo = new StudentUpdateInfo(request.getParameter("mailaddress"), request.getParameter("nonHashedPassword"), request.getParameter("displayName"), Integer.valueOf(request.getParameter("departmentValue")).longValue(), request.getParameter("selfIntroduction"), request.getParameter("iconImageURL"));
		
		//アカウントの仮登録状態を登録済みに、各種情報を入力されたものに変更。
		student.updateStudentInfo(studentInfo);
		//遷移
		ControllerUtil.translatePage("/tdu_market/general/index.jsp", request, response);		
	}

}
