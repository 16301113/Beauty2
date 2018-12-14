package com.oracle.common;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {
	// ͨ��PreparedStatement������һЩֵ���滻ռλ��"?"
	void setValues(PreparedStatement pstmt) throws SQLException;
}
