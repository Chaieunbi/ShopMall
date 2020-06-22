<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>  

  <!--메인 이미지 들어가는 곳 시작 --->
  <div class="clear"></div>
  <div id="main_img">
    <img src="images/main_img.GIF" >    
  </div>
  <!--메인 이미지 들어가는 곳 끝--->

  <div class="clear"></div>   
  <hr>

  <div id="front">   
    <h2> NEW PRODUCT </h2>     
    <div id="newProduct">         
      <c:forEach items="${newProductList }"  var="productVO">
        <div id="item">
          <a href="product_detail?pseq=${productVO.pseq}">
            <img src="product_images/${productVO.image}" />
            <h4> ${productVO.name} </h4>    
            <h5>${productVO.price2} </h5>
          </a>    
        </div>
      </c:forEach>      
    </div>
   <div class="clear"></div>
     
    <h2> POPULARITY PRODUCT </h2>     
      <div id="bestProduct">         
        <c:forEach items="${bestProductList}"  var="productVO">
          <div id="item">
           <a href="product_detail?pseq=${productVO.pseq}">
             <img src="product_images/${productVO.image}" />
           <h4> ${productVO.name} </h4>    
           <h5>${productVO.price2} </h5>
        </a>  
      </div>
    </c:forEach>      
  </div>
  <div class="clear"></div>
  </div>
    
<%@ include file="footer.jsp" %>    