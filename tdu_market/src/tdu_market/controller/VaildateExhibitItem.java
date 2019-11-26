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
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.dto.ItemCreateInfo;


/**
 * Servlet implementation class VaildateExhibitItem
 */
@WebServlet("/tdu_market/controller/VaildateExhibitItem")
public class VaildateExhibitItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VaildateExhibitItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("VaildateExhibitItem is non implementation!");

		
		//出品物情報の検証を行うクラス。正しい場合は、jspの確認画面へ遷移させる。
		
		
		//ログイン状態の検証
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}

		ItemInfoManager itemInfo = new ItemInfoManager();
		request.getParameter("mailaddress");
		ItemCreateInfo createInfo = new ItemCreateInfo(request.getParameter("exhibitorMailAddress"), request.getParameter("itemName"), request.getParameter("description"),Integer.valueOf(request.getParameter("condtion")).intValue() , Integer.valueOf(request.getParameter("price")).intValue(),
				request.getParameter("relatedClassCode"), request.getParameterValues("itemImageURLs"));
		ReturnInfo itemResult = itemInfo.validateRegisterExhibitItem(createInfo);

		if(itemResult.isSuccess()) {
			//ページ遷移(本当にこれで出品しますか？のようなjsp)
			ControllerUtil.translatePage("/tdu_market/Student/confirm_register_exhibit.jsp", request, response);
		}
		else {
			//ページ遷移
			//入力値が不正だったときの遷移先
			ControllerUtil.translatePage("/tdu_market/Student/register_exhibit.jsp", request, response);

		}
	}
}


