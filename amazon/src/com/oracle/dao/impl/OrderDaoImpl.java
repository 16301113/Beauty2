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
import com.oracle.dao.IOrderDao;
import com.oracle.entity.Order;
import com.oracle.entity.Order_detail;
import com.oracle.entity.Product;

public class OrderDaoImpl implements IOrderDao {

	private Connection conn = ConnectionFactory.getConnection();
	private Template template = new Template(conn);

	@Override
	public long insertorder(final Order order) {
		String sql = "select SEQ_order.nextval from dual";
		template.query(sql, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					order.setHo_id(rs.getLong(1));
				}
			}
		});
		sql = "insert into Hwua_order values(?,?,?,?,?,?,1,1)";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, order.getHo_id());
				pstmt.setLong(2, order.getHo_user_id());
				pstmt.setString(3, order.getHo_user_name());
				pstmt.setString(4, order.getHo_user_address());
				pstmt.setDate(5, order.getHo_create_time());
				pstmt.setDouble(6, order.getHo_cost());
			}
		});

		List<Order_detail> list = order.getOrderdetail();
		for (final Order_detail orderDetail : list) {
			// final OrderDetail detail=new OrderDetail();
			sql = "select SEQ_detail.nextval from dual";
			template.query(sql, new RowCallBackHandler() {
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					if (rs.next()) {
						orderDetail.setHod_id(rs.getLong(1));
					}
				}
			});
			sql = "insert into Hwua_order_detail values(?,?,?,?,?)";
			template.update(sql, new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement pstmt) throws SQLException {
					pstmt.setLong(1, orderDetail.getHod_id());
					pstmt.setLong(2, order.getHo_id());
					pstmt.setLong(3, orderDetail.getHp_id());
					pstmt.setLong(4, orderDetail.getHod_quantity());
					pstmt.setDouble(5, orderDetail.getHod_cost());
				}
			});
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order.getHo_id();
	}

	// 显示最新订单
	public Order selectorder(final long oid) {
		String sql = "select * from Hwua_order where ho_id=?";
		final Order order = new Order();
		template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, oid);
			}
		}, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					order.setHo_id(rs.getLong(1));
					order.setHo_user_id(rs.getLong(2));
					order.setHo_user_name(rs.getString(3));
					order.setHo_user_address(rs.getString(4));
					order.setHo_create_time(rs.getDate(5));
					order.setHo_cost(rs.getDouble(6));
					order.setHo_status(rs.getInt(7));
					order.setHo_type(rs.getInt(8));
				}
			}
		});
		sql = "select o.*,p.hp_name,p.HP_FILE_NAME,p.HP_PRICE from Hwua_order_detail o,HWUA_product p where o.hp_id=p.hp_id and ho_id=?";
		template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, oid);
			}
		}, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					Order_detail detail = new Order_detail();
					Product product = new Product();
					detail.setHod_id(rs.getLong(1));
					detail.setHo_id(rs.getLong(2));
					detail.setHp_id(rs.getLong(3));
					detail.setHod_quantity(rs.getLong(4));
					detail.setHod_cost(rs.getDouble(5));
					product.setHp_name(rs.getString(6));
					product.setHp_file_name(rs.getString(7));
					product.setHp_price(rs.getDouble(8));
					detail.setProduct(product);
					order.getOrderdetail().add(detail);
				}
			}
		});
		return order;
	}

	// 显示所有订单
	public List<Order> selectorders(final long userid) {
		String sql = "select * from Hwua_order where ho_user_id=? order by ho_id desc";
		final List<Order> orderlist = new ArrayList<Order>();
		template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, userid);
			}
		}, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					final Order order = new Order();
					order.setHo_id(rs.getLong(1));
					order.setHo_user_id(rs.getLong(2));
					order.setHo_user_name(rs.getString(3));
					order.setHo_user_address(rs.getString(4));
					order.setHo_create_time(rs.getDate(5));
					order.setHo_cost(rs.getDouble(6));
					order.setHo_status(rs.getInt(7));
					order.setHo_type(rs.getInt(8));
					String sql = "select o.*,p.hp_name,p.HP_FILE_NAME,p.HP_PRICE from Hwua_order_detail o,HWUA_product p where o.hp_id=p.hp_id and ho_id=?";
					template.query(sql, new PreparedStatementSetter() {
						@Override
						public void setValues(PreparedStatement pstmt) throws SQLException {
							pstmt.setLong(1, order.getHo_id());
						}
					}, new RowCallBackHandler() {
						@Override
						public void processRow(ResultSet rs) throws SQLException {
							while (rs.next()) {
								Order_detail detail = new Order_detail();
								Product product = new Product();
								detail.setHod_id(rs.getLong(1));
								detail.setHo_id(rs.getLong(2));
								detail.setHp_id(rs.getLong(3));
								detail.setHod_quantity(rs.getLong(4));
								detail.setHod_cost(rs.getDouble(5));
								product.setHp_name(rs.getString(6));
								product.setHp_file_name(rs.getString(7));
								product.setHp_price(rs.getDouble(8));
								detail.setProduct(product);
								order.getOrderdetail().add(detail);
							}
						}
					});
					orderlist.add(order);
				}
			}
		});

		return orderlist;
	}

}
