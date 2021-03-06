<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>음식 추천 결과</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/landing-page.min.css" rel="stylesheet">

  </head>

  <body>
<c:if test="${empty member}">
<%
response.sendRedirect("Login");
%>
</c:if>

<%
session.setAttribute("count", 0);
%>
    <!-- Navigation -->
    <nav class="navbar navbar-light bg-light static-top">
      <div class="container">
        <a class="navbar-brand" style="color:gray" >오늘 뭐먹지 ?</a>
        <a class="btn btn-primary" onclick="location='FoodMain.jsp'" style="color:white">메인페이지로</a>
      </div>
    </nav>

    <!-- Masthead -->
    <header class="masthead text-white text-center">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-xl-9 mx-auto">
            <c:choose>
			<c:when test="${member.selects eq ''}">
			<h1 class="mb-5" style="color:#E2ECFF">음식 추천을 한번 이상 해주시기 바랍니다.</h1>
			<h1>&nbsp;</h1>
  			</c:when>
  			<c:otherwise>
  			<h1 class="mb-5" style="color:#E2ECFF">회원님이 선택했던 음식은 </h1>
        	<h1 style="color:#E2ECFF"> ${member.selects},,입니다.</h1><h1>&nbsp;</h1>
        	</c:otherwise>
        </c:choose>
            <a class="btn btn-primary" onclick="location='FoodMain.jsp'" style="color:white">돌아가기</a>
          </div>
        </div>
         
      </div>
    </header>
  </body>
</html>