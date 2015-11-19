<%@ include file="/adminheader.jsp"%>
<div class = "container"><br><br>
<form action="adm_CourseAdd" method="POST">
			<div class="form-group">
				<label for="coursename" style="color: #141452"></label> <input
					type="Text" class="form-control" name="coursename"
					placeholder="Course Name">
			</div>
			<div class="form-group">
				<label for="subjectcode" style="color: #141452"></label> <input
					type="Text" class="form-control" name="subjectcode"
					placeholder="Subject Code">
			</div>
			<div class="form-group">
				<label for="description" style="color: #141452"></label> <input
					type="Text" class="form-control" name="description"
					placeholder="Description">
			</div>
			<div class="form-group">
				<label for="credits" style="color: #141452"></label> <input
					type="number" class="form-control" name="credits"
					placeholder="Credits">
			</div>
			<div class="form-group">
				<label for="semester" style="color: #141452"></label> <input
					type="Text" class="form-control" name="semester"
					placeholder="Semester">
			</div>
			<select name = "departmentid">
			<c:forEach var = "departments" items = "${departments}">
			<option value = "${departments.departmentId}">${departments.departmentName}</option>
			</c:forEach>
			</select>
			<br><br>
			<button class="btn btn-primary btn-sm">Add</button></form>
</div>
<%@ include file="/adminfooter.jsp"%>