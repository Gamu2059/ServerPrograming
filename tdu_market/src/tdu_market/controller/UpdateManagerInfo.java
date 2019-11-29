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

@WebServlet("/tdu_market/controller/UpdateManagerInfo")
@MultipartConfig(maxFileSize = 1024 * 1024)
public class UpdateManagerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		//入力フォームの必要事項が入力されているかチェック
		//ここではjsp側でしているため、していない
		String mailAddress = ControllerUtil.getMailAddress(request, response);
		String pass1 = request.getParameter("nonHashedPassword1");
		String pass2 = request.getParameter("nonHashedPassword2");
		String name = request.getParameter("displayName");
		Part part = request.getPart("iconImageURL");
		InputStream is = part.getInputStream();

		if (!pass1.equals(pass2)) {
			session.setAttribute("errorInfo", "パスワードが一致しません。");
			ControllerUtil.translatePage(JspPath.edit_profile_admin, request, response);
			return;
		}

		ManagerUpdateInfo updateInfo = new ManagerUpdateInfo(mailAddress,pass1, name,is);
		ManagerInfoManager manager = new ManagerInfoManager();
		ReturnInfo updateResult = manager.updateManagerInfo(updateInfo);

		if (updateResult.isSuccess()) {
			session.setAttribute("errorUserEditMessages", null);
			ControllerUtil.translatePage(JspPath.reference_profile_admin, request, response);
		} else {
			session.setAttribute("errorUserEditMessages", updateResult.getMsg());
			ControllerUtil.translatePage(JspPath.edit_profile_admin, request, response);
		}


	}
}
