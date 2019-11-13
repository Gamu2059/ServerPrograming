package tdu_market.controller;
import tdu_market.entity_manager.ManagerInfoManager;
import tdu_market.entity_manager.StudentInfoManager;
import java.io.IOException;
import tdu_market.dto.LoginInfo;
import tdu_market.dto.ReturnInfo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//�����ł͕֋X�I�ɃA�h���X�ƃp�X��^���Ă���
	private final String loginId = "1@gmail.com";
	private final String password = "123";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.err.println("Login is non implementation!");
		

		ManagerInfoManager manage = new ManagerInfoManager();
		StudentInfoManager student = new StudentInfoManager();
		LoginInfo info = new LoginInfo(request.getParameter("mailaddress"),request.getParameter("password"));
	
	
		if (info.getMailAddress().endsWith("@ms.dendai.ac.jp")) {			
			ReturnInfo result = student.isRegisteredState(info.getMailAddress());
			if(result.isSuccess()) {
			student.login(info);
			}
			
		}

		else if (info.getMailAddress().endsWith("@ms.dendai.ac.jp")) {
		
			manage.login(info);
		}

		//セッションにアドレスを保存
		HttpSession session = request.getSession();
		session.setAttribute("mailaddress", info.getMailAddress());
		
		

		/*����Ă��܂������O�C�������@
	        if (sentaddress.equals(loginId) && sentPw.equals(password)) {
	            HttpSession session = request.getSession();
	            session.setAttribute("loginUser", true);
	            RequestDispatcher rd = request.getRequestDispatcher("NewFile.jsp");
	            rd.forward(request, response);
	        } else {
	            request.setAttribute("loginErrorMsg", "���O�C����񂪕s���ł��B");
	            request.setAttribute("errorFlg", true);
	            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	            rd.forward(request, response);
	        }
		 */

	}


}



