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
<form action="saveReg" method="post">
<pre>
FirstName<input type="text" name="firstname"/>
LastName<input type="text" name="lastname"/>
Email<input type="text" name="email"/>
Mobile<input type="text" name="mobile"/>
<input type="submit" value="save"/>
</pre>
</form>
${msg}
</body>
</html>