package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.service.UserNameService;
import com.oracle.service.impl.UserNameServiceImpl;
/**
 * 用户名
 * 
 * @return
 */

@WebServlet("/CheckeUseName")
public class CheckUserName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckUserName() {

		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		UserNameService userNameService = new UserNameServiceImpl();

		if (userNameService.Checkexist(userName)) {
			response.getWriter().write("0");
			response.getWriter().close();
		} else {
			response.getWriter().write("1");
			response.getWriter().close();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
