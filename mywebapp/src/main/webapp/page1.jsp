<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>This is page 1</h1>
<%
	//response.sendRedirect("page2.jsp");
	request.getRequestDispatcher("page2.jsp").forward(request, response);
%>
</body>
</html>