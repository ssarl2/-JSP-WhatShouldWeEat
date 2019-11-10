<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>음식 추천</title>

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
	<form name="selectInfo" action="FoodSelect" method='post' onSubmit="return CheckForm()">
    <!-- Navigation -->
    <nav class="navbar navbar-light bg-light static-top">
      <div class="container">
        <a class="navbar-brand" style="color:gray; font-weight: bold" >음식 추천!</a>
        <a class="btn btn-primary" onclick="location='FoodMain.jsp'" style="color:white">메인페이지로</a>
      </div>
    </nav>

    <!-- Masthead -->
    <header class="masthead text-white text-center">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-xl-9 mx-auto">
            <h1 class="mb-5">${question} 어떻습니까?</h1>
            <button type="submit" id="valueId" name="answer" value="true" onClick="checkBtn(this.form.valueId.value)" class="btn btn-primary">좋아요</button>
            <button type="submit" id="valueId" name="answer" value="false" onClick="checkBtn(this.form.valueId.value)" class="btn btn-danger">싫어요</button>
          </div>
        </div>
         
      </div>
    </header>
    </form>
  </body>
</html>