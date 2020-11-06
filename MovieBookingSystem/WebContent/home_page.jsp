<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.bookmovie.dto.Movie"%>
    <%@page import="com.bookmovie.dto.User"%>
<%@page import="java.util.List"%>
<% 
       //System.out.println("hi home_page ");
      if(session.getAttribute("user") == null){
    	 session.setAttribute("err_mssg", "Please Login Again...");
    	 response.sendRedirect("prep_log_form.htm");
    	 
      }
	if(session.getAttribute("err_mssg") != null)
	 session.removeAttribute("err_mssg");
	if(session.getAttribute("err_mssg1") != null)
	 session.removeAttribute("err_mssg1");
      %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Movies</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    />
    <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <!-- Bootstrap CSS -->
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
    <script
      src="https://kit.fontawesome.com/0ff6456f25.js"
      crossorigin="anonymous"
    >
   
    
    </script>
  
    
    <style>
      body {
        height: 100%;
 	background-repeat: no-repeat;
 	background:url("home.jpg");
 	font-family: 'Oxygen', sans-serif;
	background-size: contain;
      }

      .img {
        width: 50vh;
        height: 50vh;
        margin-left: 16%;
        margin-top: 40%;
      }

      #icn {
        font-size: 25px;
        margin: 19px;
        color: white;
        cursor: pointer;
      }

      .mobileShow {
        display: inline;
      }

      /* Smartphone Portrait and Landscape */
      @media only screen and (min-device-width: 320px) and (max-device-width: 580px) {
        .mobileShow {
          display: inline;
        }
      }

      .mobileHide {
        display: inline;
      }

      /* Smartphone Portrait and Landscape */
      @media only screen and (min-device-width: 320px) and (max-device-width: 580px) {
        .mobileHide {
          display: none;
        }
      }
    </style>
  </head>
<body>
	<nav class="navbar navbar-expand fixed-top text-light navbar-dark bg-dark justify-content-between"  >
      <div class="nav navbar-nav">
        <!--<a class="nav-item nav-link active" href="#">
          <i class="fa fa-home" aria-hidden="true"></i> Home</a
        >-->
        <a class="nav-item nav-link active" href="prep_user_buy_orders.htm"><button class="btn  btn-outline-info">My Orders</button></a>
      </div>
      <div class="nav navbar-nav" style="font-family: cursive; font-size: 25px">
        <font color="white"> &#127909;</font>&nbspBOOK MY TICKET 
      </div>
      <div class="nav navbar-nav">
         <a class="nav-item nav-link" href="#"><button class="btn btn-outline-danger">Hi&nbsp<%=((User)session.getAttribute("user")).getuFname() %></button></a>
         <a class="nav-item nav-link active" href="prep_logout.htm"><button class="btn btn-danger">Logout</button></a>
      </div>
    </nav>
    
	<div style="height:80px;"></div>

    <div class="container-fluid">
      
		
		<div class="row content">
			<div class=" col-sm-12 jumbotron p-3 text-light" style="background-color:rgba(26, 26, 26, 0.6);">
				<h3 class="text-center">
					<b>Movies Available</b>
				</h3>
				<div class="container">
					<div class="row">				
						<div class="col-2 form-group col-sm-3 ml-0 pl-0 float-left">
							<a href="prep_search_page.htm"><button type="button" class="btn btn-outline-light   float-left" id="btn0" >Search</button></a>	
						</div>
						
					</div>
				</div>
				
			</div>
		</div>
	</div>
	
	
<div class="container-fluid" >
    <div class="row">
        <div class="col-md-2 col-sm-2 col-0">
            
               <!--  <ul class="list-group" id="uli1" style="cursor: pointer; ">
                    <li class="list-group-item" style="background-color:rgb(0, 0, 0); color: whitesmoke;">
                        All
                        Categories
                    </li>
                    <li class="list-group-item">Action</li>
                    <li class="list-group-item">Drama</li>
                    <li class="list-group-item">Love</li>
                    <li class="list-group-item">Sci-fi</li>
                    <li class="list-group-item">Horror</li>
                </ul> -->
           
        </div>

        <div class="col-md-9 col-sm-10 col-12">
           
		   <% List<Movie> li = (List<Movie>)request.getAttribute("mList");
				for(Movie i : li){
		   %>

				<div class="jumbotron p-1" style="background-color:rgb(255, 255, 255, 0.8);" >
					<div class="row p-4 mx-2">
						<div class="col-md-4 col-sm-3 col-4">
							<div class="card"><iframe width="100%" height="100%" src=<%=i.getUrlV() %>
									frameborder="0"
									allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
									allowfullscreen></iframe>
								
							</div>
						</div>

						

						<div class="col-md-8 col-sm-9 col-8 ">
							<div class="row justify-content-center" "><h4><%=i.getMovieName() %></h4></div>
							<div class="row mt-3"><b>&#10031;Cast :&nbsp</b> <%=i.getCast() %></div>
							<div class="row mt-1"><b>&#10023;Director :&nbsp </b> <%=i.getDirector() %> &nbsp &nbsp  <b>Language :&nbsp </b> <%=i.getLanguage() %><b><i class="fas fa-headphones-alt"></i></b></div>
							<div class="row mt-1"><b><i class="fab fa-imdb" ></i>IMDB Rating :&nbsp </b><%=i.getImdb() %>/10</div>
							<div class="row mt-1 p-0">
									<div class="col-8 p-0"><b><i class="far fa-calendar-alt" ></i>Release Date :&nbsp </b><%=i.getReleaseDate() %> </div>
									<div class="col-4 ">
										<a href="prep_show.htm?movie_id=<%=i.getMovieId()%>&mname=<%=i.getMovieName()%>&urlV=<%=i.getUrlV()%>"><button type="button" class="btn btn-outline-danger   float-right" id="btn0"   data-target="#myModal" >Book Now</button></a>      
									</div>		 
							</div>
							
						
						

						</div>
					</div>
				</div>
				
				<% } %>
				
				
				
        </div>
		<div class="col-md-1 col-sm-0 col-0"></div>
    </div>
</div>





	
    
   
    <footer class="page-footer font-small bg-dark text-light fixed-bottom">
      <div class="footer-copyright text-center">Created by : Team A</div>
      <!-- Copyright -->
      <div class="footer-copyright text-center">
        © 2020 Copyright:
        <a href="error_page.jsp"> CDAC</a><span><a href="contact_Us.jsp">&nbspContact Us</a></span>
      </div>
      <!-- Copyright -->
    </footer>
</body>
</html>