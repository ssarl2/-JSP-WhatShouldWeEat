<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>loging page</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>

<div class="page-header" style="text-align: center;">
<h1 style="margin-left:50px;"><img src="dog.png" width="40px" height="40px" style="margin-right: 15px;">login page</h1>  
</div>
<form class="form-inline" action='Login' method='post'>
<div class="container">
  <div class="row">
    <div class="col-md-8 col-md-offset-4">
      
<table class="table table-striped" style="width: 400px; text-align: center;">
 
  <tbody>
    <tr>
      <td style="text-align: left;">아이디*</td>
      <td>
          <div class="form-group">
          <input type="text" name=id class="form-control" placeholder="ID..."></div></td>
    </tr>

    <tr>
      <td style="text-align: left;">비밀번호*</td>
      <td>
          <div class="form-group">
          <input type="password" name=pw class="form-control" placeholder="Passward..."></div></td>
    </tr>
     
  </tbody>
</table>

 <div>
 <button type="button" onclick="location='MemberAdd'" class="btn btn-info btn-sm">회원가입</button>
 <button type="button" onclick="location='PasswordLoss'" class="btn btn-info btn-sm">비밀번호 찾기</button>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <button type="submit" class="btn btn-info btn-sm">로그인하기</button>
 <button type="button" onclick="location='FoodMain.jsp'" class="btn btn-danger btn-sm">취소</button>
  </div>

      </div>    
    </div>
  </div>
</form>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

  </body>
</html>