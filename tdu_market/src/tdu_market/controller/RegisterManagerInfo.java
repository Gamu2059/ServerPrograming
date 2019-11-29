package tdu_market.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import tdu_market.dto.ManagerUpdateInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.entity_manager.ManagerInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

@WebServlet("/tdu_market/controller/RegisterManagerInfo")
@MultipartConfig(maxFileSize = 1024 * 1024)
public class RegisterManagerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ControllerUtil.verifyLogin(request, response)) {
			System.out.print("AAAAA");
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		//入力フォームの必要事項が入力されているかチェック
		//ここではjsp側でしているため、していない
		String mailAddress = ControllerUtil.getMailAddress(request, response);
		String password = request.getParameter("nonHashedPassword");
		String name = request.getParameter("displayName");
		Part part = request.getPart("iconImageURL");
		InputStream is = part.getInputStream();

		ManagerUpdateInfo managerInfo = new ManagerUpdateInfo(mailAddress, password, name, is);
		ManagerInfoManager manager = new ManagerInfoManager();
		ReturnInfo createResult = manager.updateManagerInfo(managerInfo);

		if (createResult.isSuccess()) {

			ManagerTopPage topPage = new ManagerTopPage();
			System.out.println("テスト");
			topPage.doGet(request, response);
		} else {

			session.setAttribute("errorInfo", createResult.getMsg());
			ControllerUtil.translatePage(JspPath.create_admin_account, request, response);
		}
	}

}
