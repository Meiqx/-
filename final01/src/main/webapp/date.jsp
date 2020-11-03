<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*" %>
<html>	
	<head></head>
	<body>
		date:<% 
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss");
			out.println(sdf.format(date));
		%>
	</body>
</html>