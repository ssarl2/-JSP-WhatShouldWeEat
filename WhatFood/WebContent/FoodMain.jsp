<%@page import="food.table.Member"%>
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
    

    <title>오늘 뭐먹지?</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/landing-page.min.css" rel="stylesheet">
    
    <script type="text/javascript">
    function loginChk() {
    	var user = '<c:out value="${member}"/>';
    	
		if(!user)
			alert("로그인 후 사용 가능합니다.");
		else
			window.location.href = 'FoodSelect';
	}
    </script>
  </head>

  <body>
<%
session.setAttribute("count", 0);
%>
    <!-- Navigation -->
    <nav class="navbar navbar-light bg-light static-top">
      <div class="container">
        <a class="navbar-brand" style="color:gray; font-weight: bold">오늘 뭐먹지 ?</a>
		<c:choose>
			<c:when test="${not empty member}">
			<a class="btn btn-secondary" onclick="location='MemberSelected.jsp'" style="color:white; ">추천목록</a>
			<a class="btn btn-warning" onclick="location='FoodAdd'" style="color:white; margin-right: 30px;">음식추가</a>
    		<span style="color:black;  font-weight: bold">"${member.id}"님 반갑습니다.</span> 
    		<a class="btn btn-primary" onclick="location='MemberModify'" style="color:white; margin-left: 30px;">회원수정</a>
    		<a class="btn btn-info" onclick="location='Board'" style="color:white"> &nbsp;게시판&nbsp;</a>
    		<a class="btn btn-danger" onclick="location='Logout'" style="color:white">로그아웃</a>
  			</c:when>
  			<c:otherwise>
     	   	<div>
       		<a class="btn btn-primary" onclick="location='Login'" style="color:white">로그인</a>
        	<a class="btn btn-primary" onclick="location='MemberAdd'" style="color:white">회원가입</a>
        	</div>
        	</c:otherwise>
        </c:choose>
      </div>
    </nav>

    <!-- Masthead -->
    <header class="masthead text-white text-center">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-xl-9 mx-auto">
            <h1 class="mb-5">오늘 뭐먹지 ? 고민하지마세요. 우리가 추천해드릴께요.</h1>
          </div>
          <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
               <button type="button" onclick="loginChk()" class="btn btn-block btn-primary" >추천 받기 !</button>
          </div>
        </div>
      </div>
    </header>

    <!-- Icons Grid -->
    <section class="features-icons bg-light text-center">
      <div class="container">
        <div class="row">
          <div class="col-lg-4">
            <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
              <div class="features-icons-icon d-flex">
                <i class="icon-screen-desktop m-auto text-primary"></i>
              </div>
              <h3>음식 추천 사이트중 1위</h3>
              <p class="lead mb-0">여기서 느껴보세요 일등의 위엄을.</p>
            </div>
          </div>
          <div class="col-lg-4">
            <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
              <div class="features-icons-icon d-flex">
                <i class="icon-layers m-auto text-primary"></i>
              </div>
              <h3>고객 맞춤</h3>
              <p class="lead mb-0">압도적인 데이터양으로 우린 가능합니다. </p>
            </div>
          </div>
          <div class="col-lg-4">
            <div class="features-icons-item mx-auto mb-0 mb-lg-3">
              <div class="features-icons-icon d-flex">
                <i class="icon-check m-auto text-primary"></i>
              </div>
              <h3>편리한 UI</h3>
              <p class="lead mb-0">남녀노소 누구나 편하게 만들었습니다.</p>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Image Showcases -->
    <section class="showcase">
      <div class="container-fluid p-0">
        <div class="row no-gutters">

          <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('img/koreanfood.png');"></div>
          <div class="col-lg-6 order-lg-1 my-auto showcase-text">
            <h2>한식</h2>
            <p class="lead mb-0">밥, 죽, 국수, 국, 찌개, 전골, 볶음, 찜, 선, 생채, 나물, 조림, 초, 전유어, 구이, 적, 회, 쌈, 편육, 족편, 튀각, 부각, 포, 장아찌, 김치, 젓갈 등등</p>
          </div>
        </div>
        <div class="row no-gutters">
          <div class="col-lg-6  text-white showcase-img" style="background-image: url('img/chfood.jpg');"></div>
          <div class="col-lg-6 my-auto showcase-text">
            <h2>중식</h2>
            <p class="lead mb-0">깐쇼새우, 깐풍기, 꽃빵, 탄카오루양, 난자완스, 도삭면, 동파육, 딤섬, 딴딴면, 라몐, 라조기, 랑샤, 마라탕, 마파두부, 만두, 만터우, 멘보샤, 볶음밥, 불도장, 빙탕후루, 삼부점, 우육면 등</p>
          </div>
        </div>
        <div class="row no-gutters">
          <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('img/italyfood.jpg');"></div>
          <div class="col-lg-6 order-lg-1 my-auto showcase-text">
            <h2>양식</h2>
            <p class="lead mb-0">햄버거, 핫도그, 스테이크, 바비큐, 데리야키, 콘도그, 스팸, 버팔로 윙, 터키 로스트, 프라이드 치킨, 로코모코, 슬리피 조, 마카로니, 피자, 샌드위치, 랍스터, 잠발라야, 샐러드, 검보, 클램차우더, 그리츠, 브라우니, 쉬폰 케이크, 애플파이 등</p>
          </div>
        </div>
           <div class="row no-gutters">
          <div class="col-lg-6 text-white showcase-img" style="background-image: url('img/japanesefood.png');"></div>
          <div class="col-lg-6 my-auto showcase-text">
            <h2>일식</h2>
            <p class="lead mb-0">오니기리, 돈부리, 카마메시, 스시, 오차즈케, 우동, 소바, 소면, 라멘, 오코노미야키, 타코야키, 돈돈야키, 덴뿌라, 샤브샤브, 스키야키, 부타나베, 오뎅, 야키토리, 가라아케, 도테야키 등</p>
          </div>
          </div>
      </div>
    </section>

    <br>
    <br>

    <!-- Call to Action -->
    <section class="call-to-action text-white text-center">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-xl-9 mx-auto">
            <h2 class="mb-4">지금 바로 이용해 보세요!</h2>
          </div>
          <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
            <form>
              <div class="form-row">
                <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
               <button type="submit" class="btn btn-block btn-primary">추천 받기 !</button>
               </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>

    <!-- Footer -->
    <footer class="footer bg-light">
      <div class="container">
        <div class="row">
          <div class="col-lg-6 h-100 text-center text-lg-left my-auto">
            <ul class="list-inline mb-2">
              <li class="list-inline-item">
                <a href="#">About</a>
              </li>
              <li class="list-inline-item">&sdot;</li>
              <li class="list-inline-item">
                <a href="#">Contact</a>
              </li>
              <li class="list-inline-item">&sdot;</li>
              <li class="list-inline-item">
                <a href="#">Terms of Use</a>
              </li>
              <li class="list-inline-item">&sdot;</li>
              <li class="list-inline-item">
                <a href="#">Privacy Policy</a>
              </li>
            </ul>
            <p class="text-muted small mb-4 mb-lg-0">&copy; Your Website 2018. All Rights Reserved.</p>
          </div>
          <div class="col-lg-6 h-100 text-center text-lg-right my-auto">
            <ul class="list-inline mb-0">
              <li class="list-inline-item mr-3">
                <a href="#">
                  <i class="fab fa-facebook fa-2x fa-fw"></i>
                </a>
              </li>
              <li class="list-inline-item mr-3">
                <a href="#">
                  <i class="fab fa-twitter-square fa-2x fa-fw"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <i class="fab fa-instagram fa-2x fa-fw"></i>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>