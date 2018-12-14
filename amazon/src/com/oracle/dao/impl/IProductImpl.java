package com.oracle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.oracle.common.PreparedStatementSetter;
import com.oracle.common.RowCallBackHandler;
import com.oracle.common.Template;
import com.oracle.dao.IProduct;
import com.oracle.entity.Product;

public class IProductImpl implements IProduct {
	private Template template;

	public IProductImpl(Connection conn) {
		template = new Template(conn);
	}

	@Override
	public List<Product> selectProduct() {
		String sql = "select * from HWUA_product";
		final List<Product> list = new ArrayList<Product>();
		template.query(sql, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					Product pro = new Product();
					pro.setHp_id(rs.getLong(1));
					pro.setHp_name(rs.getString(2));
					pro.setHp_description(rs.getString(3));
					pro.setHp_price(rs.getDouble(4));
					pro.setHp_stock(rs.getLong(5));
					pro.setHpc_id(rs.getLong(6));
					pro.setHpc_child_id(rs.getLong(7));
					pro.setHp_file_name(rs.getString(8));
					list.add(pro);
				}
			}
		});
		return list;
	}

	@Override
	public List<Product> selectProducts(final long pid) {
		String sql = "select * from HWUA_product where hpc_id=?";
		final List<Product> list = new ArrayList<Product>();
		template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, pid);
			}
		}, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					Product pro = new Product();
					pro.setHp_id(rs.getLong(1));
					pro.setHp_name(rs.getString(2));
					pro.setHp_description(rs.getString(3));
					pro.setHp_price(rs.getDouble(4));
					pro.setHp_stock(rs.getLong(5));
					pro.setHpc_id(rs.getLong(6));
					pro.setHpc_child_id(rs.getLong(7));
					pro.setHp_file_name(rs.getString(8));
					list.add(pro);
				}
			}
		});
		return list;
	}

	@Override
	public List<Product> selectchildProduct(final long pcid) {
		String sql = "select * from HWUA_product where hpc_child_id=?";
		final List<Product> list = new ArrayList<Product>();
		template.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, pcid);
			}
		}, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					Product pro = new Product();
					pro.setHp_id(rs.getLong(1));
					pro.setHp_name(rs.getString(2));
					pro.setHp_description(rs.getString(3));
					pro.setHp_price(rs.getDouble(4));
					pro.setHp_stock(rs.getLong(5));
					pro.setHpc_id(rs.getLong(6));
					pro.setHpc_child_id(rs.getLong(7));
					pro.setHp_file_name(rs.getString(8));
					list.add(pro);
				}
			}
		});
		return list;
	}

	@Override
	public Product selectProduct(final long pcid) {
		String sql = "select * from HWUA_product where hp_id=?";
		final Product pro = new Product();
		template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, pcid);
			}
		}, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					pro.setHp_id(rs.getLong(1));
					pro.setHp_name(rs.getString(2));
					pro.setHp_description(rs.getString(3));
					pro.setHp_price(rs.getDouble(4));
					pro.setHp_stock(rs.getLong(5));
					pro.setHpc_id(rs.getLong(6));
					pro.setHpc_child_id(rs.getLong(7));
					pro.setHp_file_name(rs.getString(8));
				}
			}
		});
		return pro;
	}

	@Override
	public List<Product> seekProducts(String pname) {
		final List<Product> plist = new ArrayList<Product>();
		String sql = "select * from HWUA_product where HP_NAME like '%" + pname + "%'";
		template.query(sql, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					Product pro = new Product();
					pro.setHp_id(rs.getLong(1));
					pro.setHp_name(rs.getString(2));
					pro.setHp_description(rs.getString(3));
					pro.setHp_price(rs.getDouble(4));
					pro.setHp_stock(rs.getLong(5));
					pro.setHpc_id(rs.getLong(6));
					pro.setHpc_child_id(rs.getLong(7));
					pro.setHp_file_name(rs.getString(8));
					plist.add(pro);
				}
			}
		});

		return plist;
	}

	@Override
	public List<Product> selhotproduct() {
		String sql = "SELECT HP_ID, SUM(HOD_QUANTITY) QUANTITY FROM HWUA_ORDER_DETAIL GROUP BY HP_ID order by QUANTITY desc";
		final List<Product> hotproducts = new ArrayList<Product>();
		template.query(sql, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					Product product = selectProduct(rs.getLong(1));
					hotproducts.add(product);
				}
			}
		});
		return hotproducts;
	}

	@Override
	public boolean updetePronum(final long pid, final long num) {
		String sql = "update HWUA_product set hp_stock=hp_stock-? where hp_id=?";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, num);
				pstmt.setLong(2, pid);
			}
		});
		return true;
	}

}
