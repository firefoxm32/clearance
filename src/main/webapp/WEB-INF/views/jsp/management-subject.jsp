<%-- 
    Document   : management-subject
    Created on : Feb 10, 2017, 9:26:07 PM
    Author     : Roudhentel
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />

<div>
    <h2>LIST OF SUBJECTS PER COURSE AND YEAR</h2>
    <select id="course">
        <option value="0">SELECT COURSE</option>
        <c:forEach items="${courses}" var="course" varStatus="counter">
            <option value="${course.courseId}">
                ${course.courseName}
            </option>
        </c:forEach>
    </select>
    <select id="year"></select>
</div>

<jsp:include page="footer.jsp" />
