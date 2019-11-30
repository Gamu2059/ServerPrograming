package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.StudentGetInfo;
import tdu_market.dto.StudentSearchInfo;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

@WebServlet("/tdu_market/controller/ReferStudentListPage")
public class ReferStudentListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ReferStudentListPage is non implementation!");

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		//学科IDがnullの場合は0に指定
		long longSubjectID;
		if(request.getParameter("subjectID")==null) {
			longSubjectID = 0;
		}else {
			longSubjectID = Integer.valueOf(request.getParameter("subjectID")).longValue();
		}

		StudentInfoManager studentInfo = new StudentInfoManager();
		StudentSearchInfo searchInfo = new StudentSearchInfo(request.getParameter("studentNumberKeyword"),longSubjectID,request.getParameter("displayNameKeyword"));
		ArrayList<StudentGetInfo> searchResult = studentInfo.searchStudentInfo(searchInfo);

		//jspに情報を投げる。
		HttpSession session = request.getSession();
		session.setAttribute("studentList", searchResult);

		//遷移
		ControllerUtil.translatePage(JspPath.reference_student_list, request, response);
	}
}
