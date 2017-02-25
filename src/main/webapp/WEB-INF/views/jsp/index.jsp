<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="partials/header.jsp" />

<spring:url value="/" var="url" />
<a href="${url}courses">COURSES</a>
<a href="${url}sections">SECTIONS</a>
<a href="${url}subjects">SUBJECTS</a>
<a href="${url}students">STUDENTS</a>
<jsp:include page="partials/footer.jsp" />
