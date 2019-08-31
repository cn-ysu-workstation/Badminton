<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/22
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/fore/foreHeader.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fore/home.css">
<style>
/*div开始*/
.index-cg-menu{
width:47%;
float:left;
}

.index-notice-menu{
width:47%;
float:right;
}

.index-cg-header{
font-size: 15px;
width: 100%;
height: 40px;
line-height: 50px;
border-bottom: 2px solid #3398ff;
color: #3398ff;
background-color: #f0f0f0;
font-weight: bold;
}

.index-neirong{
background-color: #fff;
padding: 1%;
min-height: 200px;
}

.index-cg-item{
height: 34px;
line-height: 34px;
clear: both;
margin-left: 20px;
border-bottom: 1px dashed #ced8df;
}
</style>
</head>
<%@ include file="include/fore/foreNavigator.jsp"%>
<title>主页</title>


            <div id="gym" class="carousel slide" data-ride="carousel" data-interval="2000">
                <ul class="carousel-indicators">
                    <li data-target="#gym" data-slide-to="0" class="active"></li>
                    <li data-target="#gym" data-slide-to="1"></li>
                    <li data-target="#gym" data-slide-to="2"></li>
                </ul>

                <div class="carousel-inner" data-interval="100">
                    <div class="carousel-item active" style="height: 500px">
                        <img src="${pageContext.request.contextPath}/image/fore/2.jpg" style="width: 100%; height: 100%">
                    </div>
                    <div class="carousel-item" style="height: 500px">
                        <img src="${pageContext.request.contextPath}/image/fore/3.jpg" style="width: 100%; height: 100%">
                    </div>
                    <div class="carousel-item" style="height: 500px">
                        <img src="${pageContext.request.contextPath}/image/fore/4.jpg" style="width: 100%; height: 500px">
                    </div>
                </div>

                <a class="carousel-control-prev" href="#gym" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#gym" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>
            </div>

            <!-- 轮播结束 -->

            <div style="height:45px; border: 1px solid #ddd; background-color: white;margin: 0 auto">
                <marquee behavior="scroll" align="absmiddle" class="marquee-style" style="width: 100%">
                    <p><span class="time">消息通知:</span>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <span class="time">由于近期人流量较多，本场馆决定延长闭馆时间</span>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <span class="time">欢迎大家的到来</span></p>
                    <a href="#" style="font-size:16px;cursor: pointer">
                        <b><span class="time" >${p.areaname}&nbsp;&nbsp;</span>${p.address}</b>
                    </a>
                </marquee>
            </div>
            <!-- 滚动通知结束 -->
            <div style="height: 250px;width: 100%; background-color: #f0f0f0">

                    <div class="index-cg-menu">
                        <div class="index-cg-header">场地</div>
                        <div class="index-neirong">
                            <c:forEach items="${areaList}" var="p">
                                <div class="index-cg-item"><span style="color: #00AAEE">>>&nbsp;&nbsp;</span><a href="${pageContext.request.contextPath}/jump/ToIntroduce" style="color: #666;">${p.areaname}</a></div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="index-notice-menu">
                        <div class="index-cg-header">通知</div>
                        <div class="index-neirong">

                                <div class="index-cg-item"><span style="color: #00AAEE">>>&nbsp;通知：</span></div>
                            <div><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;各位羽毛球爱好、小区居住者：
                                为进一步丰富居民文体生活，我馆于本周为增强羽毛球健身活动， 时间、地点定于每周日上午8:30-11:30在福州市体育馆羽毛球馆5号场内，
                                请广大羽毛球爱好者相互转告，踊跃参与。</p></div>
                        </div>
                    </div>

            </div>

    </div>
</div>
<%@include file="include/fore/foreFooter.jsp"%>

