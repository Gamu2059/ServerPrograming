package tdu_market.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.ReturnInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.dto.ItemUpdateInfo;

/**
 * Servlet implementation class UpdateItemInfo
 */
@WebServlet("/UpdateItemInfo")
public class UpdateItemInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateItemInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		//ログイン状態の検証
				if (!ControllerUtil.verifyLogin(request, response)) {
					return;
				}
		
		//出品商品更新処理
		ItemInfoManager itemInfo = new ItemInfoManager();
		ItemUpdateInfo updateInfo = new ItemUpdateInfo(Integer.valueOf(request.getParameter("itemID")).longValue(), request.getParameter("itemName"), request.getParameter("description"), 
				Integer.valueOf(request.getParameter("condition")).intValue(), Integer.valueOf(request.getParameter("itemID")).intValue(),
				request.getParameter("relatedClassCode") , request.getParameterValues("itemImageURLs"));
		itemInfo.updateItemInfo(updateInfo);
	}

}
