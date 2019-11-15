package tdu_market.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import tdu_market.dto.ItemGetInfo;

import tdu_market.entity_manager.ItemInfoManager;

import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class ReferItemPage
 */
@WebServlet("/ReferItemPage")
public class ReferItemPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReferItemPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ReferItemPage is non implementation!");
		

		String mailAddress = ControllerUtil.getMailAddress(request, response);
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}

		ItemInfoManager itemInfo = new ItemInfoManager();
		//出品商品情報をリストへ保持
		ArrayList<ItemGetInfo> itemList = itemInfo.getExhibitItem(mailAddress) ;
		//jspに情報を投げる。
		request.setAttribute("itemLIst", itemList);
	}


}
