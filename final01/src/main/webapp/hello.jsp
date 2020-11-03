<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*" %>
<html>
<head></head>
<body style="font-size: 30px;">
	time:<%
		Date date = new Date();
		SimpleDateFormat date1 = new SimpleDateFormat();
		out.println(date1.format(date));
	%>
	<br>
	<%
		for(int i = 0;i < 100;i++){
			out.println("hello world<br/>");
		}
	
	%>

</body>
</html>