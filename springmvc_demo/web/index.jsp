<%--
  Created by IntelliJ IDEA.
  User: hekai
  Date: 2019-06-28
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

     删除 delete :<br>
    <form action="/rest/12" method="post">
      <input type="hidden" name="_method" value="DELETE">
      <input type="submit" value="delete">
    </form>
     <br>

     修改 put:<br>
    <form action="/rest/13" method="post">
      <input type="hidden" name="_method" value="PUT">
      <input type="submit" value="put">
    </form>
     <br>

     添加:<br>
    <form action="/rest/14" method="post">
      <input type="submit" value="post">
    </form>
     <br>

     获取 get:<br>
    <form action="/rest/15" method="post">
      <input type="submit" value="get">
    </form>

  </body>
</html>
