<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>게시판</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
  </head>
<body>
<c:if test="${empty member}">
<%
response.sendRedirect("Login");
%>
</c:if>

<style type="text/css">
  .custab{
    border: 1px solid #ccc;
    padding: 5px;
    margin: 5% 0;
    box-shadow: 3px 3px 2px #ccc;
    transition: 0.5s;
    }  /*수정,삭제*/
.custab:hover{
    box-shadow: 3px 3px 0px transparent;
    transition: 0.5s;
    }  /*수정,삭제*/
  </style>

   <div class="btn-group btn-group-lg navbar-right" style="margin-top:30px; margin-right: 70px;" >
  <button type="button" onclick="location.href='FoodMain.jsp'" class="btn btn-info">메인페이지로</button>
   </div>


<br>

<div class="page-header">
<h1 style="margin-left:50px;"><center><img src="dog.png" width="40px", height="40px" style="margin-right: 15px;">자유게시판</center></h1>  
</div>

<form action='Board' method='post' class="navbar-form navbar-right" role="search" style="margin-right: 55px;">
  <div class="form-group">
  	<a class="btn btn-info" onclick="location='Board'" style="color:white; margin-right: 30px;">자유게시판</a>
    <input type="text" name="title" class="form-control" placeholder="Search">
  </div>
  <button type="submit" class="btn btn-default">검색하기</button>
</form>
<table class="table table-striped text-center">
  <thead>
    <tr>
      <th><center>글번호*</center></th>
      <th><center>제목*</center></th>
      <th><center>글쓴이*</center></th>
      <th><center>조회수*</center></th>
      <th><center>작성일*</center></th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="board" items="${board}">
		<tr>
		  <td>${board.bno}</td>
	      <td><a href='BoardInner?bno=${board.bno}&views=${board.views+1}&id=${board.id}'>${board.title}</a></td>
	      <td>${board.id}</td>
	      <td>${board.views}</td>
	      <td>${board.created}</td>
    	</tr>
    </c:forEach>
  </tbody>
</table>
  <a class="btn btn-default pull-right" onclick="location='BoardAdd'" style="margin-right:70px;">글쓰기</a>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

  </body>
</html>