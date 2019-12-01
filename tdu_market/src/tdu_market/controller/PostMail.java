package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.ReturnInfo;
import tdu_market.entity_manager.ManagerInfoManager;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.AccountUtil;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;
import tdu_market.controller.SendMail;

/**
 * Servlet implementation class PostMail
 */
@WebServlet("/tdu_market/controller/PostMail")
public class PostMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostMail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("PostMail is non implementation!");

		//String mailAddress = ControllerUtil.getMailAddress(request, response);
		String mailAddress = request.getParameter("mailAddress");

		if (AccountUtil.isStudentMailAddress(mailAddress)) {
			//学生登録のとき
			StudentInfoManager student = new StudentInfoManager();
			ReturnInfo createResult = student.createTemporaryAccount(mailAddress);
			if (createResult.isSuccess()) {
				//仮パスワード送信
				SendMail.sendPassword(mailAddress, createResult.getMsg());
			} else {
				request.setAttribute("ErrorMessage", createResult.getMsg());
			}
			ControllerUtil.translatePage(JspPath.index, request, response);
		} else {
			//運営登録のとき
			ManagerInfoManager manager = new ManagerInfoManager();
			ReturnInfo createResult = manager.createTemporaryAccount(mailAddress);
			if (createResult.isSuccess()) {
				//仮パスワード送信
				SendMail.sendPassword(mailAddress, createResult.getMsg());
			} else {
				request.setAttribute("ErrorMessage", createResult.getMsg());
			}
			ControllerUtil.translatePage(JspPath.index, request, response);
		}

		/*if (createResult.isSuccess()) {
			//仮パスワード送信
			SendMail.sendPassword(mailAddress, createResult.getMsg());
			ControllerUtil.translatePage(JspPath.index, request, response);
		} else {
			request.setAttribute("ErrorMessage", createResult.getMsg());
			ControllerUtil.translatePage(JspPath.index, request, response);
		}*/
	}
}
