<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>

<br/>
<a href="hello-servlet">Hello Servlet</a><br><hr>
<a href="${pageContext.request.contextPath}/login.jsp">Go To Login</a>
</body>
</html>