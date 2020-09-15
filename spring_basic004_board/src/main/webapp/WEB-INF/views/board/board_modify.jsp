<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="java.sql.*" %>  
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include   page="../inc/header.jsp" />
<!--					 -->
<!--  header.html  -->
 

	<div class="container" style="margin-top: 3%;">
			<h3>QNA 수정하기</h3>
			<form action="<%=request.getContextPath()%>/board/board_modify"    method="post"  id="modifyform"  enctype="multipart/form-data">
					<!--  bno 숨겨서 넘겨주기  -->	
					<input type="hidden" id="bno"  name="bno" value="${SboardDto.bno}"    class="form-control" /> 			
					<div class="form-group"  >
					  <span class="glyphicon glyphicon-plus"><label for="bname">이름</label></span>
					  <input type="text" id="bname"  name="bname" value="${SboardDto.bname}"  readonly="readonly" class="form-control" /> 
					</div>	
					<div class="form-group">
					  <label for="bpass"  >비밀번호</label>
					  <input type="password"   name="bpass"   id="bpasss"   class="form-control" > 
					</div>					
					<div  class="form-group"   >
					  <span class="glyphicon glyphicon-plus"> <label for="btitle"> 제목</label></span>
					  <input type="text" id="btitle"  name="btitle" value="${SboardDto.btitle}"  class="form-control" /> 
					</div>	
					<div  class="form-group"   >
					  <span class="glyphicon glyphicon-plus"> <label for="bcontent"> 내용</label></span>
					  <textarea rows="10" cols="60" name="bcontent"  id="bcontent" class="form-control" >${SboardDto.bcontent}</textarea>
					</div>	
					<div>
					<p><img src="${pageContext.request.contextPath}/upload/${SboardDto.bfile}" alt="img"></p>
					</div>
					<div class="form-group">
					<label for="file">파일업로드</label>
					<input type="file" name="file" id="file" class="form-control">
					</div>
					<input type="hidden" name="img" value="${SboardDto.bfile}">					
					<div class="row  text-right"    >
						 <input type="submit"   class="btn btn-warning"  value="수정"   > 
						 <input type="button"   class="btn btn-danger"  value="취소"  id="board_cancel"> 
						 <a href="<%=request.getContextPath()%>/board/list"  class="btn btn-success" >목록보기</a> 
					</div>	
		</form>	
<script>	
	jQuery(document).ready(function(){
		jQuery("#modifyform").submit(function(){
			if(jQuery("#bpass").val()==""){
				alert("비밀번호를 입력하세요");
				$("#bpass").focus();
				return false;
			}
		});
	});
</script>			
	</div>
	<script>
		$(function(){
			$("#board_cancel").on("click",function(){
				history.go(-1);
			});	
		});
	
	</script>
 
<!--					 -->
<!--  Footer.html  -->
<!--					 -->
<jsp:include   page="../inc/footer.jsp" />
