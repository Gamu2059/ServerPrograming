package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class ManagerDeleteStudentInfo
 */
@WebServlet("/tdu_market/controller/ManagerDeleteStudentInfo")
public class ManagerDeleteStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerDeleteStudentInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ManagerDeleteStudentInfo is non implementation!");

		StudentInfoManager student = new StudentInfoManager();


		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}
		//セッションからメールアドレスを取得
		String mailAddress = ControllerUtil.getMailAddress(request, response);
		//学生情報削除
		student.deleteStudentInfo(mailAddress);

		//遷移
		ControllerUtil.translatePage(JspPath.reference_student_list, request, response);
	
	}


}
