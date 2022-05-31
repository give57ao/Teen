<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>jQuery basic</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="sytlesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	
	$(document).ready(function() {
		$("a").click(function(){
			alert($(this).text());
		})
	});
	</script>
</head>
<body>
<div class="container">
	<h3>jQuery Basic</h3> <br>
	<span id="ts">test span</span>
	
	<ul>
		<li><a href="#">test1</a>
		<li><a href="#">test2</a>
		<li><a href="#">test3</a>
	</ul>
</div>
</body>
</html>