<%@ include file="/adminheader.jsp" %>

	<table class="table table-striped table-bordered">
		<tr>
			<th>Name</th>
			<th>Credits</th>
			<th>Semester</th>
			<th>Department</th>
		</tr>
		<c:forEach var="myClass" items="${ classes_list }">
			<tr>
				<td>${ myClass.cours.courseName } 
				
				<td>${ myClass.cours.credits }</td>
				<td>${ myClass.cours.semester }</td>
				<td>${ myClass.cours.department.departmentName }</td>
			</tr>
		</c:forEach> 
	</table>

<%@ include file="/adminfooter.jsp" %>

