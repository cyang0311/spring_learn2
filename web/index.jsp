<%@ page import="Bean.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  Bean.User: cy
  Date: 2019/5/19
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>Spring测试</title>
  </head>
  <body>


<% if (session.getAttribute("list")!=null){
List<User> uList = (List<User>) session.getAttribute("list");
    for (User u:uList) {
%>
        姓名<%=u.getuName()%>  密码<%=u.getPwd()%>
  <%}}%>
  <%--<% if ((List<User>) session.getAttribute("list")!=null){%>--%>

  <%--列表<%=session.getAttribute("list")%>--%>
  <%--<%}else {--%>
  <%--}%>--%>
  </body>
</html>
