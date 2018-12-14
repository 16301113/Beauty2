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

import com.oracle.dao.impl.OrderDaoImpl;
import com.oracle.entity.Order;
import com.oracle.entity.User;
import com.oracle.service.UserNameService;
import com.oracle.service.impl.UserNameServiceImpl;

@WebFilter("/orders_view.jsp")
public class OrderFilter implements Filter {

	public OrderFilter() {
	}

	public void destroy() {
	}

	@SuppressWarnings("unused")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String or = req.getParameter("or");
		// 找出用户名
		String username = (String) req.getSession(false).getAttribute("username");
		UserNameService users = new UserNameServiceImpl();

		User user = users.getUserid(username);

		OrderDaoImpl daoimpl = new OrderDaoImpl();
		List<Order> orderlist = new ArrayList<Order>();
		if (or != null && or.equals("myor")) {
			orderlist = daoimpl.selectorders(user.getHu_user_id());
		} else {
			long orderid = (long) req.getSession().getAttribute("orderid");
			Order order = daoimpl.selectorder(Long.valueOf(orderid));
			orderlist.add(order);
		}
		req.setAttribute("orderlist", orderlist);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
