<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/sql"  prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Data</title>

</head>
<body>
     
     <c:out value="<--------------------User Entered Data From Form -------------------->" ></c:out>
     <sql:setDataSource driver="com.mysql.cj.jdbc.Driver"  url="jdbc:mysql://localhost:3306/dbase" user="root" password="mysql" var="ds"></sql:setDataSource>
     <sql:query dataSource="${ds}" var="rs">
        
        
        select * from userdataa;
       </sql:query>
    <table class="m-auto" frame="box" rules="all">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Age</th>
        <th>Date Of Birth</th>
    </tr>

    <c:forEach items="${rs.rows}" var="row">
        <tr>
            <td><c:out value="${row.Id}"/></td>
            <td><c:out value="${row.name}"/></td> 
            <td><c:out value="${row.email}"/></td>
            <td><c:out value="${row.age}"/></td>
            <td><c:out value="${row.Dob}"/></td>
            
        </tr>
    </c:forEach>
</table>
</body>
</html>
