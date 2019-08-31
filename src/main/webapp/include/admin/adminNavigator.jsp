<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>
<style media="screen">
	.jumpIt{
		border: 0;
		font-weight: 400;
		font-size: 18px;
	}
	.jumpIt:hover{
		text-decoration: underline;
		cursor: pointer;
	}
</style>
<div class="header-area" style="background-color: #f0f0f0; height: 55px">
	<div class="container h-100">
		<div class="h-100 d-flex justify-content-between align-items-center">
			<div class="p-2">
				<a href="#"><img src="${pageContext.request.contextPath}/image/fore/logo.jpg" width="275"></a>
				<a href="${pageContext.request.contextPath}/jump/ToHome" style="float: right;color: #666; text-decoration: none;font-size: 14px;font-weight: 400;margin: 20px">退出</a>
			</div>
		</div>
	</div>
</div>

<div id="nav-main">
	<ul class="nav-inner-box">
		<li><a id="home.jsp" href="${pageContext.request.contextPath}/Administrator/findAllAreas" style="font-weight: 400">场馆管理</a></li>
		<li><a id="introduce.jsp" href="${pageContext.request.contextPath}/Administrator/findAllUsers" style="font-weight: 400">用户管理</a></li>
		<li><a id="book.jsp" href="${pageContext.request.contextPath}/Administrator/searchAllReservation" style="font-weight: 400">预约审核</a></li>
        <li><a id="camera" href="${pageContext.request.contextPath}/Administrator/seeArea" style="font-weight: 400">调取监控</a></li>
        <li style="margin-top: 1px;">
			<select class="jumpIt" id="jumpIt" name="jumpIt">
				<option value="no" >查看统计信息</option>
				<option value="toStatisticalResults_area">某天场地营业情况</option>
				<option value="toStatisticalResults_allTimeBymonth">某月场地营业情况</option>
				<option value="toStatisticalResults">各个场地营业/盈利情况【按日期排序】</option>
				<option value="toStatisticalResults_changdi">各个场地营业/盈利情况【按场地排序】</option>
				<option value="toStatisticalResults_changdi_zongyingli">场地总营业/盈利情况</option>
			</select>
		</li>
	</ul>
	<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript">


		$("#jumpIt").change(function(){
			if ($(this).val()!='no') {
				window.open('${pageContext.request.contextPath}/Administrator/'+$(this).val())
			}

		})
	</script>
</div>
