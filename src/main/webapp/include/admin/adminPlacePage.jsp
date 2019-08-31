<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

	
<script>
$(function(){
	$("ul.pagination li.disabled a").click(function(){
		return false;
	});
});

</script>

<nav>
  <ul class="pagination">
      <c:if test="${!pageBean.info.isFirstPage}">
          <li><a href="<c:url value="/Administrator/findAllAreas" />?pc=1${pageBean.url}">首页</a></li>
          <li><a href="<c:url value="/Administrator/findAllAreas" />?pc=${pageBean.info.prePage}${pageBean.url}">上一页</a></li>
      </c:if>
      <c:forEach items="${pageBean.info.navigatepageNums}" var="navigatepageNum">
          <c:if test="${navigatepageNum==pageBean.info.pageNum}">
              <li class="active"><a href="<c:url value="/Administrator/findAllAreas" />?pc=${navigatepageNum}${pageBean.url}">${navigatepageNum}</a></li>
          </c:if>
          <c:if test="${navigatepageNum!=pageBean.info.pageNum}">
              <li><a href="<c:url value="/Administrator/findAllAreas" />?pc=${navigatepageNum}${pageBean.url}">${navigatepageNum}</a></li>
          </c:if>
      </c:forEach>
      <c:if test="${!pageBean.info.isLastPage}">
          <li><a href="<c:url value="/Administrator/findAllAreas" />?pc=${pageBean.info.nextPage}${pageBean.url}">下一页</a></li>
          <li><a href="<c:url value="/Administrator/findAllAreas" />?pc=${pageBean.info.lastPage}${pageBean.url}">最后一页</a></li>
      </c:if>
  </ul>
</nav>
