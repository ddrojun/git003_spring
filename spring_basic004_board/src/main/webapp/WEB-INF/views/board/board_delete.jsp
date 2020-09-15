<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include   page="../inc/header.jsp" />
<!--					 -->
<!--  header.html  -->
	<div class="container" style="margin-top: 3%;">
			<h3>QNA 삭제</h3>
			<form action="<%=request.getContextPath()%>/board/board_delete" method="post" id="delete_form">
				<input type="hidden" id="bno"  name="bno" value="${SboardDto.bno}"    class="form-control" /> 				
				<div class="form-group">
				  <label for="bpass"  >비밀번호</label>
				  <input type="password"   name="bpass"   id="bpass"   class="form-control" > 
				  <span>(*) 수정, 삭제시 필수입니다. </span>
				</div>
				<div class="form-group">
					<input type="submit" value="확인 " class="btn btn-info" />
					<input type="reset"   onclick="history.go(-1);"  value="취소" class="btn btn-danger" >  
				</div>	
			</form>
<script>	
	jQuery(document).ready(function(){
		jQuery("#delete_form").submit(function(){
			if(jQuery("#bpass").val()==""){
				alert("비밀번호를 입력하세요");
				$("#bpass").focus();
				return false;
			}
		});
	});
</script>				
	</div>
<!--					 -->
<!--  Footer.html  -->
<!--					 -->
<jsp:include   page="../inc/footer.jsp" />