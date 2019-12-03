package tdu_market.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
		
		/*
		 * createInfoをデータベースに登録する。
		 * info/createinfoをセッション破棄
		 */
		HttpSession session = request.getSession();
		ItemCreateInfo createInfo = (ItemCreateInfo)session.getAttribute("createInfo");//セッションからcreateInfoを取得。
		ItemInfoManager itemInfo = new ItemInfoManager();
		itemInfo.createItemInfo(createInfo);
		
		//セッションを破棄
		session.removeAttribute("createInfo");
		session.removeAttribute("info");

		ControllerUtil.translatePage(JspPath.reference_item_list, request, response);
	}
}
