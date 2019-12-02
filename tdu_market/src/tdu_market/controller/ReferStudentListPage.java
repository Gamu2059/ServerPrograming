package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.DepartmentGetInfo;
import tdu_market.dto.ItemGetInfo;
import tdu_market.dto.StudentGetInfo;
import tdu_market.dto.StudentSearchInfo;
import tdu_market.entity_manager.DepartmentInfoManager;
import tdu_market.entity_manager.ItemInfoManager;
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

		//学生情報を検索
		StudentInfoManager studentInfo = new StudentInfoManager();
		StudentSearchInfo searchInfo = new StudentSearchInfo(request.getParameter("studentNumberKeyword"),longSubjectID,request.getParameter("displayNameKeyword"));
		ArrayList<StudentGetInfo> searchResult = studentInfo.searchStudentInfo(searchInfo);

		//学科情報を取得
		DepartmentInfoManager departmentInfoManager = new DepartmentInfoManager();
		ArrayList<DepartmentGetInfo> departmentInfoList = departmentInfoManager.getAllDepartmentInfoList(true);

		//出品情報を取得
		Map<String, Integer> studentAndExhibit = new HashMap<>();
		ItemInfoManager itemInfoManager = new ItemInfoManager();
		for( StudentGetInfo info:searchResult ) {
			ArrayList<ItemGetInfo> itemInfoList = itemInfoManager.getExhibitItem(info.getMailAddress());
			studentAndExhibit.put(info.getMailAddress(), itemInfoList.size());
		}

		//jspに情報を送信する
		HttpSession session = request.getSession();
		if(request.getParameter("isBack")==null) {
			session.setAttribute("studentList", searchResult);
		} else {
			if( request.getParameter("isBack").equals("true") ) {
			} else {
				session.setAttribute("studentList", searchResult);
			}
		}
		session.setAttribute("departmentInfoList", departmentInfoList);
		session.setAttribute("studentAndExhibitMap", studentAndExhibit);

		//遷移
		ControllerUtil.translatePage(JspPath.reference_student_list, request, response);
	}
}
