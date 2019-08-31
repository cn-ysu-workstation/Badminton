<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/appraisal/css/cm-item.css">
</head>

<body>
<div class="cm-area">

    <c:forEach items="${appraisalCustomList}" var="myappraisalCustomList">
        <div class="cmi">
            <!-- <img class="cmi-c" src="./images/好评.png"> -->
            <c:if test="${myappraisalCustomList.appStatus == 0}">
                <img class="cmi-c-bad" src="${pageContext.request.contextPath}/jsp/appraisal/images/差评.png">
            </c:if>
            <c:if test="${myappraisalCustomList.appStatus == 1}">
                <img class="cmi-c-bad" src="${pageContext.request.contextPath}/jsp/appraisal/images/好评.png">
            </c:if>

            <div class="cmi-h">
                <h3>用户: ${myappraisalCustomList.user.username}</h3>
                <p>场地名:${myappraisalCustomList.area.areaname}</p>
            </div>
            <div class="cmi-b">
                <p>${myappraisalCustomList.info}</p>
            </div>
            <div class="cmi-images">

                <c:forEach items="${myappraisalCustomList.appraisalpicList}" var="picList">
                    <img src="http://47.98.40.227:81/${picList.pic}" alt="">
                </c:forEach>
            </div>
            <div class="cmi-time">
                <p>评价于 <fmt:formatDate value="${myappraisalCustomList.appTime}" pattern="yyyy-MM-dd HH:mm:ss" /></p>
            </div>
        </div>
        <div class="clear line"></div>
    </c:forEach>


</div>
</body>
</html>
