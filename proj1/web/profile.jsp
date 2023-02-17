<%@page import="com.proj1.Entities.Post"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.proj1.Entities.Category"%>
<%@page import="com.proj1.Helpers.ConnectionProvider"%>
<%@page import="com.proj1.Databases.Post_database"%>
<%@page import="com.proj1.Entities.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.proj1.Entities.user_info"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <!--css-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/newcss.css" rel="stylesheet" type="text/css"/>
        <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            .banner-background{
                clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 91%, 63% 100%, 22% 91%, 0 99%, 0 0);
            }
            body{
             background: url(images/download.jpg); 
           
             background-attachment: fixed;
            }
        </style>
    </head>
    <body><!--Header-->
        <nav class="navbar navbar-expand-lg navbar-dark primary-background">
            <a class="navbar-brand" href="index.jsp"> <span class="fa fa-asterisk"></span>Movies Hub</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#"> <span class="fa fa-bell-o"></span>don't forget to give feedback<span class="sr-only">(current)</span></a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="	fa fa-check-square-o"></span> Categories
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">hollywood</a>
                            <a class="dropdown-item" href="#">bollywood</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">tollywood</a>
                        </div>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#"> <span class="fa fa-address-card-o"></span> Contact</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#!" data-toggle="modal" data-target="#add-post-modal"> <span class="fa fa-asterisk"></span> ADD POST</a>
                    </li>



                </ul>
                <ul class="navbar-nav mr-right">
                    <li class="nav-item">
                        <%
                            user_info user = (user_info) session.getAttribute("CurrentUser");
                            if (user == null) {
                                response.sendRedirect("login.jsp");
                            }
                        %>
                        <a class="nav-link" href="#!" data-toggle="modal" data-target="#profile-modal"> <span class="fa fa-user-circle "></span><%=user.getName()%></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="logOut"> <span class="fa fa-user-plus "></span> Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
        <!--end of header-->
        <main>
            <div class="container">
                <div class="row mt-4 ">
                    <!--first col-->
                    <div class="col-md-4">

                        <div class="list-group">
                            <a href="#" onclick="getPosts(0, this)" class="c-link list-group-item list-group-item-action active primary-background">ALL MOVIES</a>
                            <!--categories-->

                            <%
                                Post_database post = new Post_database(ConnectionProvider.getConnection());

                                ArrayList<Category> list = post.getCategory();
                                for (Category cc : list) {

                            %>
                            <a href="#" onclick = "getPosts(<%= cc.getId()%>, this)" class=" c-link list-group-item list-group-item-action"><%=cc.getName()%></a>


                            <%}%>
                        </div>

                    </div>
                    <!--second col-->
                    <div class="col-md-8" >
                        <!--posts-->
                        <div class="container text-center" id="loader">
                            <i class="fa fa-refresh fa-4x fa-spin"></i>
                            <h3 class="mt-2">Loading...</h3>
                        </div>

                        <div class="container-fluid" id="post-container">

                        </div>
                    </div>

                </div>

            </div>

        </main>

        <!--add post modal-->

        <div class="modal fade" id="add-post-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Provide the Movie details..</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">

                        <form id="add-post-form" action="AddPost" method="POST" enctype="multipart/form-data">

                            <div class="form-group">
                                <select class="form-control" name="cid">
                                    <option selected disabled>---Select Category---</option>

                                    <%
                                        Post_database postd = new Post_database(ConnectionProvider.getConnection());
                                        ArrayList<Category> list1 = postd.getCategory();
                                        for (Category c : list1) {
                                    %>
                                    <option value="<%=c.getId()%>"> <%=c.getName()%></option>

                                    <%
                                        }
                                    %>
                                </select>
                            </div>

                            <div class="form-group">
                                <input name="pTitle" type="text" placeholder="Enter post Title" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <textarea name="pContent" class="form-control" style="height: 200px;" placeholder="Enter your content"></textarea>
                            </div>
                            <div class="form-group">
                                <textarea name="pCode" class="form-control" style="height: 200px;" placeholder="Attach link.."></textarea>
                            </div>
                            <div class="form-group">
                                <label>Select your pic..</label>
                                <br>
                                <input type="file" name="pic"  >
                            </div>

                            <div class="container text-center">
                                <button type="submit" class="btn btn-outline-primary">Post </button>
                            </div>

                        </form>
                        <div class="modal-footer">


                            <button type="button" class="btn btn-secondary" data-dismiss="modal">close</button>
                            <button type="button" class="btn btn-primary">save changes</button>


                        </div>

                    </div>

                </div>
            </div>
        </div>


        <!--END add post modal-->

        <%
            Message msg = (Message) session.getAttribute("msg");

            if (msg != null) {
        %>
        <div class="alert alert-primary" role="alert">

            <%=msg.getContent()%>
        </div>
        <%
                session.removeAttribute("msg");
            }%>

        <!--profile component-->
        <div class="modal fade" id="profile-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header primary-background text-white text-center">
                        <h5 class="modal-title" id="exampleModalLabel"> movies Hub </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="container text-center">
                            <img src="images/<%=user.getProfile()%>" class="img-fluid" style="border-radius:50%;max-width: 150px;;" >
                            <br>
                            <h5 class="modal-title mt-3" id="exampleModalLabel"> <%= user.getName()%> </h5>
                            <!--//details-->
                            <div class="profile-details">
                                <div id="profile-details">
                                    <table class="table">

                                        <tbody>
                                            <tr>
                                                <th scope="row"> ID :</th>
                                                <td> <%= user.getId()%></td>

                                            </tr>
                                            <tr>
                                                <th scope="row"> Email : </th>
                                                <td><%= user.getEmail()%></td>

                                            </tr>
                                            <tr>
                                                <th scope="row">Gender :</th>
                                                <td><%= user.getGender()%></td>

                                            </tr>
                                            <tr>
                                                <th scope="row">Status :</th>
                                                <td><%= user.getAbout()%></td>

                                            </tr>
                                            <tr>
                                                <th scope="row">Registered on :</th>
                                                <td> <%= user.getRdate().toString()%></td>

                                            </tr>
                                        </tbody>
                                    </table>

                                </div>
                                <!--profile edit-->
                                <div class="container">
                                    <div id="profile-edit" style="display: none;">
                                        <h3 class="mt-2">Please Edit Carefully</h3>
                                        <form action="Update_profile" method="post" enctype="multipart/form-data">
                                            <table class="table">
                                                <tr>
                                                    <td>ID :</td>
                                                    <td><%= user.getId()%></td>
                                                </tr>
                                                <tr>
                                                    <td>Email :</td>
                                                    <td> <input type="email" class="form-control" name="user_email" value="<%= user.getEmail()%>" > </td>
                                                </tr>
                                                <tr>
                                                    <td>Name :</td>
                                                    <td> <input type="text" class="form-control" name="user_name" value="<%= user.getName()%>" > </td>
                                                </tr>
                                                <tr>
                                                    <td>Password :</td>
                                                    <td> <input type="password" class="form-control" name="user_password" value="<%= user.getPassword()%>" > </td>
                                                </tr>
                                                <tr>
                                                    <td>Gender :</td>
                                                    <td> <%= user.getGender().toUpperCase()%> </td>
                                                </tr>
                                                <tr>
                                                    <td>About  :</td>
                                                    <td>
                                                        <textarea rows="3" class="form-control" name="user_about" ><%= user.getAbout()%>
                                                        </textarea>

                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>New Profile:</td>
                                                    <td>
                                                        <input type="file" name="image" class="form-control" >
                                                    </td>
                                                </tr>

                                            </table>

                                            <div class="container">
                                                <button type="submit" class="btn btn-outline-primary">Save</button>
                                            </div>

                                        </form>     
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button  id="edit-profile-button" type="button" class="btn btn-primary">EDIT</button>
                                </div>
                            </div>
                            <!--end of profile Component-->





                            <!--javascripts-->
                            <script
                                src="https://code.jquery.com/jquery-3.4.1.min.js"
                                integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
                            crossorigin="anonymous"></script>
                            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
                            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

                            <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>

                            <script src="javaScript/newjavascript.js" type="text/javascript"></script>
                            <script>
                                $(document).ready(function () {
                                    let editStatus = false;
                                    $('#edit-profile-button').click(function ()
                                    {
                                        if (editStatus == false)
                                        {
                                            $("#profile-details").hide()
                                            $("#profile-edit").show();
                                            editStatus = true;
                                            $(this).text("Back")
                                        } else
                                        {
                                            $("#profile-details").show()
                                            $("#profile-edit").hide();
                                            editStatus = false;
                                            $(this).text("Edit")
                                        }
                                    })
                                });
                            </script>
                            <script>
                                $(document).ready(function (e) {
                                    //
                                    $("#add-post-form").on("submit", function (event) {
                                        //this code gets called when form is submitted....
                                        event.preventDefault();
                                        console.log("you have clicked on submit..")
                                        let form = new FormData(this);
                                        //now requesting to server
                                        $.ajax({
                                            url: "AddPost",
                                            type: 'POST',
                                            data: form,
                                            success: function (data, textStatus, jqXHR) {
                                                //success ..
                                                console.log(data);
                                                if (data.trim() === 'done')
                                                {
                                                    swal("Good job!", "saved successfully", "success");
                                                } else
                                                {
                                                    swal("Error!!", "Something went wrong try again...", "error");
                                                }
                                            },
                                            error: function (jqXHR, textStatus, errorThrown) {
                                                //error..
                                                swal("Error!!", "Something went wrong try again...1", "error");
                                            },
                                            processData: false,
                                            contentType: false
                                        })
                                    })
                                })
                            </script>
                            <!--loading post using ajax-->
                            <script>
                                function getPosts(catId, temp) {
                                    $("#loader").show();
                                    $("#post-container").hide()
                                    $(".c-link").removeClass('active primary-background')
                                    $.ajax({
                                        url: "load_posts.jsp",
                                        data: {cid: catId},
                                        success: function (data, textStatus, jqXHR) {
                                            console.log(data);
                                            $("#loader").hide();
                                            $("#post-container").show();
                                            $('#post-container').html(data)
                                            $(temp).addClass('active primary-background')
                                        }
                                    })
                                }
                                $(document).ready(function (e) {
                                    let allPostRef = $('.c-link')[0]
                                    getPosts(0, allPostRef)
                                })
                            </script>


                            </body>
                            </html>
