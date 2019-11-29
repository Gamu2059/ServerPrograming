package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tdu_market.dto.LoginInfo;
import tdu_market.dto.ReturnInfo;
import tdu_market.entity_manager.ManagerInfoManager;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.AccountUtil;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class Login
 */
@WebServlet("/tdu_market/controller/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String MAIL_ADDRESS = "mailaddress";
	private static final String PASSWORD = "password";
	private static final String ERROR_MESSAGE = "errorMessage";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*  ' メールアドレスがメールアドレスの体をなしているかチェック
		' パスワードがパスワードの体をなしているかをチェック
		' メールアドレスから学生か運営かを判定する
		' 学生ならStudentInfoManagerにメールアドレスとパスワードを渡し、ログインできるかチェックする
		'   チェックがOKなら、StudentInfoManagerのloginを呼ぶ
		' 運営ならManagerInfoManagerにメールアドレスとパスワードを渡し、ログインできるかチェックする
		'   チェックがOKなら、ManagerInfoManagerのloginを呼ぶ
		' セッションにメールアドレスを保存する(他にいい実装があるかもしれない...)
		' アカウントが仮登録状態ならば、新規登録画面に遷移する
		' アカウントが登録済み状態ならば、トップ画面に遷移する
		
		*/

		request.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession();
		String mailAddress = request.getParameter(MAIL_ADDRESS);
		String password = request.getParameter(PASSWORD);

		if (!AccountUtil.isMeetRequirementMailAddress(mailAddress)) {
			// メールアドレスの体をなしていない
			forwardToIndex(request, response, "メールアドレスを入力して下さい。");
			return;
		}

		if (AccountUtil.isStudentMailAddress(mailAddress)) {

			// 学生アカウントの場合
			StudentInfoManager studentInfoManager = new StudentInfoManager();
			ReturnInfo loginResult = studentInfoManager.login(new LoginInfo(mailAddress, password));
			if (loginResult != null && loginResult.isSuccess()) {

				// ログイン成功
				session.setAttribute(MAIL_ADDRESS, mailAddress);
				ReturnInfo registerdResult = studentInfoManager.isRegisteredState(mailAddress);
				if (registerdResult != null && registerdResult.isSuccess()) {

					// 本登録されているのでトップへ
					TopPage topPage = new TopPage();
					topPage.doGet(request, response);
					//						ControllerUtil.translatePage(JspPath.student_top, request, response);

				} else {

					// 仮登録状態なのでアカウント作成へ
					ControllerUtil.translatePage(JspPath.create_student_account, request, response);
				}
			} else {

				// ログイン失敗
				forwardToIndex(request, response, loginResult != null ? loginResult.getMsg() : "不明なエラーが発生しました。");
			}
		} else if (AccountUtil.isManagerMailAddress(mailAddress)) {

			// 運営アカウントの場合
			ManagerInfoManager managerInfoManager = new ManagerInfoManager();
			ReturnInfo loginResult = managerInfoManager.login(new LoginInfo(mailAddress, password));
			if (loginResult != null && loginResult.isSuccess()) {

				// ログイン成功
				session.setAttribute(MAIL_ADDRESS, mailAddress);
				ReturnInfo registerdResult = managerInfoManager.isRegisteredState(mailAddress);
				if (registerdResult != null && registerdResult.isSuccess()) {

					// 本登録されているのでトップへ
					ControllerUtil.translatePage(JspPath.top_admin, request, response);
				} else {

					// 仮登録状態なのでアカウント作成へ
					ControllerUtil.translatePage(JspPath.create_admin_account, request, response);
				}
			} else {

				// ログイン失敗
				forwardToIndex(request, response, loginResult != null ? loginResult.getMsg() : "不明なエラーが発生しました。");
			}
		}
	}

	private void forwardToIndex(HttpServletRequest request, HttpServletResponse response, String errorMessage)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute(ERROR_MESSAGE, errorMessage);
		ControllerUtil.translatePage(JspPath.index, request, response);
	}
}
