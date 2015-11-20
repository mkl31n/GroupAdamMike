<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: paulawaite
  Date: 9/18/15
  Time: 6:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fortune Told</title>
</head>
<body>
<c:set var="message" scope="session" value="${returnedMessage}"/>
<h4>${message.getMyMessage()}</h4>
<ul>
  <li><a href="admin.jsp">Take me to the Admin Page</a></li>
  <li><a href="index.jsp">Take me Home</a></li>
</ul>
</body>
</html>