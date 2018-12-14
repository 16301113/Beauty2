package com.oracle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.entity.User;

import com.oracle.service.UserNameService;
import com.oracle.service.impl.UserNameServiceImpl;
/**
 * 登录
 * 
 * @return
 */

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserNameService userNameService = new UserNameServiceImpl();

		List<User> list = userNameService.login();
		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");
		int flag = -1;
		for (User user2 : list) {
			if (user2.getHu_user_name().equals(username) && user2.getHu_password().equals(password)) {
				// 登录成功
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			// 登录成功
			response.sendRedirect("index.jsp");
			HttpSession seeion = request.getSession(true);
			seeion.setAttribute("username", username);
			return;
		} else {
			// 登录失败
			response.sendRedirect("login.jsp");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
