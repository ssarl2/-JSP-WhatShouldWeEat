<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ȸ������ ������</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">

  	<script type="text/javascript">
    function CheckForm(){
		var form = document.changeInfo;

        if(!form.pw.value){
                alert("��й�ȣ�� �Է��ϼ���.");
                form.pw.focus();
                return false;
        }
        
        if(!form.newPw.value){
            alert("��й�ȣ�� �Է��ϼ���.");
            form.pw.focus();
            return false;
   		}
        
        if(!form.newPwck.value){
           		alert("��й�ȣ Ȯ���� �Է��ϼ���.");
           		form.pwck.focus();
           		return false;
 	   	}
        else if(form.newPwck.value != form.newPw.value){
        		alert("��й�ȣ Ȯ�ΰ� ��й�ȣ�� ���� �ʽ��ϴ�.");
        		form.newPwck.value = "";
        		form.newPwck.focus();
       			return false;
        }
		
		if(!form.age.value){
                alert("���̸� �Է��ϼ���.");
                form.age.focus();
                return false;
        }
		
		if(!form.sex.value){
            alert("������ �Է��ϼ���.");
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
      <td style="text-align: left;">��й�ȣ*</td>
      <td>
          <div class="form-group">
          <input type="password" class="form-control" name='pw' pattern=".{8,}" placeholder="8�ڸ� �̻�"></div></td>
    </tr>
    
    <tr>
      <td style="text-align: left;">�� ��й�ȣ*</td>
      <td>
          <div class="form-group">
          <input type="password" class="form-control" name='newPw' pattern=".{8,}" placeholder="8�ڸ� �̻�"></div></td>
    </tr>
    
    <tr>
      <td style="text-align: left;">�� ��й�ȣ Ȯ��*</td>
      <td>
          <div class="form-group">
          <input type="password" class="form-control" name='newPwck' pattern=".{8,}" placeholder="8�ڸ� �̻�"></div></td>
    </tr>
    
    <tr>
      <td style="text-align: left;">����*</td>
      <td>
          <div class="form-group">
          <input type="number" class="form-control" name='age' placeholder="age.."></div></td>
    </tr>

    <tr>
      <td style="text-align: left;">����*</td>
     <td><div class="btn-group">
 		<select class="custom-select" name='sex'>
  		<option selected value="">����</option>
 	 	<option value="man">����</option>
  		<option value="woman">����</option>
		</select>
</div>
          </td>
    </tr>
  </tbody>
</table>

<div class="col-sm-4 col-sm-offset-4">
 <button type="submit" class="btn btn-info">�����ϱ�</button>
 <button type="button" onclick="location='FoodMain.jsp'" class="btn btn-danger">���</button>
  </div>

    </div>    
  </div>
</div>
</form>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

  </body>
</html>