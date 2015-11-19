<%@ include file="/header.jsp"%>
<div class = "container"><br><br>
<div class="dropdown">
  <button class="btn btn-primary btn-xs dropdown-toggle" type="button" data-toggle="dropdown">Previous Semesters
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
    <li><a href="ins_preHome?semester=S15">S15</a></li>
    <li><a href="ins_preHome?semester=F14">F14</a></li>
    <li><a href="ins_preHome?semester=S14">S14</a></li>
  </ul>
</div><br><br>
<table class="table table-hover">
	<thead style="color: #4C1818">
		<tr>
			<th>Classes</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="classes" items="${ClassList}">

			<tr>

				<td><a href="afterHome?crn=${classes.crn}">${classes.cours.courseName}</a></td>

			</tr>
		</c:forEach>
</table>
</div>
<%@ include file="/footer.jsp"%>