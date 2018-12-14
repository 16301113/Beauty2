package com.oracle.fliter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.impl.ShopCarImpl;
import com.oracle.entity.Cart;
import com.oracle.entity.Product;
import com.oracle.entity.User;
import com.oracle.service.IProductService;
import com.oracle.service.UserNameService;
import com.oracle.service.impl.IProductServiceImpl;
import com.oracle.service.impl.UserNameServiceImpl;

@WebFilter("/shopping.jsp")
public class ShopCartFilter implements Filter {

	public ShopCartFilter() {
	}

	public void destroy() {

	}

	@SuppressWarnings("unused")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		ShopCarImpl carimpl = new ShopCarImpl();
		UserNameService users = new UserNameServiceImpl();

		IProductService ipros = new IProductServiceImpl();
		String username = (String) req.getSession(false).getAttribute("username");
		User user = users.getUserid(username);
		List<Cart> proCarts = carimpl.selectcar(user.getHu_user_id());
		List<Product> productlist = new ArrayList<Product>();
		for (Cart shopCarts : proCarts) {
			long pid = shopCarts.getPid();
			long quantity = shopCarts.getQuantity();
			long id = shopCarts.getId();
			Product pro = ipros.getProduct(pid);
			pro.getCarts().setQuantity(quantity);
			pro.getCarts().setId(id);
			productlist.add(pro);
		}
		request.setAttribute("productlist", productlist);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
