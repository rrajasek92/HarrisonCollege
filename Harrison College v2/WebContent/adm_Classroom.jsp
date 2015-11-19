<%@ include file="/header.jsp"%>
<div class="container"><br>
	<br>
	<a href="adm_ClassroomAdd.jsp" type="button" name="button"
		class="btn btn-default"> <span class="glyphicon glyphicon-plus"></span>
	</a><br>
	<br>
	<table class="table table-hover">
		<thead style="color: #4C1818">
			<tr>
				<th>Room Number</th>
				<th>Building Name</th>
				<th>Max Capacity</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="classrooms" items="${Classrooms}">

				<tr class="danger">
					<td>${classrooms.id.roomNumber}</td>
					<td>${classrooms.id.buildingName}</td>
					<td>${classrooms.maxCapacity}</td>
					<td><form
							action="adm_ClassroomRemove?bn=${classrooms.id.buildingName}&rn=${classrooms.id.roomNumber}"
							method="POST">
							<button class="btn btn-danger btn-xs">Remove</button>
						</form></td>
					<td><form
							action="adm_ClassroomPreUpdate?bn=${classrooms.id.buildingName}&rn=${classrooms.id.roomNumber}"
							method="POST">
							<button class="btn btn-danger btn-xs">Update</button>
						</form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<form action="adm_main.jsp" method="POST">
		<button class="btn btn-danger btn-xs">Home</button>
	</form>
</div>
<%@ include file="/footer.jsp"%>