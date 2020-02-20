<%@page contentType="text/html" pageEncoding="UTF-8"
	errorPage="Error.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>

	<br />

	<h2>
		<%
			String str = session.getAttribute("username").toString();
			out.println("Hello " + str);
		%>
	</h2>


	<br />
	<a href="Logout.jsp">Logout</a>

</body>
</html>

