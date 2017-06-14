<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<body>

	<h2>Subordinates Leave History Page</h2>

	<c:forEach var="subordinate" items="${submap}">

		<c:if test="${fn:length(subordinate.value) gt 0}">
			<h3>${subordinate.key.name}'s Leave History</h3>


			<table style="cellspacing: 2; cellpadding: 2; border: 1;">
				<tr class="listHeading">
					<th><spring:message code="fieldLabel.reference" /></th>
					<th><spring:message code="fieldLabel.name" /></th>
					<th><spring:message code="fieldLabel.leaveName" /></th>
					<th><spring:message code="fieldLabel.startDate" /></th>
					<th><spring:message code="fieldLabel.endDate" /></th>
					<th><spring:message code="fieldLabel.status" /></th>
				</tr>
				<c:forEach var="leave" items="${subordinate.value}">
					<tr class="listRecord">
						<td>${leave.leaveId}</td>
						<td>${leave.employeeId}</td>
						<td>${leave.leaveName}</td>
						<td>${leave.fromDate}</td>
						<td>${leave.toDate}</td>
						<td>${leave.status}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

	</c:forEach>
</body>
</html>