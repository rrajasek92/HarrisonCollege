<%@ include file="/adminheader.jsp" %>
<div class="container">
	<h3>${ department_name }</h3>
	<table class="table table-striped table-bordered">
		<tr>
			<th>Major</th>
		</tr>
		<c:choose>
			<c:when test="${ no_results == true }">
				<tr>
					<td>No results found.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="major_name" items="${ majors_list }">
					<tr>
						<td>${ major_name }</td>
					</tr>
				</c:forEach> 
			</c:otherwise>
		</c:choose>
	</table>
</div>
<%@ include file="/adminfooter.jsp" %>

