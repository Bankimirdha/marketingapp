<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Create Lead</h2>
<form action="editReg" method="post">
<pre>
<input type="hidden" name="id" value="${lead.id}">
FirstName<input type="text" name="firstname" value="${lead.firstname}"/>
LastName<input type="text" name="lastname" value="${lead.lastname}"/>
Email<input type="text" name="email" value="${lead.email}"/>
Mobile<input type="text" name="mobile" value="${lead.mobile}"/>
<input type="submit" value="update"/>
</pre>
</form>
${msg}
</body>
</html>