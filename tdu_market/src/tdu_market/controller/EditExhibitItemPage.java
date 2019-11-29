package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.ItemGetInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class EditExhibitItemPage
 */
@WebServlet("/tdu_market/controller/EditExhibitItemPage")
public class EditExhibitItemPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditExhibitItemPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("EditExhibitItemPage is non implementation!");

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		//商品情報を取得する
		ItemInfoManager itemInfo = new ItemInfoManager();
		ItemGetInfo info =  itemInfo.getItemInfo(Integer.valueOf(request.getParameter("itemID")));

		//jspに情報を投げる。
		request.setAttribute("info", info);
		//遷移
		ControllerUtil.translatePage("/tdu_market/Student/Edit_exhibit.jsp", request, response);


		/*
		request.setAttribute("itemID",info.getItemID());
		request.setAttribute("itemName",info.getItemName());
		request.setAttribute("description",info.getDescription());
		request.setAttribute("condtion",info.getCondition());
		request.setAttribute("price",info.getPrice());
		request.setAttribute("TradingState",info.getTradingState());
		request.setAttribute("ExhibitDate",info.getExhibitDate());
		request.setAttribute("itemImageURLs",info.getItemImageURLs());
		*/

	}

}
