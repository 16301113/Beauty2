package com.oracle.dao;

import java.util.List;

import com.oracle.entity.Cart;

public interface IShopCar {

	public void insertcar(Cart carts);

	public List<Cart> selectcar(long userid);
}
