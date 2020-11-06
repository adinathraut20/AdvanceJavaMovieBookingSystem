<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.bookmovie.dto.Admin"%>
<% 
       //System.out.println("hi shows_page ");
      if(session.getAttribute("admin") == null){
    	 session.setAttribute("err_mssg", "Please Login Again...");
    	 response.sendRedirect("prep_admin_log.htm");
    	 
      }
	
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
      html,body {
	
 	background-repeat: no-repeat;
 	background:url("home.jpg");
 	background-size: contain;
    padding:0;
    margin:0;
    height:100%;
    min-height:100%;
   }
  
  .quarter{
    width:50%;
    height:100%;
    float:left;
  }
  .contents{
    height:50%;
    width:100%;
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
      </div>
      <div class="nav navbar-nav" style="font-family: cursive; font-size: 25px">
        <font color="white"> &#127909;</font>&nbspBOOK MY TICKET 
      </div>
      <div class="nav navbar-nav">
         <a class="nav-item nav-link active" href="prep_logout.htm"><button class="btn btn-danger">Logout</button></a>
      </div>
    </nav>
    
	<div style="height:80px;"></div>
	
	
<div class="container-fluid" >
    
     <div class="contents">
            <div class="col-md-6 quarter d-flex justify-content-center align-items-center" style="background:rgba(26, 26, 26, 0.7); height: 50vh;"><a href="prep_admin_shows.htm" class="btn btn-warning btn-lg" role="button" aria-pressed="true"><b><font color="black"> &#x2634;</font>&nbspSHOWS</b></a></div>
            <div class="col-md-6 quarter d-flex justify-content-center align-items-center" style="background-color:rgba(255, 255, 255, 0.7); height: 50vh;"><a href="prep_admin_orders.htm" class="btn btn-warning btn-lg" role="button" aria-pressed="true"><b><font color="black"> &#x2139;</font>&nbspORDERS</b></a></div>
            <div class="col-md-6 quarter d-flex justify-content-center align-items-center" style="background-color:rgba(255, 255, 255, 0.7); height: 50vh;"><a href="prep_admin_movie.htm" class="btn btn-warning btn-lg" role="button" aria-pressed="true"><b><font color="black"> &#127909;</font>&nbspMOVIES</b></a></div>
            <div class="col-md-6 quarter d-flex justify-content-center align-items-center" style="background: rgba(26, 26, 26, 0.7); height: 50vh;"><a href="prep_admin_hall.htm" class="btn btn-warning btn-lg" role="button" aria-pressed="true"><b><font color="black"> &#x2638;</font>&nbspHALLS</b></a></div>   
      </div>
    
</div>
  
   
</body>
</html>