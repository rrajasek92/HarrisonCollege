<%@ include file="advisorHeader.jsp"%>
<div class="panel panel-default">
	<div class="panel-body">
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
	<a class="btn btn-danger btn-xs" role="button" href="advisorViewClasslist?studentid=${studentid }">Back</a>
	</div>
	
</div>

<%@ include file="footer.jsp"%>