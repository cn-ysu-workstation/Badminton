<%--
  Created by IntelliJ IDEA.
  User: JokerZ
  Date: 2019/8/16
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Minimal and Clean Sign up / Login and Forgot Form by FreeHTML5.co</title>
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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/Regist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/Regist/css/animate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/Regist/css/style.css">

    <!-- Modernizr JS -->
    <script src="${pageContext.request.contextPath}/jsp/Regist/js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>-->
    <script src="${pageContext.request.contextPath}/jsp/Regist/js/respond.min.js"></script>
    <![endif]-->

</head>
<body class="style-2">

<div class="container">
    <div class="row">
        <div class="col-md-4">


            <!-- Start Sign In Form -->
            <form action="#" class="fh5co-form animate-box" data-animate-effect="fadeInLeft">
                <h2>注册</h2>
                <div class="form-group">
                    <div class="alert alert-success" role="alert">请输入相关的注册信息</div>
                </div>
                <div class="form-group">
                    <label for="username" class="sr-only">用户名</label>
                    <input type="text" class="form-control" name="username" id="username" placeholder="请输入用户名" autocomplete="off" required="required">
                </div>
                <div class="form-group">
                    <label for="password" class="sr-only">密码</label>
                    <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码" autocomplete="off"required="required">
                </div>
                <div class="form-group">
                    <label for="re-password" class="sr-only">确认密码</label>
                    <input type="password" class="form-control" id="re-password" placeholder="请再次确认密码" autocomplete="off"required="required">
                </div>
                <div class="form-group">
                    <label for="name" class="sr-only">真实姓名</label>
                    <input type="text" class="form-control" name="name" id="name" placeholder="请输入您的真实姓名" autocomplete="off"required="required">
                </div>
                <div class="form-group">
                    <select id="select" name="sex">
                        <option value="1">男</option>
                        <option value="0">女</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="phonenumber" class="sr-only">手机号码</label>
                    <input type="type" class="form-control" name="phonenumber" id="phonenumber" placeholder="请输入您的手机号码" autocomplete="off" required="required">
                </div>
                <div class="form-group">
                    <label for="file" class="sr-only">请上传头像</label>
                    <input type="file" class="form-control" name="file" id="file">
                </div>
                <div class="form-group">
                    <p>已经注册用户? <a href="${pageContext.request.contextPath}/jsp/Login/login.jsp">点击登录</a></p>
                </div>
                <div class="form-group">
                    <input type="submit" value="注册" class="btn btn-primary">
                </div>
            </form>
            <!-- END Sign In Form -->


        </div>
    </div>
</div>

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/jsp/Regist/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/jsp/Regist/js/bootstrap.min.js"></script>
<!-- Placeholder -->
<script src="${pageContext.request.contextPath}/jsp/Regist/js/jquery.placeholder.min.js"></script>
<!-- Waypoints -->
<script src="${pageContext.request.contextPath}/jsp/Regist/js/jquery.waypoints.min.js"></script>
<!-- Main JS -->
<script src="${pageContext.request.contextPath}/jsp/Regist/js/main.js"></script>

</body>

</body>
</html>
