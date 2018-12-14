package com.oracle.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.common.Listp;
import com.oracle.entity.Product;
import com.oracle.service.IProductService;
import com.oracle.service.impl.IProductServiceImpl;

@WebServlet("/pview")
public class PviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PviewServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("pid");
		long id = Long.valueOf(pid);
		System.out.println("pid"+pid);
		// List<Product> list = new ArrayList<Product>();

		IProductService ipros = new IProductServiceImpl();

		Product pro = ipros.getProduct(id);
		request.setAttribute("pro", pro);

		if (Listp.reclist.size() == 0) {
			Listp.reclist.add(pro);
		} else {
			for (Product p : Listp.reclist) {
				if (p.getHp_id() == id) {
					Listp.reclist.remove(p);
					break;
				}
			}
			Listp.reclist.add(0, pro);
			if (Listp.reclist.size() >= 5) {
				Listp.reclist.remove(4);
			}
		}

		request.getSession().setAttribute("reclist", Listp.reclist);
		RequestDispatcher fd = request.getRequestDispatcher("product_view.jsp");
		fd.forward(request, response);
	}

}
