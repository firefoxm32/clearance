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

<div>
    <form:form modelAttribute="student" method="POST">
        <table>
            <tr>
                <td>NAME: </td>
                <td>
                    <form:input path="name" placeholder="NAME" />
                </td>
            </tr>
            <tr>
                <td>GENDER: </td>
                <td>
                    <form:radiobutton path="gender" value="M" />Male
                    <form:radiobutton path="gender" value="F" />Female
                </td>
            </tr>
            <tr>
                <td>BIRTHDAY: </td>
                <td>
                    <form:input path="birthday" placeholder="BIRTHDAY" class="js-date-picker" />
                </td>
            </tr>
            <tr>
                <td>CONTACT NO: </td>
                <td>
                    <form:input path="contactNo" placeholder="Contact No." />
                </td>
            </tr>
            <tr>
                <td>BIRTHDAY: </td>
                <td>
                    <form:input path="birthday" placeholder="BIRTHDAY" />
                </td>
            </tr>
            <tr>
                <td>EMAIL: </td>
                <td>
                    <form:input path="email" placeholder="EMAIL ADDRESS" />
                </td>
            </tr>
            <tr>
                <td>ADDRESS: </td>
                <td>
                    <form:input path="address" placeholder="ADDRESS" />
                </td>
            </tr>
        </table>
    </form:form>
</div>

<jsp:include page="partials/footer.jsp" />