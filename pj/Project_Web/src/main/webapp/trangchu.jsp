<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<head>
<head>
<meta charset="UTF-8" />
<meta name="theme-color" content="#f02b2b" />
<!-- ấn f12 thu nhỏ đúng lúc -->
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!-- icon -->
<title>TL Restaurant</title>
<link rel="icon" href="images/icon.png" type="image/x-icon" />
<link rel="preload" as="script"
	href="//bizweb.dktcdn.net/100/469/097/themes/882205/assets/jquery.js?1686650273952" />
<script
	src="//bizweb.dktcdn.net/100/469/097/themes/882205/assets/jquery.js?1686650273952"
	type="text/javascript"></script>

<link rel="preload" as="script"
	href="//bizweb.dktcdn.net/100/469/097/themes/882205/assets/swiper.js?1686650273952" />
<script
	src="//bizweb.dktcdn.net/100/469/097/themes/882205/assets/swiper.js?1686650273952"
	type="text/javascript"></script>

<link rel="preload" as="script"
	href="//bizweb.dktcdn.net/100/469/097/themes/882205/assets/lazy.js?1686650273952" />
<script
	src="//bizweb.dktcdn.net/100/469/097/themes/882205/assets/lazy.js?1686650273952"
	type="text/javascript"></script>
<script
	src="//bizweb.dktcdn.net/100/469/097/themes/882205/assets/waypoints.js?1686650273952"
	type="text/javascript"></script>
<script
	src="//bizweb.dktcdn.net/100/469/097/themes/882205/assets/counterup.js?1686650273952"
	type="text/javascript"></script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/trangchu.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/index.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/q.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/s.css" rel="stylesheet" type="text/css" media="all" />



<script src="/dist/js/stats.min.js?v=8177d93"></script>


</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="bodywrap">

		<section class="section">
			<div class="container">
				<div class="wrap_background_aside page_login">
					<div class="row">
						<div
							class="col-lg-4 col-md-6 col-sm-12 col-xl-4 offset-0 offset-xl-4 offset-lg-4 offset-md-3 offset-xl-3 col-12">
							<div class="row">
								<div class="page-login pagecustome clearfix">
									<div class="wpx">
										<ul class="auth-block__menu-list">
											<li class="active"><a href="#" title="Đăng nhập">Đăng
													nhập</a></li>
											<li><a href="dangky" title="Đăng ký">Đăng ký</a></li>
										</ul>
										<h1 class="title_heads a-center">
											<span>Đăng nhập</span>
										</h1>
										<c:if test="${er_Login == true}">
											<p class="alert"
												style="background: #ff0000; color: #fff; padding: 5px 10px; border-radius: 6px; margin-top: 14px;">Thông
												tin đăng nhập không chính xác</p>
										</c:if>
										<div id="login" class="section">
											<form action="dangnhap" method="post" id="customer_login"
												accept-charset="UTF-8">
												<input name="customer" type="hidden" value="customer_login" />
												<input name="utf8" type="hidden" value="true" /> <span
													class="form-signup" style="color: red;"></span>
												<div class="form-signup clearfix">
													<fieldset class="form-group">
														<input type="text" class="form-control form-control-lg"
															value="" name="username" id="customer_email"
															placeholder="Tên đăng nhập" Required>
													</fieldset>
													<fieldset class="form-group">
														<input type="password"
															class="form-control form-control-lg" value=""
															name="password" id="customer_password"
															placeholder="Mật khẩu" Required>
													</fieldset>
													<div class="pull-xs-left">
														<input class="btn btn-style btn_50" type="submit"
															value="Đăng nhập" /> <span class="block a-center quenmk">Quên
															mật khẩu</span>
													</div>
												</div>
											</form>
											<c:if test="${forgetSucces != null}">
												<p class="alert"
													style="background: #34eb67; color: #fff; padding: 5px 10px; border-radius: 6px; margin-top: 14px;">${forgetSucces}</p>
											</c:if>
											<c:if test="${forgetEr != null}">
												<p class="alert"
													style="background: #ff0000; color: #fff; padding: 5px 10px; border-radius: 6px; margin-top: 14px;">${forgetEr}</p>
											</c:if>
										</div>
										<div class="h_recover" style="display: none;">
											<div id="recover-password" class="form-signup page-login">
												<form method="post" action="quenmatkhau"
													id="recover_customer_password" accept-charset="UTF-8">
													<input name="FormType" type="hidden"
														value="recover_customer_password" /> <input name="utf8"
														type="hidden" value="true" />
													<div class="form-signup" style="color: red;"></div>
													<div class="form-signup clearfix">
														<fieldset class="form-group">
															<input type="email"
																pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,63}$"
																class="form-control form-control-lg" value=""
																name="Email" id="recover-email" placeholder="Email"
																Required>
														</fieldset>
													</div>
													<div class="action_bottom">
														<input class="btn btn-style btn_50"
															style="margin-top: 0px;" type="submit"
															value="Lấy lại mật khẩu" />
													</div>

												</form>
											</div>
										</div>
										
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<jsp:include page="footer.jsp"></jsp:include>


	</div>
	<script
		src="//bizweb.dktcdn.net/100/469/097/themes/882205/assets/main.js?1686650273952"
		type="text/javascript"></script>


</body>

</html>