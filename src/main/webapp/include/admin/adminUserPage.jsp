<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/include/admin/adminUserPage.css">
<!-- 分页 -->
<div class="htmleaf-content" style="position: relative;padding:5px;">
	共${pageBean.info.total}条记录，当前显示第&nbsp;${pageBean.info.pageNum}/${pageBean.info.pages}&nbsp;页
    <ul class="manu" style="position:absolute;right:0px;top:0px;">
        <c:if test="${!pageBean.info.isFirstPage}">
            <li><a href="${pageContext.request.contextPath}/Administrator/findAllUsers?pc=1${pageBean.url}">首页</a></li>
            <li><a href="${pageContext.request.contextPath}/Administrator/findAllUsers?pc=1${pageBean.url}">上一页</a></li>
        </c:if>
        <c:forEach items="${pageBean.info.navigatepageNums}" var="navigatepageNum">
            <c:if test="${navigatepageNum==pageBean.info.pageNum}">
                <li class="active"><a href="${pageContext.request.contextPath}/Administrator/findAllUsers?pc=${navigatepageNum}${pageBean.url}">${navigatepageNum}</a></li>
            </c:if>
            <c:if test="${navigatepageNum!=pageBean.info.pageNum}">
                <li><a href="${pageContext.request.contextPath}/Administrator/findAllUsers?pc=${navigatepageNum}${pageBean.url}">${navigatepageNum}</a></li>
            </c:if>
        </c:forEach>
        <c:if test="${!pageBean.info.isLastPage}">
            <li><a href="${pageContext.request.contextPath}/Administrator/findAllUsers?pc=${pageBean.info.nextPage}${pageBean.url}">下一页</a></li>
            <li><a href="${pageContext.request.contextPath}/Administrator/findAllUsers?pc=${pageBean.info.lastPage}${pageBean.url}">最后一页</a></li>
        </c:if>
    </ul>
</div>
