<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<link rel="icon" href="images/icon.png" type="image/x-icon" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/trangchu.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/404error.css" rel="stylesheet" type="text/css"
	media="all" />
</head>

<body class="bg-purple">

	<div class="stars">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="central-body">
			<img class="image-404" src="images/404.png"
				width="500px"> <a href="trangchu" class="btn-go-home">Trở về trang chủ</a>
		</div>
		<div class="objects">
			<img class="object_rocket"
				src="http://salehriaz.com/404Page/img/rocket.svg" width="40px">
			<div class="earth-moon">
				<img class="object_earth"
					src="http://salehriaz.com/404Page/img/earth.svg" width="100px">
				<img class="object_moon"
					src="http://salehriaz.com/404Page/img/moon.svg" width="80px">
			</div>
			<div class="box_astronaut">
				<img class="object_astronaut"
					src="http://salehriaz.com/404Page/img/astronaut.svg" width="140px">
			</div>
		</div>
		<div class="glowing_stars">
			<div class="star"></div>
			<div class="star"></div>
			<div class="star"></div>
			<div class="star"></div>
			<div class="star"></div>

		</div>

	</div>

</body>

</html>