<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="com.recombooks.*" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.recombooks.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<%@ include file="head.jsp" %>

<body>

<%= ((Context)request.getAttribute("context")).getMember().memberID %>
<form action="/?cmd=admin-login" method="post">
  First Name <br>
  <input type="text" name="email"><br>
  Password<br>
  <input type="password" name="password">
  <input type="submit" value="Login">
</form>

<%@ include file="footer.jsp" %>

</body>
</html>