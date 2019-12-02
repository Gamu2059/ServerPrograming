package tdu_market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		//文字コードを統一
		request.setCharacterEncoding("UTF-8");

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
		String confirmTeacherName = "";
		TeacherInfoManager teacherInfoManager = new TeacherInfoManager();
		ArrayList<TeacherGetInfo> teacherInfo = new ArrayList<TeacherGetInfo>();
		teacherInfo = teacherInfoManager.getTeacherInfoList();
		for(int i = 0;i<teacherInfo.size();i++) {
			if(teacherInfo.get(i).getTeacherName().contains(teacherName)) {
				teacherID = teacherInfo.get(i).getTeacherID();
				confirmTeacherName = teacherInfo.get(i).getTeacherName();
				break;
			}
		}

		//必須入力でない部分のnull回避
		if(overview==null || overview.isEmpty()) overview="※目的概要は登録されていません";
		if(target==null || target.isEmpty()) target="※達成目標は登録されていません";
		if(requierments==null || requierments.isEmpty()) requierments="※履修条件は登録されていません";
		if(evaluationMethod==null || evaluationMethod.isEmpty()) evaluationMethod="※評価方法は登録されていません";

		//シラバス情報の登録準備
		SyllabusInfoManager syllabus = new SyllabusInfoManager();
		SyllabusCreateInfo createInfo = new SyllabusCreateInfo(classCode, className, subjectID, teacherID,dates, unitNum, classRoom,  overview, target, requierments, evaluationMethod, semesterID);

		//入力情報の検証
		ReturnInfo retunResult = syllabus.validateRegisterSyllabus(createInfo);

		//jspへデータの送信
		HttpSession session = request.getSession();
		session.setAttribute("confirmCreateSyllabusInfo", createInfo );
		session.setAttribute("confirmTeacherName", confirmTeacherName);

		//登録の時
		if(request.getAttribute("registOrEdit").equals("regist")) {
			//遷移先分岐
			if(retunResult.isSuccess())	{
//				syllabus.createSyllabusInfo(createInfo);
				//エラーメッセージを破棄
				session.removeAttribute("createSyllabusErrorMessage");
				ControllerUtil.translatePage(JspPath.confirm_syllabus_by_admin, request, response);
			}else {
				//エラーメッセージをjspに送信
				session.setAttribute("createSyllabusErrorMessage", retunResult.toString());
				ControllerUtil.translatePage(JspPath.register_syllabus_by_admin, request, response);
			}
		} else if(request.getAttribute("registOrEdit").equals("edit")) {

		}

	}
}
