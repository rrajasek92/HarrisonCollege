<%@ include file="student_header.jsp"%>
<div class="panel panel-default" style="width:60%;margin:auto;">
	<div class="panel-body" align="center">
		<h3>Class Enrollments</h3>
			<c:choose>
				<c:when test="${ no_classes == true }">
					<p>No classes enrolled.</p>
				</c:when>
				<c:otherwise>
				<br>
		<table
			class="table table-striped table table-bordered table table-hover"
			border="3" bordercolor="red">
			<thead>
				<tr>
					<th>Student ID</th>
					<th>CRN</th>
					<th>Course ID</th>
					<th>Course Name</th>
					<th>Semester</th>
					<th>Maximum Seats Available</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
					${tableinfo}
			</tbody>
		</table>
				</c:otherwise>
			</c:choose>
	</div>
</div>



<%@ include file="footer.jsp"%>