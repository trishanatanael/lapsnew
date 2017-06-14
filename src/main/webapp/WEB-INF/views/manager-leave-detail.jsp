<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<body>
	<h3>
		<spring:message code="${title.leaveDetailsHistory}" />
	</h3>

	<table>
		<tr>
			<th align="right"><spring:message code="fieldLabel.leaveId" /></th>
			<td colspan="3"><c:out value="${leave.leaveId}" /></td>
		</tr>
		<tr>
			<th align="right"><spring:message code="fieldLabel.leaveName" /></th>
			<td colspan="3"><c:out value="${leave.leaveName}" /></td>
		</tr>
		
		<tr>
			<th align="right"><spring:message code="fieldLabel.startDate" /></th>
			<td><c:out value="${leave.fromDate}" ></c:out></td>
			<th align="right"><spring:message code="fieldLabel.endDate" /></th>
			<td><c:out value="${leave.toDate}" /></td>
		</tr>
		<tr>
			<th align="right"><spring:message
					code="fieldLabel.justification" /></th>
			<td colspan="3"><c:out value="${leave.justification}" /></td>
		</tr>
		<tr>
			<th align="right"><spring:message code="fieldLabel.status" /></th>
			<td colspan="3"><c:out value="${leave.status}" /></td>
		</tr>
	</table>
	<form:form method="POST" modelAttribute="approve"
		action="${pageContext.request.contextPath}/manager/leave/edit/${leave.leaveId}.html">
		<table>
			<tr>
				<td><form:radiobutton path="decision" value="APPROVED" id="decision"/> <spring:message
						code="caption.approve" /> &nbsp;&nbsp; <form:radiobutton
						path="decision" value="REJECTED" id="decision" /> <spring:message
						code="caption.reject" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.managerComment" /><br>
					<form:textarea path="comment" cols="60" rows="4" id="comment"/></td>
			</tr>
		</table>
		<form:button name="submit" type="submit" value="s">
			<img src="${pageContext.request.contextPath}/image/button_submit.gif"
				width="59" height="22" alt="" border="0">
		</form:button>
	</form:form>
</body>
</html>