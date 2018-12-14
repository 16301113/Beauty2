package com.oracle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.entity.Product;
/**
 * 分页
 * 
 * @return
 */
@WebServlet("/ref")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PageServlet() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String spage = request.getParameter("page");
		int page = Integer.valueOf(spage);

		List<List<Product>> plist = (List<List<Product>>) request.getAttribute("plist");
		request.setAttribute("proolist", plist.get(page - 1));

		request.setAttribute("page", page);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
