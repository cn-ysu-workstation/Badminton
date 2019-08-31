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

	<link rel="stylesheet" type="text/css" href="css/appraisal.css" >

  </head>
  
  <body>
        <div id="area">
            <%--场地:--%><img src="http://47.98.40.227:81/${areaFirstPic}" id="areaPic" style="max-width:1000px;"/>
        </div>
      <div id="container">
          <form id="form1" action="${pageContext.request.contextPath}/appr/insertAppr" method="post" enctype="multipart/form-data"></form>
          <ul>
<%--              <li>商品名称：<input form="form1" type="text" name="name" /></li>--%>
              <li>
                  评价种类:好评:<input form="form1" type="radio" name="appStatus" value="1" id="good"/>
                  差评:<input form="form1" type="radio" name="appStatus" value="0" id="bad"/>
              </li>
              <li>评价内容：<textarea form="form1" name="info"></textarea></li>

               <li>评价图片1：<input form="form1" type="file" name="file1"  accept='image/*' onchange='openFile(event)' /></li>
    <li>评价图片2：<input form="form1" type="file" name="file2"  accept='image/*' onchange='openFile2(event)' /></li>
    <li>评价图片3：<input form="form1" type="file" name="file3" <%--id="uploadfile"--%> accept='image/*' onchange='openFile3(event)' /></li>
    <li><input form="form1" type="submit" value="发表" /></li>
          </ul>
          <!--测试时的删除按钮-->
<%--          <form id="form2" action="${pageContext.request.contextPath}/appr/delAppr" method="post"  hidden></form>--%>
<%--          <input type="submit" value="删除" form="form2"/>--%>
          <!--测试时的查找按钮-->
          <%--          <form id="form2" action="${pageContext.request.contextPath}/appr/selectAppr" method="post" ></form>--%>
          <%--          <input type="submit" value="查找" form="form2"/>--%>
      </div>
      <div id="firP" class="otherP">
          <label  hidden id="prev1">预览1:</label> <img  id="output" <%--style="display:none"--%> hidden="hidden" style="max-width:300px;" /><br/>
      </div>
      <div id="secP" class="otherP">
          <label  hidden id="prev2">预览2:</label><img  id="output2"  hidden="hidden" style="max-width:300px;"/><br/>
      </div>
      <div class="otherP" id="thiP">
          <label  hidden id="prev3">预览3:</label> <img  id="output3" hidden="hidden" style="max-width:300px;"/>
      </div>


      <script>
          var openFile = function(event) {
              var input = event.target;

              var reader = new FileReader();
              reader.onload = function(){
                  var dataURL = reader.result;
                  document.getElementById('prev1').style.display = 'block';
                  var output = document.getElementById('output');
                  output.style.display = 'block';
                  output.src = dataURL;
              };
              reader.readAsDataURL(input.files[0]);
          };
          var openFile2 = function(event) {
              var input = event.target;

              var reader = new FileReader();
              reader.onload = function(){
                  var dataURL = reader.result;
                  document.getElementById('prev2').style.display = 'block';
                  var output = document.getElementById('output2');
                  output.style.display = 'block';
                  output.src = dataURL;
              };
              reader.readAsDataURL(input.files[0]);
          };
          var openFile3 = function(event) {
              var input = event.target;

              var reader = new FileReader();
              reader.onload = function(){
                  var dataURL = reader.result;
                  document.getElementById('prev3').style.display = 'block';
                  var output = document.getElementById('output3');
                  output.style.display = 'block';
                  output.src = dataURL;
              };
              reader.readAsDataURL(input.files[0]);
          };
      </script>
  </body>
</html>
