<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/24
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/fore/foreHeader.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fore/introduce.css">
</head>

<%@ include file="include/fore/foreNavigator.jsp" %>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>

<title>场地介绍</title>
<script>

    $(document).ready(function () {

        $.ajax({
            type: 'post',
            url: 'user/searchAreaDetail',
            data: 'areaId=1',
        })

    }) </script>

<%--        // <!-- tab标签开始 -->--%>
<div id="wrapper" style="margin-top: 20px">


    <div class="sub-nav" id="sub-nav">
        <dl style="background-color: #fff;">
            <dt>全部场地</dt>
            <c:forEach items="${areaList}" var="p" varStatus="index">
                <dd style="background-color: #fff; border-bottom: 1px solid #ddd">
<%--                <a onclick="changeBack(this)" id="${p.areaname}" style="background-color: #fff;">${p.areaname}</a>--%>
                   <a href="${pageContext.request.contextPath}/user/searchAreaDetail?areaId=${p.areaId}">${p.areaname}</a>
                </dd>

            </c:forEach>
        </dl>
        <div class="img-box">
            <img src="${pageContext.request.contextPath}/image/fore/sub-img.jpg" width="178" height="300"/>
        </div>
    </div>
    <div class="sub-content-con">
        <div class="position-bar">
            当前位置：场地介绍
        </div>

        <div class="list-content">
            <div style="width: 100%; height: 230px; display:block; background-color: #fff;" id="${area.areaId}">

                <div class="img-box" style="background-color: #fff;padding-left: 10px;padding-top: 15px;display: inline; float: left;">
                    <c:forEach items="${area.areapicList}" var="pic">
                    <img src="http://47.98.40.227:81/${pic.pic}" style="width:440px ;height:272px;float: left"/>
                    </c:forEach>
                </div>

                <div style="width: 400px;margin:20px;padding-top:13px;float:left;background-color: #fff;">
                    <p style="background-color: #fff;"><a href="${pageContext.request.contextPath}/user/findAreaAppraisal?areaId=${area.areaId}">场地名称：&nbsp;${area.areaname}</a></p>
                    <p style="background-color: #fff;">场地英文名：&nbsp;${area.des}</p>
                    <p style="background-color: #fff;">场地地点: &nbsp;${area.address}</p>
                    <p style="background-color: #fff;">场地介绍：&nbsp;${area.des}</p>
                    <p style="background-color: #fff;">场地价格(元/小时)：&nbsp;${area.price}</p>
                    <p><h3>好评率：${area.goodRate}%</h3></p>
                </div>
            </div>
        </div>
    </div>

    <!-- tab标签结束 -->

</div>

</div>
</div>
<%--<script>--%>
<%--    var k = document.getElementById("${placeList[0].name}");--%>
<%--    k.style.backgroundColor = "#007bff";--%>
<%--    k.style.color = "white";--%>
<%--    document.getElementById(k.id.toString() + "place").style.display = "";--%>

<%--    function changeBack(id) {--%>
<%--        var tmp = document.getElementById("sub-nav").getElementsByTagName("a");--%>
<%--        for (var i = 0; i < tmp.length; i++) {--%>
<%--            tmp[i].style.color = "";--%>
<%--            tmp[i].style.backgroundColor = "";--%>
<%--            document.getElementById(tmp[i].id.toString() + "place").style.display = "none";--%>
<%--        }--%>
<%--        id.style.display = "";--%>
<%--        id.style.color = "white";--%>
<%--        id.style.backgroundColor = "#007bff";--%>
<%--        document.getElementById(id.id.toString() + "place").style.display = "";--%>
<%--    }--%>
<%--</script>--%>

<%@include file="include/fore/foreFooter.jsp" %>

