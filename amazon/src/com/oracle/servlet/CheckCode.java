package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 验证码
 * 
 * @return
 */

@WebServlet("/checkCode")
public class CheckCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckCode() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getSession().getAttribute("validateCode").toString();
		String veryCode = request.getParameter("veryCode");
		if (code.equals(veryCode)) {
			response.getWriter().write("1");
		} else {
			response.getWriter().write("0");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
