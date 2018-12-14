package com.oracle.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.entity.Comment;
import com.oracle.service.IGuestBookService;
import com.oracle.service.impl.GuestBookServiceImpl;

/**
 * 留言
 * 
 * @return
 */


@WebServlet("/addComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddComment() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String guestName = request.getParameter("guestName");
		String guestContent = request.getParameter("guestContent");
		Date createtime = new java.sql.Date(new java.util.Date().getTime());
		Comment tcom = new Comment();
		tcom.setHc_content(guestContent);
		tcom.setHc_create_time(createtime);
		tcom.setHc_nick_name(guestName);

		IGuestBookService igbs = new GuestBookServiceImpl();
		if (igbs.saveguestbook(tcom)) {
			response.sendRedirect("guestbook.jsp");
		} else {
			response.getWriter().write("<h1>留言失败</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
