<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.bookmovie.dto.Movie"%>   
<%@page import="java.util.List"%>

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
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    />
     
     <link rel="stylesheet" type="text/css" href="signup.css">
     
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
    <script>
    $(document).ready(function() {
		$("#myInput").on("keyup", function() {
			var value = $(this).val().toLowerCase();
			$("#myTableBody tr").filter(function() {
				$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			});
		});
	});
    </script>
    
    
    <style>
      body {
        
        background-repeat: no-repeat;
        background-size: cover;
      }
		
		.jumbotron {
 			 background-image: url("background.jpg");
		  background-size: cover;
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
         <a class="nav-item nav-link active" href="prep_admin_logout.htm"><button class="btn btn-danger">Logout</button></a>
      </div>
    </nav>
    
	<!--  <div style="height:80px;"></div>  -->

<div class="container-fluid">
      
		
		<div class="row content">
			<div class="text-light col-sm-12 main jumbotron" style="background: rgba(26, 26, 26, 0.6)">
				<h3 class="text-center" >
					<b ><span style="color;white;">All Movies &#127909;</span></b>
				</h3>
				<div class="container">
					<div class="row">				
						<div class="col-2 form-group col-sm-3 ml-0 pl-0 float-left"><input class="form-control  float-center" id="myInput" type="text" placeholder="&#128269; Search"></div>
						<div class="col-8 form-group col-sm-6 float-left">
								<span style="color:#FF0000;">
                                    <%=((session.getAttribute("err_mssgMovie") != null)?(String)session.getAttribute("err_mssgMovie") : "") %></span>
                                    <span style="color:#00FF40;">
                                    <%=((session.getAttribute("err_mssgMovie1") != null)?(String)session.getAttribute("err_mssgMovie1") : "") %></span>													
						</div>
						<div class="col-2 form-group col-sm-3 ">
						<a href="admin_home.htm">
							<button type="button" class="btn btn-outline-light " id="btn0"   data-target="#myModal">Home</button>
						</a>
						<a href="prep_admin_movie_add.htm"><button type="button" class="btn btn-outline-success " id="btn0" data-toggle="modal" data-target="#myModal">Add</button></a>
						
						</div>
					</div>
				</div>
				<div class="table-responsive" id="myTable"></div>
				<table class="table  table-striped ">
					<thead class="table-dark">
						<tr>
							<th class="align-middle">Movie Id</th>
							<th class="align-middle">Movie Name</th>
							<th class="align-middle">Release Date</th>							
							<th class="align-middle">Director</th>
							<th class="align-middle">Cast</th>
							<th class="align-middle">Language</th>
							<th class="align-middle">IMDB Rating</th>
							<th class="align-middle">Action</th>
					
						</tr>
					</thead>
					<tbody id="myTableBody">
					<% List<Movie> li = (List<Movie>)request.getAttribute("mList");
							for(Movie f : li){
							
		  			 %>
						<tr style="color:white;">
							<td class="align-middle"><%= f.getMovieId() %></td>
							<td class="align-middle"><%= f.getMovieName()%></td>
							<td class="align-middle"><%= f.getReleaseDate() %></td>
							<td class="align-middle"><%= f.getDirector()%></td>
							<td class="align-middle"><%= f.getCast() %></td>
							<td class="align-middle"><%= f.getLanguage() %></td>
							<td class="align-middle"><%= f.getImdb() %></td>
							
							
							<td class="align-middle">
								<a href="prep_admin_movie_update.htm?movie_id=<%=f.getMovieId()%>"><button type="button" class="btn btn-primary btn-sm" id="btn0"   data-target="#myModal" >Update</button></a>							
															
							</td>
							
						</tr>
						<% } %>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
	  
   
    <footer class="page-footer font-small bg-dark text-light fixed-bottom">
      <div class="footer-copyright text-center">Created by : Team A</div>
      <!-- Copyright -->
      <div class="footer-copyright text-center">
        © 2020 Copyright:
        <a href="https://mdbootstrap.com/"> CDAC</a>
      </div>
      <!-- Copyright -->
    </footer>
</body>
</html>

<% session.removeAttribute("err_mssgMovie");
	session.removeAttribute("err_mssgMovie1");
%>