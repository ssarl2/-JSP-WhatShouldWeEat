<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${board.title}</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<c:if test="${empty member}">
<%
response.sendRedirect("Login");
%>
</c:if>
<div class="page-header">
<h1 style="margin-left:50px;"><center><img src="dog.png" width="40px", height="40px" style="margin-right: 15px;">${board.title}</center></h1>  
</div>
<div class="container">
  <div class="row">
    <div>
      
<table class="table table-striped" style="text-align: center;">

  <tbody>
  <tr>
    <td>글번호</td>
    <td style="text-align: left;">${board.bno}</td>
  </tr>

  <tr>
    <td>작성자</td>
    <td style="text-align: left;">${board.id}</td>
  </tr>
  
  <tr>
    <td>작성일</td>
    <td style="text-align: left;">${board.created}</td>
  </tr>

  <tr>
    <td>조회수</td>
    <td style="text-align: left;">${board.views}</td>
  </tr>

  <tr>
    <td>제목</td>
    <td style="text-align: left;">${board.title}</td>
  </tr>
    
    <tr>
      <td>내용</td>
      <td style="text-align: left;">${board.contents}</td>
    </tr>
  
  </tbody>
  <tbody>
  <!-- 해당 게시글 작성자 인지에 따라 수정버트을 나타낼지 안나타낼지 정하는 자바 코드. 자바 코드는 나도 넣기 싫었음. -->
	    
  </tbody>
</table>
    </div>    
  </div>
</div>
<div style="margin-top: 200px;">
<tr><td>
	    	    <div style="text-align: center;">
	    <%
	    	Boolean check = (Boolean) request.getAttribute("check");
	    	if(check){
	    %>

	    	  <input type="button" onclick="location.href='BoardEdit?bno=${board.bno}'" class="btn btn-info" value="수정">
	    <%
	    	}
	    %>
		      <input type="button" onclick="location.href='Board'" class="btn btn-info" value="목록">
		      </div>
	    </td></tr>
	    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>