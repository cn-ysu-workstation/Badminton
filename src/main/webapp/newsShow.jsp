<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/24
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/fore/foreHeader.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fore/news.css">
</head>
<%@ include file="include/fore/foreNavigator.jsp"%>
<title>${news.title}</title>
<!-- tab标签开始 -->
<div id="wrapper" style="margin-top: 20px">


    <div class="sub-content" style="margin: 20px 0; font-size: small">
        <div class="position-bar">
            当前位置：<a href="#">场地通知</a>&nbsp;>&nbsp;
        </div>

        <div style="text-indent: 2em; margin: 40px">
            <p style="text-align: center">
                <strong>
                    <span style="font-size: 24px;">通知</span>
                </strong>
            </p>
            <p><br/></p>
            <p><span style="font-size: 20px">各位羽毛球爱好、小区居住者：<br/></span></p>
            <p><span style="font-size: 20px">&nbsp;为进一步丰富居民文体生活，我馆于本周为增强羽毛球健身活动，
                时间、地点定于每周日上午8:30-11:30在福州市体育馆羽毛球馆5号场内，
                请广大羽毛球爱好者相互转告，踊跃参与。
            </span></p>
            <p><br/></p>
            <p><br/></p>
            <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;${news.TIME}</p>
        </div>

    </div>

    <!-- tab标签结束 -->

</div>



</div>
<%@include file="include/fore/foreFooter.jsp"%>


