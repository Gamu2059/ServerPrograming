package tdu_market.controller;
import tdu_market.entity_manager.ManagerInfoManager;
import tdu_market.entity_manager.StudentInfoManager;
import java.io.IOException;

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

	//ここでは便宜的にアドレスとパスを与えている
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
		String sentaddress = request.getParameter("mailaddress");
		String sentPw = request.getParameter("password");
		
		// 'メールアドレスから学生か運営かを判定する
		if (sentaddress.endsWith("@ms.dendai.ac.jp")) {
			// '学生ならStudentInfoManagerにメールアドレスとパスワードを渡し、ログインできるかチェックする
			//'アカウントが仮登録状態ならば、新規登録画面に遷移する
			//'アカウントが登録済み状態ならば、トップ画面に遷移する
			// 'チェックがOKなら、StudentInfoManagerのloginを呼ぶ
			student.login();
		}

		if (sentaddress.endsWith("@ms.dendai.ac.jp")) {
			// '運営ならManagerInfoManagerにメールアドレスとパスワードを渡し、ログインできるかチェックする
			//'アカウントが仮登録状態ならば、新規登録画面に遷移する
			//'アカウントが登録済み状態ならば、トップ画面に遷移する
			// 'チェックがOKなら、ManagerInfoManagerのloginを呼ぶ
		}

		//セッションにメールアドレスを保存する(他にいい実装があるかもしれない...)
		HttpSession session = request.getSession();
		session.setAttribute("mailaddress", sentaddress);


		/*作ってしまったログイン処理　
	        if (sentaddress.equals(loginId) && sentPw.equals(password)) {
	            HttpSession session = request.getSession();
	            session.setAttribute("loginUser", true);
	            RequestDispatcher rd = request.getRequestDispatcher("NewFile.jsp");
	            rd.forward(request, response);
	        } else {
	            request.setAttribute("loginErrorMsg", "ログイン情報が不正です。");
	            request.setAttribute("errorFlg", true);
	            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	            rd.forward(request, response);
	        }
		 */

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}



