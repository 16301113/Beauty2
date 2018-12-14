package com.oracle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.entity.User;
import com.oracle.service.UserNameService;
import com.oracle.service.impl.UserNameServiceImpl;

@WebServlet("/retrievePassWordServlet")
public class RetrievePassWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RetrievePassWordServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		UserNameService ius = new UserNameServiceImpl();
		List<User> userlist = ius.login();
		int flag = 1;
		String password = null;
		for (User user : userlist) {
			if (email.equals(user.getHu_email()) && userName.equals(user.getHu_user_name())) {
				// 找回成功
				password = user.getHu_password();
				flag = -1;
				break;
			}
		}
		if (flag == 1) {
			// 找回失败
			request.setAttribute("error", "用户名或邮箱地址不正确！");
			RequestDispatcher rd = request.getRequestDispatcher("retrieve_password.jsp");
			rd.forward(request, response);
		} else {
			request.getSession().setAttribute("password", password);
			response.sendRedirect("back.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
