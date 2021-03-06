package com.cjon.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class MemberLogoutServlet
 */
@WebServlet("/memberLogout")
public class MemberLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String callback = request.getParameter("callback");
		String id = request.getParameter("id");
		
		HttpSession session = request.getSession(true);
		
		session.removeAttribute("ID");
		
		System.out.println("========================================");
		System.out.println("No  SessionID  UserID");
		System.out.println("========================================");
		
		String user_id = (String) session.getAttribute("ID");
		System.out.print(" " + id);
		System.out.println("  userID = [" + user_id + "]");
		
		response.setContentType("text/plain; charset=utf8");
		PrintWriter out = response.getWriter();
		
		JSONObject obj = new JSONObject();
		
		
		String result=	obj.toString();
		
		out.println(callback + "(" + result + ")");

		out.flush();
		out.close();
		
//		System.out.println(result);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
