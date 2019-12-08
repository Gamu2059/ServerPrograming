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
import tdu_market.dto.StudentGetInfo;
import tdu_market.entity_manager.DepartmentInfoManager;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class ManagerEditStudentPage
 */
@WebServlet("/tdu_market/controller/ManagerEditStudentPage")
public class ManagerEditStudentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerEditStudentPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ManagerEditStudentPage is non implementation!");
		//ログイン状態の検証

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		HttpSession session = request.getSession();
		//学生情報を保持していなければ再取得
		if ( request.getAttribute("studentInfo")==null ) {
			StudentInfoManager studentInfoManager = new StudentInfoManager();
			StudentGetInfo studentGetInfo = studentInfoManager.getStudentInfo(request.getParameter("studentMailAddress"), false);
			session.setAttribute("studentInfo", studentGetInfo);
		}

		//学科情報を保持していなければ再取得
		if( request.getAttribute("departmentInfoList")==null ) {
			DepartmentInfoManager departmentInfoManager = new DepartmentInfoManager();
			ArrayList<DepartmentGetInfo> departmentGetInfo = new ArrayList<DepartmentGetInfo>();
			departmentGetInfo = departmentInfoManager.getAllDepartmentInfoList(false);
			session.setAttribute("departmentInfoList", departmentGetInfo);
		}

		//遷移
		ControllerUtil.translatePage(JspPath.edit_student_by_admin, request, response);

	}


}
