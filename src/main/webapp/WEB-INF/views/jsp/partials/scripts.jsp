<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/bower_components/jquery/dist/jquery.min.js" var="jqueryJs" />
<spring:url value="/resources/bower_components/jquery-ui/jquery-ui.min.js" var="jqueryUIJs" />
<spring:url value="/resources/bower_components/mustache.js/mustache.min.js" var="mustache" />
<spring:url value="/resources/core/js/app.js" var="appJs" />
<spring:url value="/resources/core/js/sections.js" var="sectionJs" />
<spring:url value="/resources/core/js/course.js" var="courseJs" />
<spring:url value="/resources/core/js/subject.js" var="subjectJs" />

<script src="${jqueryJs}"></script>
<script src="${jqueryUIJs}"></script>
<script src="${mustache}"></script>
<%-- <script src="${appJs}"></script> --%>
<script src="${sectionJs}"></script>
<script src="${courseJs}"></script>
<script src="${subjectJs}"></script>