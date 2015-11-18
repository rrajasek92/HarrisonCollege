<%@ include file="header.jsp"%>
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
	</div>
	
	<a class="btn btn-default" role="button" href="advisorViewClasslist?studentid=${studentid }">Home</a>
</div>

<%@ include file="footer.jsp"%>