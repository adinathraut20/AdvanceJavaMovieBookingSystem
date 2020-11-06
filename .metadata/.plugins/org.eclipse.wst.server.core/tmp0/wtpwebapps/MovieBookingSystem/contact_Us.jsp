<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>
        Watch movies
    </title>
    <link rel="stylesheet" href="contact.css">
</head>
<body style="display: flex; justify-content: center; align-items: center; height: 80vh; background-color: rgb(0, 0, 0); color:white; font-size: xx-large;">
    <div class="container-fluid">
    <div class="row" style="border: solid 5px black; padding: 50px;">
        
       <h2>&#xf27b;CONTACT US</h2>

    <div id="form-main">
        <div id="form-div">
          <form class="montform" id="reused_form" action="prep_log_form.htm">
            <p class="name"> 
                <input  style="font-size: large; width:57vh; padding: 20px ;" name="name" type="text" class="feedback-input" required placeholder="&#xf2b9; Enter your name" id="name" />
            </p>
            <p class="email">
              <input  style="font-size: large;width:57vh; padding: 20px ;" name="email" type="email" required  class="feedback-input" id="email" placeholder="&#xf0e0; Email" />
            </p>
            <p class="text">
              <textarea  style="font-size: large; width:57vh; padding: 20px ;" name="message" class="feedback-input" id="comment" placeholder="&#9829; We would love to hear from you."></textarea>
            </p>
            <div style="display: flex; justify-content: center; align-items: center;">
                  <div class="submit">
              <button  style="font-size: large; padding: 15px ; border-radius: 20px;" type="submit" class="button-blue">SUBMIT</button>
              <div class="ease"></div>
            </div>
        </div>
          </form>
                <div id="error_message" style="width:100%; height:100%; display:none; ">
                      <h4>Error</h4>
                      Sorry there was an error sending your form.
                </div>
                <div id="success_message" style="width:100%; height:100%; display:none; ">
                <h2>Success! Your Message was Sent Successfully.</h2>
                </div>
          </div>
      </div>
    </div>
</div>
</body>
</html>