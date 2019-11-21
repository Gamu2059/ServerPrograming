package tdu_market.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tdu_market.dto.SyllabusUpdateInfo;
import tdu_market.entity_manager.SyllabusInfoManager;
import tdu_market.util.ControllerUtil;

/**
 * Servlet implementation class DeleteSyllabusInfo
 */
@WebServlet("/DeleteSyllabusInfo")
public class DeleteSyllabusInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSyllabusInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println("DeleteSyllabusInfo is non implementation!");
		
		if (!ControllerUtil.verifyLogin(request, response)) {
			return;
		}

		SyllabusInfoManager syllabus = new SyllabusInfoManager();
	
		//シラバス情報の更新
		syllabus.deleteSyllabusInfo(request.getParameter("classCode"));
	}

}
