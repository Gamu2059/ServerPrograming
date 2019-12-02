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
import tdu_market.dto.SemesterGetInfo;
import tdu_market.dto.TeacherGetInfo;
import tdu_market.entity_manager.DepartmentInfoManager;
import tdu_market.entity_manager.SemesterInfoManager;
import tdu_market.entity_manager.TeacherInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class SearchSyllabusPage
 */
@WebServlet("/tdu_market/controller/ManagerSearchSyllabusPage")
public class ManagerSearchSyllabusPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerSearchSyllabusPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("SearchSyllabusPage is non implementation!");

		//ログイン検証
		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		//必要なデータ
		//学科情報
		DepartmentInfoManager departmentInfoManager = new DepartmentInfoManager();
		ArrayList<DepartmentGetInfo> departmentGetInfos = departmentInfoManager.getAllDepartmentInfoList(true);

		//教員情報
		TeacherInfoManager teacherInfoManager = new TeacherInfoManager();
		ArrayList<TeacherGetInfo> teacherGetInfos = teacherInfoManager.getTeacherInfoList();

		//年度情報
		SemesterInfoManager semesterInfoManager = new SemesterInfoManager();
		ArrayList<SemesterGetInfo> semesterGetInfos = semesterInfoManager.getSemesterInfoList();

		//送信する
		HttpSession session = request.getSession();
		session.setAttribute("departmentInfoList", departmentGetInfos );
		session.setAttribute("teacherInfoList", teacherGetInfos );
		session.setAttribute("semesterInfoList", semesterGetInfos );

		//遷移
		ControllerUtil.translatePage(JspPath.search_syllabus_by_admin, request, response);

	}
}
