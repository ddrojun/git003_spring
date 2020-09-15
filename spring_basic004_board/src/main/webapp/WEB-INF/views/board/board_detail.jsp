<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="java.sql.*" %>  
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include   page="../inc/header.jsp" />
<!--					 -->
<!--  header.html  -->
 

	<div class="container  spring2_detail" style="margin-top: 3%;">
			<h3>QNA 상세보기</h3>
			<form action="<%=request.getContextPath()%>/board/listAll" method="get">
				    <input type="hidden"	name='bno'   value="${SboardDto.bno}"	readonly="readonly">				
    				<div class="form-group"  >
					  <span class="glyphicon glyphicon-plus">  조회수</span>
					  <div  class="form-control">${SboardDto.bhit}</div>
					</div>	 
					<div class="form-group"  >
					  <span class="glyphicon glyphicon-plus"><label for="bname">이름</label></span>
					  <input type="text" id="bname"  name="bname" value="${SboardDto.bname}"  readonly="readonly" class="form-control" /> 
					</div>				
					<div  class="form-group"   >
					  <span class="glyphicon glyphicon-plus"> <label for="btitle"> 제목</label></span>
					  <input type="text" id="btitle"  name="btitle" value="${SboardDto.btitle}"  readonly="readonly" class="form-control" /> 
					</div>	
					<div  class="form-group"   >
					  <span class="glyphicon glyphicon-plus"> <label for="bcontent"> 내용</label></span>
					  <textarea  rows="10" cols="60" name="bcontent"  id="bcontent" class="form-control"  readonly="readonly" >${SboardDto.bcontent}</textarea>
					  <p><img src="<%=request.getContextPath()%>/upload/${SboardDto.bfile}" alt="" /></p>
					</div>	

					<div class="row  text-right"    >
						 <a href="<%=request.getContextPath()%>/board/board_modify?bno=${SboardDto.bno}"  class="btn btn-warning" >수정</a> 
						 <a href="<%=request.getContextPath()%>/board/board_delete?bno=${SboardDto.bno}"  class="btn btn-danger" >삭제</a> 
						 <a href="<%=request.getContextPath()%>/board/list"   class="btn btn-success">목록보기</a>  
					</div>	
		</form>
	</div>

<!--					 -->
<!--  Footer.html  -->
<!--					 -->
<jsp:include   page="../inc/footer.jsp" />
