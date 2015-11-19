<%@ include file="advisorHeader.jsp"%>
<div class="panel panel-default">
	<div class="panel-body">
<h2>Class Enrollments</h2>
<br>
<div>
<a role="button" class="btn btn-danger btn-xs" href="catalog_filter.jsp">Enroll Classes</a>
<br><br>
<a role="button" class="btn btn-danger btn-xs" href="advisorViewTranscript?studentid=${ studentid }">Transcript</a>
</div>
</div>

<div class="panel panel-default">
	<div class="panel-body">
		<c:choose>
				<c:when test="${ no_classes == true }">
					<p>No classes enrolled.</p>
				</c:when>
				<c:otherwise>
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
<div>
&nbsp&nbsp&nbsp&nbsp<a class="btn btn-danger btn-xs" role="button" href="http://localhost:8080/Harrison_College_v2/advisor">Back</a><br><br>
</div>
</div>
</div>



<%@ include file="footer.jsp"%>