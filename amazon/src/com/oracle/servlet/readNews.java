package com.oracle.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.entity.News;

import com.oracle.service.NewsService;
import com.oracle.service.impl.NewsServiceImpl;

@WebServlet("/readNews")
public class readNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public readNews() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int nid = Integer.valueOf(request.getParameter("id"));

		NewsService newsService = new NewsServiceImpl();

		News news = newsService.selectnews(nid);
		request.setAttribute("news", news); 
		RequestDispatcher rd = request.getRequestDispatcher("news_view.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
