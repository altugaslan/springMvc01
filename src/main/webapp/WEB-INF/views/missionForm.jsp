<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Gorev Ekle</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css?version=1">
</head>
<body>
	<div class="container">
		<div align="center">
			<h2>Add / Update Mission</h2>
			<table>
				<form:form modelAttribute="mission" action="saveMission" method="post">
					<form:hidden path="id" />
					<tr>
						<td class="missionprop"><b>GorevAdi:</b></td>
						<td><form:input path="gorevAdi" size="30" /></td>
						<td><form:errors path="gorevAdi" class="error" /></td>
					</tr>

					<tr>
						<td class="missionprop"><b>GorevinGerektirdikleri:</b></td>
						<td><form:input path="gorevinGerektirdikleri" size="30" /></td>
						<td><form:errors path="gorevinGerektirdikleri" class="error" /></td>
					</tr>

					<tr>
						<td class="missionprop"><b>GorevSuresi:</b></td>
						<td><form:input path="gorevSuresi" size="30" /></td>
						<td><form:errors path="gorevSuresi" class="error" /></td>
					</tr>

					<tr>
						<td></td>
						<td align="center"><form:button>Vazifem</form:button></td>
						<td></td>
					</tr>
				</form:form>
			</table>
		</div>
	</div>
</body>
</html>