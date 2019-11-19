package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class ManagerDeleteIntemInfo
 */
@WebServlet("/ManagerDeleteItemInfo")
public class ManagerDeleteItemInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerDeleteItemInfo() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ManagerDeleteItemInfo is non implementation!");
		//ログイン状態の検証
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}
		//削除処理
		ItemInfoManager itemInfo = new ItemInfoManager();
		itemInfo.deleteItemInfo(Integer.valueOf(request.getParameter("itemID")));
	}

}
