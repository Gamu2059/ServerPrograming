package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.StudentGetInfo;
import tdu_market.dto.StudentSearchInfo;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class ReferStudentListPage
 */
@WebServlet("/tdu_market/controller/ReferStudentListPage")
public class ReferStudentListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReferStudentListPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ReferStudentListPage is non implementation!");

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		StudentInfoManager studentInfo = new StudentInfoManager();
		StudentSearchInfo searchInfo = new StudentSearchInfo(request.getParameter("studentNumberKeyword"),Integer.valueOf(request.getParameter("subjectID;")).longValue(),request.getParameter("displayNameKeyword"));
		ArrayList<StudentGetInfo> searchResult = studentInfo.searchStudentInfo(searchInfo);

		//jspに情報を投げる。
		request.setAttribute("searchResult", searchResult);
		//遷移
		ControllerUtil.translatePage(JspPath.reference_student_list, request, response);

	}


}
