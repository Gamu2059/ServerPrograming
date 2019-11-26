package tdu_market.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.ItemCreateInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class RegisterItemInfo
 */
@WebServlet("/tdu_market/controller/RegisterItemInfo")
public class RegisterItemInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterItemInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//出品物情報の作成そのものを行うクラス。値の検証はValidateExhibitItem
		
		//ログイン状態の検証
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}

		ItemInfoManager itemInfo = new ItemInfoManager();
		ItemCreateInfo createInfo = new ItemCreateInfo(request.getParameter("exhibitorMailAddress"), request.getParameter("itemName"), request.getParameter("description"),Integer.valueOf(request.getParameter("condtion")).intValue() , Integer.valueOf(request.getParameter("price")).intValue(),
				request.getParameter("relatedClassCode"), request.getParameterValues("itemImageURLs"));
		//アイテム情報の作成	
		itemInfo.createItemInfo(createInfo);
		
		//遷移
		ControllerUtil.translatePage("/tdu_market/Student/reference_item_list.jsp", request, response);

	}

}
