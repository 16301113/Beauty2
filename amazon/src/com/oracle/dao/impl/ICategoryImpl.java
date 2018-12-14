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
import com.oracle.dao.ICategory;
import com.oracle.entity.Product_category;

public class ICategoryImpl implements ICategory {

	private Connection conn = ConnectionFactory.getConnection();
	private Template template = new Template(conn);

	@Override
	public List<Product_category> selectcategory() {
		String sql = "select * from HWUA_PRODUCT_CATEGORY where hpc_id=hpc_parent_id order by hpc_id";
		final List<Product_category> map = new ArrayList<Product_category>();
		template.query(sql, new RowCallBackHandler() {
			@Override
			public void processRow(final ResultSet rs) throws SQLException {
				while (rs.next()) {
					final Product_category cat = new Product_category();
					cat.setHpc_id(rs.getLong(1));
					cat.setHpc_name(rs.getString(2));
					cat.setHpc_parent_id(rs.getLong(3));
					String sqlee = "select * from HWUA_PRODUCT_CATEGORY where hpc_id<>hpc_parent_id and hpc_parent_id=? order by hpc_id";
					template.query(sqlee, new PreparedStatementSetter() {
						public void setValues(PreparedStatement pstmt) throws SQLException {
							pstmt.setLong(1, cat.getHpc_id());
						}
					}, new RowCallBackHandler() {
						@Override
						public void processRow(ResultSet rs) throws SQLException {
							@SuppressWarnings("unused")
							List<Product_category> list = new ArrayList<Product_category>();
							while (rs.next()) {
								Product_category nrb = new Product_category();
								nrb.setHpc_id(rs.getLong(1));
								nrb.setHpc_name(rs.getString(2));
								nrb.setHpc_parent_id(rs.getLong(3));
								cat.getList().add(nrb);
							}
							map.add(cat);
						}
					});
				}
			}
		});
		return map;
	}

}
