<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/11
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../include/admin/adminHeader.jsp"%>
<%@ include file="../include/admin/adminNavigator.jsp"%>

<script>
$(function () {
    $("#addForm").submit(function () {
        if (!checkEmpty("name", "场馆名称"))
            return false;
        if (!checkEmpty("location", "场馆地址"))
            return false;
        if (!checkEmpty("introduction", "场馆介绍"))
            return false;
        if (!checkEmpty("placePic", "场馆图片"))
            return false;
        return true;
    });
});
function showNumber(obj) {
    var nuber = document.getElementById(obj.id).value;
    document.getElementById(obj.id+"Number").innerHTML = nuber;
}
</script>

<title>场馆管理</title>

<div class="workingArea">
    <h1 class="label label-info">场馆管理</h1>
    <br>
    <br>

    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover table-condensed">
            <thead>
                <tr class="success">
                    <th>ID</th>
                    <th>场地名称</th>
                    <th>场地图片</th>
                    <th>场地开始营业时间</th>
                    <th>场地结束营业时间</th>
                    <th>场地信息</th>
                    <th>场地价格(元/小时)</th>
                    <th>场地地址</th>
                    <th>场地评价</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${pageBean.beanList }" var="area">
                    <tr>
                        <td>${area.areaId}</td>
                        <td>${area.areaname}</td>
                        <%--<td><img height="20px" src=""></td>--%>
                        <td>
                        <c:forEach items="${area.areapicList}" var="areapic">
                            <img height="20px" src="http://47.98.40.227:81/${areapic.pic}">
                        </c:forEach>
                        </td>
                        <td>${area.starttime}</td>
                        <td>${area.stoptime}</td>
                        <td>${area.des}</td>
                        <td>${area.price}</td>
                        <td>${area.address}</td>
                        <td>   <a href="<c:url value="/Administrator/findAppraisal"/>?area_id=${area.areaId}">查看</a>
                            </td>
                        <td>
                            <a href="<c:url value="/Administrator/deleteArea"/>?areaId=${area.areaId}">删除</a>
                            <a href="<c:url value="/Administrator/toUpdateArea"/>?areaId=${area.areaId}">修改</a>

                        </td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="pageDiv">
        <%@ include file="../include/admin/adminPlacePage.jsp" %>
    </div>

    <div class="panel panel-warning addDiv">
        <div class="panel-heading">新增场馆</div>
        <div class="panel-body">
            <form method="post" id="addForm" action="<c:url value="/Administrator/addArea"/>" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <td>场地名称</td>
                        <td><input id="areaname" name="areaname" type="text" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td>场地价格(元/小时)</td>
                        <td>
                            <input id="price" name="price" type="text" placeholder="请输入价钱数值，如20元，输入20即可" class="form-control"/>
                        </td>
                    </tr>
                    <tr>
                        <td>场地地址</td>
                        <td>
                            <input id="address" name="address" type="text" class="form-control" />
                        </td>
                    </tr>
                    <tr>
                        <td>场地简介</td>
                        <td>
                            <textarea id="des" name="des" class="form-control"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>开始营业(点)</td>
                        <td>
                            <%--<input id="starttime" name="starttime" type="text" class="form-control" />--%>
                                <input type="range" id="starttime" name="starttime" onmousemove="showNumber(this)" max="23" min="0" value="8" step="1">

                        </td>
                    <td id="starttimeNumber"></td>
                    </tr>
                    <tr>
                        <td>结束营业(点)</td>
                        <td>
                            <%--<input id="stoptime" name="stoptime" type="text" class="form-control" />--%>
                                <input type="range" id="stoptime" name="stoptime" onmousemove="showNumber(this)" max="23" min="0" value="20" step="1">
                        </td>
                    <td id="stoptimeNumber"></td>
                    </tr>
                    <tr>
                        <td>场地图片</td>
                        <td>
                            <input  id="placePic" accept="image/*" type="file" name="fileList" multiple />
                        </td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">提交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

<%@include file="../include/admin/adminFooter.jsp"%>