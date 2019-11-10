<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>비밀번호 찾기</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <script type="text/javascript">
    function CheckForm(){
		var form = document.pwLoss;

        if(!form.lossId.value){
                alert("아이디를 입력하세요.");
                form.lossId.focus();
                return false;
        }
    }
 </script>
    
  </head>
  <body>

<div class="page-header" style="text-align: center;">
<h1 style="margin-left:50px;"><img src="dog.png" width="40px", height="40px" style="margin-right: 15px;">비밀번호 찾기</h1>  
</div>

<div class="container">
  <div class="row">
    <div class="col-md-8 col-md-offset-4">
<form name="pwLoss" action="PasswordLoss" method='post' onSubmit="return CheckForm()">      
<table class="table table-striped" style="width: 400px; text-align: center;">
 
  <tbody>
    <tr>
      <td style="text-align: left;">아이디*</td>
      <td>
          <div class="form-group">
          <input type="text" class="form-control" name=lossId pattern="[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*" placeholder="ID..."></div></td>
    </tr>

  </tbody>
</table>

<div class="col-sm-10 col-sm-offset-2">
 <button type="submit" class="btn btn-info">비밀번호 이메일로 전송받기</button>
 <button type="button" onclick="location='Login'" class="btn btn-danger">취소</button>
  </div>
</form>
    </div>    
  </div>
</div>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

  </body>
</html>