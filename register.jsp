<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>CHIC : Registration</title>

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

    <!--[if lt IE 9]>
    <script src="//oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!--[if lt IE 9]>
    <script src="//oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<header>
 <!-- Start PreHeader Area -->
    <div class="preheader-area">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6 text-center text-md-left">
                    <!-- Start PreHeader Left -->
                    <div class="preheader-left-wrap">
                        <a href="tel:1018889999"><i class="fa fa-phone"></i> 101.888.9999</a>
                        <a href="#">FREE Shipping on orders over $150</a>
                    </div>
                    <!-- End PreHeader Left -->
                </div>

                <div class="col-md-6 mt-3 mt-md-0">
                      <!-- Start PreHeader Right -->
                    <div class="preheader-right-wrap">
                        <nav id="site-settings">
                            <ul class="nav justify-content-center justify-content-md-end">
                                <a href="login.jsp">Click Here to Login on or Register Please</a>
                              
                                <li class="dropdown-show"><a href="#" class="arrow-toggle"><img
                                        src="assets/img/icons/flag/en.png" alt="English"/> English</a>
                                    <ul class="dropdown-nav">
                                        <li><a href="#"><img src="assets/img/icons/flag/de.png" alt="German"/>
                                            German</a></li>
                                        <li><a href="#"><img src="assets/img/icons/flag/bd.png" alt="Bengali"/> Bengali</a>
                                        </li>
                                        <li><a href="#"><img src="assets/img/icons/flag/fr.png" alt="France"/>
                                            France</a></li>
                                    </ul>
                                </li>

                            </ul>
                        </nav>
                    </div>
                    <!-- End PreHeader Right -->
                </div>
            </div>
        </div>
    </div>
    <!-- End PreHeader Area -->

</header>
<body>
	<%@ include file="index_top.jsp"%>

	<div id="register" class="wrap">
		<div class="shadow">
			<em class="corner lb"></em> <em class="corner rt"></em>
			<div class="box">
				<h1>Welcome to register on CHIC</h1>
				<ul class="steps clearfix">
					<li class="current"><em></em>Fill in registration information</li>
					<li class="last"><em></em>Registeration Complete!</li>
				</ul>
				<form id="regForm" method="post" action="Register"
					onsubmit="return checkForm(this)">
					<table>
						<tr>
							<td class="field">Username:</td>
							<td><input id="userName" class="text" type="text"
								name="userName" onfocus="FocusItem(this)"
								onblur="CheckItem(this);" maxlength="15" /><span id="uName"></span></td>
						</tr>
						<tr>
							<td class="field">Password:</td>
							<td><input class="text" type="password" id="passWord"
								name="passWord" onfocus="FocusItem(this)"
								onblur="CheckItem(this);" /><span></span></td>
						</tr>
						<tr>
							<td class="field">Very password:</td>
							<td><input class="text" type="password" name="rePassWord"
								onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
						</tr>
						<tr>
							<td class="field">Gender:</td>
							<td><input type="radio" name="sex" style="border: 0px;"
								checked="checked" value="0" />Male<input type="radio" name="sex"
								style="border: 0px;" value="1" />Female<span></span></td>
						</tr>
						<tr>
							<td class="field">Birthday:</td>
							<td><input class="text" type="text" name="birthday"
								onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
						</tr>
						<tr>
							<td class="field">ID card number:</td>
							<td><input class="text" type="text" name="identity"
								onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
						</tr>
						<tr>
							<td class="field">E-mail address:</td>
							<td><input class="text" type="text" name="email"
								onfocus="FocusItem(this)" onblur="CheckItem(this);"
								onmouseout="checkEmail()" /><span id="uemail"></span></td>
						</tr>
						<tr>
							<td class="field">Phone number:</td>
							<td><input class="text" type="text" name="mobile"
								onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
						</tr>
						<tr>
							<td class="field">Address:</td>
							<td><input class="text" type="text" name="address"
								onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
						</tr>
						<tr>
							<td class="field">Verification code:</td>
							<td><input class="text verycode" type="text" name="veryCode"
								onfocus="FocusItem(this)" onblur="CheckItem(this);"
								maxlength="4" /><img id="veryCode" src="code.jsp" /><span
								id="Code"></span></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-green"><input type="submit"
									name="submit" value="Submit registeration" /></label></td>
						</tr>
					</table>
				</form>
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
