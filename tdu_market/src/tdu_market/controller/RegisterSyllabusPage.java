package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.DepartmentGetInfo;
import tdu_market.dto.TeacherGetInfo;
import tdu_market.entity_manager.DepartmentInfoManager;
import tdu_market.entity_manager.TeacherInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class RegisterStudentInfo
 */
@WebServlet("/tdu_market/controller/RegisterSyllabusPage")
public class RegisterSyllabusPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterSyllabusPage() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		//学科情報を取得
		DepartmentInfoManager departmentInfoManager = new DepartmentInfoManager();
		ArrayList<DepartmentGetInfo> departmentGetInfo = new ArrayList<DepartmentGetInfo>();
		departmentGetInfo = departmentInfoManager.getAllDepartmentInfoList(true);

		//全教員情報を取得
		TeacherInfoManager teacherInfoManager = new TeacherInfoManager();
		ArrayList<TeacherGetInfo> teacherInfoList = new ArrayList<TeacherGetInfo>();
		teacherInfoList = teacherInfoManager.getTeacherInfoList();

		//jspに情報をおくる
		HttpSession session = request.getSession();
		session.setAttribute("departmentInfoList", departmentGetInfo);
		session.setAttribute("teacherInfoList", teacherInfoList);

		//遷移
		ControllerUtil.translatePage(JspPath.register_syllabus_by_admin, request, response);

	}

}
