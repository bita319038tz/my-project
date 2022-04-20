<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="author" content="State University of Zanzibar">

  <title>Login Page</title>
  <!-- Bootstrap CSS -->
  <link href="vendors/css/bootstrap.min.css" rel="stylesheet">
  <!-- bootstrap theme -->
  <link href="vendors/css/bootstrap-theme.css" rel="stylesheet">
  <!--external css-->
  <!-- font icon -->
  <link href="vendors/css/elegant-icons-style.css" rel="stylesheet" />
  <link href="vendors/css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles -->
  <link href="vendors/css/style.css" rel="stylesheet">
  <link href="vendors/css/style-responsive.css" rel="stylesheet" />
  <link href="vendors/custom/css/custom.css" rel="stylesheet" type="text/css"/>
</head>

<body class="login-img3-body">

  <div class="container">
      <form class="login-form" action="login" method="POST">
      <div class="login-wrap">
        <div class="login-img text-center" style="color: #34aadc"><i class="icon_lock_alt"></i></div>
        <div class="form-group">
            <label>Username</label>
            <div class="input-group">
              <span class="input-group-addon"><i class="icon_profile"></i></span>
              <input type="text" name="username" class="form-control" placeholder="Username" id="username">
            </div>
             <span class="error"></span>  
        </div>
        <div class="form-group">
            <label>Password</label>
            <div class="input-group">
              <span class="input-group-addon"><i class="icon_key_alt"></i></span>
              <input type="password" name="password" class="form-control"  placeholder="Password" id="password">
            </div>
             <span class="error"></span>  
        </div>
        <label class="checkbox">
            <span class="pull-right"> <a href="#" style="color: black"> Forgot Password?</a></span>
        </label>
        <button class="btn btn-primary btn-lg btn-block" style="margin-bottom: 40px;background: #394a59;font-weight: bold" type="submit">Login</button>
        <div class="text-center error"><%
        if(request.getSession().getAttribute("error") != null){
        	out.println(request.getSession().getAttribute("error"));
        }
        request.getSession().setAttribute("error", null);
        session.invalidate();
        %></div>
      </div>
    </form>
  </div >

</body>

</html>
