package com.oracle.dao;

import java.util.List;

import com.oracle.entity.Comment;

public interface IguestBook {

	public List<Comment> selectguestbook();

	/**
	 * 留言
	 * 
	 * @param comment
	 * @return
	 */
	public boolean insertguestbook(Comment comment);

}
