<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="fp.css">
  <title>Watch Movies</title>
</head>
<body>
  <div class="fp-wrapper">
    <form action="forgot_password.htm" method="post" class="form">
      <img src="forgetpasspop.png" alt="popcorn">

      <h3><i class="fa fa-lock fa-4x"></i></h3>
                  <h2 class="text-center">Forgot Password?</h2>
                  <p>You can reset your password here.</p>
                  
            
                  <div class="form-group">
                    <div class="input-group">
                     
                      <input id="email" name="email" placeholder="Enter your registered e-mail address" class="form-control"  type="email">
                    </div>
                  </div>

      <input type="submit" value="SUBMIT" class="submit-btn">
      
    </form>

    <div id="forgot-pw">
      <form action="" class="form">
        <a href="/aish"></a>
        <h2>Reset Password</h2>
        <div class="input-group">
          <input type="email" name="email" id="email" required/>
          <label for="email">Email</label>
        </div>
        
      </form>
    </div>
  </div>
</body>
</html>