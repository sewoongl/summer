<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/summer/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
<title>Insert title here</title>
<script>
	$(document).ready(function(){
		
		var NO = '${QueryString.NO}';
		var data = {"NO" : NO};
		
		$.ajax({
			url:"/summer/pll/join/One",
			data: data
		}).done(function(data){
			console.log(JSON.parse(data));
			var d = JSON.parse(data).result;
			console.log(d);
			$("#ID").text(d.ID);
			$("#PW").text(d.PW);
			$("#SX").text(d.SX);
			$("#BD").text(d.BD);
		});
		
	});
</script>
</head>
<body>
	<h1 id="ID"></h1>
	<p id="PW"></p>
	<p id="SX"></p>
	<p id="BD"></p>
</body>
</html>