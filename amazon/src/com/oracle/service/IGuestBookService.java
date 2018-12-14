package com.oracle.service;

import java.util.List;

import com.oracle.entity.Comment;


public interface IGuestBookService {

	public List<Comment> getguestbook();
	
	/**
	 * 留言
	 */
	public boolean saveguestbook(Comment comment);

}
