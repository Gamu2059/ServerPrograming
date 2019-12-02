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
import tdu_market.dto.SyllabusGetInfo;
import tdu_market.dto.TeacherGetInfo;
import tdu_market.entity_manager.DepartmentInfoManager;
import tdu_market.entity_manager.SyllabusInfoManager;
import tdu_market.entity_manager.TeacherInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class EditSyllabusPage
 */
@WebServlet("/tdu_market/controller/EditSyllabusPage")
public class EditSyllabusPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditSyllabusPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("EditSyllabusPage is non implementation!");

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		//jspにデータを送信する
		//更新対象シラバス情報
		SyllabusInfoManager syllabusInfoManager = new SyllabusInfoManager();
		SyllabusGetInfo syllabusGetInfo = syllabusInfoManager.getSyllabusInfo(request.getParameter("classCode"));
		//学科情報
		DepartmentInfoManager departmentInfoManager = new DepartmentInfoManager();
		ArrayList<DepartmentGetInfo> departmentGetInfo = departmentInfoManager.getAllDepartmentInfoList(true);
		//教員情報
		TeacherInfoManager teacherInfoManager = new TeacherInfoManager();
		ArrayList<TeacherGetInfo>teacherGetInfo = teacherInfoManager.getTeacherInfoList();

		//jspにデータを送信
		HttpSession session = request.getSession();
		session.setAttribute("syllabusInfo", syllabusGetInfo);
		session.setAttribute("departmentInfoList", departmentGetInfo);
		session.setAttribute("teacherInfoList", teacherGetInfo);

		// 遷移
		ControllerUtil.translatePage(JspPath.edit_syllabus_by_admin, request, response);

	}

}
