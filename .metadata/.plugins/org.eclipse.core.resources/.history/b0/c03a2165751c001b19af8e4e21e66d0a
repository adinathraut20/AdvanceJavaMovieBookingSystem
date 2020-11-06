<%@page import="service.FlightServiceImple"%>
<%@page import="service.FlightService"%>
<%@page import="dto.Flight"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="flight" class="dto.Flight" scope="session" ></jsp:useBean>    
    
 <%
 	
	if(session.getAttribute("uname") == null){
		response.sendRedirect("login.jsp?error_msg=Please Login!!!");
	}
 	
	 FlightService flightService = new FlightServiceImple();  
	 ArrayList<Flight> list = flightService.showFlight();
 %>


<!DOCTYPE html>
<html>
<head>
    <title>Modify-Flights</title>
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
        <b> BABA AIRLINES &#9992 </b>
      </div>
      <div class="nav navbar-nav">
         <a class="nav-item nav-link active" href="logout.jsp"><button class="btn btn-danger">Logout</button></a>
      </div>
    </nav>
<div style="height:80px;"></div>

    <div class="container-fluid">
      
		
		<div class="row content">
			<div class=" col-sm-12 main jumbotron">
				<h3 class="text-center">
					<b>Flight Info</b>
				</h3>
				<div class="container">
					<div class="row">				
						<div class="col-2 form-group col-sm-3 ml-0 pl-0 float-left"><input class="form-control  float-center" id="myInput" type="text" placeholder="Search"></div>
						<div class="col-8 form-group col-sm-6 float-left">														
						</div>
						<div class="col-2 form-group col-sm-3 ">
						<a href="AddFlightForm.jsp">
							<button type="button" class="btn btn-primary   float-right" id="btn0"   data-target="#myModal">Add Flight</button>
						</a>
						</div>
					</div>
				</div>
				<div class="table-responsive" id="myTable"></div>
				<table class="table  table-striped ">
					<thead class="table-dark">
						<tr>
							<th class="align-middle">Flight Id</th>
							<th class="align-middle">Source</th>
							<th class="align-middle">Destination</th>
							<th class="align-middle">Date</th> 
							<th class="align-middle">Time</th>
							<th class="align-middle">Economy Seats</th>
							<th class="align-middle">Business Seats</th>
							<th class="align-middle">Economy Amount</th>
							<th class="align-middle">Business Amount</th> 
							<th class="align-middle">Modify</th> 
						</tr>
					</thead>
					<tbody id="myTableBody">
					<% 
						for(Flight f : list){
					%>
						<tr style="">
							<td class="align-middle"><%= f.getFlightId() %></td>
							<td class="align-middle"><%= f.getSource() %></td>
							<td class="align-middle"><%= f.getDestination() %></td>
							<td class="align-middle"><%= f.getDate() %></td>
							<td class="align-middle"><%= f.getTime() %></td>
							<td class="align-middle"><%= f.getSeatsEconomy() %></td>
							<td class="align-middle"><%= f.getSeatsBuisness() %></td>
							<td class="align-middle"><%= f.getAmountEconomy() %></td>
							<td class="align-middle"><%= f.getAmountBuisness() %></td>
							<td class="align-middle">
								<a href="flight_update.jsp?flightId=<%=f.getFlightId()%>">
								<button  type="button" class="btn btn-info  btn-sm" id="btn0"  data-toggle="modal" data-target="#myModal">Update</button>
								</a>
								<a href="flight_delete.jsp?flightId=<%=f.getFlightId()%>" 
				onclick="if(!(confirm('Are You Sure you want to delete ?'))) return false" >
				<button type="button" class="btn btn-danger  btn-sm" id="btn0" data-toggle="modal" data-target="#myModal">Delete</button></a>

							
				
							
							</td>
							
						</tr>
						<% } %>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-xl">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title" id="modal-title" style="text-align: center"></h3>
				</div>
				<div class="modal-body container-fluid">
					<h3 class="text-center" style="margin-top: 0px"><small>Click on colored code snippets to compare. Same colored codes have possible similarities.</small></h3>
					<div class="row content" id="code_modal">
						<div class=" col-sm-6 container">
							<div id="name_1" style="text-align: center"></div>
							<div id="code_1_div"></div>
						</div>
						<div class=" col-sm-6 container">
							<div id="name_2" style="text-align: center"></div>
							<div id="code_2_div"></div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
        
      </div>
    </div>
    <footer class="page-footer font-small bg-dark text-light fixed-bottom">
      <div class="footer-copyright text-center">Created by : SUPER30</div>
      <!-- Copyright -->
      <div class="footer-copyright text-center">
        © 2020 Copyright:
        <a href="https://mdbootstrap.com/"> CDAC</a>
      </div>
      <!-- Copyright -->
    </footer>
</body>
</html>