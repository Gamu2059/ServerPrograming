package tdu_market.controller;
import tdu_market.entity_manager.StudentInfoManager;
import java.io.IOException;
import tdu_market.entity_manager.ManagerInfoManager;
import tdu_market.entity_manager.StudentInfoManager;
import java.io.IOException;
import java.util.Enumeration;
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Logout() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("Logout is non implementation!");
		StudentInfoManager student = new StudentInfoManager();
		
		
		// StudentInfoManagerのlogoutを呼ぶ
		student.logout(mailAddress);
		//セッションに保存してある色々なデータを抹消する
		HttpSession sess = request.getSession();
			//セッションにある全ての要素名を取得する
		Enumeration vals = sess.getAttributeNames();

			//取得した要素名をループ処理で全て削除する
		while(vals.hasMoreElements()){
			String nm = (String)vals.nextElement();
			sess.removeAttribute(nm);
		}	
		//ログインページに遷移する
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);


	}

}
