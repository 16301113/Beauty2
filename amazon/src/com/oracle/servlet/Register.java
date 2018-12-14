package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.entity.User;
import com.oracle.service.UserNameService;
import com.oracle.service.impl.UserNameServiceImpl;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String identity = request.getParameter("identity");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		User user = new User(userName, passWord, sex, birthday, identity, email, mobile, address);

		UserNameService userNameService = new UserNameServiceImpl();
		userNameService.register(user);
			response.sendRedirect("reg-result.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
