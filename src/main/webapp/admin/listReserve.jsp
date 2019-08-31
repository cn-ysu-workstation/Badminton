<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/27
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/admin/adminHeader.jsp"%>
<%@ include file="../include/admin/adminNavigator.jsp"%>
<style media="screen">
  .green{
    color: green;
    font-weight: bold;
  }
  .orange{
    color: orange;
    font-weight: bold;
  }
  .red{
    color: red;
    font-weight: bold;
  }
  .nopay{
    color: lightskyblue;
    font-weight: bold;
  }
  .orderListItemTable tr:hover
  {
    background-color: gray;
    cursor: pointer;
  }
</style>
<title>预约审核</title>
<div class="workingArea">
    <div style="padding: 12px;">
        <div >
            <!--总表头部-->
            <table class="orderListItemTable">
                <tr>
                    <td width="80px">用户</td>
                    <td width="150px">场地</td>
                    <td width="150px">预约日期</td>
                    <td width="150px">预约时间</td>
                    <td width="100px">订单编号</td>
                    <td width="100px">状态</td>
                    <td width="100px">操作</td>
                </tr>
            </table>


            <%-- <c:forEach items="${reserveList}" var="r"> --%>
                <table class="orderListItemTable" >

                    <%-- <!--订单头-->
                    <tr class="orderListItemFirstTR">
                        <td colspan="2" style="text-align: left; padding-left: 20px; box-sizing: border-box">
                            <b><fmt:formatDate value="${r.time}" pattern="yyyy-MM-dd HH:mm:ss" /> </b>
                            <span style="background-color: #f0f0f0">订单号：${r.id}</span>
                        </td>
                        <td colspan="3"></td>
                    </tr> --%>

                    <!--订单内容-->

                    <c:forEach items="${reservationCustomList}" var="reservation" varStatus="st">
                        <tr class="orderItemTR">
                            <!--用户名-->

                            <td valign="center"  class="orderListItemNumberTD orderItemOrderInfoPartTD" width="80px" >
                                <span class="orderListItemNumber">${reservation.user.username}</span>
                            </td>

                            <!--场地名-->
                            <td class="orderItemProductInfoPartTD" width="150px">${reservation.area.areaname}</td>
                            <%--预约日期--%>


                            <td class="orderItemProductInfoPartTD" width="150px"><fmt:formatDate value="${reservation.preDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                            <!--时间-->
                            <td class="orderItemProductInfoPartTD" width="150px">${reservation.starttime}点~${reservation.stoptime}点</td>
                            <!--订单编号-->
                            <td class="orderItemProductInfoPartTD" width="100px">${reservation.reservationId}</td>
                            <!--状态和操作-->
                            <%-- <c:if test="${st.count == 1}"> --%>
                            <td valign="center" class="orderListItemNumberTD orderItemOrderInfoPartTD" width="100px">

                                <c:if test="${reservation.preStatus eq 0}">
                                    <span class="orange">待审核</span>
                                </c:if>
                                <c:if test="${reservation.preStatus eq 1}">
                                    <span class="nopay">审核通过(未付款)</span>
                                </c:if>
                                <c:if test="${reservation.preStatus eq 2}">
                                    <span class="green">审核通过(已付款)</span>
                                </c:if>
                                <c:if test="${reservation.preStatus eq -1}">
                                    <span class="red">审核未通过</span>
                                </c:if>
                            </td>

                            <td valign="center"  class="orderListItemNumberTD orderItemOrderInfoPartTD" width="100px">
                                <span>
                                  <c:if test="${reservation.preStatus eq -1}">
                                    <a href="${pageContext.request.contextPath}/Administrator/examineReservation?reservationId=${reservation.reservationId}" ><span class="orderListItemDelete glyphicon glyphicon-ok">通过</span></a>
                                  </c:if>
                                  <c:if test="${reservation.preStatus eq 0}">
                                    <a href="${pageContext.request.contextPath}/Administrator/examineReservation?reservationId=${reservation.reservationId}" ><span class="orderListItemDelete glyphicon glyphicon-ok">通过</span></a>
                                  </c:if>
                                <c:if test="${reservation.preStatus != -1}">
                                <a href="${pageContext.request.contextPath}/Administrator/rejectReservation?reservationId=${reservation.reservationId}" ><span class="orderListItemDelete glyphicon glyphicon-remove">驳回</span></a>
                                </c:if>
                                </span>
                            </td>


                            <%-- </c:if> --%>
                        </tr>
                    </c:forEach>

                </table>
            <%-- </c:forEach> --%>

        </div>
    </div>
    <div class="pageDiv">
        <%--<%@include file="../include/admin/adminPlacePage.jsp"%>--%>
    </div>
</div>

<%@include file="../include/admin/adminFooter.jsp"%>
