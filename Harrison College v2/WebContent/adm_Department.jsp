<%@ include file="/header.jsp"%>
<div class = "container"><br>
	<br>
<a href="adm_DepartmentAdd.jsp" type="button" name="button"
		class="btn btn-default"> <span class="glyphicon glyphicon-plus"></span>
	</a><br>
	<br>
<table class="table table-hover">
	<thead style="color: #4C1818">
		<tr>
			<th>Department</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="departments" items="${Departments}">

			<tr class="danger">
				<td>${departments.departmentName}</td>
				<td><form action="adm_DepartmentRemove?did=${departments.departmentId}" method="POST"><button class="btn btn-danger btn-xs">Remove</button></form></td>
				<td><form action="adm_DepartmentPreUpdate?did=${departments.departmentId}" method="POST"><button class="btn btn-danger btn-xs">Update</button></form></td>
			</tr>
	</c:forEach>
	</tbody>
</table><br><br>
<form action="adm_main.jsp" method="POST">
<button class="btn btn-danger btn-xs">Home</button></form>
</div>
<%@ include file="/footer.jsp"%>