<%-- 
    Document   : management-subject
    Created on : Feb 10, 2017, 9:26:07 PM
    Author     : Roudhentel
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="partials/header.jsp" />

<div style="margin: auto;width: 50%; height: auto; border: black solid; padding: 5px" class="subject-container">
    <div style="margin: auto;width: auto; height: auto; border: black solid; padding: 5px">
        <h2>LIST OF SUBJECTS BY COURSE AND YEAR</h2>
        <select class="js-select-course">
            <option value="0">SELECT COURSE</option>
            <c:forEach items="${courses}" var="course" varStatus="counter">
                <option value="${course.courseId}">
                    ${course.courseName}
                </option>
            </c:forEach>
        </select>
        <select class="js-select-year">
            <option value="0">SELECT YEAR</option>
        </select>
        <input class="js-input-name" type="text" placeholder="Subject" />
        <button class="js-button-save" type="submit">Save</button>
    </div>
    <div>
        <table style="margin: auto;width: 100%; height: auto; border: black solid;" class="js-table" >
            <thead>
                <td style="margin: auto;width: 30%; height: auto; border: black solid;">SUBJECT ID</td>
                <td style="margin: auto;width: 40%; height: auto; border: black solid;">SUBJECT NAME</td>
                <td style="margin: auto;width: 30%; height: auto; border: black solid;">ACTION</td>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</div>
<jsp:include page="partials/footer.jsp" />
