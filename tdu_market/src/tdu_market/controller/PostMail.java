package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tdu_market.entity_manager.StudentInfoManager;
/**
 * Servlet implementation class PostMail
 */
@WebServlet("/PostMail")
public class PostMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostMail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("PostMail is non implementation!");

		StudentInfoManager student = new StudentinfoManager();
		//' メールアドレスがメールアドレスの体をなしているかチェック
		//' メールアドレスがDBに登録されていないかをチェックする
		if( student.existMailAddress(mailAddress)) {
			//' 新規アカウントを仮登録状態、仮パスワードで作成する
			student.createTemporaryAccount(mailAddress);
		//' 仮パスワードをメールアドレス宛に送信する
			
			//ここもんだい
			
		//' 送信した後、ログインページに遷移する
		  RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
          rd.forward(request, response);
		}
	}

}
