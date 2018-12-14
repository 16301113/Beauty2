package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.impl.ShopCarImpl;
import com.oracle.entity.Cart;
/**
 * 删除商品
 * 
 * @return
 */

@WebServlet("/deleteCart")
public class deleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public deleteCart() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		ShopCarImpl carimpl = new ShopCarImpl();
		Cart carts = new Cart();
		carts.setId(Long.valueOf(id));
		carimpl.deletecar(carts);
		response.sendRedirect("shopping.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
