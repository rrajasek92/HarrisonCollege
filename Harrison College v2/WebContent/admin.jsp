<%@ include file="/adminheader.jsp"%>
<a class="navbar-brand" href="#"></a>
<%  

String UserName=(String) session.getAttribute("email");
session.setAttribute("email", UserName);


 

%>
 <script>
            showMenu = function() {
                var div = document.getElementById('box1');
                div.style.display = 'block';
            }
            hideMenu = function() {
                var div = document.getElementById('box1');
                div.style.display = 'none';
            }
        </script>
</br >
<div class="panel panel-default">

<div class="panel-body">
<table class="table table-striped">
<thead>

<tr>
<th>Full Name</th>
<th>Position</th>
<th>Entry Year</th>
<th>Email</th>
</tr>
</thead>
<tbody>

${tableinfo}

</tbody>
</table>

</div>
</div>

<%@ include file="/adminfooter.jsp" %>
