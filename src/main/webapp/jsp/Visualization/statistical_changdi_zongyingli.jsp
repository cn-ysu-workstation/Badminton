<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>统计功能</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords" content=""/>

    <!-- Meta tag Keywords -->
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <!-- css files -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/Visualization/css/statistical.css" type="text/css" media="all" />
    <!-- js files-->

    <script src="${pageContext.request.contextPath}/jsp/Visualization/js/echarts.js"></script>

</head>

<body>

<div  id="main" style="width:1500px; height: 800px;"></div>
<script src="${pageContext.request.contextPath}/jsp/Visualization/js/statistical_changdi_zongyingli.js"></script>

</body>
</html>
