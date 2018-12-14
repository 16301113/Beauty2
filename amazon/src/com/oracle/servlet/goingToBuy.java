package com.oracle.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.impl.OrderDaoImpl;
import com.oracle.entity.Order;
import com.oracle.entity.Order_detail;
import com.oracle.entity.Product;
import com.oracle.entity.User;
import com.oracle.service.IProductService;
import com.oracle.service.UserNameService;
import com.oracle.service.impl.IProductServiceImpl;
import com.oracle.service.impl.UserNameServiceImpl;
/**
 * 立即购买
 * 
 * @return
 */

@WebServlet("/goingToBuy")
public class goingToBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public goingToBuy() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 保存订单
		String id = request.getParameter("id");
		System.out.println(id + "id");
		String[] pidcount = id.split("_");
		String pid = pidcount[0];
		String count = pidcount[1];// 数量

		// 用户
		String username = (String) request.getSession(false).getAttribute("username");
		UserNameService ius = new UserNameServiceImpl();
		User user = ius.getUserid(username);
		// 订单
		Date date = new Date();
		// 转换成数据库时间
		java.sql.Date createtime = new java.sql.Date(date.getTime());
		// 获取商品价格
		IProductService iprs = new IProductServiceImpl();
		Product product = iprs.getProduct(Long.valueOf(pid));
		double price = product.getHp_price();
		long number = Long.valueOf(count);// 数量
		double totalcost = price * number;// 总价

		OrderDaoImpl daoimpl = new OrderDaoImpl();
		Order order = new Order();
		order.setHo_cost(totalcost);
		order.setHo_create_time(createtime);
		order.setHo_user_address(user.getHu_adderss());
		order.setHo_user_id(user.getHu_user_id());
		order.setHo_user_name(username);
		Order_detail detail = new Order_detail();
		detail.setHod_cost(totalcost);
		detail.setHod_quantity(number);
		detail.setHp_id(Long.valueOf(pid));
		order.getOrderdetail().add(detail);
		long orderid = daoimpl.insertorder(order);
		if (orderid != 0) {
			IProductService ipro = new IProductServiceImpl();
			ipro.updetePronums(Long.valueOf(pid), number);
		}
		request.getSession().setAttribute("orderid", orderid);
		response.sendRedirect("shopping-result.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
