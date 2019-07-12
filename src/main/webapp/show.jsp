<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	    <script type="text/javascript">
	    	$(function(){
	    		$("tr:odd").css("background-color","red");
	    		$("tr:even").css("background-color","blue");
	    	})
	    </script>
	    <style type="text/css">
	    	div{
	    		width: 600px;
	    		margin: 0px auto;
	    	}
	    </style>
	</head>
	<body>
	<div>
	<h1>空气质量检测信息库</h1>
	<form method="post" action="getairquality">

	<p>按区域查询
	<select name="disid">
		<option value="-1">请选择</option>
		<c:forEach items="${dlist}" var="dis">
		<option value="${dis.id}" ${dis.id==disid?'selected':''}>${dis.name}</option>
		</c:forEach>
	</select>
		<input type="submit" value="查找" />

	<a href="findalldis">添加空气质量</a></p>
	</form>

	<table border="solid">
	<tr>
	<td>序号</td>
	<td>区域</td>
	<td>检测时间</td>
	<td>PM10数据</td>
	<td>PM2.5数据</td>
	<td>监测站</td>
	</tr>
		<c:forEach items="${pi.list}" var="air" varStatus="a">
	<tr>
	<td>${a.count}</td>
		<td> <a href="findbyaid?aid=${air.id}">${air.district.name}</a></td>
        <%--<td>${air.monitorTime}</td>--%>

        <td><fmt:formatDate value="${air.monitorTime}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate></td>
	<td>${air.pm10}</td>
	<td>${air.pm25}</td>
	<td>${air.monitoring}</td>
	</tr>
		</c:forEach >
		<tr>
			<td colspan="6">
				<a href="getairquality?disid=${disid}">首页</a>&nbsp;&nbsp;
				<a href="getairquality?disid=${disid}&index=${pi.prePage==0?1:pi.prePage}">上一页</a>&nbsp;&nbsp;
				<a href="getairquality?disid=${disid}&index=${pi.nextPage==pi.pages?pi.pages:pi.nextPage}">下一页</a>&nbsp;&nbsp;
				<a  href="getairquality?disid=${disid}&index=${pi.pages}">尾页</a>&nbsp;&nbsp;
				第${pi.pageNum}页 /共${pi.pages}页 &nbsp;&nbsp;${pi.total}条
			</td>

		</tr>

	</table>
	</div>
	</body> 
</html>
