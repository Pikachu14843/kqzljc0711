<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript"></script>
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			$(function () {
				$("[value='重置']").click(function () {
					location.href="findalldis";
				})
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

		<h1>添加空气质量信息</h1>
            <form method="get" action="insertair" >

                <table>
                <tr><td>监测区域:</td><td>

                    <select name="districtId">
                        <c:forEach items="${dlist}" var="dl">
                            <option value="${dl.id}">${dl.name}</option>
                        </c:forEach>
                    </select>
                </td></tr>
                <tr><td>检测日期:</td><td><input type="text" name="monitorTime"/></td></tr>
                <tr><td>PM10值:</td><td><input type="text" name="pm10"/></td></tr>
                <tr><td>PM2.5值:</td><td><input type="text" name="pm25" /></td></tr>
                <tr><td>监测站:</td><td><input type="text" name="monitoring"/></td></tr>

                </table>
                <p>
                    <input type="submit" value="保存" />
                    <input type="button" value="重置" />
                    <input type="button" onclick="javascript:history.go(-1)" value="返回" />
                </p>
			</form>

		</div>
	</body>
</html>
