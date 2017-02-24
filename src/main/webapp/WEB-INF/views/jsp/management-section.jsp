<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="partials/header.jsp" />
<div style="margin: auto;width: 80%; height: auto; border: black solid; padding: 5px" class="section-container">
    <div style="width: auto; height: auto; border: black solid; padding: 5px">
        <h2>LIST OF SECTIONS PER COURSE AND YEAR</h2>
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

        <input class="js-input-name" type="text" placeholder="Section" />
        <button class="js-button-save" type="submit">Save</button>
    </div>
    <div style="width: 50%; height: auto; border: black solid; padding: 5px">
        <table class="js-table">
            <thead>
                <td>SECTION ID</td>
                <td>SECTION NAME</td>
                <td>ACTION</td>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="partials/footer.jsp" />