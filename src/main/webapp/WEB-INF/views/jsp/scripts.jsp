<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/plugins/jquery-3.1.1.min.js" var="jqueryJs" />
<spring:url value="/resources/core/js/app.js" var="appJs" />
<spring:url value="/resources/core/js/sections.js" var="sectionJs" />

<script src="${jqueryJs}"></script>
<%-- <script src="${appJs}"></script> --%>
<script src="${sectionJs}"></script>