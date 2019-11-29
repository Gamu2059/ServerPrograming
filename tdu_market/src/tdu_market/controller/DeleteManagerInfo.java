package tdu_market.controller;

import java.io.IOException;

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
 * Servlet implementation class DeleteManagerInfo
 */
@WebServlet("/tdu_market/controller/DeleteManagerInfo")
public class DeleteManagerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteManagerInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("DeleteManagerInfo is non implementation!");

		ManagerInfoManager manager = new ManagerInfoManager();

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}
		//セッションからメールアドレスを取得
		String mailAddress = ControllerUtil.getMailAddress(request, response);
		//運営情報削除
		manager.deleteManagerInfo(mailAddress);
		//セッションの破棄
		HttpSession session = request.getSession();
		session.invalidate();
		// 遷移
		ControllerUtil.translatePage("/tdu_market/general/index.jsp", request, response);

	}

}
