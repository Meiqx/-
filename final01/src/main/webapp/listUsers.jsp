<%@page import="dao.*,java.util.*"%>
<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<html>
<head>
<style type="text/css">
.row1 {
	background-color: #fff8dc;
}

.row2 {
	background-color: #f0f0f0;
}
</style>
</head>
<body style="font-size: 30xp;">
	<table border="1" width="60%" cellpadding="0" cellspacing="0">
		<tr>
			<td>ID</td>
			<td>用户名</td>
			<td>密码</td>
			<td>邮箱</td>
		</tr>
		<% 
			UserDao dao = new UserDao();
			List<User> users = dao.findAll();
			for(int i = 0 ;i<users.size();i++){
				User user = users.get(i);
		%>
					<tr class="row<%= i % 2 + 1%>">
						<td><%=user.getId()%></td>
						<td><%=user.getUsername()%></td>
						<td><%=user.getPassword()%></td>
						<td><%=user.getEmail()%></td>
					</tr>
		<%
			}
			
		%>
			
	</table>

</body>
</html>