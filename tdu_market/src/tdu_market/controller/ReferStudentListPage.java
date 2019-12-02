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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		String studentNumberKeyword = request.getParameter("studentNumberKeyword");
		String displayNameKeyword = request.getParameter("displayNameKeyword");
		String subjectIDStr = request.getParameter("subjectID");

		long subjectID = -1;
		try {
			subjectID = Long.parseLong(subjectIDStr);
		} catch (NumberFormatException e) {

		}

		StudentInfoManager studentInfo = new StudentInfoManager();
		// 仮登録状態の学生は無視するのでfalseを指定する
		StudentSearchInfo searchInfo = new StudentSearchInfo(studentNumberKeyword, subjectID, displayNameKeyword, false);
		ArrayList<StudentGetInfo> searchResult = studentInfo.searchStudentInfo(searchInfo);

		DepartmentInfoManager departmentInfoManager = new DepartmentInfoManager();
		// 学生として普通科目に属する人はいないはずなのでfalseを指定する
		ArrayList<DepartmentGetInfo> departmentInfoList = departmentInfoManager.getAllDepartmentInfoList(false);

		// 絶対この処理重い(今後試したときに重すぎたら改良する)
		Map<String, Integer> studentAndExhibit = new HashMap<>();
		ItemInfoManager itemInfoManager = new ItemInfoManager();
		for (StudentGetInfo info : searchResult) {
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
