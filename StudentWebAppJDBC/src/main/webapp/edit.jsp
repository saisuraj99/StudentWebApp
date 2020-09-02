<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit</title>
</head>
<body>
<%int id = Integer.parseInt(request.getParameter("id"));

%>
<form action="edit" method="post">
ID:<input type="text" value="<%=id %>" readonly="readonly" name="id"><br>
NAME:<input type="text" name="name" ><br>
DOB:<input type="text" name="dob" ><br>
EMAIL:<input type="text" name="email" ><br>
MOBILE:<input type="text" name="mobile"><br>
<input type="submit" value="submit">
</form>
</body>
</html>