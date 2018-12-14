package com.oracle.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.common.ConnectionFactory;
import com.oracle.common.PreparedStatementSetter;
import com.oracle.common.RowCallBackHandler;
import com.oracle.common.Template;
import com.oracle.dao.IUserDao;
import com.oracle.entity.User;

public class IUserDaoImpl implements IUserDao {

	private Connection conn = ConnectionFactory.getConnection();
	private Template template = new Template(conn);

	@Override
	public boolean saveuser(final User users) {
		String sql = "select SEQ_USER.nextval from dual";
		template.query(sql, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					users.setHu_user_id(rs.getLong(1));
				}
			}
		});
		sql = "insert into hwua_user values(?,?,?,?,?,?,?,?,?,?)";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, users.getHu_user_id());
				pstmt.setString(2, users.getHu_user_name());
				pstmt.setString(3, users.getHu_password());
				pstmt.setString(4, users.getHu_sex());
				pstmt.setDate(5, Date.valueOf(users.getHu_birthday()));
				pstmt.setString(6, users.getHu_identity_code());
				pstmt.setString(7, users.getHu_email());
				pstmt.setString(8, users.getHu_mobile());
				pstmt.setString(9, users.getHu_adderss());
				pstmt.setInt(10, 0);
			}
		});

		return false;
	}

	@Override
	public boolean selectuser(final String username) {
		String sql = "select HU_USER_NAME from hwua_user";
		final User users = new User();
		template.query(sql, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					if (rs.getString(1).equals(username)) {
						users.setHu_user_name(rs.getString(1));
						break;
					} else {
						users.setHu_user_name("");
					}
				}
			}
		});
		if (users.getHu_user_name().equals("")) {
			// 不存在，可以注册
			return true;
		} else {
			// 存在
			return false;
		}
	}

	@Override
	public boolean selectemail(final String email) {
		String sql = "select HU_EMAIL from hwua_user";
		final User users = new User();
		template.query(sql, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					if (rs.getString(1).equals(email)) {
						users.setHu_email(rs.getString(1));
						break;
					} else {
						users.setHu_email("");
					}
				}
			}
		});
		if (users.getHu_email().equals("")) {
			// 不存在，可以注册
			return true;
		} else {
			// 存在
			return false;
		}
	}

	@Override
	public List<User> selectuser() {
		String sql = "select * from hwua_user";
		final List<User> list = new ArrayList<User>();
		template.query(sql, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while (rs.next()) {
					User user = new User();
					user.setHu_user_name(rs.getString(2));
					user.setHu_password(rs.getString(3));
					list.add(user);
				}
			}
		});
		return list;
	}

	@Override
	public User selectuserid(final String username) {
		String sql = "select * from hwua_user where HU_USER_NAME=?";
		final User users = new User();
		template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, username);
			}
		}, new RowCallBackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				if (rs.next()) {
					users.setHu_user_id(rs.getLong(1));
					users.setHu_adderss(rs.getString(9));
				}
			}
		});
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
