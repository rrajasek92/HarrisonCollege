<%@ include file="/header.jsp"%>
<div class = "container">
<table class="table table-hover">
	<thead style="color: #4C1818">
		<tr>
			<th>Classes</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="classes" items="${preClassList}">

			<tr>

				<td><a href="ins_preClassRoster?Crn=${classes.crn}">${classes.cours.courseName}</a></td>

			</tr>
		</c:forEach>
</table>
</div>
<%@ include file="/footer.jsp"%>