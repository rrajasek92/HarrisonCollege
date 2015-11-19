<%@ include file="/header.jsp"%><%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class = "container">
<table class="table table-hover">
	<thead style="color: #4C1818">
		<tr>
			<th>Student Name</th>
			<th></th>
		</tr>
	</thead>
	<tbody></tbody>
	<c:forEach var="students" items="${StudentList}">

		<c:choose><c:when test="${fn:contains(assigned, students.huser.userId)}"> 
		<tr class="danger">
					<td>${students.huser.fullName}</td>
					<td>Assigned</td>
			</tr>
			</c:when>
			<c:otherwise>

			<tr>
				<form action="ins_assignGrade" method="POST">
					<td><input type="hidden" name="studentid"
						value="${students.huser.userId}">${students.huser.fullName}</td>
					<td><select name="grade">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
							<option value="F">F</option>
					</select>
						<button class="btn btn-danger btn-xs">Assign Grade</button></td>
				</form>
			</tr></c:otherwise>
	</c:choose>
	</c:forEach>
</table><br><br>
<form action="ins_classesTaught" method="POST">
<button class="btn btn-danger btn-xs">Home</button></form>
</div>
<%@ include file="/footer.jsp"%>