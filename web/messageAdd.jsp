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
    <title>Add Fortune</title>
</head>
<body>
<h4>Fortune Add Form</h4>

<form action="AddMessageServlet" method="POST">
  <label>Message</label>
  <input type="text" name="user_message" value="" /><br />
  <br />
  <input type="submit" name="" value="Enter" />
</form>
<br />
<c:if test="${AddMessage != null}" >
  <h3>${AddMessage}</h3>
</c:if>
<ul>
  <li><a href="admin.jsp">Take me to the Admin Page</a></li>
  <li><a href="index.jsp">Take me Home</a></li>
</ul>
</body>
</html>