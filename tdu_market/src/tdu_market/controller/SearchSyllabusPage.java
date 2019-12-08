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
 * Servlet implementation class SearchSyllabusPage
 */
@WebServlet("/tdu_market/controller/SearchSyllabusPage")
public class SearchSyllabusPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchSyllabusPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("SearchSyllabusPage is non implementation!");

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		HttpSession session = request.getSession();
		//学科情報を保持していなければ送信
		if(session.getAttribute("departmentList")==null) {
			DepartmentInfoManager departmentInfoManager = new DepartmentInfoManager();
			ArrayList<DepartmentGetInfo> departmentList = new ArrayList<DepartmentGetInfo>();
			departmentList = departmentInfoManager.getAllDepartmentInfoList(true);
			session.setAttribute("departmentList", departmentList);
		}
		//教員情報を保持していなければ送信
		if(session.getAttribute("teacherList")==null) {
			TeacherInfoManager teacherInfoManager = new TeacherInfoManager();
			ArrayList<TeacherGetInfo> teacherList = new ArrayList<TeacherGetInfo>();
			teacherList = teacherInfoManager.getTeacherInfoList();
			session.setAttribute("teacherList", teacherList);
		}

		//遷移
		ControllerUtil.translatePage(JspPath.search_from_syllabus, request, response);

	}
}
