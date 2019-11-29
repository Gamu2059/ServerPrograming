package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.ReturnInfo;
import tdu_market.entity_manager.ManagerInfoManager;
import tdu_market.util.ControllerUtil;
import tdu_market.util.JspPath;

/**
 * Servlet implementation class ManagerPostMail
 */
@WebServlet("/tdu_market/controller/ManagerPostMail")
public class ManagerPostMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerPostMail() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("ManagerPostMail is non implementation!");
/*
 *
 * 新規登録画面の送信ボタンから呼び出される
・正式にはPostMailクラス
・メールアドレスがメールアドレスの体をなしているかチェック
・メールアドレスがDBに登録されていないかをチェックする
・新規アカウントを仮登録状態、仮パスワードで作成する
・仮パスワードをメールアドレス宛に送信する
・送信した後、ログインページに遷移する

 */

		if (!ControllerUtil.verifyLogin(request, response)) {
			ControllerUtil.translatePage(JspPath.index, request, response);
			return;
		}
		String mailAddress = ControllerUtil.getMailAddress(request, response);
		ManagerInfoManager manager = new ManagerInfoManager();

		ReturnInfo createResult = manager.createTemporaryAccount(mailAddress);

		if(createResult.isSuccess()) {
			//仮パスワード送信
			SendMail.sendPassword(mailAddress,createResult.getMsg());
			ControllerUtil.translatePage("/tdu_market/general/index.jsp", request, response);
		}
		else {
			request.setAttribute("ErrorMessage",createResult.getMsg());
			ControllerUtil.translatePage("/tdu_market/general/index.jsp", request, response);
		}
	}

}
