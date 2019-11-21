package tdu_market.controller;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;

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
		//セッションからメールアドレスを取得
		String mailAddress = ControllerUtil.getMailAddress(request, response);
		// StudentInfoManagerのlogoutを呼ぶ。
		student.logout(mailAddress);

		//セッションに保存されたデータの削除
		HttpSession sess = request.getSession();
		Enumeration vals = sess.getAttributeNames();
		while(vals.hasMoreElements()){
			String nm = (String)vals.nextElement();
			sess.removeAttribute(nm);
		}	

		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);


	}

}
