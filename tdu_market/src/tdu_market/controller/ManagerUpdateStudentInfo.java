package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.StudentUpdateInfo;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class ManagerUpdateStudentInfo
 */
@WebServlet("/tdu_market/controller/ManagerUpdateStudentInfo")
public class ManagerUpdateStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerUpdateStudentInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ManagerUpdateStudentInfo is non implementation!");

		StudentInfoManager student = new StudentInfoManager();
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}

		//必要項目の入力チェック（jsp側）

		//アカウントの情報を変更
		StudentUpdateInfo updateInfo = new StudentUpdateInfo(request.getParameter("mailaddress"), request.getParameter("nonHashedPassword"), request.getParameter("displayName"), Integer.valueOf(request.getParameter("departmentID")).longValue(), request.getParameter("selfIntroduction"), request.getParameter("iconImageURL"));
		student.updateStudentInfo(updateInfo);
		//遷移
		ControllerUtil.translatePage("/tdu_market/Admin/edit_student_by_admin.jsp", request, response);


	}

}
