package com.oracle.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Template {
	private Connection conn;

	public Template(Connection conn) {
		this.conn = conn;
	}

	// R(Retrieve) Statement
	public void query(String sql, RowCallBackHandler handler) {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (handler != null)
				handler.processRow(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, stmt);
		}
	}

	// R(Retrieve) PreparedStatement
	public void query(String sql, PreparedStatementSetter setter, RowCallBackHandler handler) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			if (setter != null)
				setter.setValues(pstmt);
			rs = pstmt.executeQuery();
			if (handler != null)
				handler.processRow(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt);
		}
	}

	// C(Create) U(Update) D(Delete)
	public void update(String sql, PreparedStatementSetter setter) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			if (setter != null)
				setter.setValues(pstmt);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(null, pstmt);
		}
	}

}
