<%--
  Created by IntelliJ IDEA.
  User: hekai
  Date: 2019-07-03
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

   list page

   <br>

<%--   jsp  标签授权 --%>
   welcome:
   <shiro:principal></shiro:principal> <br>

   <shiro:hasRole name="admin">
       <a href="admin.jsp">admin page</a>
   </shiro:hasRole>

   <br>

   <shiro:hasRole name="user">
       <a href="user.jsp"> user page </a>
   </shiro:hasRole>
   <br>

   <a href="/shiro_web/test01"> 注解 权限</a>

   <a href="/shiro_web/logout">登出</a>

</body>
</html>
