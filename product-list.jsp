<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>CHIC - Product List</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
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
		Your Location：<a href="ProductServlet">CHIC</a> &gt; <a
			href="product-list.jsp">Books & Videos</a> &gt; Books
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<%@ include file="index_product_sort.jsp"%>
			<div class="spacer"></div>
			<div class="last-view">
				<h2>Recently Visit</h2>
				<dl class="clearfix">

					<dt>
						<img style="width: 54px; height: 54px;" src="images/product/0.jpg" />
					</dt>
					<dd>
						<a href="#">Product Name</a>
					</dd>
						<c:forEach items="" var="p">
							<dt>
								<img style="width: 54px; height: 54px;" src="" />
							</dt>
							<dd>
								<a href="pview"></a>
							</dd>
						</c:forEach>
				

				</dl>
			</div>
		</div>
		<div class="main">
			<div class="product-list">
				<h2>All Products</h2>
				<div class="clear"></div>
				<ul class="product clearfix">

					<li>
						<dl>
							<dt>
								<a href="#" target="_self"><img src="images/product/0.jpg" /></a>
							</dt>
							<dd class="title">
								<a href="#" target="_self">Product Name</a>
							</dd>
							<dd class="price">￥12.34</dd>
						</dl>
					</li>

					<li>
						<dl>
							<dt>
								<a href="#" target="_self"><img src="images/product/0.jpg" /></a>
							</dt>
							<dd class="title">
								<a href="#" target="_self">Product Name</a>
							</dd>
							<dd class="price">￥12.34</dd>
						</dl>
					</li>


				</ul>
				<div class="clear"></div>
				<div class="pager">
					<ul class="clearfix">
						<li><a href="#">Last Page</a></li>
						<li>2</li>


						<li><a href="#">3</a></li>


						<li><a href="#">Next Page</a></li>
					</ul>
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