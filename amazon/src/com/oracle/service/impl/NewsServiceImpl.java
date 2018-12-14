package com.oracle.service.impl;

import java.util.List;

import com.oracle.dao.INews;
import com.oracle.dao.impl.INewsImpl;
import com.oracle.entity.News;
import com.oracle.service.NewsService;

public class NewsServiceImpl implements NewsService {

	private INews inews = new INewsImpl();

	@Override
	public List<News> selectnews() {

		return inews.selectnews();
	}

	@Override
	public News selectnews(long hn_id) {

		return inews.selectnews(hn_id);
	}

}
