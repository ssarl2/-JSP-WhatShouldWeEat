<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>회원가입 페이지</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">

  	<script type="text/javascript">
    function CheckForm(){
		var form = document.changeInfo;

        if(!form.pw.value){
                alert("비밀번호를 입력하세요.");
                form.pw.focus();
                return false;
        }
        
        if(!form.newPw.value){
            alert("비밀번호를 입력하세요.");
            form.pw.focus();
            return false;
   		}
        
        if(!form.newPwck.value){
           		alert("비밀번호 확인을 입력하세요.");
           		form.pwck.focus();
           		return false;
 	   	}
        else if(form.newPwck.value != form.newPw.value){
        		alert("비밀번호 확인과 비밀번호가 맞지 않습니다.");
        		form.newPwck.value = "";
        		form.newPwck.focus();
       			return false;
        }
		
		if(!form.age.value){
                alert("나이를 입력하세요.");
                form.age.focus();
                return false;
        }
		
		if(!form.sex.value){
            alert("성별을 입력하세요.");
            form.sex.focus();
            return false;
    	}
	
    }
 </script>
  
  </head>
  <body>
<c:if test="${empty member}">
<%
response.sendRedirect("Login");
%>
</c:if>

<div class="page-header" style="text-align: center;">
<h1 style="margin-left:50px;"><img src="dog.png" width="40px" height="40px" style="margin-right: 15px;">Modify page</h1>  
</div>
<form name="changeInfo" action="MemberModify" method='post' onSubmit="return CheckForm()">
<div class="container">
  <div class="row">
    <div class="col-md-8 col-md-offset-4">
      
<table class="table table-striped" style="width: 400px; text-align: center;">
 
  <tbody>
    <tr>
      <td style="text-align: left;">비밀번호*</td>
      <td>
          <div class="form-group">
          <input type="password" class="form-control" name='pw' pattern=".{8,}" placeholder="8자리 이상"></div></td>
    </tr>
    
    <tr>
      <td style="text-align: left;">새 비밀번호*</td>
      <td>
          <div class="form-group">
          <input type="password" class="form-control" name='newPw' pattern=".{8,}" placeholder="8자리 이상"></div></td>
    </tr>
    
    <tr>
      <td style="text-align: left;">새 비밀번호 확인*</td>
      <td>
          <div class="form-group">
          <input type="password" class="form-control" name='newPwck' pattern=".{8,}" placeholder="8자리 이상"></div></td>
    </tr>
    
    <tr>
      <td style="text-align: left;">나이*</td>
      <td>
          <div class="form-group">
          <input type="number" class="form-control" name='age' placeholder="age.."></div></td>
    </tr>

    <tr>
      <td style="text-align: left;">성별*</td>
     <td><div class="btn-group">
 		<select class="custom-select" name='sex'>
  		<option selected value="">성별</option>
 	 	<option value="man">남성</option>
  		<option value="woman">여성</option>
		</select>
</div>
          </td>
    </tr>
  </tbody>
</table>

<div class="col-sm-4 col-sm-offset-4">
 <button type="submit" class="btn btn-info">수정하기</button>
 <button type="button" onclick="location='FoodMain.jsp'" class="btn btn-danger">취소</button>
  </div>

    </div>    
  </div>
</div>
</form>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

  </body>
</html>