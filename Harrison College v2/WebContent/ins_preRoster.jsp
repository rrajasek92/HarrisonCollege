<%@ include file="/header.jsp"%>
<div class = "container">
<table class="table table-hover">
	<thead style="color: #4C1818">
		<tr>
			<th>Student ID</th>
			<th>Grade</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="students" items="${PreStudentList}">

			<tr class="danger">
				<td>${students.studentId}</td>
				<td>${students.letterGrade}</td>
			</tr>
	</c:forEach>
	</tbody>
</table><br><br>
<form action="ins_classesTaught" method="POST">
<button class="btn btn-danger btn-xs">Home</button></form>
</div>
<%@ include file="/footer.jsp"%>