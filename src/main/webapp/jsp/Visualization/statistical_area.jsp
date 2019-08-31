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
    <style media="screen">
        #main{
            padding-top:100px;
            padding-bottom:100px;
            margin: auto;
            width: 1300px;
        }
        .timeShowClass{
            width: 50px;
            height: 50px;
            background-color: gray;
            color: black;
            font-size: 15px;
            font-weight: bold;
            text-align: left;
            line-height: 50px;
            display: inline-block;
            border-left: solid white 1px;
        }
        .yingyeClass{

            width: 50px;
            height: 50px;
            background-color: rgb(106, 176, 184);
            color: black;
            font-size: 15px;
            font-weight: bold;
            text-align: left;
            line-height: 50px;
            display: inline-block;
            border-left: solid white 1px;
        }
        #tip{
            display: none;
            width: 201px;
            margin: auto;
        }
    </style>
</head>

<body onload="">
<center>
    <select class="" name="chooseData">
        <option value="" selected>请选择日期</option>
    </select>
    <select class="" name="chooseArea">
    </select>
    <input type="button" id="showChart" name="" value="显示">

</center>
<div  id="main" >

</div>
<div id="tip">
    <div class="timeShowClass">

    </div>
    非营业
    <div class="yingyeClass">

    </div>
    营业
</div>

<script src="${pageContext.request.contextPath}/jsp/Visualization/js/statistical_area.js"></script>
<script type="text/javascript">

</script>
</body>
</html>
