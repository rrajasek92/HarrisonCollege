<%@ include file="/adminheader.jsp"%>
<div class = "container"><br><br>
<!-- <a href="adm_Course" class="btn btn-default btn-sm active" role="button">Courses</a>
<a href="adm_Classroom" class="btn btn-default btn-sm active" role="button">Classrooms</a>
<a href="adm_Department" class="btn btn-default btn-sm active" role="button">Departments</a>
<a href="admin" class="btn btn-default btn-sm active" role="button">Change Roles</a>
<a href="CatalogBrowsing?search_type=ac_cs" role="button" class="btn btn-default btn-sm active">All classes in current semester</a> -->

<br>
	<h3>Current Semester: F15</h3>
	<br><br>
		<div class="form-group form-grp-lg">
			<!-- all classes by an instructor in current semester -->
			<form method="POST" action="CatalogBrowsing">
				Search for instructor in current semester<br>
				<input type="hidden" name="search_type" value="ac_by_instructor_cs">
				<div class="input-group">
					<input class="form-control" type="text" name="instructor_name" placeholder="Instructor full name">
					<input class="btn btn-default" type="submit" value="Search">
				</div>
			</form>
		</div>
		<div class="form-group form-grp-lg">
			<!-- all courses in a department -->
			<form method="POST" action="CatalogBrowsing">
				Search for a specific department<br>
				<input type="hidden" name="search_type" value="ac_by_department">
				<div class="input-group">
					<input class="form-control" type="text" name="department_name" placeholder="Department name">
					<input class="btn btn-default" type="submit" value="Search">
				</div>
			</form>
		</div>
		<div class="form-group form-grp-lg">
			<!-- all current classes in a department -->
				<form method="POST" action="CatalogBrowsing">
					Search for a specific department in current semester<br>
					<input type="hidden" name="search_type" value="ac_by_department">
					<div class="input-group">
						<input class="form-control" type="text" name="department_name" placeholder="Department name">
						<input class="btn btn-default" type="submit" value="Search">
					</div>
				</form>
		</div>
</div>
<%@ include file="/adminfooter.jsp" %>
