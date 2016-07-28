<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="com.recombooks.*" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.recombooks.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<%@ include file="head.jsp" %>

<body>

Member ID is <%= ((Context)request.getAttribute("context")).getMember().memberID %>
<br />
Welcome <%= ((Context)request.getAttribute("context")).getMember().emailAddress %>
<br />

<h3>File Upload:</h3>
Select a file to upload: <br />
<form action="/?cmd=admin-add-file" method="post"
                        enctype="multipart/form-data">
<input type="file" name="file" size="50" />
<br />
<input type="submit" value="Upload File" />
</form>


</body>
</html>
