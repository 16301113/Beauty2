package com.oracle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.impl.ShopCarImpl;
import com.oracle.entity.Cart;
import com.oracle.entity.User;
import com.oracle.service.UserNameService;
import com.oracle.service.impl.UserNameServiceImpl;
/**
 * 添加商品
 * 
 * @return
 */

@WebServlet("/addToCart")
public class addToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public addToCart() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("Pid");
		String[] idcount = pid.split("_");
		String id = idcount[0];
		String count = idcount[1];
		String username = (String) request.getSession(false).getAttribute("username");

		UserNameService ius = new UserNameServiceImpl();
		User user = ius.getUserid(username);
		Cart carts = new Cart();
		carts.setPid(Long.valueOf(id));
		carts.setQuantity(Long.valueOf(count));
		carts.setUserid(user.getHu_user_id());
		ShopCarImpl carimpl = new ShopCarImpl();
		List<Cart> list = carimpl.selectcar(user.getHu_user_id());
		int flag = -1;
		for (Cart shopCarts : list) {
			if (shopCarts.getPid() == Long.valueOf(id)) {
				// 该商品已经添加过
				flag = 1;
				break;
			}
		}
		if (flag == -1) {
			carimpl.insertcar(carts);
		} else {
			carimpl.updatecar(carts);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
