<%-- 
    Document   : management-student
    Created on : Feb 25, 2017, 12:55:41 PM
    Author     : All
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="partials/header.jsp" />
<div style="margin: auto;width: 80%; height: auto; border: black solid; padding: 5px" class="student-container section-container form-student-container" >
    <div style="width: auto; height: auto; border: black solid; padding: 5px">
        <h2>LIST OF STUDENTS</h2>
        <select class="js-select-course" >
            <option value="0">SELECT COURSE</option>
            <c:forEach items="${courses}" var="course" varStatus="counter">
                <option value="${course.courseId}">
                    ${course.courseName}
                </option>
            </c:forEach>
        </select>
        <select class="js-select-year">
            <option value="0">
                SELECT YEAR
            </option>
        </select>
        <select class="js-select-section">
            <option value="0">
                SELECT SECTION
            </option>
        </select>
    </div>
    <div style="width: auto; height: auto; border: black solid; padding: 5px">
        <table class="js-table">
            <thead>
                <td>STUDENT ID</td>
                <td>NAME</td>
                <td>GENDER</td>
                <td>ADDRESS</td>
                <td>EMAIL</td>
                <td>SEMESTER</td>
                <td>ACTION</td>
            </thead>
            <tbody>
                
            </tbody>
        </table>
    </div>
    <spring:url value="/student/add" var="url" />
    <a href="${url}">ADD STUDENT</a>
</div>
<jsp:include page="partials/footer.jsp" />
