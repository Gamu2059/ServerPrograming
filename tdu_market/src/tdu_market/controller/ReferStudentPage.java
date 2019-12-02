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

@WebServlet("/tdu_market/controller/ReferStudentPage")
public class ReferStudentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		StudentInfoManager student = new StudentInfoManager();
		String mailAddress = ControllerUtil.getMailAddress(request, response);

		StudentGetInfo studentInfo = student.getStudentInfo(mailAddress);

		HttpSession session = request.getSession();

		//学科情報を取得
		if(session.getAttribute("departmentInfoList") == null) {
			DepartmentInfoManager departmentInfoManager = new DepartmentInfoManager();
			ArrayList<DepartmentGetInfo> departmentInfoList = departmentInfoManager.getAllDepartmentInfoList(true);
			session.setAttribute("departmentInfoList", departmentInfoList);
		}

		session.setAttribute("studentInfo", studentInfo);

		ControllerUtil.translatePage(JspPath.reference_profile_student, request, response);
	}
}
