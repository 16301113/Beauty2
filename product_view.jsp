<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>CHIC - Product View</title>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/index.js"></script>
<script type="text/javascript" src="scripts/product_view.js"></script>
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
	<%@ include file="index_top.jsp"%>
	<div id="position" class="wrap">
		<c:set value="" var="s"></c:set>
		Your Location：<a href="index.jsp">CHIC</a> &gt; <a href="category"></a> &gt; <a
			href="category"></a>
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<%@ include file="index_product_sort.jsp"%>
		</div>
		<div id="product" class="main">
			<c:set var="p" value="${requestScope.pro}"></c:set>
			<h1>Product Name:${p.hp_name}</h1>
			<div class="infos">
				<div class="thumb">
					<img style="width: 100px; height: 100px;" src="${p.hp_file_name}" />
				</div>
				<div class="buy">
					<p>
						Price：<span class="price">￥${p.hp_price}</span>
					</p>
					<c:choose>
						<c:when test="${p.hp_stock>0}">
							<p>
								Stock：<span id="stock">${p.hp_stock}</span>(In stock)
							</p>
						</c:when>
						<c:otherwise>
							<p>Stock：${p.hp_stock}Not in stock
						</c:otherwise>
					</c:choose>
					<input type="button" id="minus" value=" - " width="3px"
						onclick="minus();"> <input type="text" id="count"
						name="count" onBlur="checkStock()" value="1" maxlength="5"
						size="1" style="text-align: center; vertical-align: middle">
					<input type="button" id="add" value=" + " width="2px"
						onclick="add();">
					<c:choose>
						<c:when test="${username==null}">
							<div class="button">
								<input type="button" name="button" value="" onClick="remaind();"
									style="background: url(images/buyNow.png)" /> <input
									type="image" name="imageField" src="images/cartbutton.png"
									onclick="remaind()" />
							</div>

						</c:when>
						<c:otherwise>
							<div class="button">
								<input type="button" name="button" value=""
									onclick="goingToBuy(${p.hp_id });"
									style="background: url(images/buyNow.png)" /> <input
									type="image" name="imageField" src="images/cartbutton.png"
									onclick="addToCart(${p.hp_id });" />
							</div>
						</c:otherwise>
					</c:choose>

				</div>
				<div class="clear"></div>
			</div>
			<div class="introduce">
				<h2>
					<strong>Commodity details：${p.hp_description}</strong>
				</h2>
				<div class="text">
					Product Name：${p.hp_name}<br /> Product Discription：${p.hp_description}<br />
					Product Price：￥${p.hp_price}<br /> Product Stock：${p.hp_stock}<br />
				</div>
			</div>
		</div>
		<div class="clear"></div>
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