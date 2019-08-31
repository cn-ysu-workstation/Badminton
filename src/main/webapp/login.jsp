<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/21
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/fore/foreHeader.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fore/login.css">
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
</head>
<%@ include file="include/fore/foreNavigator.jsp" %>
<title>登陆</title>
<script>
    $(function () {
        <c:if test="${!empty mess}">
        $("span.errorMessage").html("${mess}");
        $("span.errorMessage").css("visibility", "visible");
        </c:if>

        $("#sub1").click(function () {

            if ($("#username").val().length == 0 || $("#password").val().length == 0)
            {
                $("span.errorMessage").css("visibility", "visible");
                $("span.errorMessage").html("*请输入账号密码");
            }else {
                $("#LoginForm").submit();
            }

        });
        $("#sub2").click(function () {

            if ($("#username").val().length == 0 || $("#password").val().length == 0)
            {
                $("span.errorMessage").css("visibility", "visible");
                $("span.errorMessage").html("*请输入账号密码");
            }else {
                $("#username").attr("form","AdLogin")
                $("#password").attr("form","AdLogin")
                $("#AdLogin").submit();
            }

        });

    })
</script>

<!-- 登陆框开始 -->

<div class="content">
    <div class="login_wrapper"
         style="background-image:url('${pageContext.request.contextPath}/image/fore/main.jpg'); background-repeat: no-repeat; margin-top: 10px">
        <div class="glass"></div>
        <div class="login_content">
            <h5 class="login-text">登陆账号</h5>
            <div class="loginErrorMessageDiv">
                <div>
                    <span class="errorMessage" style="color: red; visibility: hidden"></span>
                </div>
            </div>
            <form id="AdLogin" method="post" action="${pageContext.request.contextPath}/Administrator/Login"></form>
            <form  id="LoginForm" class="loginForm" method="post" action="${pageContext.request.contextPath}/user/findUserToLogin"></form>

                <div class="login-item">
                    <input form="LoginForm" type="text" id="username" name="username" placeholder="请输入用户名">
                </div>
                <div class="login-item">
                    <input  form="LoginForm" type="password" id="password" name="password" placeholder="请输入密码">
                </div>
                <div>
                    <button type="button" class="login-button" id="sub1">用户登陆</button>
                    <button type="button" class="login-button" id="sub2">管理员登陆</button>
                </div>

        </div>
    </div>
</div>
</div>
</div>
<%@ include file="include/fore/foreFooter.jsp" %>
