<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.recombooks.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ include file="head.jsp" %>

<body>

<%@ include file="header.jsp" %>

<% Book book = (Book) request.getAttribute("book");
 Recommendation recommendation = (Recommendation) request.getAttribute("recommendation");
%>

<%= book.getTitle() %>
<%= book.getAuthor() %>

<img src="<%= book.getLargeImageUrl() %>" />

<%= recommendation.getReview() %>

<%@ include file="footer.jsp" %>

</body>
</html>

