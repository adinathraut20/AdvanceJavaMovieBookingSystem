<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@page import="com.bookmovie.dto.Orders"%>
<% 
       //System.out.println("hi shows_page ");
      if(session.getAttribute("user") == null){
    	 session.setAttribute("err_mssg", "Please Login Again...");
    	 response.sendRedirect("prep_log_form.htm");
    	 
      }
      
      Orders ord = (Orders)request.getAttribute("orders");
	  session.setAttribute("orders", ord);
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
   
     <div class="row" style="height:3vw;">
                 
      </div>
      
      <div class="row" >
      			<div class="col-3 col-sm-1 col-md-2">
                 	
                 </div>
                 <div class="col-6 col-sm-10 col-md-8" >
                 			<div class="jumbotron" >
                 						
                 						
                 						<div class="row mt-2">
                 								<div class="col-2 mt-2">
                 									
                 								</div>	
                 								<div class="col-10 mt-2">
                 									<div class="text-dark">Movie Name:  &nbsp<%=ord.getShows().getMovie().getMovieName() %></div>
                 								</div>                 									
                 						</div>
                 						
                 						<div class="row mt-2">
                 								<div class="col-2 mt-2">
                 									
                 								</div>	
                 								<div class="col-10 mt-2">
                 									<div class="text-dark">Show Id :  &nbsp<%=ord.getShows().getShowId() %></div>
                 								</div>
                 									
                 						</div>
                 						<div class="row mt-2">
                 								<div class="col-2 mt-2">
                 									
                 								</div>	
                 								<div class="col-10 mt-2">
                 									<div class="text-dark">Screen No. :  &nbsp<%=ord.getSeatNo() %></div>
                 								</div>
                 									
                 						</div>
                 						<div class="row mt-2">
                 								<div class="col-2 mt-2">
                 									
                 								</div>	
                 								<div class="col-10 mt-2">
                 									<div class="text-dark">Seat No. :  &nbsp<%=ord.getSeatNo() %></div>
                 								</div>                 									
                 						</div>
                 						<div class="row mt-2">
                 								<div class="col-2 mt-2">
                 									
                 								</div>	
                 								<div class="col-10 mt-2">
                 									<div class="text-dark">Language :  &nbsp<%=ord.getShows().getMovie().getLanguage() %></div>
                 								</div>
                 									
                 						</div>
                 						<div class="row mt-2">
                 								<div class="col-2 mt-2">
                 									
                 								</div>	
                 								<div class="col-10 mt-2">
                 									<div class="text-dark">Price :  &#x20B9;&nbsp<%=ord.getShows().getPrice() %></div>
                 								</div>
                 									
                 						</div>
                 						
										<div class="row mt-2" >
                 								<div class="col-2 mt-2">
                 									
                 								</div>	
                 								<div class="col-10 mt-2 float-right">
                 									<a href=""></a> <div class="text-dark">Total Price GST 18.00% :  &#x20B9;&nbsp<%=ord.getPrice() %></div>
                 								</div>                 									
                 						</div>
                 						
                 						<div class="row mt-2">
                 								<div class="col-2 mt-2">
                 									
                 								</div>	
                 								<div class="col-10 mt-2 float-right">
                 									
                 									<a href="confirm_book_page.htm"> <button class="btn btn-warning ">Confirm</button></a>&nbsp
                 									<a href="homeValidate.htm"> <button class="btn btn-danger ">Cancel</button></a>
                 								</div>  
                 								<div class="col-10 mt-2 float-right">
                 									
                 									
                 									
                 								</div>                 									
                 						</div>				
                 			</div>
                 </div>
                 
                 <div class="col-3 col-sm-1 col-md-2" >
                 	
                 </div>
      </div>
    
</div>
  
   
</body>
</html>