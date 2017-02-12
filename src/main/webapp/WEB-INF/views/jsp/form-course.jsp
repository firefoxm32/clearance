<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Course By ID</title>
</head>
<body>
	<spring:url value="/save-course" var="saveOrUpdateUrl" />
	<form:form modelAttribute="courseAttribute" action="${saveOrUpdateUrl}"
		method="post">
		<form:hidden path="courseId"/>
		<label> Course </label>
		<p>
			<form:input path="courseName" type="text" placeholder="Course Name" />
		</p>
		<label> Years </label>
		<p>
			<c:if test="${action eq 'view'}">
				<c:set var="alphabet">st,nd,rd,th,th,th</c:set>
				<c:set var="splittedAlpha" value="${fn:split(alphabet, ',')}" />
				<c:forEach items="${courseAttribute.courseYears}" var="list" varStatus="counter">
					<%-- <form:input path="${list.yearName}" type="text" placeholder="Years" /> --%>
						<p>
							<c:out value="${list.yearName}${splittedAlpha[counter.index]} Year" />
						</p>
				</c:forEach>
			</c:if>
				<%-- <c:out value="${fn:length(courseAttribute.courseYears)}" /> --%>
			<c:if test="${action ne 'view'}">
				<c:set value="${fn:length(courseAttribute.courseYears)}" var="yearName" />
				<input name="years" value="${yearName}" />
			</c:if>
		</p>
		<button>Submit</button>
	</form:form>
</body>
</html>