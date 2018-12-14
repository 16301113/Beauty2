package com.oracle.service.impl;

import java.sql.Connection;
import java.util.List;

import com.oracle.common.ConnectionFactory;
import com.oracle.common.DBUtils;
import com.oracle.dao.IProduct;
import com.oracle.dao.impl.IProductImpl;
import com.oracle.entity.Product;
import com.oracle.service.IProductService;

public class IProductServiceImpl implements IProductService {

	private Connection conn;

	private IProduct ipro;

	public IProductServiceImpl() {
		conn = ConnectionFactory.getConnection();
		ipro = new IProductImpl(conn);
	}

	@Override
	public List<Product> getProducts() {

		return ipro.selectProduct();
	}

	@Override
	public List<Product> getPProducts(long pid) {

		return ipro.selectProducts(pid);
	}

	@Override
	public List<Product> getCProduct(long pcid) {

		return ipro.selectchildProduct(pcid);
	}

	@Override
	public Product getProduct(long pcid) {

		return ipro.selectProduct(pcid);
	}

	@Override
	public List<Product> getseekProducts(String pname) {

		return ipro.seekProducts(pname);
	}

	@Override
	public List<Product> gethotproduct() {

		return ipro.selhotproduct();
	}

	@Override
	public void release() {
		if (conn != null) {
			DBUtils.close(null, null, conn);
		}
	}

	@Override
	public boolean updetePronums(long pid, long num) {

		return ipro.updetePronum(pid, num);
	}

}
