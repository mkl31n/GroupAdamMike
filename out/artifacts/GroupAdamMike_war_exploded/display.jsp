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
    <title>Fortune Entry</title>
</head>
<body>
<h4>Enter Birth Date for Fortune</h4>

<form action="MessageServlet" method="GET">
  <label>Birth Month</label>
  <input type="text" name="month" value="" /><br />
  <br />
  <label>Calendar Day</label>
  <input type="text" name="day" value="" /><br />
  <br />
  <label>Year</label>
  <input type="text" name="year" value="" /><br />
  <br />
  <input type="submit" name="" value="Enter" />
</form>
<ul>
  <li><a href="admin.jsp">Take me to the Admin Page</a></li>
  <li><a href="index.jsp">Take me Home</a></li>
</ul>
</body>
</html>
