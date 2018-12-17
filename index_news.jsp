<%@page import="com.oracle.entity.News"%>

<%@page import="com.oracle.service.impl.NewsServiceImpl"%>
<%@page import="com.oracle.service.NewsService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
.news-list ul li {
	
}
</style>
<div class="newsList">
	<%
		NewsService ins = new NewsServiceImpl();
		List<News> list = ins.selectnews();
		request.setAttribute("list", list);
	%>
	<h2>News Information</h2>
	<ul>


		<c:forEach items="${list}" var="n" end="10">
			<li><a href="readNews?id=${n.hn_id}">${n.hn_title}&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;</a></li>
		</c:forEach>
	</ul>
</div>
