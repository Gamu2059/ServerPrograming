package tdu_market.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DialogUtil {
	
	/**
	 * ダイアログのメタ設定を行うクラス。基本データの編集などを行ったサーブレットから呼び出す。
	 * @param message　ダイアログに表示される文章
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void setDialog(String message, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
 		boolean isDisplayDialog = true;
 		HttpSession session = request.getSession();
 		String dialogMessage = message;
 		session.setAttribute("dialogMessage", dialogMessage);
 		session.setAttribute("isDisplayDialog", isDisplayDialog);
	}
	
	/**
	 * ダイアログを表示するかどうかのブール値をセッションから取得し、boolean型を返す。
	 * @param request
	 * @param response
	 * @return ダイアログ表示の有無。
	 * @throws ServletException
	 * @throws IOException
	 */
	public static boolean checkDisplayDialog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		boolean isDisplayDialog = false;
		HttpSession session = request.getSession();
		isDisplayDialog = (boolean)session.getAttribute("isDisplayDialog");
		return isDisplayDialog;
	}
	
	/**
	 * ダイアログの表示内容を取得する。String型を返す。
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public static String getDialogMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String message = null;
		HttpSession session = request.getSession();
		message = " ' "+(String)session.getAttribute("dialogMessage") + " ' ";
		return message;
	}
}
