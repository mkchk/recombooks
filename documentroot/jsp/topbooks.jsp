<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="com.recombooks.*"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.*"%>

<%@ page import="com.recombooks.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<%@ include file="head.jsp"%>

<body>

    <%@ include file="header.jsp"%>

    <script>

var allBooks =     [];

var topbooks = [

        <% HashMap<String, List<Recommender>> booksByCount = (HashMap<String, List<Recommender>>) request.getAttribute("topbooks");

        int i = 1;
        int totalBooks = booksByCount.keySet().size();
        for (String bookASIN : booksByCount.keySet()){
            %>
            {"ASIN" :"<%= bookASIN %>",
            "recommender" : [
<%
int count = 1;
if(booksByCount.get(bookASIN)!=null){
                             for (Recommender recommender : booksByCount.get(bookASIN)){
                                 %>
                                 { "recommenderName" :"<%= recommender.getName() %>",
                                 "recommenderID" :"<%= recommender.getRecommenderID() %>",
                                 "recommenderImageLink" : "<%="/images/" +  recommender.getName().replace(" ", "-").toLowerCase() + ".jpg" %>",
                                 } ,
                                 <%
                             }
}
%>
                             ]

            }
           <%
              i++;
              if(i==10 || i==totalBooks){
                  break;
              }
              else{
                  %> , <%
              }

            }
    %>] ;
           console.log(topbooks[0]);
           var b;
</script>


    <%@ include file="footer.jsp"%>

</body>
</html>