<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>CHIC - Order Page</title>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/index.js"></script>
<script type="text/javascript" src="scripts/shopping.js"></script>
<style type="text/css">#oderview{font-size: 14px}</style>
  <!--=== Favicon ===-->
    <link rel="shortcut icon" href="assets/img/favicon.ico" type="image/x-icon"/>

    <!--== Google Fonts ==-->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,300i,400,400i,700,900" rel="stylesheet">

    <!--=== Bootstrap CSS ===-->
    <link href="assets/css/vendor/bootstrap.min.css" rel="stylesheet"/>
    <!--=== Font-Awesome CSS ===-->
    <link href="assets/css/vendor/font-awesome.css" rel="stylesheet"/>
    <!--=== Plugins CSS ===-->
    <link href="assets/css/plugins.css" rel="stylesheet"/>
    <!--=== Main Style CSS ===-->
    <link href="assets/css/style.css" rel="stylesheet"/>

    <!-- Modernizer JS -->
    <script src="assets/js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<body>
<%@ include file="index_top.jsp"  %>

<div id="position" class="wrap">
	Your location：<a href="index.jsp">CHIC</a> &gt; Newest Order
</div>
<div class="wrap">
	<div id="shopping">
		<form action="doBuy" method="post">
		<c:set value="${requestScope.orderlist}" var="orderitem"></c:set>
		<c:forEach items="${orderitem}" var="order">
			<table id="oderview">
				<c:set value="" var="view"></c:set>
				<%-- <c:set value="${requestScope.order}" var="order"></c:set> --%>
				<tr>
					<th>Order time:${order.ho_create_time}</th>
					<th>Order number::15100579753${order.ho_id}</th>
					<th>Order Price:${order.ho_cost}</th>	
					<th><th>				
				</tr>
				<!-- 根据用户购物车生成列表 -->
				<c:forEach items="${order.orderdetail}" var="shopping">
				<tr id="product_id_1">
					<td class="thumb"><img style="width: 100px; height: 100px;" src="${shopping.product.hp_file_name}" />${shopping.product.hp_name}<a href="pview"></a></td>
					<td class="price" >
						￥<span >Unit Price：${shopping.product.hp_price}</span>
					</td>
					<td class="number">
							<span>X${shopping.hod_quantity}</span>
					</td>
					<td class="delete">Shipping now</td>
					
				</tr>
				</c:forEach>
			</table>
			</c:forEach>
		</form>
	</div>
</div>

<!--== Start Footer Section ===-->
<footer id="footer-area">
    <!-- Start Newsletter Area -->
    <div class="newsletter-area-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 m-auto text-center">
                    <div class="newsletter-content-wrap">
                        <h2>Newsletter</h2>
                        <p>Be the first to hear about new styles and offers and see how you’ve helped.</p>
						<h2>Email us 888888@chic.com</h2>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Newsletter Area -->
</footer>
<!--== End Footer Section ===-->

<!-- Scroll to Top Start -->
<a href="#" class="scrolltotop"><i class="fa fa-angle-double-up"></i></a>
<!-- Scroll to Top End -->

<!--=======================Javascript============================-->
<!--=== Jquery Min Js ===-->
<script src="assets/js/vendor/jquery-3.3.1.min.js"></script>
<!--=== Jquery Migrate Min Js ===-->
<script src="assets/js/vendor/jquery-migrate-1.4.1.min.js"></script>
<!--=== Popper Min Js ===-->
<script src="assets/js/vendor/popper.min.js"></script>
<!--=== Bootstrap Min Js ===-->
<script src="assets/js/vendor/bootstrap.min.js"></script>
<!--=== Plugins Js ===-->
<script src="assets/js/plugins.js"></script>
<!--=== Ajax Mail Js ===-->
<script src="assets/js/ajax-mail.js"></script>

<!--=== Active Js ===-->
<script src="assets/js/active.js"></script>
</body>
</html>
