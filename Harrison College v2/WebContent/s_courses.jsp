<%@ include file="/header.jsp" %>
<div class="container">
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
				<c:choose>
					<c:when test="${ advisor_logged_in == true}">
						<a role="button" class="btn btn-xs btn-default" href="advisorAddCourse?crn=${ myClass.crn }">Add</a></td>
					</c:when>
					<c:otherwise>
						<a role="button" class="btn btn-xs btn-default" href="addCourse?crn=${ myClass.crn }">Add</a></td>
					</c:otherwise>
				</c:choose>
				<td>${ myClass.cours.credits }</td>
				<td>${ myClass.cours.semester }</td>
				<td>${ myClass.cours.department.departmentName }</td>
			</tr>
		</c:forEach> 
	</table>
</div>
<%@ include file="/footer.jsp" %>

