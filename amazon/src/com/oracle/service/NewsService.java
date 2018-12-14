package com.oracle.service;

import java.util.List;

import com.oracle.entity.News;

public interface NewsService {

	public List<News> selectnews();

	/**
	 * 根据标题查询新闻
	 * 
	 * @param title
	 * @return
	 */
	public News selectnews(long hn_id);

}
