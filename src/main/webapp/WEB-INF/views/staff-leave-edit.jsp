<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="STYLESHEET" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-ui.theme.css" />

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$("#datepicker1").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});
	$(document).ready(function() {
		$("#datepicker2").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});
</script>
<h3>New Leave page</h3>
<form:form method="POST" modelAttribute="leave"
	action="${pageContext.request.contextPath}/staff/leave/edit/${leave.leaveId}.html">
	<form:hidden path="leaveId" />
	<form:hidden path="employeeId" />
	<form:hidden path="status" />
	<table>
		<tr>
			<td><spring:message code="fieldLabel.leaveName" /></td>
			<td colspan="3"><form:input size="40" path="leaveName" /> <form:errors
					path="leaveName" cssStyle="color: red;" /></td>
		</tr>
		<tr>
			<td><spring:message code="fieldLabel.startDate" /></td>
			<td><form:input size="16" path="fromDate" 
					id="datepicker1" />
				<form:errors path="fromDate" cssStyle="color: red;" /></td>
			<td><spring:message code="fieldLabel.endDate" /></td>
			<td><form:input size="16" path="toDate"
					id="datepicker2" /> <form:errors path="toDate"
					cssStyle="color: red;" /></td>
		</tr>
		<tr>
			<td><spring:message code="fieldLabel.justification" /></td>
			<td colspan="3"><form:textarea cols="64" rows="5"
					path="justification" /></td>
		</tr>
		<tr>
			<td><spring:message code="fieldLabel.status" /></td>
			<td><form:input disabled="true" size="20" path="status" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td colspan="2" align="left"><br></br> <form:button
					type="submit">
					<img
						src="${pageContext.request.contextPath}/image/button_submit.gif"
						alt="" align="middle">
				</form:button></td>
		</tr>

	</table>
</form:form>
