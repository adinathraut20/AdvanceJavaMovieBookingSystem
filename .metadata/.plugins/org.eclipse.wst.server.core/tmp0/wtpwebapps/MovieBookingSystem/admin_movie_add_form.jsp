<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.bookmovie.dto.Movie"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>  
    
    <% 
       
      if(session.getAttribute("admin") == null){
    	 session.setAttribute("err_mssg", "Please Login Again...");
    	 response.sendRedirect("prep_admin_log.htm");
    	 
      }
		
      %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Movie</title>

    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    />
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
    ></script>
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
    
    <div class="container-fluid justify-content-center bg-light align-items-center">
    <div class="row justify-content-center align-items-center my-5">
        <div class="col-10 align-items-center mt-5">
            <div class="dash-header">
                <div class="dash-title">
                    <h1>Add Movie</h1>
                </div>
            </div>
            <div class="text-danger" style='font-size: 15;text-align: center;' >
					<%-- <%=(request.getParameter("err_msg")!=null)? request.getParameter("err_msg"):"" %> --%>
					</div>
            <br><br>
            <div class="blog-form">
                <spr:form action="admin_movie_add_done.htm" method="post" commandName="movie">
                
                    <div class="form-group form-row">
                        <label class="col-md-3">Movie Name </label>
                        <div class="col-md-9">
                        
                            <spr:input   class="form-control"  path="movieName"
                                required="true"/>                      
                        </div>
                    </div>
                    
                    <div class="form-group form-row">
                        <label class="col-md-3">Language </label>
                        <div class="col-md-9">
                        
                            <spr:input   class="form-control"  path="language"
                                required="true"/>                      
                        </div>
                    </div>
                    
                    <div class="form-group form-row">
                        <label class="col-md-3">Release Date </label>
                        <div class="col-md-9">
                            <spr:input class="form-control" path="releaseDate"
                                required="true"/>                      
                        </div>
                    </div>
                    
                    <div class="form-group form-row">
                        <label class="col-md-3">Director <span class="required"></span></label>
                        <div class="col-md-9">
                            <spr:input  class="form-control" path="director"
                                required="true"/>                      
                        </div>
                    </div>
                    
                    <div class="form-group form-row">
                        <label class="col-md-3">Cast <span class="required"></span></label>
                        <div class="col-md-9">
                            <spr:input   class="form-control" path="cast"
                                required="true"/>                      
                        </div>
                    </div>
                    
                    <div class="form-group form-row">
                        <label class="col-md-3">ImDB Rating </label>
                        <div class="col-md-9">
                            <spr:input  class="form-control" path="imdb"
                                required="true"/>                      
                        </div>
                    </div>
                    
                    <div class="form-group form-row">
                        <label class="col-md-3">Video Trailer Url </label>
                        <div class="col-md-9">
                            <spr:input  class="form-control" path="urlV"
                                required="true"/>                      
                        </div>
                    </div>
                   
                    
                           
                    <div class="form-group form-row">
                        <label class="col-md-3"></label>
                        <div class="col-md-9">
                            <input type="hidden">
                            <button type="submit"  class="btn btn-primary">Save</button>
                          	<a href="prep_admin_movie.htm" style="color:red;">&nbsp&nbspCancel</a>
                        </div>
                                          
                        
                    </div>
                </spr:form>
            </div>
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
    
</body>
</html>