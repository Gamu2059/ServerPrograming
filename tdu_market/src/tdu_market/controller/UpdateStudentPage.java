package tdu_market.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import tdu_market.dto.ReturnInfo;
import tdu_market.dto.StudentGetInfo;
import tdu_market.dto.StudentUpdateInfo;
import tdu_market.entity_manager.StudentInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class UpdateStudentPage
 */
@WebServlet("/UpdateStudentPage")
@MultipartConfig(location="WEB-INF/tmp", maxFileSize = 1048576)
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
        Part part = request.getPart("file");
        String fileName = this.getFileName(part);
        part.write(getServletContext().getRealPath("WEB-INF/uploaded") + "/" + fileName);
        
		
		//必要項目の入力チェック（jsp側）
		HttpSession session = request.getSession();
		String pass1 = request.getParameter("nonHashedPassword1");
		String pass2 = request.getParameter("nonHashedPassword2");
		String name = request.getParameter("displayName");
		String intro = request.getParameter("selfIntroduction");
		String url = request.getParameter("iconImageURL");
		
		System.out.println(pass1);
		System.out.println(name);
		System.out.println(intro);
		System.out.println(url);
		
		/* long id = Integer.valueOf(request.getParameter("departmentID")); */
		String id = request.getParameter("departmentID");
		System.out.println(id);

		
		
		if(!pass1.equals(pass2)) {
			RequestDispatcher rd = request.getRequestDispatcher("Student/edit_profile_student.jsp");
			rd.forward(request, response);
		}
		
		//アカウントの情報を変更（メールアドレスは変更できないため、セッションから取得）
		StudentUpdateInfo updateInfo = new StudentUpdateInfo(
				(String)session.getAttribute("mailaddress"),
				request.getParameter("nonHashedPassword"), 
				request.getParameter("displayName"),
				Integer.valueOf(request.getParameter("departmentID")).longValue(),
				request.getParameter("selfIntroduction"),
				request.getParameter("iconImageURL")
				);
		student.updateStudentInfo(updateInfo);
		RequestDispatcher rd = request.getRequestDispatcher("Student/edit_profile_student.jsp");
		rd.forward(request, response);		


	}
    private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }

}
