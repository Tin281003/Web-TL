<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="vi">

<head>
<meta charset="UTF-8" />
<meta name="theme-color" content="#f02b2b" />
<!-- ấn f12 thu nhỏ đúng lúc -->
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<!-- icon -->
<title>Dola Restaurant</title>
<link rel="icon" href="images/icon.png" type="image/x-icon" />
<script
	src="//bizweb.dktcdn.net/100/469/097/themes/882205/assets/jquery.js?1686650273952"
	type="text/javascript"></script>
<script
	src="//bizweb.dktcdn.net/100/469/097/themes/882205/assets/swiper.js?1686650273952"
	type="text/javascript"></script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/trangchu.css" rel="stylesheet" type="text/css"
	media="all" />

</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="bodywrap"></div>
		<section class="section_slider">
			<div class="home-slider swiper-container">
				<div class="swiper-wrapper">
					<div class="swiper-slide animate__bounceIn"
						style="margin-top: 100px">
						<a href="html/menu\menu.html" class="clearfix" title="Slider 1">
							<picture>
							<source media="(min-width: 1200px)"
								srcset="images/anhnentrangchu.webp">
							<img width="1920" height="930" src="images/anhnentrangchu.webp"
								alt="Slider 1" class="img-responsive" /> </picture>
						</a>
						<section class="home" id="home">
							<div class="content">
								<h3>Dola Restaurant</h3>
								<p>Món ăn đa dạng</p>
								<a href="datban" class="btn">Đặt Bàn Ngay</a>
							</div>
						</section>
					</div>
				</div>
			</div>
		</section>

		<section class="section_about">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-12">
						<span class="title-smail"> Về chúng tôi </span> <span
							class="title"> Dola Restaurant </span> <span class="content">
							Nhà hàng chúng tôi luôn luôn đặt khách hàng lên hàng đầu, tận tâm
							phục vụ, mang lại cho khách hàng những trãi nghiệm tuyệt với
							nhất. Các món ăn với công thức độc quyền sẽ mang lại hương vị mới
							mẻ cho thực khách. Dola Restaurant xin chân thành cảm ơn. </span>
					</div>
					<div class="col-lg-6 col-12">
						<div class="thump-image">
							<a href="#" title="Dola Restaurant"> <img width="680"
								height="460" class="lazyload" src="images/anhvechungtoi.jpg"
								title="Về chúng tôi">
							</a>
						</div>

					</div>
				</div>
			</div>
		</section>

		<section class="section_category">
			<div class="container">
				<div class="title-index clearfix">
					<h2>Danh mục nổi bật</h2>
				</div>
				<div class="product-cate-swiper swiper-container">
					<div class="swiper-wrapper">
						<div class="swiper-slide item">
							<a href="#" title="Món bò">

								<div class="image">
									<img width="160" height="160" class="lazyload"
										src="images/bo.webp" alt="Món bò">
								</div>

								<h4 class="title">Món bò</h4> <span class="content"> Các
									món bò được chế biến tinh tế với hương vị đặc biệt nhất </span>
							</a>
						</div>
						<div class="swiper-slide item">
							<a href="#" title="Món gà">

								<div class="image">
									<img width="160" height="160" class="lazyload"
										src="images/Ga.png" alt="Món gà">
								</div>

								<h4 class="title">Món gà</h4> <span class="content"> Các
									món gà được chế biến tinh tế với hương vị đặc biệt nhất </span>
							</a>
						</div>
						<div class="swiper-slide item">
							<a href="#" title="Món heo">

								<div class="image">
									<img width="160" height="160" class="lazyload"
										src="images/Heo.png" alt="Món heo">
								</div>

								<h4 class="title">Món heo</h4> <span class="content"> Các
									món heo được chế biến tinh tế với hương vị đặc biệt nhất </span>
							</a>
						</div>
						<div class="swiper-slide item">
							<a href="#" title="Món cá">

								<div class="image">
									<img width="160" height="160" class="lazyload"
										src="images/Cá.png" alt="Món cá">
								</div>

								<h4 class="title">Món cá</h4> <span class="content"> Các
									món cá được chế biến tinh tế với hương vị đặc biệt nhất </span>
							</a>
						</div>
						<div class="swiper-slide item">
							<a href="#" title="Các món khác">

								<div class="image">
									<img width="160" height="160" class="lazyload"
										src="images/Cacmonkhac.png" alt="Các món khác">
								</div>

								<h4 class="title">Các món khác</h4> <span class="content">
									Các món ăn được chế biến tinh tế với hương vị đặc biệt nhất </span>
							</a>
						</div>
					</div>
					<!-- 2 nút dưới -->
					<div class="swiper-pagination"></div>
				</div>
			</div>
		</section>

		<section class="section_banner">
			<div class="container">
				<div class="row">
					<div class="col-lg-3 col-sm-5 col-9 banner">
						<img width="400" height="500" class="lazyload"
							src="images/banner1.webp" alt="banner">
						<div class="content">
							<a href="#" title="banner"> <span class="title1">Dola
									Restaurant</span> <span class="title2">Món ăn đa dạng</span>
							</a>
						</div>
					</div>
					<div class="col-lg-3 col-sm-5 col-9 banner">
						<img width="400" height="500" class="lazyload"
							src="images/banner2.webp" alt="Banner">
						<div class="content">
							<a href="#" title="Banner"> <span class="title1">Dola
									Restaurant</span> <span class="title2">Hương vị đặc biệt</span>
							</a>
						</div>
					</div>
					<div class="col-lg-3 col-sm-5 col-9 banner">
						<img width="400" height="500" class="lazyload"
							src="images/banner3.webp" alt="Banner">
						<div class="content">
							<a href="#" title="Banner"> <span class="title1">Dola
									Restaurant</span> <span class="title2">Công thức độc quyền</span>
							</a>
						</div>
					</div>
					<div class="col-lg-3 col-sm-5 col-9 banner">
						<img width="400" height="500" class="lazyload"
							src="images/banner4.webp" alt="">
						<div class="content">
							<a href="#" title=""> <span class="title1">Dola
									Restaurant</span> <span class="title2">Đảm bảo chất lượng</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</section>

		<section class="section_num">
			<div class="container">
				<div class="row">
					<div class="col-lg-3 col-sm-6 col-6 item">
						<img width="64" height="64" class="lazyload"
							src="images/cuahang.webp" alt="Cửa hàng">
						<div class="content">
							<span class="num "><span class="counter">8</span>+</span> <span
								class="title">Cửa hàng</span>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6 col-6 item">
						<img width="64" height="64" class="lazyload"
							src="images/nhanvien.webp" alt="Nhân viên">

						<div class="content">
							<span class="num "><span class="counter">200</span>+</span> <span
								class="title">Nhân viên</span>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6 col-6 item">
						<img width="64" height="64" class="lazyload"
							src="images/khachhang.webp" alt="Khách hàng">
						<div class="content">
							<span class="num "><span class="counter">5000</span>+</span> <span
								class="title">Khách hàng</span>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6 col-6 item">
						<img width="64" height="64" class="lazyload"
							src="images/monan.webp" alt="Món ăn">
						<div class="content">
							<span class="num "><span class="counter">50</span>+</span> <span
								class="title">Món ăn</span>
						</div>
					</div>
				</div>
			</div>
		</section>

		<section class="section_danhgia">
			<div class="container">
				<div class="background"></div>
				<div class="row">
					<div class="col-xl-6 col-lg-7">
						<div class="danhgia-slider swiper-container">
							<div class="swiper-wrapper">
								<div class="swiper-slide">
									<div class="item">
										<div class="info">
											<!-- 2 dấu phẩy phía trên -->
											<div class="icon">
												<svg xmlns="http://www.w3.org/2000/svg"
													viewBox="0 0 448 512">
													<path
														d="M96 96C42.98 96 0 138.1 0 192s42.98 96 96 96c11.28 0 21.95-2.305 32-5.879V288c0 35.3-28.7 64-64 64c-17.67 0-32 14.33-32 32s14.33 32 32 32c70.58 0 128-57.42 128-128V192C192 138.1 149 96 96 96zM448 192c0-53.02-42.98-96-96-96s-96 42.98-96 96s42.98 96 96 96c11.28 0 21.95-2.305 32-5.879V288c0 35.3-28.7 64-64 64c-17.67 0-32 14.33-32 32s14.33 32 32 32c70.58 0 128-57.42 128-128V192z" />
												</svg>
											</div>
											<div class="avatar">
												<img width="80" height="80" alt="Mai Phương"
													class="lazyload" src="images/maiphuong.jpg">
												<div class="testimonial">
													<h5>Mai Phương</h5>
													<span>Sinh Viên</span>
												</div>
											</div>

										</div>
										<div class="content">
											<p>Món ăn ở đây hầu hết đều rất ngon, khẩu vị phù hợp với
												tôi, tôi sẽ luôn ủng hộ nhà hàng Dola Restaurant</p>
										</div>
									</div>
								</div>
								<div class="swiper-slide">
									<div class="item">
										<div class="info">
											<div class="icon">
												<svg xmlns="http://www.w3.org/2000/svg"
													viewBox="0 0 448 512">
													<path
														d="M96 96C42.98 96 0 138.1 0 192s42.98 96 96 96c11.28 0 21.95-2.305 32-5.879V288c0 35.3-28.7 64-64 64c-17.67 0-32 14.33-32 32s14.33 32 32 32c70.58 0 128-57.42 128-128V192C192 138.1 149 96 96 96zM448 192c0-53.02-42.98-96-96-96s-96 42.98-96 96s42.98 96 96 96c11.28 0 21.95-2.305 32-5.879V288c0 35.3-28.7 64-64 64c-17.67 0-32 14.33-32 32s14.33 32 32 32c70.58 0 128-57.42 128-128V192z" />
												</svg>
											</div>
											<div class="avatar">
												<img width="80" height="80" alt="Thiên Tân" class="lazyload"
													src="images/thientan.jpg">
												<div class="testimonial">
													<h5>Thiên Tân</h5>
													<span>Sinh Viên</span>
												</div>
											</div>

										</div>
										<div class="content">
											<p>Món ăn ở đây hầu hết đều rất ngon, khẩu vị phù hợp với
												tôi, tôi sẽ luôn ủng hộ nhà hàng Dola Restaurant</p>
										</div>
									</div>
								</div>


							</div>
							<div class="swiper-pagination"></div>
						</div>
					</div>
				</div>
			</div>
		</section>

		<jsp:include page="footer.jsp"></jsp:include>
		<script
			src="//bizweb.dktcdn.net/100/469/097/themes/882205/assets/main.js?1686650273952"
			type="text/javascript"></script>
		<script src="js/trangchu.js" type="text/javascript"></script>
</body>

</html>