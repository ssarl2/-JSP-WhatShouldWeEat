<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>게시글 쓰기</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
<c:if test="${empty member}">
<%
response.sendRedirect("Login");
%>
</c:if>

<div class="page-header" style="text-align: center;">
<h1 style="margin-left:50px;"><img src="dog.png" width="40px", height="40px" style="margin-right: 15px;">게시글 쓰기</h1>  
</div>
<form action='BoardAdd' method='post'>
<div class="container">
  <div class="row">
    <div>
      
<table class="table table-striped" style="text-align: center;">

  <tbody>
    <tr>
      <td style="text-align: left;">제목</td>
      <td>
          <div class="form-group">
          <input type="text" class="form-control" placeholder="Title.." name="title"></div></td>
    </tr>
    <tr>
      <td style="text-align: left;">내용</td>
      <td>
          <div class="form-group">
			<label for="exampleFormControlTextarea1"></label>
			<textarea class="form-control" name='contents' rows="5" placeholder='자유롭게 적어주세요.'></textarea>
			</div></td>
    </tr>
  
  </tbody>
</table>
    </div>    
  </div>
</div>

<div style="text-align: center;"> 
 <button type='submit' class="btn btn-info">확인</button>
 <button type="button" onclick='location.href="Board"' class="btn btn-danger">취소</button>
  </div>
</form>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

  </body>
</html>