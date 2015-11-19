<%@ include file="/instructor_header.jsp"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="panel panel-default" style="width: 60%; margin: auto;">
	<div class="panel-body">
			<table class="table table-hover table-bordered">
				<thead style="color: #4C1818">
					<tr>
						<th>Student Name</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="students" items="${StudentList}">

					<c:choose>
						<c:when test="${fn:contains(assigned, students.huser.userId)}">
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
									</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button class="btn btn-danger btn-xs">Assign Grade</button></td>
								</form>
							</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</tbody>
			</table>
			<br>
			<br>
	</div>
</div>
<%@ include file="/footer.jsp"%>