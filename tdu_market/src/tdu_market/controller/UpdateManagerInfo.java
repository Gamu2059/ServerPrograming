package tdu_market.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.ManagerUpdateInfo;
import tdu_market.entity_manager.ManagerInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class UpdateManagerInfo
 */
@WebServlet("/UpdateManagerInfo")
public class UpdateManagerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateManagerInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("UpdateManagerInfo is non implementation!");
		ManagerInfoManager manager = new ManagerInfoManager();
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}
		
		//必要項目の入力チェック（jsp側）
		
		//アカウントの情報を変更
		ManagerUpdateInfo updateInfo = new ManagerUpdateInfo( request.getParameter("mailAddress"),request.getParameter("nonHashedPassword"), request.getParameter("displayName"),   request.getParameter("iconImageURL"));
		manager.updateManagerInfo(updateInfo);
		//ページ遷移
		ControllerUtil.translatePage("edit_profile_admin.jsp", request, response);
	

	}

}
