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

import com.oracle.entity.Product;
import com.oracle.service.IProductService;
import com.oracle.service.impl.IProductServiceImpl;

@WebFilter(urlPatterns = { "/index.jsp", "/ref", "/hotproduct.jsp" })
public class ProductFilter implements Filter {

	public ProductFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// 显示商品
		List<Product> list = null;
		String cate = request.getParameter("cate");
		// 将cate加入到pageServlet中
		String pid = null;
		IProductService ipro = new IProductServiceImpl();
		// 热卖商品
		List<Product> hotlist = new ArrayList<Product>();
		// 搜索商品 qname 商品名字
		String qname = req.getParameter("qname");
		if (qname != null && !qname.equals("")) {
			
			if (cate != null && !cate.equals("")) {
				if (cate.equals("parent")) {
					pid = request.getParameter("pid");// 父级id
					list = ipro.getPProducts(Long.valueOf(pid));
				} else if (cate.equals("child")) {
					pid = request.getParameter("pcid");// 子级id
					list = ipro.getCProduct(Long.valueOf(pid));
				}
				// 传给分页pageServlet
				req.setAttribute("cate", cate);
				req.setAttribute("pid", pid);
			} else {
				String str = new String(qname.getBytes("ISO-8859-1"),"utf-8");
				list = ipro.getseekProducts(str);

			}

		} else {
			if (cate != null && !cate.equals("")) {
				if (cate.equals("parent")) {
					pid = request.getParameter("pid");// 父级id
					list = ipro.getPProducts(Long.valueOf(pid));
				} else if (cate.equals("child")) {
					pid = request.getParameter("pcid");// 子级id
					list = ipro.getCProduct(Long.valueOf(pid));
				}
				// 传给分页pageServlet
				request.setAttribute("cate", cate);
				request.setAttribute("pid", pid);

			} else {
				IProductService produceimpl = new IProductServiceImpl();
				list = produceimpl.getProducts();

			}
		}

		// 分页
		int page = 0;
		if (list.size() % 12 == 0) {
			page = list.size() / 12;
		} else {
			page = list.size() / 12 + 1;
		}
		int[] pages = new int[page];
		for (int i = 0; i < pages.length; i++) {
			pages[i] = i + 1;
		}
		// 集合嵌套分页
		List<List<Product>> proolist = new ArrayList<List<Product>>();
		if (list.size() > 12) {
			for (int i = 0; i < pages.length; i++) {
				List<Product> prolist = new ArrayList<Product>();
				for (Product pro : list) {
					int n = list.indexOf(pro);
					if (n >= i * 12 && n < ((i + 1) * 12)) {
						prolist.add(pro);
					}
				}
				proolist.add(prolist);
			}
		} else {
			proolist.add(list);
		}

		request.setAttribute("pages", pages);// 页号
		request.setAttribute("totalPage", pages.length);// 总页数
		request.setAttribute("page", 1);// 初始化首页页号
		request.setAttribute("proolist", proolist.get(0));// 初始化首页显示的商品
		request.setAttribute("plist", proolist);// 把分页集合放到一个集合中
		// 热卖商品
		hotlist = ipro.gethotproduct();
		request.setAttribute("hotlist", hotlist);
		// 释放资源
		ipro.release();
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
