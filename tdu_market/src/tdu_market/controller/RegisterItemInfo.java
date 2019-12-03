package tdu_market.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import tdu_market.dto.ItemCreateInfo;
import tdu_market.entity_manager.ItemInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

@WebServlet("/tdu_market/controller/RegisterItemInfo")
@MultipartConfig(maxFileSize = 1024 * 1024)
public class RegisterItemInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		request.setCharacterEncoding("UTF-8");

		String mailAddress = ControllerUtil.getMailAddress(request, response);
		String itemName = request.getParameter("itemName");
		String description = request.getParameter("description");
		String conditionStr = request.getParameter("condtion");
		String priceStr = request.getParameter("price");
		String relatedClassCode = request.getParameter("relatedClassCode");

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

		InputStream[] iss = null;
		Collection<Part> parts = request.getParts();
		if (parts != null) {
			iss = new InputStream[parts.size()];
			int i = 0;
			for (Part p : parts) {
				iss[i] = p.getInputStream();
				i++;
			}
		}

		ItemCreateInfo createInfo = new ItemCreateInfo(mailAddress, itemName, description, condition, price,
				relatedClassCode, iss);
		ItemInfoManager itemInfo = new ItemInfoManager();
		itemInfo.createItemInfo(createInfo);

		// 出品物一覧へ遷移する
		ReferExhibitItemListPage referExhibitItemListPage = new ReferExhibitItemListPage();
		referExhibitItemListPage.doGet(request, response);
	}
}
