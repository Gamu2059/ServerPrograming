package tdu_market.controller;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.entity_manager.ManagerInfoManager;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.AccountUtil;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;


@WebServlet("/tdu_market/controller/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}

		String mailAddress = ControllerUtil.getMailAddress(request, response);

		//学生の場合
		if(AccountUtil.isStudentMailAddress(mailAddress)) {
			StudentInfoManager student = new StudentInfoManager();

			// StudentInfoManagerのlogoutを呼ぶ。
			student.logout(mailAddress);
		} else if(AccountUtil.isManagerMailAddress(mailAddress)) {
			ManagerInfoManager manager = new ManagerInfoManager();

			//ManagerInfoManagerのlogoutを呼ぶ。
			manager.logout(mailAddress);
		}

		HttpSession session = request.getSession();
		Enumeration<String> vals = session.getAttributeNames();
		while (vals.hasMoreElements()) {
			String name = vals.nextElement();
			session.removeAttribute(name);
		}
		
		ControllerUtil.translatePage(JspPath.index, request, response);
	}
}
