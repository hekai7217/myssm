<%--
  Created by IntelliJ IDEA.
  User: hekai
  Date: 2019-07-03
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
     login page

<%--               /shiro_web/login--%>
     <form action="shiro_web/login" method="post">

       username:<input type="text" name="username"> <br>
       password:<input type="text" name="password"> <br>

       <input type="submit" value="登录">

     </form>

  </body>
</html>
