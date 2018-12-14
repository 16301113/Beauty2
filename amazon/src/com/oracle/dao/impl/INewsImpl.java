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
import com.oracle.dao.INews;
import com.oracle.entity.News;

public class INewsImpl implements INews {

	private Connection conn = ConnectionFactory.getConnection();
	private Template template = new Template(conn);

	@Override
	public List<News> selectnews() {
		String sql = "select * from HWUA_NEWS";
		final List<News> list = new ArrayList<News>();
		template.query(sql, new RowCallBackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					News news = new News();
					news.setHn_id(rs.getLong(1));
					news.setHn_title(rs.getString(2));
					news.setContent(rs.getString(3));
					news.setHn_create_time(rs.getDate(4));
					list.add(news);
				}
			}
		});
		return list;
	}

	@Override
	public News selectnews(final long hn_id) {
		String sql = "select * from HWUA_NEWS where hn_id=?";
		final News news = new News();
		template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, hn_id);
			}
		}, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					news.setHn_id(rs.getLong(1));
					news.setHn_title(rs.getString(2));
					news.setContent(rs.getString(3));
					news.setHn_create_time(rs.getDate(4));
				}
			}
		});
		return news;
	}

}
