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

ADD NEW RECOMMENDER
<form action="/?cmd=admin-recommender-add" method="post">
  Recommender Name <br>
  <input type="text" name="name"><br>
  Description <br>
  <input type="textarea" name="description"><br>
  Focus <br>
  <input type="text" name="focus">
  <br>
  <input type="text" name="imageLink">
  <br>
  <input type="submit" value="Add Recommender">
</form>

<div class="container">
<div id="row" class="row">

</div>
</div>

<script>

var allRecommenders =     [
<% IntMap<Recommender> recommenders = (IntMap<Recommender>) request.getAttribute("allRecommenders");

int count = 0;
int totalRecommenders = recommenders.values().size();
for (Recommender recommender : recommenders.values()){
   //Book book = recommendation.getBook();
   int MAX_CHAR = 200;
   //int maxLength = (recommendation.getReview().length() < MAX_CHAR)?recommendation.getReview().length():MAX_CHAR;
   //String review = recommendation.getReview().substring(0, maxLength);
   %>
      { 
          "name" : "<%= Helper.escapeJsonEval(recommender.getName()) %>",
          "imageUrl" : "<%= Helper.escapeJsonEval(recommender.getImageLink()) %>",
          "description" : "<%= Helper.escapeJsonEval(recommender.getDescription()) %>",
          "focus" : "<%= Helper.escapeJsonEval(recommender.getFocus()) %>"
      }<%
      count++;
      if(count == totalRecommenders){
          break;
      }
      else{
          %>,<%
      }
  }
%>
] ;
console.log(allRecommenders[0]);
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