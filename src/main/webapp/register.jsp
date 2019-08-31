<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/21
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/fore/foreHeader.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fore/register.css">
</head>
<%@ include file="include/fore/foreNavigator.jsp"%>
<title>注册</title>
<script src="${pageContext.request.contextPath}/js/fore/jquery-3.3.1.js" ></script>
<script src="${pageContext.request.contextPath}/js/fore/register.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

        $("#username").change(function () {

            var $userName=$("#username").val();

            $.ajax({

                type:'post',
                url:'${pageContext.request.contextPath}/user/regist',
                data:'username='+$userName,
                success:function (data) {
                    if(data.length>0)
                    {
                        $("#use").show();
                        $("#use").text("用户名已注册")
                    }
                    if(data.length<=0){
                        $("#use").hide();
                        $("#use").text("");
                    }

                }

            })

        });

    })

</script>
<script>
    $(function () {
        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        $("div.registerErrorMessageDiv").css("visibility","visible");
        </c:if>
    })
</script>

        <div class="content">
            <div class="login_wrapper" style="background-image:url('${pageContext.request.contextPath}/image/fore/main.jpg'); background-repeat: no-repeat; margin-top: 10px">
                <div class="glass" style="height: 470px"></div>
                <div class="login_content">
                    <form role="form" method="post" action="${pageContext.request.contextPath}/user/register" class="registerForm">
                        <h5 class="login-text">注册账号</h5>

                        <div class="registerErrorMessageDiv" style="margin: 3px">
                            <div class="alert" role="alert">
                                <span class="errorMessage" style="color: red"></span>
                            </div>
                        </div>

                        <div style="margin-top: 17px;">
                            <div class="login-item form-group">
                                用户名:
                                <input type="text" class="form-control" id="username" name="username" placeholder="用户名" required>
                                <lable id="use" style="color: red;display:none"> </lable>
                            </div>
                            <div class="login-item form-group">
                                姓名:
                                <input type="text" class="form-control" id="name" name="name" placeholder="请输入6-16位字符" required  title="帐号应为6-16位">
                            </div>
                            <div class="login-item form-group">
                                密码:
                                <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码" required id="pwd1">
                            </div>
                            <div class="login-item form-group">
                                确认密码:
                                <input type="password" class="form-control" placeholder="请确认密码" required id="pwd2" onkeyup="validate()">
                                <span id="tishi"></span>
                            </div>
                            <div class="login-item form-group">
                                手机号码:
                                <input type="text" class="form-control" placeholder="手机号码" required id="phonenumber"  name="phonenumber">

                            </div>
                            <div class="login-item form-group d-flex justify-content-around">
                                <div class="btn-group">
                                    <button type="submit" class="btn btn-primary" id="submit">&nbsp;&nbsp;注册&nbsp;&nbsp;</button>
                                </div>
                                <div class="btn-group">
                                    <button type="reset" class="btn btn-primary" onclick="resetpwd()">&nbsp;&nbsp;重置&nbsp;&nbsp;</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
<%@ include file="include/fore/foreFooter.jsp"%>