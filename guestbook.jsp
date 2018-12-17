<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>CHIC - Message</title>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css"
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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/comment.js"></script>
</head>
<body>
	<%@ include file="index_top.jsp"%>
	<div id="position" class="wrap">
		Your location<a href="${pageContext.request.contextPath}/index.jsp">CHIC</a>
		&gt; Leave Message Online
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<%@ include file="index_product_sort.jsp"%>
		</div>
		<div class="main">
			<div class="guestbook">
				<h2>All Messages</h2>
				<ul>
					<c:forEach items="${requestScope.listcom}" var="guestbooks">

						<li>
							<dl>
								<dt>内容：${guestbooks.hc_content}</dt>
								<dd class="author">
									<span>Author：${guestbooks.hc_nick_name}</span>
								</dd>
								<dd>Comment Time：${guestbooks.hc_create_time}</dd>
								<dd>Reply：${guestbooks.hc_pepiy}</dd>
								<dd>Reply Time：${guestbooks.hc_reply_time}</dd>
							</dl>
						</li>
					</c:forEach>


				</ul>
				<div class="clear"></div>
				<div class="pager">
					<ul class="clearfix">

					</ul>

				</div>
				<div id="reply-box">
					<form action="addComment" method="post"
						onsubmit="return commentCheck()">
						<table>
							<tr>
								<td class="field">Nickname：</td>
								<td><input class="text" type="text" name="guestName" /></td>
							</tr>
							<tr>
								<td class="field">Message Title：</td>
								<td><input class="text" type="text" name="guestTitle" /></td>
							</tr>
							<tr>
								<td class="field">Message content：</td>
								<td><textarea name="guestContent"></textarea></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td><label class="ui-blue"><input type="submit"
										name="submit" value="submit message" /></label></td>
							</tr>
						</table>
					</form>
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