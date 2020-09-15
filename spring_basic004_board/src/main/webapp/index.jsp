<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<!-- 
db명 : db0
mysql> desc sboard1 
    -> ;
+----------+--------------+------+-----+-------------------+----------------+
| Field    | Type         | Null | Key | Default           | Extra          |
+----------+--------------+------+-----+-------------------+----------------+
| bno      | int(11)      | NO   | PRI | NULL              | auto_increment |
| bname    | varchar(50)  | NO   |     | NULL              |                |
| bpass    | varchar(50)  | NO   |     | NULL              |                |
| btitle   | varchar(100) | NO   |     | NULL              |                |
| bcontent | text         | NO   |     | NULL              |                |
| bip      | varchar(20)  | NO   |     | NULL              |                |
| bdate    | timestamp    | NO   |     | CURRENT_TIMESTAMP |                |
| bhit     | int(11)      | NO   |     | NULL              |                |
+----------+--------------+------+-----+-------------------+----------------+
8 rows in set (0.06 sec)

 -->
	<div class="container  panel panel-info">
		<h3 class="panel-heading"></h3>
		
		<script>location.href="<%=request.getContextPath()%>/board/list";</script>
		 
	</div><!-- end container --> 
	
	
	
</body>
</html>


