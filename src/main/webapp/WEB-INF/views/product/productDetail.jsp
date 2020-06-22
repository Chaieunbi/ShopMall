<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>
<%@ include file="sub_img.html" %>
<%@ include file="sub_menu.jsp" %>       
  <article>
  <br><br>
    <h1> Product </h1><br>
    <div id="itemdetail" >
      <form method="post" name="formm">    
        <fieldset>
          <legend> Product Detail </legend>  
          <a href="product_detail?pseq=${productVO.pseq}">         
            <span style="float: left;">
              <img src="product_images/${productVO.image}"  />
            </span>              
            <h2> ${productVO.name} </h2>  
          </a>    
          <label> Price   </label>  
          <p> ${productVO.price2} 원</p>  
          <label> Quantity </label>
          <input  type="text"      name="quantity"  size="2"      value="1"><br>
          <input  type="hidden"    name="pseq"       value="${productVO.pseq}"><br>
        </fieldset>
        <div class="clear"></div>
        <div id="buttons">
          <input type="button" value="장바구니에 담기"   class="submit"    onclick="return go_cart()"> 
          <input type="button" value="목록으로"       class="submit"    onclick="history.go(-1);"> 
          <input type="reset"  value="취소"           class="cancel">
        </div>
      </form>  
    </div>
    <!-- 상품평 처리 -->
<%@ include file="comment.jsp" %>
  </article>
<%@ include file="../footer.jsp" %>    