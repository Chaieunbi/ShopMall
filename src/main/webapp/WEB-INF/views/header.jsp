<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Disney Shop</title>
  <link href="css/shopping.css" rel="stylesheet">  
  <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
  <script type="text/javascript" src="member/member.js"></script>
  <script type="text/javascript" src="mypage/mypage.js"></script> 
  <script type="text/javascript" src="member/findIdAndPassword.js"></script>
  <script type="text/javascript" src="product/product.js"></script>
  <script type="text/javascript" src="review/review.js"></script>
</head>

<body>
<div id="wrap">
<!--헤더파일 들어가는 곳 시작 -->
  <header>
    <!--로고 들어가는 곳 시작--->  
    <div id="logo">
      <a href="index">
        <img src="images/logo_image_1.jpg" width="180" height="80" alt="disneyshop">
      </a>  
    </div>
    <!--로고 들어가는 곳 끝-->  
    
    <nav id="catagory_menu">
     <ul>
       <c:choose>
       <c:when test="${empty sessionScope.loginUser}">
       <li>         
         <a href="login_form" style="width:90px;">Login</a>   
	     <a href="admin_login_form" style="width:90px;">Admin Login</a>
	   </li> 
       <li><a href="contract">Register</a></li>
       </c:when>
       <c:otherwise>
       <li style="color:black">
         ${sessionScope.loginUser.name}(${sessionScope.loginUser.id})
       </li>
       <li><a href="logout">Logout</a></li>
       </c:otherwise>       
       </c:choose>
     </ul>
    </nav>

    <nav id="top_menu">
      <ul> 
        <li>
          <a href="category?kind=1">Store</a>
        </li> 
        <li>
        	<a href="review_list">Community</a>
        </li> 
        <li>
          <a href="cart_list">My Page</a>
        </li> 
      </ul>
    </nav>
    <div class="clear"></div>
    <hr>
  </header>
  <!--헤더파일 들어가는 곳 끝 -->