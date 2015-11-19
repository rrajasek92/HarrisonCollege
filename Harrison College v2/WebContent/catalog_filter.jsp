<%@ include file="/student_header.jsp" %>
<!-- all classes in current semester -->
<div class="panel panel-default" style="width:60%;margin:auto;">
	<div class="panel-body" align="center">
		<h2>Current Semester: F15</h2><br><br>
		<a href="CatalogBrowsing?search_type=ac_cs" role="button" class="btn btn-danger">All classes in current semester</a>
		<br><br>
		<div class="form-horizontal">
			<br>
			<div class="form-group form-grp-lg">
				<!-- all classes by an instructor in current semester -->
				<form method="POST" action="CatalogBrowsing">
					<b>By instructor in current semester</b><br>
					<input type="hidden" name="search_type" value="ac_by_instructor_cs">
					<div class="input-group">
						<input class="form-control" type="text" name="instructor_name" placeholder="Instructor full name" style="margin-bottom:7px;margin-right:3px;width:300px;">
						<input class="btn btn-danger" type="submit" value="Search">
					</div>
				</form>
			</div>
			<div class="form-group form-grp-lg">
				<!-- all courses in a department -->
				<form method="POST" action="CatalogBrowsing">
					<b>By department</b><br>
					<input type="hidden" name="search_type" value="ac_by_department">
					<div class="input-group">
						<input class="form-control" type="text" name="department_name" placeholder="Department name" style="margin-bottom:7px;margin-right:3px;width:300px;">
						<input class="btn btn-danger" type="submit" value="Search">
					</div>
				</form>
			</div>
			<div class="form-group form-grp-lg">
				<!-- all current classes in a department -->
					<form method="POST" action="CatalogBrowsing">
						<b>By department in current semester</b><br>
						<input type="hidden" name="search_type" value="ac_by_department">
						<div class="input-group">
							<input class="form-control" type="text" name="department_name" placeholder="Department name" style="margin-bottom:7px;margin-right:3px;width:300px;">
							<input class="btn btn-danger" type="submit" value="Search">
						</div>
					</form>
			</div>
		</div>
	</div>
</div><br><br><br><br>
<%@ include file="/footer.jsp" %>