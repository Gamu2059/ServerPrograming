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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import tdu_market.dto.StudentUpdateInfo;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class UpdateStudentPage
 */

@WebServlet("/tdu_market/controller/UpdateStudentPage")
@MultipartConfig()
public class UpdateStudentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStudentPage() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("UpdateStudentPage is non implementation!");

		StudentInfoManager student = new StudentInfoManager();
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}
		/* Part part = request.getPart("iconImageURL"); */
		Collection<Part> parts = request.getParts();


		/*ファイル名の取得getSubmittedFilename()
		 * String fileName = this.getFileName(part); System.out.println(fileName);
		 * part.write(getServletContext().getRealPath("WEB-INF/uploaded") + "/" +
		 * fileName);
		 */

		//必要項目の入力チェック（jsp側）
		HttpSession session = request.getSession();
		String mailAddress = (String)session.getAttribute("mailaddress");
		String pass1 = request.getParameter("nonHashedPassword1");
		String pass2 = request.getParameter("nonHashedPassword2");
		String name = request.getParameter("displayName");
		String intro = request.getParameter("selfIntroduction");
//		String url = request.getParameter("iconImageURL");

		Part part = request.getPart("iconImageURL");
		InputStream is = part.getInputStream();


		System.out.println(pass1);
		System.out.println(name);
		System.out.println(intro);

		if(!pass1.equals(pass2)) {
			ControllerUtil.translatePage("/tdu_market/Student/edit_profile_student.jsp", request, response);
			return;
		}

		// 学生自身は所属学科を変更できないため、subjectID = -1
		// TODO urlは、後々バイナリで受け取る用の処理の変更する
		StudentUpdateInfo updateInfo = new StudentUpdateInfo(
				mailAddress,
				pass1,
				name,
				-1,
				intro,
				is
				);
		student.updateStudentInfo(updateInfo);

		//ページ遷移
		ControllerUtil.translatePage("/tdu_market/Student/edit_profile_student.jsp", request, response);
	}

    private String getFileName(Part part) {
		/*
		 * String name = null; for (String dispotion :
		 * part.getHeader("Content-Disposition").split(";")) { if
		 * (dispotion.trim().startsWith("filename")) { name =
		 * dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
		 * name = name.substring(name.lastIndexOf("\\") + 1); break; } } return name;
		 */
        for (String cd : part.getHeader("Content-Disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
