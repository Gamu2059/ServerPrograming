package tdu_market.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.entity_manager.ManagerInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class ManagerLogout
 */
@WebServlet("/tdu_market/controller/ManagerLogout")
public class ManagerLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLogout() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ManagerLogout is non implementation!");

			ManagerInfoManager manager = new ManagerInfoManager();
			//セッションからメールアドレスを取得
			String mailAddress = ControllerUtil.getMailAddress(request, response);
			// ManagerInfoManagerのlogoutを呼ぶ。
			manager.logout(mailAddress);

			//セッションに保存されたデータの削除
			HttpSession sess = request.getSession();
			Enumeration vals = sess.getAttributeNames();
			while(vals.hasMoreElements()){
				String nm = (String)vals.nextElement();
				sess.removeAttribute(nm);
			}	
			//ログインページに遷移
			ControllerUtil.translatePage(JspPath.index, request, response);
		
	}

}
