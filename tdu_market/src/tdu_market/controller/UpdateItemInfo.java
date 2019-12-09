package tdu_market.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import tdu_market.dto.ItemUpdateInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

@WebServlet("/tdu_market/controller/UpdateItemInfo")
@MultipartConfig(maxFileSize = 1024 * 1024)
public class UpdateItemInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		request.setCharacterEncoding("UTF-8");

		String itemIdStr = request.getParameter("itemID");
		String itemName = request.getParameter("itemName");
		String description = request.getParameter("description");
		String conditionStr = request.getParameter("condtion");
		String priceStr = request.getParameter("price");
		String relatedClassCode = request.getParameter("relatedClassCode");

		long itemID = -1;
		try {
			itemID = Long.parseLong(itemIdStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		int condition = -1;
		try {
			condition = Integer.parseInt(conditionStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		int price = -1;
		try {
			price = Integer.parseInt(priceStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		Part image1 = request.getPart("itemImageURLs_1");
		Part image2 = request.getPart("itemImageURLs_2");
		Part image3 = request.getPart("itemImageURLs_3");
		Part image4 = request.getPart("itemImageURLs_4");

		InputStream[] iss = new InputStream[4];
		iss[0] = image1.getInputStream();
		iss[1] = image2.getInputStream();
		iss[2] = image3.getInputStream();
		iss[3] = image4.getInputStream();
		
		/*
		InputStream[] iss = null;
		Collection<Part> parts = request.getParts();
		if (parts != null) {
			iss = new InputStream[parts.size()];
			int i = 0;
			for (Part p : parts) {
				iss[i] = p.getInputStream();
				i++;
			}
		}*/
		
		HttpSession session = request.getSession();

		ItemUpdateInfo updateInfo = new ItemUpdateInfo(itemID, itemName, description, condition, price, relatedClassCode, iss);
		ItemInfoManager itemInfo = new ItemInfoManager();
		itemInfo.updateItemInfo(updateInfo);

 		boolean isDisplayDialog = true;
 		String dialogMessage = "出品物を更新しました";
 		session.setAttribute("dialogMessage", dialogMessage);
 		session.setAttribute("isDisplayDialog", isDisplayDialog);
		ControllerUtil.translatePage(JspPath.reference_exhibit_list, request, response);
	}
}
