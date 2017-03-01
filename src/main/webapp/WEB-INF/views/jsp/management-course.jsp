<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Management Course</title>
</head>
<body style="width: 100%; height: 100%;">
	<h1>List of Courses</h1>
	<div
		style="margin: auto; width: 80%; height: 50%; border: 1px; border-color: black; border-style: solid;">
		<table style="margin: auto; width: 80%; height: 50%;">
			<tr>
				<th style="border: 1px; border-color: black; border-style: solid;">Course
					ID</th>
				<th style="border: 1px; border-color: black; border-style: solid;">Course
					Name</th>
				<th style="border: 1px; border-color: black; border-style: solid;">Years</th>
			</tr>
			<c:forEach items="${courses}" var="list">
				<tr>
					<td style="border: 1px; border-color: black; border-style: solid;">
						${list.courseId}</td>
					<td style="border: 1px; border-color: black; border-style: solid;">
						${list.courseName}</td>
					<td style="border: 1px; border-color: black; border-style: solid;">
						${fn:length(list.courseYears)}</td>
					<td style="border: 1px; border-color: black; border-style: solid;">
						<spring:url value="/course/" var="courseFormUrl" />
						<a href="${courseFormUrl}update/${list.courseId}">UPDATE</a><a href="${courseFormUrl}${list.courseId}" style="padding-left: 10px">VIEW</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div
			style="margin: auto; width: 80%; height: 50%; border: 2px; border-style: solid;">
			<spring:url value="/course/add" var="courseUrl" />

			<a href="${courseUrl}">Add Course</a>
		</div>
	</div>
</body>
</html>