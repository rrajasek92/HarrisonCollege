<%@ include file="/adminheader.jsp"%>
<div class = "container"><br>
	<br>
<a href="adm_CourseAdd.jsp" type="button" name="button"
		class="btn btn-default"> <span class="glyphicon glyphicon-plus"></span>
	</a><br>
	<br>
<table class="table table-hover">
	<thead style="color: #4C1818">
		<tr>
			<th>Course Name</th>
			<th>Subject Code</th>
			<th>Description</th>
			<th>Credits</th>
			<th>Semester</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="courses" items="${Courses}">

			<tr class="danger">
				<td>${courses.courseName}</td>
				<td>${courses.subjectCode}</td>
				<td>${courses.description}</td>
				<td>${courses.credits}</td>
				<td>${courses.semester}</td>
				<td><form action="adm_CourseRemove?cid=${courses.courseId}" method="POST"><button class="btn btn-danger btn-xs">Remove</button></form></td>
				<td><form action="adm_CoursePreUpdate?cid=${courses.courseId}" method="POST"><button class="btn btn-danger btn-xs">Update</button></form></td>
			</tr>
	</c:forEach>
	</tbody>
</table><br><br>
<form action="adm_main.jsp" method="POST">
<button class="btn btn-danger btn-xs">Home</button></form>
</div>
<%@ include file="/adminfooter.jsp"%>