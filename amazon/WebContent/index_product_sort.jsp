<%@page import="com.oracle.service.impl.CategoryServiceImpl"%>
<%@page import="com.oracle.service.CategoryService"%>
<%@page import="com.oracle.entity.Product_category"%>
<%@page import="com.oracle.dao.impl.ICategoryImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="p_category">
	<h2>商品分类</h2>


	<c:set var="categoryInfo" value=""></c:set>

	<%
		CategoryService cat = new CategoryServiceImpl();
		List<Product_category> map = cat.selectcategory();
		request.setAttribute("maps", map);
	%>

	<c:forEach items="${maps}" var="c">
		<dl>
			<dt>
				<a href="index.jsp?cate=parent&pid=${c.hpc_id}">
					${c.hpc_name} </a>
			</dt>
			<c:forEach items="${c.list}" var="b">
				<dd>
					<a href="index.jsp?cate=child&pcid=${b.hpc_id}">${b.hpc_name}</a>
				</dd>

			</c:forEach>
		</dl>
	</c:forEach>


</div>

