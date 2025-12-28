<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="opacity_menu"></div>
<header class="header header-index">
	<div class="container">
		<div class="bottom-header">
			<div class="row">
				<div class="col-xl-2 col-lg-2">
					<div class="logo">
						<a href="trangchu" title="Logo"> <img width="172" height="50"
							src="images/logo.png" alt="Dola Restaurant">
						</a>
					</div>
				</div>
				<div class="col-xl-7 col-lg-7 header-menu">
					<nav class="header-nav">
						<ul class="item_big">
							<c:set var="pageName" value="${pageContext.request.servletPath}"></c:set>
							<c:set var="pageTC" value="/trangchu.jsp"></c:set>
							<c:set var="pageGT" value="/gioithieu.jsp"></c:set>
							<c:set var="pageMN" value="/monngonmoingay.jsp"></c:set>
							<c:set var="pageLH" value="/liemhe.jsp"></c:set>

							<c:if test="${pageName == pageTC}">
								<li class="nav-item active "><a class="a-img"
									href="trangchu" title="Trang chủ"> Trang chủ </a></li>
							</c:if>
							<c:if test="${pageName != pageTC }">
								<li class="nav-item"><a class="a-img" href="trangchu"
									title="Trang chủ"> Trang chủ </a></li>
							</c:if>

							<c:if test="${pageName == pageGT}">
								<li class="nav-item active "><a class="a-img"
									href="gioithieu" title="Giới thiệu"> Giới thiệu </a></li>
							</c:if>
							<c:if test="${pageName != pageGT}">
								<li class="nav-item "><a class="a-img" href="gioithieu"
									title="Giới thiệu"> Giới thiệu </a></li>
							</c:if>
							<c:if test="${pageName == pageMN}">
								<li data-title="Menu" data-link="#"
									data-img="images/biamenu.jpg"
									class="nav-item active  has-mega "><a
									class="a-img caret-down" href="menuType?type=all" title="Menu">
										Menu </a>
							</c:if>
							<c:if test="${pageName != pageMN}">
								<li data-title="Menu" data-link="#"
									data-img="images/biamenu.jpg" class="nav-item    has-mega "><a
									class="a-img caret-down" href="menuType?type=all" title="Menu">
										Menu </a>
							</c:if>
							<!-- DẤU CỘNG MENU KHI -->
							<i class="fa fa1 fa-caret-down"></i>

							<div class="mega-content d-lg-block d-none">
								<div class="row">
									<div class="col-lg-9">
										<ul class="level0">
											<c:forEach items="${menuType}" var="t">
												<li class="level1 parent item fix-navs"
													data-title="${t.name}" data-img="images/khaivi.jpg"><a
													class="hmega" href="menuType?type=${t.name}"
													title="Khai vị">${t.name}</a>
													<ul class="level1">
														<c:forEach items="${t.category}" var="ct">
															<li class="level2"><a title="Salad"
																href="menuType?category=${ct}">${ct}</a></li>
														</c:forEach>
													</ul></li>
											</c:forEach>
										</ul>
									</div>
									<div class="col-lg-3">
										<a class="url-mega" href="#" title="Menu"> <img
											width="400" height="500" class="lazyload image-mega"
											alt="Menu" />
										</a>
									</div>
								</div>
							</div>
							<!-- trong dấu cộng -->
							<c:if test="${pageName == pageLH}">
								<li class="nav-item active"><a class="a-img" href="lienhe"
									title="Liên hệ"> Liên hệ </a></li>
							</c:if>
							<c:if test="${pageName != pageLH}">
								<li class="nav-item "><a class="a-img" href="lienhe"
									title="Liên hệ"> Liên hệ </a></li>
							</c:if>
							<c:if test="${user != null && user.username == 'admin'}">
								<li class="nav-item "><a class="a-img" href="quanlythongke"
									title="Liên hệ"> Quản lý </a></li>
							</c:if>
							<li class="account d-lg-none d-block"></li>
						</ul>
					</nav>
				</div>
				<div class="col-xl-3 col-lg-3 header-control">
					<!-- 3 sọc menu -->
					<div class="menu-bar d-lg-none d-block">
						<svg aria-hidden="true" focusable="false" data-prefix="far"
							data-icon="bars" role="img" xmlns="http://www.w3.org/2000/svg"
							viewBox="0 0 448 512" class="svg-inline--fa fa-bars fa-w-14">
								<path style="fill: #fff;"
								d="M436 124H12c-6.627 0-12-5.373-12-12V80c0-6.627 5.373-12 12-12h424c6.627 0 12 5.373 12 12v32c0 6.627-5.373 12-12 12zm0 160H12c-6.627 0-12-5.373-12-12v-32c0-6.627 5.373-12 12-12h424c6.627 0 12 5.373 12 12v32c0 6.627-5.373 12-12 12zm0 160H12c-6.627 0-12-5.373-12-12v-32c0-6.627 5.373-12 12-12h424c6.627 0 12 5.373 12 12v32c0 6.627-5.373 12-12 12z"
								class=""></path>
							</svg>
					</div>
					<div class="search-header">
						<svg width="20" height="20" viewBox="0 0 20 20" fill="none"
							xmlns="http://www.w3.org/2000/svg">
								<path
								d="M14.1404 13.4673L19.852 19.1789C20.3008 19.6276 19.6276 20.3008 19.1789 19.852L13.4673 14.1404C12.0381 15.4114 10.1552 16.1835 8.09176 16.1835C3.6225 16.1835 0 12.5613 0 8.09176C0 3.6225 3.62219 0 8.09176 0C12.561 0 16.1835 3.62219 16.1835 8.09176C16.1835 10.1551 15.4115 12.038 14.1404 13.4673ZM0.951972 8.09176C0.951972 12.0356 4.14824 15.2316 8.09176 15.2316C12.0356 15.2316 15.2316 12.0353 15.2316 8.09176C15.2316 4.14797 12.0353 0.951972 8.09176 0.951972C4.14797 0.951972 0.951972 4.14824 0.951972 8.09176Z"
								fill="#222222"></path>
							</svg>
						<div class="header-action d-lg-block d-none">
							<div class="header-content">
								<p class="title">Tìm kiếm món ăn của bạn</p>
								<div class="search-smart">
									<form action="search" method="get"
										class="header-search-form input-group search-bar"
										role="search">
										<input type="text" name="search" required
											class="input-group-field auto-search search-auto form-control"
											placeholder="Nhập tên món ăn..." autocomplete="off">
										<input type="hidden" name="type" value="product">
										<button type="submit" class="btn icon-fallback-text"
											aria-label="Tìm kiếm" title="Tìm kiếm">
											<svg width="20" height="20" viewBox="0 0 20 20" fill="none"
												xmlns="http://www.w3.org/2000/svg">
													<path
													d="M14.1404 13.4673L19.852 19.1789C20.3008 19.6276 19.6276 20.3008 19.1789 19.852L13.4673 14.1404C12.0381 15.4114 10.1552 16.1835 8.09176 16.1835C3.6225 16.1835 0 12.5613 0 8.09176C0 3.6225 3.62219 0 8.09176 0C12.561 0 16.1835 3.62219 16.1835 8.09176C16.1835 10.1551 15.4115 12.038 14.1404 13.4673ZM0.951972 8.09176C0.951972 12.0356 4.14824 15.2316 8.09176 15.2316C12.0356 15.2316 15.2316 12.0353 15.2316 8.09176C15.2316 4.14797 12.0353 0.951972 8.09176 0.951972C4.14797 0.951972 0.951972 4.14824 0.951972 8.09176Z"
													fill="#222222"></path>
												</svg>
										</button>
									</form>
								</div>
							</div>
						</div>
					</div>
					<div class="block-cart">
						<a href="giohang" class="header-cart" aria-label="Xem giỏ hàng"
							title="Giỏ hàng"> <svg viewBox="0 0 27 26" fill="none"
								xmlns="http://www.w3.org/2000/svg">
									<path
									d="M8.47253 20.4219C6.94111 20.4219 5.69971 21.6707 5.69971 23.211C5.69971 24.7513 6.94117 26 8.47253 26C10.004 26 11.2454 24.7513 11.2454 23.211C11.2454 21.6707 10.004 20.4219 8.47253 20.4219ZM8.47253 24.7605C7.62176 24.7605 6.93209 24.0668 6.93209 23.211C6.93209 22.3553 7.62176 21.6616 8.47253 21.6616C9.32331 21.6616 10.013 22.3553 10.013 23.211C10.013 24.0668 9.32331 24.7605 8.47253 24.7605Z"
									fill="white"></path>
									<path
									d="M20.1801 20.4219C18.6486 20.4219 17.4072 21.6707 17.4072 23.211C17.4072 24.7513 18.6487 26 20.1801 26C21.7114 26 22.9529 24.7513 22.9529 23.211C22.9529 21.6707 21.7115 20.4219 20.1801 20.4219ZM20.1801 24.7605C19.3293 24.7605 18.6396 24.0668 18.6396 23.211C18.6396 22.3553 19.3293 21.6616 20.1801 21.6616C21.0308 21.6616 21.7205 22.3553 21.7205 23.211C21.7206 24.0668 21.0308 24.7605 20.1801 24.7605Z"
									fill="white"></path>
									<path
									d="M26.4343 4.15262C26.306 4.01162 26.1304 3.92336 25.9413 3.90468L5.88457 3.62578L5.33001 1.92135C4.93933 0.781956 3.87856 0.0127528 2.6804 0H0.616185C0.275865 0 0 0.277478 0 0.619787C0 0.962097 0.275865 1.23957 0.616185 1.23957H2.6804C3.35036 1.25446 3.94031 1.68717 4.15926 2.32422L8.07203 14.1931L7.76397 14.9059C7.42035 15.7971 7.52354 16.8003 8.04125 17.6019C8.554 18.3893 9.41662 18.8752 10.352 18.9035H22.3368C22.6771 18.9035 22.9529 18.626 22.9529 18.2837C22.9529 17.9414 22.6771 17.6639 22.3368 17.6639H10.3519C9.8237 17.6506 9.33748 17.3711 9.0579 16.9202C8.78145 16.4747 8.72466 15.9259 8.90387 15.4326L9.15037 14.8748L22.121 13.5113C23.5458 13.3535 24.7178 12.3112 25.0479 10.9082L26.5268 4.67934C26.5934 4.49997 26.5581 4.29824 26.4343 4.15262ZM23.8463 10.6293C23.6463 11.5325 22.884 12.1986 21.967 12.2718L9.15037 13.6043L6.2851 4.86535L25.1711 5.14425L23.8463 10.6293Z"
									fill="white"></path>
								</svg> <span class="count_item_pr"> <c:if
									test="${fn:length(GioHang.bill) > 0}">${fn:length(GioHang.bill)}</c:if>
								<c:if test="${fn:length(GioHang.bill) == 0}">0</c:if> </svg>
						</span>
						</a>
						<div class="top-cart-content">
							<div class="CartHeaderContainer">
								<c:if test="${fn:length(GioHang.bill) == 0}">

									<div class="cart--empty-message">
										<svg xmlns="http://www.w3.org/2000/svg"
											xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1"
											id="Capa_1" x="0px" y="0px" viewBox="0 0 201.387 201.387"
											style="enable-background: new 0 0 201.387 201.387;"
											xml:space="preserve">
											<g>
												<g>
													<path
												d="M129.413,24.885C127.389,10.699,115.041,0,100.692,0C91.464,0,82.7,4.453,77.251,11.916    c-1.113,1.522-0.78,3.657,0.742,4.77c1.517,1.109,3.657,0.78,4.768-0.744c4.171-5.707,10.873-9.115,17.93-9.115    c10.974,0,20.415,8.178,21.963,19.021c0.244,1.703,1.705,2.932,3.376,2.932c0.159,0,0.323-0.012,0.486-0.034    C128.382,28.479,129.679,26.75,129.413,24.885z">
													</path>
												</g>
											</g>
											<g>
												<g>
													<path
												d="M178.712,63.096l-10.24-17.067c-0.616-1.029-1.727-1.657-2.927-1.657h-9.813c-1.884,0-3.413,1.529-3.413,3.413    s1.529,3.413,3.413,3.413h7.881l6.144,10.24H31.626l6.144-10.24h3.615c1.884,0,3.413-1.529,3.413-3.413s-1.529-3.413-3.413-3.413    h-5.547c-1.2,0-2.311,0.628-2.927,1.657l-10.24,17.067c-0.633,1.056-0.648,2.369-0.043,3.439s1.739,1.732,2.97,1.732h150.187    c1.231,0,2.364-0.662,2.97-1.732S179.345,64.15,178.712,63.096z">
													</path>
												</g>
											</g>
											<g>
												<g>
													<path
												d="M161.698,31.623c-0.478-0.771-1.241-1.318-2.123-1.524l-46.531-10.883c-0.881-0.207-1.809-0.053-2.579,0.423    c-0.768,0.478-1.316,1.241-1.522,2.123l-3.509,15c-0.43,1.835,0.71,3.671,2.546,4.099c1.835,0.43,3.673-0.71,4.101-2.546    l2.732-11.675l39.883,9.329l-6.267,26.795c-0.43,1.835,0.71,3.671,2.546,4.099c0.263,0.061,0.524,0.09,0.782,0.09    c1.55,0,2.953-1.062,3.318-2.635l7.045-30.118C162.328,33.319,162.176,32.391,161.698,31.623z">
													</path>
												</g>
											</g>
											<g>
												<g>
													<path
												d="M102.497,39.692l-3.11-26.305c-0.106-0.899-0.565-1.72-1.277-2.28c-0.712-0.56-1.611-0.816-2.514-0.71l-57.09,6.748    c-1.871,0.222-3.209,1.918-2.988,3.791l5.185,43.873c0.206,1.737,1.679,3.014,3.386,3.014c0.133,0,0.27-0.009,0.406-0.024    c1.87-0.222,3.208-1.918,2.988-3.791l-4.785-40.486l50.311-5.946l2.708,22.915c0.222,1.872,1.91,3.202,3.791,2.99    C101.379,43.261,102.717,41.564,102.497,39.692z">
													</path>
												</g>
											</g>
											<g>
												<g>
													<path
												d="M129.492,63.556l-6.775-28.174c-0.212-0.879-0.765-1.64-1.536-2.113c-0.771-0.469-1.696-0.616-2.581-0.406L63.613,46.087    c-1.833,0.44-2.961,2.284-2.521,4.117l3.386,14.082c0.44,1.835,2.284,2.964,4.116,2.521c1.833-0.44,2.961-2.284,2.521-4.117    l-2.589-10.764l48.35-11.626l5.977,24.854c0.375,1.565,1.775,2.615,3.316,2.615c0.265,0,0.533-0.031,0.802-0.096    C128.804,67.232,129.932,65.389,129.492,63.556z">
													</path>
												</g>
											</g>
											<g>
												<g>
													<path
												d="M179.197,64.679c-0.094-1.814-1.592-3.238-3.41-3.238H25.6c-1.818,0-3.316,1.423-3.41,3.238l-6.827,133.12    c-0.048,0.934,0.29,1.848,0.934,2.526c0.645,0.677,1.539,1.062,2.475,1.062h163.84c0.935,0,1.83-0.384,2.478-1.062    c0.643-0.678,0.981-1.591,0.934-2.526L179.197,64.679z M22.364,194.56l6.477-126.293h143.701l6.477,126.293H22.364z">
													</path>
												</g>
											</g>
											<g>
												<g>
													<path
												d="M126.292,75.093c-5.647,0-10.24,4.593-10.24,10.24c0,5.647,4.593,10.24,10.24,10.24c5.647,0,10.24-4.593,10.24-10.24    C136.532,79.686,131.939,75.093,126.292,75.093z M126.292,88.747c-1.883,0-3.413-1.531-3.413-3.413s1.531-3.413,3.413-3.413    c1.882,0,3.413,1.531,3.413,3.413S128.174,88.747,126.292,88.747z">
													</path>
												</g>
											</g>
											<g>
												<g>
													<path
												d="M75.092,75.093c-5.647,0-10.24,4.593-10.24,10.24c0,5.647,4.593,10.24,10.24,10.24c5.647,0,10.24-4.593,10.24-10.24    C85.332,79.686,80.739,75.093,75.092,75.093z M75.092,88.747c-1.882,0-3.413-1.531-3.413-3.413s1.531-3.413,3.413-3.413    s3.413,1.531,3.413,3.413S76.974,88.747,75.092,88.747z">
													</path>
												</g>
											</g>
											<g>
												<g>
													<path
												d="M126.292,85.333h-0.263c-1.884,0-3.413,1.529-3.413,3.413c0,0.466,0.092,0.911,0.263,1.316v17.457    c0,12.233-9.953,22.187-22.187,22.187s-22.187-9.953-22.187-22.187V88.747c0-1.884-1.529-3.413-3.413-3.413    s-3.413,1.529-3.413,3.413v18.773c0,15.998,13.015,29.013,29.013,29.013s29.013-13.015,29.013-29.013V88.747    C129.705,86.863,128.176,85.333,126.292,85.333z">
													</path>
												</g>
											</g>
											<g> </g>
											<g> </g>
											<g> </g>
											<g> </g>
											<g> </g>
											<g> </g>
											<g> </g>
											<g> </g>
											<g> </g>
											<g> </g>
											<g> </g>
											<g> </g>
											<g> </g>
											<g> </g>
											<g> </g>
										</svg>
										<p>Không có sản phẩm nào trong giỏ hàng của bạn</p>
									</div>
								</c:if>
								<c:if test="${fn:length(GioHang.bill) > 0}">

									<form action="giohang" method="post" novalidate=""
										class="cart ajaxcart cartheader">
										<div
											class="ajaxcart__inner ajaxcart__inner--has-fixed-footer cart_body items">
											<c:forEach items="${GioHang.bill}" var="o">
												<div class="ajaxcart__row">
													<div class="ajaxcart__product cart_product" data-line="1">
														<a href="#" class="ajaxcart__product-image cart_image"
															title="${o.food.name}"><img width="80" height="80"
															src="imgFood/${o.food.urlImg}.jpg" alt="${o.food.name}"></a>
														<div class="grid__item cart_info">
															<div class="ajaxcart__product-name-wrapper cart_name">
																<a href="#" class="ajaxcart__product-name h4"
																	title="${o.food.name}">${o.food.name}</a>
															</div>
															<div class="grid">
																<div
																	class="grid__item one-half cart_select cart_item_name">
																	<label class="cart_quantity">Số lượng</label> <a>${o.quantity}</a>
																</div>
																<div class="grid__item one-half text-right cart_prices">
																	<span class="cart-price"> <fmt:formatNumber
																			pattern="###,000" value="${o.totalPrice()}" />₫
																	</span>
																</div>
															</div>
														</div>
													</div>
												</div>
											</c:forEach>
										</div>
										<div
											class="ajaxcart__footer ajaxcart__footer--fixed cart-footer">
											<div class="ajaxcart__subtotal">
												<div class="cart__subtotal">
													<div class="cart__col-6">Tổng tiền:</div>
													<div class="text-right cart__totle">
														<span class="total-price"><fmt:formatNumber
																pattern="###,000" value="${GioHang.totalBill()}" />₫</span>
													</div>
												</div>
											</div>
											<div class="cart__btn-proceed-checkout-dt">
												<button href="/giohang.jsp"
													class="button btn btn-default cart__btn-proceed-checkout"
													id="btn-proceed-checkout" title="Thanh toán">Thanh
													toán</button>
											</div>
										</div>
									</form>
								</c:if>
							</div>
						</div>
					</div>

					<div class="account-header">
						<svg viewBox="0 0 512 512">
								<path style="fill: #fff;"
								d="M437.02,330.98c-27.883-27.882-61.071-48.523-97.281-61.018C378.521,243.251,404,198.548,404,148    C404,66.393,337.607,0,256,0S108,66.393,108,148c0,50.548,25.479,95.251,64.262,121.962    c-36.21,12.495-69.398,33.136-97.281,61.018C26.629,379.333,0,443.62,0,512h40c0-119.103,96.897-216,216-216s216,96.897,216,216    h40C512,443.62,485.371,379.333,437.02,330.98z M256,256c-59.551,0-108-48.448-108-108S196.449,40,256,40    c59.551,0,108,48.448,108,108S315.551,256,256,256z"
								data-original="#222222" class="active-path" fill="#222222"></path>
							</svg>
						<ul>
							<c:choose>
								<c:when test="${user == null}">
									<li class="ng-scope"><a rel="nofollow" href="dangnhap"
										title="Đăng nhập">Đăng nhập</a></li>
									<li class="ng-scope"><a rel="nofollow" href="dangky"
										title="Đăng ký">Đăng ký</a></li>
								</c:when>
								<c:when test="${user != null}">
									<li class="ng-scope"><a rel="nofollow" href="taikhoan"
										title="Tài khoản">Tài khoản</a></li>
									<li class="ng-scope"><a rel="nofollow" href="dangxuat"
										title="Đăng xuất">Đăng xuất</a></li>
								</c:when>
							</c:choose>

							<li><a class="js-wishlist-link" href=""
								aria-label="Món ăn Yêu thích" title="Món ăn Yêu thích">Món
									ăn yêu thích</a></li>
						</ul>
					</div>
					<a class="button-header" href="datban" title="đặt bàn">Đặt bàn</a>

				</div>
				<div class="col-12 header-control  d-lg-none d-block">
					<div class="search-smart search-smart-mb" style="display: none">
						<form action="tim_kiem" method="get"
							class="header-search-form input-group search-bar" role="search">
							<input type="text" name="search" required
								placeholder="Nhập tên món ăn...">
							<button type="submit" class="btn icon-fallback-text"
								aria-label="Tìm kiếm" title="Tìm kiếm" href="tim_kiem">
								<svg width="20" height="20" viewBox="0 0 20 20" fill="none"
									xmlns="http://www.w3.org/2000/svg">
										<path
										d="M14.1404 13.4673L19.852 19.1789C20.3008 19.6276 19.6276 20.3008 19.1789 19.852L13.4673 14.1404C12.0381 15.4114 10.1552 16.1835 8.09176 16.1835C3.6225 16.1835 0 12.5613 0 8.09176C0 3.6225 3.62219 0 8.09176 0C12.561 0 16.1835 3.62219 16.1835 8.09176C16.1835 10.1551 15.4115 12.038 14.1404 13.4673ZM0.951972 8.09176C0.951972 12.0356 4.14824 15.2316 8.09176 15.2316C12.0356 15.2316 15.2316 12.0353 15.2316 8.09176C15.2316 4.14797 12.0353 0.951972 8.09176 0.951972C4.14797 0.951972 0.951972 4.14824 0.951972 8.09176Z"
										fill="#222222"></path>
									</svg>
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>