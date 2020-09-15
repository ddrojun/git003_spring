<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%--
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false"%> --%>

<jsp:include   page="../inc/header.jsp" />
<!-- Main content -->
<section class="container"  style="margin-top: 3%;">
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>BNO</th>
				<th>TITLE</th>
				<th>WRITER</th>
				<th>DATE</th>
				<th>HIT</th>
			</tr>
		</thead>
		<tbody>
		<%-- 
		<a href="${pageContext.request.contextPath}/board/board_detail?bno=3">test</a>
		<a href="${pageContext.request.contextPath}/board/board_detail?bno=4">test4</a> --%>
 		<c:forEach items="${list}" var="SboardDto"  varStatus="status" >
			<tr>	
			 	<td>${list.size()-status.index}</td>
			 	<td><a href="${pageContext.request.contextPath}/board/board_detail?bno=${SboardDto.bno}">${SboardDto.btitle}</a></td>
			 	<td>${SboardDto.bname}</td>
			 	<td>${SboardDto.bdate}</td>
			 	<td><span class="badge bg-red">${SboardDto.bhit}</span></td>
			 </tr>
		</c:forEach> 
		</tbody>				
	</table>
	<p class="text-right"><a href='<%=request.getContextPath()%>/board/board_write' class="btn btn-info"> 글쓰기</a></p>
	<h3 class="panel-heading" style="font-size: 90%;">SEARCH</h3>
	<div>
		<input type="search" id="search" name="search" placeholder="검색어를 입력해주세요" class="form-control"   />
		<script>
		$(function(){
			$("search").on("keyup", function(){
				$("#result tbody").html();
				if( $("#search").val()=="" ) {
					$("#search").focus();
				}// end if
				else{
					$.ajax({
						url : "${pageContext.request.contextPath}/boardajax/searchBaord"  //확인하기
						, type : "get", dataType : "json" 
						, data : {"search" : $("#search").val() }
						, success : function( data ) {
							console.log(data);
							$("#result tbody").empty();
							$.each(data, function(index, item) {
								var tr = $("<tr>");
								var td1 = $("<td>").html(item.bno);
								var td2 = $("<td>").html("<a href='<%=request.getContextPath()%>/board/board_detail?bno='"
										+item.bno +">" +item.btitle +"</a>");
								var td3 = $("<td>").html(item.bname);
								var td4 = $("<td>").html(item.bdate);
								var td5 = $("<td>").html(item.bhit);
								tr.append(td1).appned(td2).appned(td3).appned(td4).appned(td5);
								$("#result tbody").append(tr);
								
								
							});
						}//end success
						, error : function(xhr, textStatus, errorThrown){
							
						}//end error
						
					});
				}//end else
			});
		});
		</script>
	</div>
	<table class="table table-striped table-hover" id="result">
		<thead>
			<tr>
				<th>BNO</th>
				<th>TITLE</th>
				<th>WRITER</th>
				<th>DATE</th>
				<th>HIT</th>
			</tr>
		</thead>
		<tbody>
		 <!-- 검색결과 -->
		</tbody>
	</table>
</section>


<jsp:include   page="../inc/footer.jsp" />
