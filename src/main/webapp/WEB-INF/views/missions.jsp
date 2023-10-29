<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- jstl  -->
<!--jstl-- jsp içinde daha az java kodu yazmamızı sağlayan bir yapı -->
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Mission-project</title>

<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style.css?version=1">
</head>
<body>
	<div class="container">
		<h2>Missions</h2>
		<table>

			<tr style="background-color: lightblue">
				<th>ID</th>
				<th>Gorev Adi</th>
				<th>Gorevin Gerektirdikleri</th>
				<th>Gorev Suresi</th>
				<th>Gorev Tarihi</th>
			</tr>

			<c:forEach items="${missionList}" var="mission" varStatus="status">

				<!-- create an "update" link with Mission id -->
				<c:url var="updateLink" value="/missions/update">
					<c:param name="id" value="${mission.id}" />
				</c:url>

				<!-- create an "delete" link with Mission id -->
				<c:url var="deleteLink" value="/missions/delete">
					<c:param name="id" value="${mission.id}" />
				</c:url>

				<tr
					style="background-color:${status.index % 2==0? 'lightgray':'#9484d5'}">
					<td>${mission.id}</td>
					<td>${mission.gorevAdi}</td>
					<td>${mission.gorevinGerektirdikleri}</td>
					<td>${mission.gorevSuresi}</td>
					<td>${mission.gorevTarihi}</td>
					<td>
						<!-- show the links --> 
						 
						<a class="update" href="${updateLink}">Update</a> 
						<a class="delete" href="${pageContext.request.contextPath}/missions/delete/${mission.id}">Delete</a>
						<!--   <a class="delete" href="${deleteLink}"> Delete</a>-->
					</td>

				</tr>
			</c:forEach>
		</table>
		<p><a class="normal" href="${pageContext.request.contextPath}/missions/new">Gorev Ekle</a>
	</div>
</body>
</html>