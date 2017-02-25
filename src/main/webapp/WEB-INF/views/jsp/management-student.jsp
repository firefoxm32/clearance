<%-- 
    Document   : management-student
    Created on : Feb 25, 2017, 12:55:41 PM
    Author     : All
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="partials/header.jsp" />
<spring:url value="/student/add" var="url" />
<a href="${url}">ADD STUDENT</a>
<jsp:include page="partials/footer.jsp" />
