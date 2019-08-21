<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
          <form id="form1" action="${pageContext.request.contextPath}/appr/updateAppr" method="post" enctype="multipart/form-data"></form>
          <ul>
<%--              <li>商品名称：<input form="form1" type="text" name="name" /></li>--%>
              <li>
                  评价种类:好评:<input form="form1" type="radio" name="appStatus" value="0" id="good"/>
                  差评:<input form="form1" type="radio" name="appStatus" value="1" id="bad"/>
              </li>
              <li>评价内容：<textarea form="form1" name="info"></textarea></li>

               <li>评价图片1：<input form="form1" type="file" name="file1"  accept='image/*' onchange='openFile(event)' /></li>
    <li>评价图片2：<input form="form1" type="file" name="file2"  accept='image/*' onchange='openFile2(event)' /></li>
    <li>评价图片3：<input form="form1" type="file" name="file3" <%--id="uploadfile"--%> accept='image/*' onchange='openFile3(event)' /></li>
    <li><input form="form1" type="submit" value="发表" /></li>
          </ul>
          <form id="form2" action="${pageContext.request.contextPath}/appr/selectAppr" method="post" ></form>
          <input type="submit" value="查找" form="form2"/>
    预览1:<img  id="output" />
    预览2:<img  id="output2" />
    预览3:<img  id="output3" />



      </div>

      <script>
          var openFile = function(event) {
              var input = event.target;

              var reader = new FileReader();
              reader.onload = function(){
                  var dataURL = reader.result;
                  var output = document.getElementById('output');
                  output.src = dataURL;
              };
              reader.readAsDataURL(input.files[0]);
          };
          var openFile2 = function(event) {
              var input = event.target;

              var reader = new FileReader();
              reader.onload = function(){
                  var dataURL = reader.result;
                  var output = document.getElementById('output2');
                  output.src = dataURL;
              };
              reader.readAsDataURL(input.files[0]);
          };
          var openFile3 = function(event) {
              var input = event.target;

              var reader = new FileReader();
              reader.onload = function(){
                  var dataURL = reader.result;
                  var output = document.getElementById('output3');
                  output.src = dataURL;
              };
              reader.readAsDataURL(input.files[0]);
          };
      </script>
  </body>
</html>
