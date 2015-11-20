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
    <title>Read/Delete Database</title>
</head>
<body>
<h4>Read/Delete Database</h4>

<form action="ReadMessagesServlet" method="GET">
    <label for="term">ID Number</label>
    <input type="text" name="term" value="" /><br />
    <br />
    <label for="id">Search</label>
    <input type="radio" name="stype" value="id" id="id"/>
    <label for="read_all">Read All</label>
    <input type="radio" name="stype" value="read_all" id="read_all"/><br />
    <label for="delete">Delete</label>
    <input type="radio" name="stype" value="delete" id="delete"/><br />
  <br />
  <input type="submit" name="" value="Enter" />
</form>
<br />
<table border="1" cellpadding="5">
  <caption><h2>Search Results</h2></caption>
  <tr>
    <th>id</th>
    <th>message</th>
  </tr>
    <c:choose>
        <c:when test="${readList != null}">
            <c:forEach var="message" items="${readList}">
                <tr>
                    <td>${message.id}</td>
                    <td>${message.myMessage}</td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <c:if test="${readMessage != null}" >
                <tr>
                    <td>${readMessage.getId()}</td>
                    <td>${readMessage.getMyMessage()}</td>
                </tr>
            </c:if>
        </c:otherwise>
    </c:choose>

</table>
<ul>
  <li><a href="messageAdd.jsp">Add Fortune to Database</a></li>
  <li><a href="index.jsp">Take me Home</a></li>
</ul>
</body>
</html>