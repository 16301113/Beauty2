package com.oracle.service.impl;

import java.util.List;

import com.oracle.dao.IguestBook;
import com.oracle.dao.impl.GuestBookImpl;
import com.oracle.entity.Comment;

import com.oracle.service.IGuestBookService;

public class GuestBookServiceImpl implements IGuestBookService {

	private IguestBook igus = new GuestBookImpl();

	@Override
	public List<Comment> getguestbook() {

		return igus.selectguestbook();
	}

	@Override
	public boolean saveguestbook(Comment comment) {
		if (igus.insertguestbook(comment)) {
			return true;
		} else {
			return false;
		}
	}

}
