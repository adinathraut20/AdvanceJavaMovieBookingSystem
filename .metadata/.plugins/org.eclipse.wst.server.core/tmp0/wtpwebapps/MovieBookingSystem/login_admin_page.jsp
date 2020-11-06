<%@page import="org.springframework.web.servlet.view.RedirectView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    
    
<!DOCTYPE html>
<html lang="en">

    <head>
        <title> Watch Movies </title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="Stylesheet" type="text/css" href="login.css">

        <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        
    </head>

    <body>
         <div class="container-fluid">
            <div class="row">
                <div class="col-6 d-flex justify-content-center align-items-center" id="nav" style="height: 15vh; background-color: black;">
                    <font color="white"> &#127909;</font>&nbspBOOK MY TICKET 
                </div>
                <div class="col-6" style="margin-top: 20vh;">
                    <div class="d-flex justify-content-center h-100">
                        <div class="card">
                            <div class="card-header">
                                <h3>Sign In</h3>
                                <div class="d-flex justify-content-end social_icon">
                                    <span><i class="fab fa-facebook-square"></i></span>
                                    <span><i class="fab fa-google-plus-square"></i></span>
                                    <span><i class="fab fa-twitter-square"></i></span>
                                </div>
                            </div>
                            <div class="card-body ">
                                <spr:form action="admin_log_validate.htm" method="post" commandName="admin">
                                    <div class="input-group form-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                                        </div>
                                        <spr:input type="text" path="email" class="form-control" placeholder="username"/>
                                        
                                    </div>
                                    <font color="red" ><spr:errors path="email" ></spr:errors></font>
                                    <div class="input-group form-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                                        </div>
                                        <spr:input type="password" path="password" class="form-control" placeholder="password"/>
                                        
                                    </div>
                                    <font color="red" ><spr:errors path="password" ></spr:errors></font>
                                    
                                    <div class="row align-items-center remember">
                                        <input type="checkbox">Remember Me
                                    </div>
                                    <div class="form-group">
                                        <input type="submit" value="Login" class="btn float-right login_btn">
                                    </div> <span style="color:red;">
                                    <%=((session.getAttribute("err_mssg") != null)?(String)session.getAttribute("err_mssg") : "") %></span>
                                    <span style="color:green;">
                                    <%=((session.getAttribute("err_mssg1") != null)?(String)session.getAttribute("err_mssg1") : "") %></span>
                                </spr:form>
                            </div>
                            <div class="card-footer">
                                
                                <div class="d-flex justify-content-center">
                                     <a href="prep_log_form.htm">User Login?</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
         </div>
      
    </body>

</html>
