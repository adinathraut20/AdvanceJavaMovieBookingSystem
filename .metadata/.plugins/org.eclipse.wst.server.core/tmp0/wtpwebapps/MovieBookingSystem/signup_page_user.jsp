<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>


<!DOCTYPE html>
<html lang="en">
    <head> 
		<title> Watch Movie</title>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		<!-- jQuery and JS bundle w/ Popper.js -->
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

		
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">		
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
        <link rel="stylesheet"  href="signup.css">
		<!--<link rel="stylesheet" href="style.css"> -->
		<title>User Registration</title>
		
	</head>
	<body>
		<div class="container-fluid">
			<div class="row" style="height: 4vh; color:white; font-size: x-large; font-family:cursive; padding:15px;">
				<font color="white"> &#127909;</font>&nbspBOOK MY TICKET 
			</div>
					
						  
					  <div class="row justify-content-center align-items-center mt-5">
            <div class="col-12 col-md-6 shadow-lg justify-content-center rounded align-items-center my-4"
                style="background-color: rgba(235, 235, 235,0.95);">
                <h1 style="text-align: center; margin-top: 30px; margin-bottom: 30px ;">
                    Sign Up</h1>
                <spr:form action="registerValidateUser.htm" class="row justify-content-center align-items-center" method="post"  commandName="user">
                
                    <div class="col-12 d-flex justify-content-center align-items-center">
                        <div class="was-validated" style="width:60%;">

                            <label for="">First Name</label>
                            <spr:input  type="text"  path="uFname" class="form-control mb-4 border" 
                                id="F_Name" placeholder="First Name" pattern="[a-zA-Z]{1,20}" maxlength="20"
                                minlength="1" required="required" />
                                <font color="red" ><spring:errors path="uFname" ></spring:errors></font>
                            <label for="">Last Name</label>
                            <spr:input  type="text" path="uLname" class="form-control mb-4 border" 
                                id="L_Name" placeholder="Last Name" pattern="[a-zA-Z]{1,20}" maxlength="20"
                                minlength="1" required="required" />
                                <font color="red" ><spring:errors path="uLname" ></spring:errors></font>

                            <label for="">Email</label>
                            <spr:input  type="email" path="email" class="form-control mb-4 border" name="Email"
                                id="Email_id" placeholder="Email" 
                                pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$" maxlength="50" minlength="6"
                                required="required" />
								<font color="red" ><spring:errors path="email" ></spring:errors></font>
                            <label for="">Mobile No.</label>
                            <spr:input  type="number" path="contact" class="form-control mb-4 border" 
                                id="Contact" placeholder="Mobile No." maxlength="15" minlength="8" required="required"/>
                                <font color="red" ><spring:errors path="contact" ></spring:errors></font>
                            <label for="">Password</label>
                            <spr:input type="password" path="password" class="form-control mb-4 border"
                                id="password1" placeholder="Password" maxlength="15" minlength="8" required="required"/>
                           
                            
                            <input  type="submit" class="btn btn-success my-4" name=""
                                id="submit1" value="Create Account"  style="width:100%;">
							<div style="text-align:center"><span style="color:red;">
                                    <%=((session.getAttribute("err_mssg") != null)?(String)session.getAttribute("err_mssg") : "") %></span></div>
                            <div id="helpId" class="form-text text-muted d-flex justify-content-center mt-3 mb-5"><a
                                    href="prep_log_form.htm">Already have an Account!</a></div>
                        </div>
                    </div>
                </spr:form>
            </div>
        </div>	
					  
				
					  
					  
				</div>
		
		
		</body>
	
</html>




<%
session.removeAttribute("err_mssg");
session.removeAttribute("err_mssg1");
%>