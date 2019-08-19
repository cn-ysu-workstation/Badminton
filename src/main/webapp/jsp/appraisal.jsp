<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
      <div id="container">
          <form id="form1" action="<c:url value="/appr/insertInto"/>" method="post" ></form>
          <ul>
<%--              <li>商品名称：<input form="form1" type="text" name="name" /></li>--%>
              <li>
                  评价种类:好评:<input form="form1" type="radio" name="appStatus" value="0" id="good"/>
                  差评:<input form="form1" type="radio" name="appStatus" value="1" id="bad"/>
              </li>
              <li>评价内容：<textarea form="form1" name="info"></textarea></li>
              <li><input form="form1" type="submit" value="发布" /></li>
          </ul>
      </div>
  </body>
</html>
