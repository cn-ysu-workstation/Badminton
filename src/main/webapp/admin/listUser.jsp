<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2018/12/10
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/admin/adminHeader.jsp"%>
<%@ include file="../include/admin/adminNavigator.jsp"%>



<title>用户管理</title>

<div class="workingArea">
    <h1 class="label label-info">用户管理</h1>

    <br>
    <br>

    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover table-condensed">
            <thead>
                <tr class="success">
                    <th>用户名</th>
                    <th>密码</th>
                    <th>昵称</th>
                    <th>性别</th>
                    <th>电话</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach items="${pageBean.beanList }" var="userList">
                  <c:if test="${userList.delStatus eq 0}">
                    <tr>
                        <td><p class="username" contenteditable>${userList.username}</p></td>
                        <td><p class="password"contenteditable>${userList.password}</p></td>
                        <td><p class="name"contenteditable>${userList.name}</p></td>
                        <td>
                          <select class="sex" name="sex">
                            <c:if test="${userList.sex == 0}">
                              <option value="0" selected>男</option>
                              <option value="1">女</option>
                            </c:if>
                            <c:if test="${userList.sex == 1}">
                              <option value="0" >男</option>
                              <option value="1" selected>女</option>
                            </c:if>
                          </select>
                        </td>


                        <%-- <c:if test="${userList.sex == 0}">
                          <td>男</td>
                        </c:if>
                        <c:if test="${userList.sex == 1}">
                          <td>女</td>
                        </c:if> --%>

                        <td><p class="phonenumber"contenteditable>${userList.phonenumber}</p></td>

                        <%-- <c:if test="${userList.priceStatus == 0}">
                          <td>普通会员</td>
                        </c:if>
                        <c:if test="${userList.priceStatus == 1}">
                          <td>高级会员</td>
                        </c:if> --%>

                        <td>
                          <select class="priceStatus" name="priceStatus">
                            <c:if test="${userList.priceStatus == 0}">
                              <option value="0" selected>普通会员</option>
                              <option value="1">高级会员</option>
                            </c:if>
                            <c:if test="${userList.priceStatus == 1}">
                              <option value="0" >普通会员</option>
                              <option value="1" selected>高级会员</option>
                            </c:if>
                          </select>
                        </td>

                        <th>
                          <a href="${pageContext.request.contextPath}/Administrator/deleteUser?userId=${userList.userId}" >删除</a>
                          <a href="#" id="${userList.userId}" class="updateBtn">修改</a>
                      </th>
                    </tr>
                  </c:if>
                </c:forEach>
                <tr>
                  <td colspan="7">
                      <%@include file="../include/admin/adminUserPage.jsp"%>
                  </td>
                </tr>
            </tbody>

        </table>
    </div>
<%-- 引入jQuery --%>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
    $(".updateBtn").click(function(){
      var userId = $(this).attr("id");
      var username = $(this).parent().parent().find(".username").text();
      var password = $(this).parent().parent().find(".password").text();
      var name = $(this).parent().parent().find(".name").text();
      var sex = $(this).parent().parent().find(".sex").val();
      var phonenumber = $(this).parent().parent().find(".phonenumber").text();
      var priceStatus = $(this).parent().parent().find(".priceStatus").val();
      $.ajax({
             type: 'get',
             url: '${pageContext.request.contextPath}/Administrator/updateUser',
             contentType: 'application/json;charset=utf-8',
             traditional: true,
              dataType: 'json',
              data:{
                      'userId':userId,
                      'username':username,
                      'password':password,
                      'name':name,
                      'sex':sex,
                      'phonenumber':phonenumber,
                      'priceStatus':priceStatus
                 },
             success: function (data) { //返回json结果

             },
            error:function(jqXHR){
              if (jqXHR.status=='200') {
                alert("修改成功!");
              }
              else {
                alert("Error: "+jqXHR.status);
              }
            }
           });
    })
  })
</script>

</div>
<%@include file="../include/admin/adminFooter.jsp"%>
