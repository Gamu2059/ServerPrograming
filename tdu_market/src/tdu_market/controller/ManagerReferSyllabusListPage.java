package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.SyllabusGetInfo;
import tdu_market.entity_manager.SyllabusInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class ReferSyllabusListPage
 */
@WebServlet("/tdu_market/controller/ManagerReferSyllabusListPage")
public class ManagerReferSyllabusListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerReferSyllabusListPage() {
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

		/*
		 //授業コードが適切かどうか
		String classCode = "";
		if(request.getParameter("classCode")!=null) {
			classCode = request.getParameter("classCode");
		}
		//学部IDが適切かどうか
		long departmentID = 0;
		if(request.getParameter("departmentID")!=null) {
			departmentID = Integer.valueOf(request.getParameter("departmentID")).longValue();
		}
		//授業名キーワードが適切かどうか
		String classNameKeyword ="";
		if(request.getParameter("classNameKeyword")!=null) {
			classNameKeyword = request.getParameter("classNameKeyword");
		}
		//担当教員名が適切かどうか
		String teacherNameKeyword = "";
		if(request.getParameter("teacherNameKeyword")!=null) {
			teacherNameKeyword = request.getParameter("teacherNameKeyword");
		}
		//学期IDが適切かどうか
		long semesterID = 0;
		if(request.getParameter("semesterID")!=null) {
			semesterID = Integer.valueOf(request.getParameter("semesterID")).longValue();
		}
		*/

		SyllabusInfoManager syllabusInfo = new SyllabusInfoManager();
		//SyllabusSearchInfo searchInfo = new SyllabusSearchInfo( classCode, departmentID, classNameKeyword, teacherNameKeyword, semesterID);

		//シラバス検索情報を格納
		ArrayList<SyllabusGetInfo> syllabusInfoList = syllabusInfo.getAllSyllabus();
		//jspに情報を投げる。
		HttpSession session = request.getSession();
		session.setAttribute("syllabusInfoList", syllabusInfoList);

		//遷移
		ControllerUtil.translatePage(JspPath.reference_syllabus_list_by_admin, request, response);


	}

}
