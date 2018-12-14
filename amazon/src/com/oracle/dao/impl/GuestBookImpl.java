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
import com.oracle.dao.IguestBook;
import com.oracle.entity.Comment;

public class GuestBookImpl implements IguestBook {

	private Connection conn = ConnectionFactory.getConnection();
	private Template template = new Template(conn);

	@Override
	public List<Comment> selectguestbook() {
		final List<Comment> listcom = new ArrayList<Comment>();
		String sql = "select * from hwua_comment";
		template.query(sql, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					Comment tc = new Comment();
					tc.setHc_id(rs.getLong(1));
					tc.setHc_pepiy(rs.getString(2));
					tc.setHc_content(rs.getString(3));
					tc.setHc_create_time(rs.getDate(4));
					tc.setHc_reply_time(rs.getDate(5));
					tc.setHc_nick_name(rs.getString(6));
					tc.setHc_state(rs.getString(7));
					listcom.add(tc);
				}
			}
		});
		return listcom;
	}

	@Override
	public boolean insertguestbook(final Comment comment) {
		String sql = "select SEQ_COMMENT.nextval from dual";
		template.query(sql, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					comment.setHc_id(rs.getLong(1));
				}
			}
		});
		sql = "insert into hwua_comment(hc_content,hc_create_time,hc_nick_name,hc_id) values(?,?,?,?)";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, comment.getHc_content());
				pstmt.setDate(2, comment.getHc_create_time());
				pstmt.setString(3, comment.getHc_nick_name());
				pstmt.setLong(4, comment.getHc_id());
			}
		});
		return true;
	}

}
