 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<style>
	
	
	.lform{
	width:100%;
box-sizing:border-box;
padding:10px 0;
margin-top:30px;
outline:none;
background:black;
opacity:0.7;
border-radius:20px;
font-size:20px;
color:white;
border : 1px solid red";
	}
	
	
	.loginsec{
max-width:450px;
border-radius:0 0 20px 20px;
margin:auto;
background:rgba(0,0,0,0.8);
box-sizing:border-box;
padding:20px;
color:#fff;
}
img{
max-width:450px;
width:450px;
display:block;
margin-left:auto;
margin-right:auto;
}
</style>

<body>


<img src='../img/movie.jfif' height="250">
<div class="loginsec">
<form method="post" action="loginOK">
<input class='lform' type='text' name='userid' placeholder='  ID'/>
<input class='lform' type='password' name='password' placeholder='  Password'/>
<button class='lform' type='submit'>login</button>
</form>

<form method="get" action="signup">
<button id="signupb" class='lform' type='submit' value='./signup.jsp'>Sign up</button>
</form>

</div>

</body>
</html>