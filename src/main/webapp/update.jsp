<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
		<%--<script type="text/javascript">--%>
			<%--$(function () {--%>
				<%--$("[value='删除']").click(function () {--%>
					<%--alert("hhhh")--%>
					<%--var val1 = $(["name='aid'"]).val();--%>

					<%--location.href="air?method=deleteair&aid="+val1;--%>
				<%--})--%>
			<%--})--%>
		<%--</script>--%>
		<style type="text/css">
			div{
				width: 600px;
				margin: 0px auto;
			}
		</style>
	</head>
	<body>
		<div>
		<h1>空气质量信息维护页面</h1>
			<form action="updateair" method="post">
				<input type="hidden" name="id" value="${air.id}">
		<table>
		<tr><td>监测区域:</td><td>
			<select name="districtId">

			<c:forEach items="${dlist}" var="d">
				<option value="${d.id}" ${d.id==air.district.id?"selected":""}>${d.name}</option>
			</c:forEach>
			</select>
		</td></tr>
		<tr><td>检测日期:</td><td><input type="text" name="monitorTime" value="${air.monitorTime}" /></td></tr>
		<tr><td>PM10值:</td><td><input type="text" name="pm10" value="${air.pm10}" /></td></tr>
		<tr><td>PM2.5值:</td><td><input type="text"  name="pm25" value="${air.pm25}"/></td></tr>
		<tr><td>监测站:</td><td><input type="text" name="monitoring"  value="${air.monitoring}"/></td></tr>
		<tr><td>最后修改日期:<fmt:formatDate value="${air.lastModifyTime}" pattern="yyyy-MM-dd hh:mm:ss" ></fmt:formatDate></td></tr>
		</table>
		<p>
			<input type="submit" value="更新"/>
			<input type="button" onclick="javascript:location.href='deleteair?aid=${air.id}'" value="删除"/>
			<input type="button" onclick="javascript:history.go(-1)" value="返回"/>
		</p>
			</form>
		</div>
	</body>
</html>
