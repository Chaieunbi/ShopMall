<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Disney Admin</title>
<link rel="stylesheet" href="admin/css/admin.css">
<script type="text/javascript" src="admin/product/product.js"></script>
<script type="text/javascript" src="admin/notice/notice.js"></script>
</head>

<body onload="go_ab()">  <!-- 페이지 로드시에 제품의 순매출 계산 -->
	<div id="wrap1">
		<header>			
			<div id="logo">
				 <h1 style="text-align:center;  margin-left: 800px;">관리자 페이지</h1>
			</div>	<hr>
			<input class="btn" type="button"  value="logout"  style="float: right;"
			   onClick="location.href='admin_logout'">		
			
			<nav id="sub_menu">
				<ul>
				<li><a href='admin_product_list'> 상품리스트</a></li>
				<li><a href='admin_order_list'> 주문리스트</a></li>
				<li><a href='admin_member_list'> 회원리스트</a></li>
				<li><a href='admin_qna_list'> Q&amp;A리스트</a></li>
				<li><a href='admin_notice_list'> 공지사항 리스트</a></li>
				</ul>
			</nav>	
		</header>
		<hr>
		<div class="clear"></div>
		</div>
	</body>