package com.oracle.common;

import java.sql.Connection;
import java.sql.SQLException;

public class Transaction {
	
	public void beginTransaction(Connection conn){
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("��������ʧ��");
			e.printStackTrace();
		}
	}
	
	public void commit(Connection conn){
		try {
			conn.commit();
		} catch (SQLException e) {
			System.out.println("�ύ����ʧ��");
			e.printStackTrace();
		}
	}
	
	public void rollback(Connection conn){
		try {
			conn.rollback();
		} catch (SQLException e) {
			System.out.println("�ع�����ʧ��");
			e.printStackTrace();
		}
	}
	
	
}
