<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/dist/scripts/app.min.js" var="appJs" />
<spring:url value="/resources/dist/scripts/vendor.min.js" var="vendorJs" />


<script src="${vendorJs}"></script>
<script src="${appJs}"></script>