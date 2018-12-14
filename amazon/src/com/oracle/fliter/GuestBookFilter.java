package com.oracle.fliter;

import java.io.IOException;
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

import com.oracle.entity.Comment;
import com.oracle.service.IGuestBookService;
import com.oracle.service.impl.GuestBookServiceImpl;

@WebFilter("/guestbook.jsp")
public class GuestBookFilter implements Filter {

	public GuestBookFilter() {

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		IGuestBookService igues = new GuestBookServiceImpl();
		List<Comment> listcom = igues.getguestbook();
		request.setAttribute("listcom", listcom);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
