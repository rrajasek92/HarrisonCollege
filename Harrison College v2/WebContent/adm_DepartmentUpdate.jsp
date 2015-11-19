<%@ include file="/header.jsp"%>
<div class = "container"><br><br>
<form action="adm_DepartmentUpdate" method="POST">
			<div class="form-group">
				<label for="departmentname" style="color: #141452"></label> <input
					type="Text" class="form-control" name="departmentname"
					placeholder="${department.departmentName}">
			</div>
			
			<br><br>
			<button class="btn btn-primary btn-sm">Update</button></form>
</div>
<%@ include file="/footer.jsp"%>