<%@ include file="/header.jsp"%>
<div class = "container"><br><br>
<form action="adm_DepartmentAdd" method="POST">
			
			
			<div class="form-group">
				<label for="departmentname" style="color: #141452"></label> <input
					type="text" class="form-control" name="departmentname"
					placeholder="Department Name">
			</div>
			
			<br><br>
			<button class="btn btn-primary btn-sm">Add</button></form>
</div>
<%@ include file="/footer.jsp"%>