<%@ include file="/header.jsp"%>
<div class = "container"><br><br>
<form action="adm_CourseUpdate" method="POST">
			<div class="form-group">
				<label for="coursename" style="color: #141452"></label> <input
					type="Text" class="form-control" name="coursename"
					placeholder="${course.courseName}">
			</div>
			<div class="form-group">
				<label for="subjectcode" style="color: #141452"></label> <input
					type="Text" class="form-control" name="subjectcode"
					placeholder="${course.subjectCode}">
			</div>
			<div class="form-group">
				<label for="description" style="color: #141452"></label> <input
					type="Text" class="form-control" name="description"
					placeholder="${course.description}">
			</div>
			<div class="form-group">
				<label for="credits" style="color: #141452"></label> <input
					type="number" class="form-control" name="credits"
					placeholder="${course.credits}">
			</div>
			<div class="form-group">
				<label for="semester" style="color: #141452"></label> <input
					type="Text" class="form-control" name="semester"
					placeholder="${course.semester}">
			</div>
			<select name = "departmentid">
			<c:forEach var = "departments" items = "${departments}">
			<option value = "${departments.departmentId}">${departments.departmentName}</option>
			</c:forEach>
			</select>
			<br><br>
			<button class="btn btn-primary btn-sm">Update</button></form>
</div>
<%@ include file="/footer.jsp"%>