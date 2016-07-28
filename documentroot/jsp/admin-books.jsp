<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="com.recombooks.*" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.recombooks.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">


<body>

<%@ include file="admin-head.jsp" %>


Member ID is <%= ((Context)request.getAttribute("context")).getMember().memberID %>
<br />
Welcome <%= ((Context)request.getAttribute("context")).getMember().emailAddress %>
<br />

MESSAGE
<%=request.getAttribute("message")%><br>

ADD NEW BOOK
<form action="/?cmd=admin-book-add" method="post">
  Book Title <br>
  <input type="text" name="title"><br>
  Author <br>
  <input type="text" name="author"><br>
  ASID <br>
  <input type="text" name="asin">
  <br>
  <input type="submit" value="Add book">
</form>



<div class="container">
<div id="row" class="row">

</div>
</div>

<script>

var allBooks =     [
<% IntMap<Book> recommendations = (IntMap<Book>) request.getAttribute("allBooks");

int count = 0;
int totalRecommendations = recommendations.values().size();
for (Book book : recommendations.values()){
   //Book book = recommendation.getBook();
   int MAX_CHAR = 200;
   //int maxLength = (recommendation.getReview().length() < MAX_CHAR)?recommendation.getReview().length():MAX_CHAR;
   //String review = recommendation.getReview().substring(0, maxLength);
   %>
      { 
          "asin" : "<%= book.getASIN() %>",
          "imageUrl" : "<%= Helper.escapeJsonEval(book.getLargeImageUrl()) %>",
          "title" : "<%= Helper.escapeJsonEval(book.getTitle()) %>",
          "author" : "<%= Helper.escapeJsonEval(book.getAuthor()) %>"
      }<%
      count++;
      if(count == totalRecommendations){
          break;
      }
      else{
          %>,<%
      }
  }
%>
] ;
console.log(allBooks[0]);
var b;

var body = '';

body += '<div data-role="page" id="pageone">'
body += '<div data-role="main" class="ui-content">'
body += '<ol data-role="listview">'

allBooks.forEach(function(book){
   body += '<li>';
   body += book.title + ' by '
   body += book.author
   body += '<br />'
   body += '<br />'
   body += '</li>';
});

body += '</div>'
body += '</div>'

$('.row').append(body);

</script>

</body>
</html>