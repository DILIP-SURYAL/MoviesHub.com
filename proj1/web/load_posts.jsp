<%@page import="com.proj1.Entities.user_info"%>
<%@page import="com.proj1.Databases.Like_database"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.proj1.Entities.Post"%>
<%@page import="com.proj1.Helpers.ConnectionProvider"%>
<%@page import="com.proj1.Databases.Post_database"%>
                            <script src="javaScript/newjavascript.js" type="text/javascript"></script>

<div class="row">
<%
   user_info uu = (user_info)session.getAttribute("CurrentUser");
Post_database post = new Post_database(ConnectionProvider.getConnection());
ArrayList<Post> list = null;
int catId = Integer.parseInt(request.getParameter("cid"));
if(catId == 0 ){
list=post.getAllPosts();
    }
    else{
    list = post.getPostsByCatid(catId);
    }
    if(list.size()== 0){
    out.println("<h3 class='display-3 text-center'>No Movies in this category</h3>");
    }
for(Post e : list){
    
    %>
    
    <div class="col-md-6 mt-2">
        <div class="card">
            <img class="card-img-top" src="movie_picture/<%= e.getpPic() %>" alt="Card image cap">
            <div class="card-body">
                <b><%= e.getpTitle() %></b>
                <p><%= e.getpContent() %></p>
                <pre><%= e.getpCode() %></pre>
                
            </div>
                <div class="card-footer text-center primary-background"> 
                    <% Like_database lc = new Like_database(ConnectionProvider.getConnection()); %>
                        <a href="#!" onclick="doLike(<%=e.getPid() %>,<%=uu.getId()%>)" class="btn btn-outline-light btn-sm"><i class="fa fa-thumbs-o-up"><span class="counter"><%=lc.countLike(e.getPid()) %></span></i></a>
                       <a href="full_post.jsp?post_id=<%=e.getPid()%>" class="btn btn-outline-light btn-sm">Read More</a>
                    <a href="#!" class="btn btn-outline-light btn-sm"><i class="fa fa-commenting-o"><span>7</span></i></a>
                        
                </div>
        </div>
    </div>
    <%
    }

%>
</div>