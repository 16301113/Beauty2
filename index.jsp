
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>CHIC - Homepage</title>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/index.js"></script>

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
	<div id="middle">
		<div class="p_left">
			<!--商品分类-->
			<%@ include file="index_product_sort.jsp"%>
			<!--商品分类结束-->

			<div class="pre_look">
				<h3>Recently Visit</h3>
				
				<dl>
					<c:forEach items="${reclist}" var="p" end="3">
						<dt>
							<img style="width: 54px; height: 54px;" src="${p.hp_file_name}" />
						</dt>
						<dd>
							<a href="pview">${p.hp_name}</a>
						</dd>
					</c:forEach>
				</dl>
			</div>
		</div>

		<div class="p_center">
			<div id="wrapper">
				<div id="focus">
					<ul>
						<li><a href="#"><img src="images/T1.jpg" /></a></li>
						<li><a href="#"><img src="images/T2.jpg" /></a></li>
						<li><a href="#"><img src="images/T3.jpg" /></a></li>
						<li><a href="#"><img src="images/T4.jpg" /></a></li>
						<li><a href="#"><img src="images/T5.jpg" /></a></li>
					</ul>
				</div>
			</div>
			<div class="p_list">
				<div class="p_info">
					<img src="images/icon_sale.png" />List of Products
				</div>
			</div>

			<ul class="product2">
				<c:if test="${requestScope.proolist.size()==0}">
					<h3 style="width: 500px; text-align: center; line-height: 150px">Cannot be found！</h3>
				</c:if>
				<c:set value="${requestScope.proolist}" var="products"></c:set>
				<c:forEach items="${products}" var="p">
					<li>
						<dl>
							<dt>
								<a href="pview?pid=${p.hp_id}" target="_self"><img
									src="${p.hp_file_name}" /></a>
							</dt>
							<dd class="title">
								<a href="pview?pid=${p.hp_id}" target="_self">${p.hp_name}</a>
							</dd>
							<dd class="price">￥${p.hp_price}</dd>
						</dl>
					</li>

				</c:forEach>

			</ul>

			<!--分页-->
			<div class="pager">
				<ul>
					<ul>
						<li><a href="javascript:lastPage()" id="lastPage">last page</a></li>
						<c:forEach items="${requestScope.pages}" var="pl">
							<li><a href="ref?page=${pl}&cate=${requestScope.cate}&pid=${requestScope.pid}&pcid=${requestScope.pid}">${pl}</a></li>
						</c:forEach>
						<li><a href="javascript:nextPage()" id="nextPage">next page</a></li>
					</ul>
				</ul>
				<input type="hidden" id="cate" value="${requestScope.cate}" />
				<input type="hidden" id="pid" value="${requestScope.pid}" />
				<input type="hidden" id="totalPage" value="${totalPage}" /> 
				<input type="hidden" id="currentPage" value="${page}" /> 
				<input type="hidden" id="queryName" value="" />
			</div>
		</div>

		<div id="p_right">
			<%@ include file="index_news.jsp"%>
			<%@ include file="hotproduct.jsp"%>
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