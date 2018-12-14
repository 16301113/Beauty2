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

import com.oracle.entity.Product;
import com.oracle.service.IProductService;
import com.oracle.service.impl.IProductServiceImpl;

@WebFilter("/index.jsp")
public class IndexProductlist implements Filter {

	public IndexProductlist() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		// 商品列表
		IProductService productS = new IProductServiceImpl();
		List<Product> list = productS.getProducts();
		req.setAttribute("list", list);
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
