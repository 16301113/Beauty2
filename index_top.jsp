
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	double num = Math.random();
%>

<div id="header">
	<div class="login_menu">
	<div class="logo_search">
		<div class="logo">
			<img src="assets/img/logo.png">
		</div>
		
	</div>
		<div class="login_container">
			<c:set value="" var="user"></c:set>
			<ul class="m_left">
				<c:choose>
					<c:when test="${username!=null}">
						<li><a href="index.jsp" class="c_red">${username}</a>&nbsp;&nbsp;&nbsp;</li>
						<li><a href="LogoutServlet">EXIT</a>&nbsp;&nbsp;&nbsp;</li>
						<li><a href="register.jsp">Register</a></li>
					</c:when>

					<c:otherwise>
						<li><a href="login.jsp" class="c_red">Login</a>&nbsp;&nbsp;&nbsp;</li>
						<li><a href="register.jsp">Register</a></li>
					</c:otherwise>
				</c:choose>
			</ul>

			<ul class="m_right">
				<c:choose>
					<c:when test="${username!=null}">
						<li><img src="images/icon_3.png"><a href="shopping.jsp"
							class="c_red">Shopping Cart</a></li>
					</c:when>
					<c:otherwise>
						<li><img src="images/icon_3.png"><a
							href="javascript:tips()" class="c_red">Shopping Cart</a></li>
					</c:otherwise>
				</c:choose>
				<li><img src="images/icon_4.png"><a
					href="javascript:AddFavorite('My website',location.href)">Shopping Cart</a></li>
				<li><img src="images/icon_2.png"><a href="guestbook.jsp">Message</a></li>
				<li><img src="images/icon_1.png"><a href="index.jsp">Homepage</a></li>
			</ul>
		</div>
	</div>
	


	<script type="text/javascript">
		function tips() {
			alert("Please Login First!");
			window.location.href = "login.jsp";
		}

		function AddFavorite(title, url) {
			try {
				window.external.addFavorite(url, title);
			} catch (e) {
				try {
					window.sidebar.addPanel(title, url, "");
				} catch (e) {
					alert("Sorry, the browser you are using cannot do this. \n\nn failed to join the collection. Please use Ctrl+D to add");
				}
			}
		}
	</script>
</div>
