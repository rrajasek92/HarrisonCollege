<%@ include file="/header.jsp" %>
<!-- all classes in current semester -->
<div class="container">
	<h3>Current Semester: F15</h3>
	<a href="CatalogBrowsing?search_type=ac_cs" role="button" class="btn btn-default">all classes in current semester</a>
	<br><br>
	<div class="form-horizontal">
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
</div>
<%@ include file="/footer.jsp" %>