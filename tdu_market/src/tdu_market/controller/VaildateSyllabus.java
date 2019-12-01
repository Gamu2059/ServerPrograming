package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.ReturnInfo;
import tdu_market.dto.SyllabusCreateInfo;
import tdu_market.dto.TeacherGetInfo;
import tdu_market.entity_manager.SyllabusInfoManager;
import tdu_market.entity_manager.TeacherInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class RegisterStudentInfo
 */
@WebServlet("/tdu_market/controller/VaildateSyllabus")
public class VaildateSyllabus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VaildateSyllabus() {
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

		//データの受け取り
		String classCode = request.getParameter("classCode");
		String className = request.getParameter("className");
		long subjectID = Integer.valueOf(request.getParameter("subjectID")).longValue();
		long semesterID = Integer.valueOf(request.getParameter("semesterID")).longValue();
		String dates = request.getParameter("dates");
		int unitNum = Integer.valueOf(request.getParameter("unitNum"));
		String classRoom = request.getParameter("classRoom");
		String teacherName = request.getParameter("teacherName");
		String overview = request.getParameter("overview");
		String target = request.getParameter("target");
		String requierments = request.getParameter("requierments");
		String evaluationMethod = request.getParameter("evaluationMethod");

		//教員名を教員IDに変換
		long teacherID = 0;
		TeacherInfoManager teacherInfoManager = new TeacherInfoManager();
		ArrayList<TeacherGetInfo> teacherInfo = new ArrayList<TeacherGetInfo>();
		teacherInfo = teacherInfoManager.getTeacherInfoList();
		for(int i = 0;i<teacherInfo.size();i++) {
			if(teacherInfo.get(i).getTeacherName().equals(teacherName)) {
				teacherID = teacherInfo.get(i).getTeacherID();
				break;
			}
		}

		//必須入力でない部分のnull回避
		if(overview==null) overview="※目的概要は登録されていません";
		if(target==null) target="※達成目標は登録されていません";
		if(requierments==null) requierments="※履修条件は登録されていません";
		if(evaluationMethod==null) evaluationMethod="※評価方法は登録されていません";

		//シラバス情報の登録準備
		SyllabusInfoManager syllabus = new SyllabusInfoManager();
		SyllabusCreateInfo createInfo = new SyllabusCreateInfo(classCode, className, subjectID, teacherID,dates, unitNum, classRoom,  overview, target, requierments, evaluationMethod, semesterID);

		//入力情報の検証
		ReturnInfo retunResult = syllabus.validateRegisterSyllabus(createInfo);

		//遷移先分岐
		if(retunResult.isSuccess())	{
//			syllabus.createSyllabusInfo(createInfo);
		}
		//遷移
		ControllerUtil.translatePage(JspPath.register_syllabus_by_admin, request, response);

	}
}
