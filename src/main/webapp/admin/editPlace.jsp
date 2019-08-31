<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/11
  Time: 23:36
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
            if (!checkEmpty("ename", "场馆英文名称"))
                return false;
            if (!checkEmpty("location", "场馆地址"))
                return false;
            if (!checkEmpty("introduction", "场馆介绍"))
                return false;
            return true;
        });
    });

</script>


<div class="workingArea">

    <ol class="breadcrumb">
        <li><a href="admin_place_list">场地管理</a></li>
        <li><a href="admin_place_edit?id=${place.id}">${place.name}</a></li>
        <li class="active">信息编辑</li>
    </ol>

    <div class="panel panel-warning addDiv">
        <div class="panel-heading">场馆信息编辑</div>
        <div class="panel-body">
            <form method="post" id="addForm" action="<c:url value="/Administrator/updateArea"/>" enctype="multipart/form-data">
                <table class="addTable">
                    <c:forEach items="${areaList}" var="area" varStatus="status">
                        <input type="hidden" name="areaList[${status.index}].areaId" value="${area.areaId }" />
                        <tr>
                            <td>场地名称</td>
                            <td><input id="areaname" name="areaList[${status.index}].areaname" type="text" class="form-control" value="${area.areaname }"/></td>
                        </tr>
                        <tr>
                            <td>场地价格</td>
                            <td>
                                <input id="price" name="areaList[${status.index}].price" value="${area.price}" type="text" placeholder="请输入价钱数值，如20元，输入20即可" class="form-control"/>
                            </td>
                        </tr>
                        <tr>
                            <td>场地地址</td>
                            <td>
                                <input id="address" name="areaList[${status.index}].address" value="${area.address }" type="text" class="form-control" />
                            </td>
                        </tr>
                        <tr>
                            <td>场地简介</td>
                            <td>
                                <textarea id="des" name="areaList[${status.index}].des" class="form-control">${area.des }</textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>开始营业(点)</td>
                            <td>
                                    <input id="starttime" name="areaList[${status.index}].starttime" value="${area.starttime }" type="text" class="form-control" />
                            </td>
                        </tr>
                        <tr>
                            <td>结束营业(点)</td>
                            <td>
                                    <input id="stoptime" name="areaList[${status.index}].stoptime" value="${area.stoptime }" type="text" class="form-control" />
                            </td>
                        </tr>
                        <tr>
                            <td>场地图片</td>
                            <td>
                                <input id="placePic" accept="image/*" multiple type="file" name="fileList" />
                            </td>
                        </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">提交</button>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </form>
        </div>
    </div>
</div>

<%@ include file="../include/admin/adminFooter.jsp"%>
