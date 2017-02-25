<%-- 
    Document   : form-student
    Created on : Feb 25, 2017, 12:53:04 PM
    Author     : All
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="partials/header.jsp" />

<div class="form-student-container section-container">
    <spring:url value="/student/save" var="action" />
    <form:form modelAttribute="studentAttribute" method="POST" action="${action}">
        <table>
            <tr>
                <td>STUDENT ID: </td>
                <td>
                    <form:input path="studentId" placeholder="STUDENT ID" class="js-input-student-id" />
                </td>
            </tr>
            <tr>
                <td>NAME: </td>
                <td>
                    <form:input path="name" placeholder="NAME" class="js-input-student-name" />
                </td>
            </tr>
            <tr>
                <td>GENDER: </td>
                <td>
                    <form:radiobutton path="gender" value="M" class="js-rdb-gender" />Male
                    <form:radiobutton path="gender" value="F" class="js-rdb-gender" />Female
                </td>
            </tr>
            <tr>
                <td>BIRTHDAY: </td>
                <td>
                    <input type="text" name="birthdate" placeholder="BIRTHDAY" class="js-date-picker" />
                </td>
            </tr>
            <tr>
                <td>CONTACT NO: </td>
                <td>
                    <form:input path="contactNo" placeholder="Contact No." class="js-input-contact" />
                </td>
            </tr>
            <tr>
                <td>EMAIL: </td>
                <td>
                    <form:input path="email" placeholder="EMAIL ADDRESS" class="js-input-email" />
                </td>
            </tr>
            <tr>
                <td>ADDRESS: </td>
                <td>
                    <form:input path="address" placeholder="ADDRESS" class="js-input-address" />
                </td>
            </tr>
            <tr>
                <td>SEMESTER: </td>
                <td>
                    <%--<form:input path="${studentDetails.semester}" placeholder="SEMESTER" />--%>
                    <select name="select-sem" class="js-select-sem">
                        <option value="0">SELECT SEMESTER</option>
                        <option value="1st Sem">1st Sem</option>
                        <option value="2nd Sem">2nd Sem</option>
                        <option value="3rd Sem">3rd Sem</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>COURSE: </td>
                <td>
                    <select class="js-select-course" style="width: 100%" name="select-course">
                        <option value="0">SELECT COURSE</option>
                        <c:forEach items="${coursesAttribute}" var="course" varStatus="counter">
                            <option value="${course.courseId}">
                                ${course.courseName}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>YEAR: </td>
                <td>
                    <select class="js-select-year" style="width: 100%" name="select-year">
                        <option value="0">SELECT YEAR</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>SECTION: </td>
                <td>
                    <select class="js-select-section" style="width: 100%" name="select-section">
                        <option value="0">SELECT SECTION</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button style="width: 100%">SUBMIT</button>
                </td>
            </tr>
        </table>
    </form:form>
</div>

<jsp:include page="partials/footer.jsp" />