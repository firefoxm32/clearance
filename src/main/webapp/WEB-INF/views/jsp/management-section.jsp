<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />

<div style="width: 50%; height: auto; border: black solid; padding: 5px">
    <h2>LIST OF SECTIONS PER COURSE AND YEAR</h2>
    <select id="course" >
        <option value="0">SELECT COURSE</option>
        <c:forEach items="${courses}" var="course" varStatus="counter">
            <option value="${course.courseId}">
                ${course.courseName}
            </option>
        </c:forEach>
    </select>

    <select id="year"></select>

    <input id="section" type="text" placeholder="Section" />
    <button id="save" type="submit">Save</button>
</div>
<div style="width: 50%; height: auto; border: black solid; padding: 5px">
    <table id="sections">
<!--        <tr style="width: auto;border: black solid">
            <th style="border: black solid; padding: 5px">SECTION ID</th>
            <th style="border: black solid; padding: 5px">SECTION NAME</th>
        </tr>
-->
    </table>
</div>
<jsp:include page="footer.jsp" />