<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>에러페이지</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
  </head>


  <body>

<div class="page-header" style="text-align: center;">
<h1 style="margin-left:50px;"><img src="dog.png" width="40px", height="40px" style="margin-right: 15px;">에러페이지</h1>  
</div>

<div class="jumbotron text-center" style="background-image: url('img/bg-masthead.jpg');">
 <div class="container">
  <h1>실패 하셨습니다.</h1>
  <p>메인페이지로 돌아가주십시오.</p>
   <p><a class="btn btn-danger btn-lg" onclick="location='FoodMain.jsp'" role="button">메인페이지로</a></p>
 </div>
</div>
</html>