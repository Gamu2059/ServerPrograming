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
 * Servlet implementation class ReferItemPage
 */
@WebServlet("/tdu_market/controller/ManagerReferItemPage")
public class ManagerReferItemPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerReferItemPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		ItemInfoManager itemInfo = new ItemInfoManager();
		//出品商品情報をリストへ保持
		ItemGetInfo itemGetInfo = itemInfo.getItemInfo(Integer.valueOf(request.getParameter("itemID")).longValue()) ;
		//jspに情報を投げる。
		request.setAttribute("itemInfo", itemGetInfo);

		//遷移
		ControllerUtil.translatePage(JspPath.reference_item_detail_by_admin, request, response);
	
		
	}


}
