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

<div class="leftMin" style="display:inline-block;float:left;">
  <img id="pageleft"src="${pageContext.request.contextPath}/jsp/Visualization/imgs/left.png" alt="上个月">
</div>
<div class="center" style="display:inline-block">
  <center >
    <select class="selectedMonth" name="month">
        <option value="12">十二月份</option>
        <option value="11">十一份</option>
        <option value="10">十月份</option>
        <option value="09">九月份</option>
        <option value="08" selected>八月份</option>
        <option value="07">七月份</option>
        <option value="06">六月份</option>
        <option value="05">五月份</option>
        <option value="04">四月份</option>
        <option value="03">三月份</option>
        <option value="02">二月份</option>
        <option value="01">一月份</option>
    </select>
    <input  id="showGraph" type="button" name="showGraph" value="查找">
  </center>
  <div  id="main" style="width:800px; height: 700px;display:inline-block;">

  </div>
</div>

<div class="rightMin" style="display:inline-block;float:right;">
  <img id="pageright"src="${pageContext.request.contextPath}/jsp/Visualization/imgs/right.png" alt="下个月">
</div>
<script src="${pageContext.request.contextPath}/jsp/Visualization/js/statistical_allTimeBymonth.js"></script>
</body>
</html>
