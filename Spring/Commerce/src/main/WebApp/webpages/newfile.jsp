<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/commerce"
         user = "root"  password = "theavengers"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * from visit where user_id = 5;
      </sql:query>
      
      <table border = "1" width = "100%">
         <tr>
            <th>Visit Id</th>
            <th>Enter</th>
            <th>Leave</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.id}"/></td>
               <td><c:out value = "${row.enter_time}"/></td>
               <td><c:out value = "${row.leave_time}"/></td>
            </tr>
         </c:forEach>
      </table>
</body>
</html>