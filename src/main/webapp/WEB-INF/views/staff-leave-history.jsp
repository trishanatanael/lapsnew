<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<body>
	<h3>
		Employee Leave History
	</h3>
	<c:if test="${fn:length(chistory) gt 0}">
		<table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.reference" /></th>
				<th><spring:message code="fieldLabel.name" /></th>
				<th><spring:message code="fieldLabel.leaveName" /></th>
				<th><spring:message code="fieldLabel.startDate" /></th>
				<th><spring:message code="fieldLabel.endDate" /></th>
				<th><spring:message code="fieldLabel.status" /></th>
				<th><spring:message code="fieldLabel.update" /></th>
				<th><spring:message code="fieldLabel.withdraw" /></th>
			</tr>
			<c:forEach var="leave" items="${chistory}">
				<tr class="listRecord">
					<td>${leave.leaveId}</td>
					<td>${leave.employeeId}</td>
					<td>${leave.leaveName}</td>
					<td>${leave.fromDate}</td>
					<td>${leave.toDate}</td>
					<td>${leave.status}</td>
					<c:if
						test="${leave.status eq 'SUBMITTED' || leave.status eq 'UPDATED' }">
						<td><a
							href="${pageContext.request.contextPath}/staff/leave/edit/${leave.leaveId}.html"><spring:message
									code="fieldLabel.update" /></a></td>
						<td><a
							href="${pageContext.request.contextPath}/staff/leave/withdraw/${leave.leaveId}.html"><spring:message
									code="fieldLabel.withdraw" /></a></td>
					</c:if>
					<c:if
						test="${leave.status eq 'WITHDRAWN' || leave.status eq 'APPROVED' ||leave.status eq 'REJECTED' }">
						<td></td>
						<td></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>