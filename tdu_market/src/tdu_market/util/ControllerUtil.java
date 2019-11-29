package tdu_market.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.ReturnInfo;
import tdu_market.entity_manager.StudentInfoManager;

public class ControllerUtil {

	// ログイン状態の検証を行うクラス。ログインしていない場合は、トップ画面に遷移。
	public static boolean verifyLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mailAddress = getMailAddress(request, response);
		StudentInfoManager student = new StudentInfoManager();
		ReturnInfo loginResult = student.existMailAddress(mailAddress);

		return loginResult.isSuccess();
	}

	// セッションからメールアドレスを取得する。
	public static String getMailAddress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String mailAddress = (String) session.getAttribute("mailaddress");

		return mailAddress;
	}

	/**
	 * ページ遷移を行う。いまはリダイレクト。
	 *
	 * @param path
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void translatePage(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(path);
	}
}
