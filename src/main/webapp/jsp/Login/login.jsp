<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>用户登录</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />

	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/Login/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/Login/css/animate.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/Login/css/style.css">


	<!-- Modernizr JS -->
	<script src="${pageContext.request.contextPath}/jsp/Login/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>-->
	<script src="${pageContext.request.contextPath}/jsp/Login/js/respond.min.js"></script>
	<![endif]-->

</head>
<body class="style-2">

<div class="container">
	<div class="row">
		<div class="col-md-4">


			<!-- Start Sign In Form -->
			<form action="<c:url value="/Administrator/Login"/>" class="fh5co-form animate-box" data-animate-effect="fadeInLeft" method="post">
				<h2><h2>
					<c:choose>
						<c:when test="${mess ne null }">${mess }</c:when>
						<c:otherwise>登录</c:otherwise>
					</c:choose>
					<i class="fas fa-level-down-alt"></i>
				</h2></h2>
				<div class="form-group">
					<label for="username" class="sr-only">用户名</label>
					<input type="text" class="form-control" id="username" name="username" placeholder="请输入您的用户名" autocomplete="off" required="required">
				</div>
				<div class="form-group">
					<label for="password" class="sr-only">密码</label>
					<input type="password" class="form-control" id="password" name="password" placeholder="请输入您的密码" autocomplete="off" required="required">
				</div>
				<div class="form-group">
					<label for="remember"><input type="checkbox" id="remember">记住密码</label>
				</div>
				<div class="form-group">
					<p>还没有注册？ <a href="${pageContext.request.contextPath}/jsp/Regist/regist.jsp">注册</a> | <a href="forgot2.html">忘记密码?</a></p>
				</div>
				<div class="form-group">
					<input type="submit" value="登录" class="btn btn-primary">
				</div>

			</form>
			<!-- END Sign In Form -->

		</div>
	</div>
</div>

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/jsp/Login/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/jsp/Login/js/bootstrap.min.js"></script>
<!-- Placeholder -->
<script src="${pageContext.request.contextPath}/jsp/Login/js/jquery.placeholder.min.js"></script>
<!-- Waypoints -->
<script src="${pageContext.request.contextPath}/jsp/Login/js/jquery.waypoints.min.js"></script>
<!-- Main JS -->
<script src="${pageContext.request.contextPath}/jsp/Login/js/main.js"></script>

</body>
</html>
