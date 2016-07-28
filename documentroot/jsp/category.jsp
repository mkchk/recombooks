<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="com.recombooks.*" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.recombooks.util.*" %>
<%@ page import="java.util.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<%@ include file="head.jsp" %>

<body>

<%@ include file="header.jsp" %>

<script>

var allBooks =     [
        <% List<Recommender> recommenders = (List<Recommender>) request.getAttribute("allRecommenders");

        int i = 1;
        int totalRecommenders = recommenders.size();
        for (Recommender recommender : recommenders){
           %>
           { "recommenderName" :"<%= recommender.getName() %>",
           "recommenderID" :"<%= recommender.getRecommenderID() %>",
           "recommenderImageLink" : "<%="/images/" +  recommender.getName().replace(" ", "-").toLowerCase() + ".jpg" %>",
           "recommendations" : [
           <% 

           IntMap<Recommendation> recommendations = recommender.getRecommendations();

           int count = 0;
           int totalRecommendations = recommendations.values().size();
           for (Recommendation recommendation : recommendations.values()){
               Book book = recommendation.getBook();
               int MAX_CHAR = 200;
               int maxLength = (recommendation.getReview().length() < MAX_CHAR)?recommendation.getReview().length():MAX_CHAR;
               String review = recommendation.getReview().substring(0, maxLength);
               %>
                  { 
                      "asin" : "<%= book.getASIN() %>",
                      "imageUrl" : "<%= Helper.escapeJsonEval(book.getLargeImageUrl()) %>",
                      "title" : "<%= Helper.escapeJsonEval(book.getTitle()) %>",
                      "author" : "<%= Helper.escapeJsonEval(book.getAuthor()) %>",
                      "review" : "<%= Helper.escapeJsonEval(review) %>",
                      "recommendationID" : "<%= recommendation.getRecommendationID() %>"
                  }<%
                  count++;
                  if(count == 9 || count == totalRecommendations){
                      break;
                  }
                  else{
                      %>,<%
                  }
              }
           %>
           ]}
           <%
              i++;
              if( i==totalRecommenders){
                  break;
              }
              else{
                  %>,<%
              }

        }
    %>] ;
           console.log(allBooks[0]);
           var b;
</script>


<%@ include file="footer.jsp" %>

</body>
</html>