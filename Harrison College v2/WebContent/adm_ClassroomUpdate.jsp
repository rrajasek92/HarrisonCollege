<%@ include file="/adminheader.jsp"%>
<div class="container">
	<br>
	<br>
	<form action="adm_ClassroomUpdate" method="POST">

		<div class="form-group">
			<label for="roomnumber" style="color: #141452"></label> <input
				type="number" class="form-control" name="roomnumber"
				placeholder="${classroom.id.roomNumber}">
		</div>

		<div class="form-group">
			<label for="buildingname" style="color: #141452"></label> <input
				type="text" class="form-control" name="buildingname"
				placeholder="${classroom.id.buildingName}">
		</div>
		<div class="form-group">
			<label for="maxcapacity" style="color: #141452"></label> <input
				type="number" class="form-control" name="maxcapacity"
				placeholder="${classroom.maxCapacity}">
		</div>
		<br>
		<br>
		<button class="btn btn-primary btn-sm">Add</button>
	</form>
</div>

<%@ include file="/adminfooter.jsp"%>