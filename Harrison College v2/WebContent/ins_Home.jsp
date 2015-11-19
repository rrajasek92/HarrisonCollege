<%@ include file="/instructor_header.jsp"%>
<div class = "panel panel-default" style="width:60%;margin:auto;">
	<div class="panel-body">
		<table class="table table-hover table-bordered">
			<thead style="color: #4C1818">
				<tr>
					<th>Classes</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="classes" items="${ClassList}">
		
					<tr>
		
						<td><a href="afterHome?crn=${classes.crn}">${classes.cours.courseName}</a></td>
		
					</tr>
				</c:forEach>
		</table>
	</div>
</div>
<%@ include file="/footer.jsp"%>