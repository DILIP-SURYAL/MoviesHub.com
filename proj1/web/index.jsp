<%@page import="com.proj1.Helpers.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movies Hub.com</title>

        <!--css-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/newcss.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            .banner-background{
                clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 91%, 63% 100%, 22% 91%, 0 99%, 0 0);
            }
        </style>

    </head>
    <body>

        <!--navbar-->

        <%@include file="Header.jsp" %>
        <!--//banner-->

        <div class="container-fluid p-0 m-0">

            <div class="jumbotron primary-background text-white banner-background">
                <div class="container">
                    <h3 class="display-3">Moives Hub</h3>

                    <p>welcome to movies hub , movies hub offer you any kind of movie and series also you can watch online of content of the movie and also you can download in your device and see in your gallary ,(note : this is illegal web site dont try this at home) this also provide you a see series in you phone or laptop or any devices which is connected to internet </p>
                    <p>
                        movies hub offer you to download a series and movies and short films in different quality such as like 1080p , 720p , 480p also watch in online these platform 
                    </p>

                    <button class="btn btn-outline-light btn-lg"> <span class="fa fa fa-user-plus"></span>  download or watch (free!!)</button>
                    <a href="login.jsp" class="btn btn-outline-light btn-lg"> <span class="fa fa-user-circle fa-spin"></span>  Login</a>

                </div>
            </div>






        </div>



        <!--//cards-->

        <div class="container">

            <div class="row mb-2">

                <div class="col-md-4">
                    <div class="card" >

                        <div class="card-body">
                            <h5 class="card-title">hollywood</h5>
                            <p class="card-text">Hoollywood movie and series are these content which is made in usa...</p>
                            <a href="https://en.wikipedia.org/wiki/Hollywood" class="btn primary-background text-white">Read more</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card" >

                        <div class="card-body">
                            <h5 class="card-title">bollywood</h5>
                            <p class="card-text">bollywood movies are made in india and produced by indian producers and directors...</p>
                            <a href="https://en.wikipedia.org/wiki/Hindi_cinema" class="btn primary-background text-white">Read more</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card" >

                        <div class="card-body">
                            <h5 class="card-title">tollywood</h5>
                            <p class="card-text"> the Telugu-language film industry based in Andhra Pradesh and Telangana
                                Film Nagar (Tollywood), the film district of Hyderabad, Telangana, India</p>
                            <a href="https://en.wikipedia.org/wiki/Tollywood" class="btn primary-background text-white">Read more</a>
                        </div>
                    </div>
                </div>


            </div>






        </div>



        <!--javascripts-->
        <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/myjs.js" type="text/javascript"></script>

    </body>
</html>