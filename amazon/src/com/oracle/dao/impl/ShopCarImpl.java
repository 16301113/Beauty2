package com.oracle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.common.ConnectionFactory;
import com.oracle.common.PreparedStatementSetter;
import com.oracle.common.RowCallBackHandler;
import com.oracle.common.Template;
import com.oracle.dao.IShopCar;
import com.oracle.entity.Cart;

public class ShopCarImpl implements IShopCar {

	private Connection conn = ConnectionFactory.getConnection();
	private Template template = new Template(conn);

	@Override
	public void insertcar(final Cart carts) {
		String sql = "select SEQ_HWUA_CART.nextval from dual";
		template.query(sql, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					carts.setId(rs.getLong(1));
				}
			}
		});
		sql = "insert into HWUA_CART values(?,?,?,?)";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, carts.getId());
				pstmt.setLong(2, carts.getPid());
				pstmt.setLong(3, carts.getQuantity());
				pstmt.setLong(4, carts.getUserid());
			}
		});
	}

	public void updatecar(final Cart carts) {
		String sql = "update HWUA_CART set quantity=quantity+? where pid=?";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, carts.getQuantity());
				pstmt.setLong(2, carts.getPid());
			}
		});
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deletecar(final Cart carts) {
		String sql = "delete from HWUA_CART where id=?";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, carts.getId());
			}
		});
	}

	@Override
	public List<Cart> selectcar(final long userid) {
		final List<Cart> list = new ArrayList<Cart>();
		String sql = "select * from HWUA_CART where USERID =?";
		template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, userid);
			}
		}, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					Cart carts = new Cart();
					carts.setId(rs.getLong(1));
					carts.setPid(rs.getLong(2));
					carts.setQuantity(rs.getLong(3));
					carts.setUserid(userid);
					list.add(carts);
				}
			}
		});
		return list;
	}

}
