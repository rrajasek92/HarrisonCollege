<%@ include file="student_header.jsp"%>
<div class="panel panel-default" style="width:60%;margin:auto;">
	<div class="panel-body" align="center">
		<h2>Student Transcript</h2>
			<table class="table table-striped table table-bordered table table-hover" border="3" bordercolor="red">
				<thead>
					<tr>
						<th>Student ID</th>
						<th>Grade</th>
					</tr>
				</thead>
				<tbody>
					${tableinfo}
				</tbody>
			</table>
		<a class="btn btn-danger" role="button"
			href="http://localhost:8080/Harrison_College_v2/TranscriptConfirmation.jsp">Purchase
			Transcript ($5)</a>
		<a class="btn btn-danger" role="button" href="studentClasslistServlet">Home</a>
	</div>
</div>

<%@ include file="footer.jsp"%>