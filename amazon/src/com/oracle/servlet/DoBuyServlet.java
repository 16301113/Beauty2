package com.oracle.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.impl.OrderDaoImpl;
import com.oracle.dao.impl.ShopCarImpl;
import com.oracle.entity.Cart;
import com.oracle.entity.Order;
import com.oracle.entity.Order_detail;
import com.oracle.entity.Product;
import com.oracle.entity.User;
import com.oracle.service.IProductService;
import com.oracle.service.UserNameService;
import com.oracle.service.impl.IProductServiceImpl;
import com.oracle.service.impl.UserNameServiceImpl;
/**
 * 结算
 * 
 * @return
 */

@WebServlet("/doBuy")
public class DoBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoBuyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] checkpro = request.getParameterValues("onecheck");
		if (checkpro != null) {
			for (int i = 0; i < checkpro.length; i++) {
				System.out.println(checkpro[i]);
			}
		} else {

		}

		// 用户
		String username = (String) request.getSession(false).getAttribute("username");
		UserNameService ius = new UserNameServiceImpl();
		User user = ius.getUserid(username);
		// 订单时间
		Date date = new Date();
		// 转换成数据库时间
		java.sql.Date createtime = new java.sql.Date(date.getTime());
		// 购物车商品总价
		double totalcost = 0;
		// 查询购物车所有物品

		ShopCarImpl carimpl = new ShopCarImpl();
		List<Cart> carlist = carimpl.selectcar(user.getHu_user_id());
		List<Order_detail> details = new ArrayList<Order_detail>();
		for (Cart shopCart : carlist) {
			Order_detail detail = new Order_detail();
			IProductService ipros = new IProductServiceImpl();
			detail.setHod_quantity(shopCart.getQuantity());// 数量
			detail.setHp_id(shopCart.getPid());// 商品id

			Product product = ipros.getProduct(detail.getHp_id());
			double totalcostmin = product.getHp_price() * shopCart.getQuantity();
			detail.setHod_cost(totalcostmin);
			detail.setProduct(product);
			details.add(detail);
			totalcost += totalcostmin;
		}
		// 保存订单
		Order order = new Order();
		order.setHo_cost(totalcost);
		order.setHo_create_time(createtime);
		order.setHo_user_address(user.getHu_adderss());
		order.setHo_user_id(user.getHu_user_id());
		order.setOrderdetail(details);
		order.setHo_user_name(username);

		OrderDaoImpl daoimpl = new OrderDaoImpl();
		long orderid = daoimpl.insertorder(order);
		// 修改库存
		if (orderid != 0) {
			IProductService ipro = new IProductServiceImpl();
			for (Order_detail orderDetail : details) {
				ipro.updetePronums(orderDetail.getHp_id(), orderDetail.getHod_quantity());
			}
		}
		request.getSession().setAttribute("orderid", orderid);
		response.sendRedirect("shopping-result.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
