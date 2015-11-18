<%@ include file="header.jsp"%>
<h2>Class Enrollments</h2>
<br>

<a role="button" class="btn btn-default" href="catalog_filter.jsp">Enroll Classes</a><br>
<a role="button" class="btn btn-default" href="advisorViewTranscript?studentid=${ studentid }">Transcript</a>
<div class="panel panel-default">
	<div class="panel-body">
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
			<tbody>${tableinfo}
			</tbody>
		</table>
	</div>
</div>



<%@ include file="footer.jsp"%>