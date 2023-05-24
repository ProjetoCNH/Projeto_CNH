<%-- 
    Document   : resultadogeral
    Created on : 18/04/2023, 20:14:20
    Author     : alunos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%String message = (String)request.getAttribute("message");%>
        <h2><%out.println(message);%></h2>
    </body>
</html>
