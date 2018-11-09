<%@page import="model.bean.Taikhoan"%>
<%@page import="model.bean.Thongbao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tìm đối đá bóng, đặt sân trực tuyến - Tìm Đối Nhanh - Tìm
	đối nhanh, đặt sân rẻ</title>
<!-- Google Font -->
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800'
	rel="stylesheet" type="text/css">
<link href="Assets/css/font-awesome.min.css" rel="stylesheet" />
<!--Stylesheets-->
<link
	href="css/plugins079c.css?v=Ahqo92Qjg_5hNgokcNbdDKqsKgb-VMnRUm9SH4imTUk1"
	rel="stylesheet" />
<link
	href="Assets/css/maind533.css?v=rBrNA_Ie8mU1GAAJGmu8FmgLAO4dS0CvaXQu5oBhCF41"
	rel="stylesheet" />
<!--Libraries-->
<script
	src="scripts/libs5992.js?v=zkvBZ0Y7GXymwX7ixYzy5fOCoH5nHt9_E-mHwnHPCYo1"></script>
<script
	src="scripts/firebase78dc.js?v=ViiODJOSSLf5H-KOUXkWltIlSN07oOrFe9X_7VsjhHc1"></script>
<!--angularjs ui-select-->
<!--angularjs moment-picker-->
<!--Common-->
<style>
.switch {
	position: relative;
	display: inline-block;
	width: 60px;
	height: 34px;
}

.switch input {
	opacity: 0;
	width: 0;
	height: 0;
}

.slider {
	position: absolute;
	cursor: pointer;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background-color: #ccc;
	-webkit-transition: .4s;
	transition: .4s;
}

.slider:before {
	position: absolute;
	content: "";
	height: 26px;
	width: 26px;
	left: 4px;
	bottom: 4px;
	background-color: white;
	-webkit-transition: .4s;
	transition: .4s;
}

input:checked+.slider {
	background-color: #2196F3;
}

input:focus+.slider {
	box-shadow: 0 0 1px #2196F3;
}

input:checked+.slider:before {
	-webkit-transform: translateX(26px);
	-ms-transform: translateX(26px);
	transform: translateX(26px);
}

/* Rounded sliders */
.slider.round {
	border-radius: 34px;
}

.slider.round:before {
	border-radius: 50%;
}
</style>
</head>

<jsp:include page="../include/head.jsp"></jsp:include>
<div class="content-wrap is-admin-page">
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="sidebar sidebar-tien-ich">
					<ul class="list-left-links">
						<li><a href="Thongbao" class="red">Quản lí thông báo</a></li>
						<li><a href="Quanlidatsan">Đặt sân</a></li>
						<li><a href="Quanli">Quản lý đội bóng</a> <!-- ngIf: myTeams.length>0 -->
						</li>
						<li><a href="Quanlisan">Quản lý sân</a></li>
						<li><a href="Quanlitaikhoan">Tài khoản</a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-9 sidebar team-management-page">
				<div class="layout-main">
					<!-- ngView: -->
					<div id="settings-content"
						class="tab-content stacked-content ng-scope" ng-view="">
						<div class="page-team-setting layout-main-content ng-scope">
							<div class="heading-block">
								<!-- ngIf: vm.teamId == 0 -->
								<p class="title-box ng-scope">
									<i class="fa fa-map-marker"></i> Quản lí thông báo
								</p>
								<!-- end ngIf: vm.teamId == 0 -->
								<!-- ngIf: vm.teamId > 0 -->
							</div>
							<!-- /.heading-block -->
							<form class="form-horizontal ng-pristine ng-valid" role="form"
								method="get" action="Thongbao">
								<div class="form-group form-group-sm">
									<label class="control-label col-sm-3">Nội dung thông
										báo</label>
									<div class="col-sm-9">
										<input name="noidung" type="text"
											class="form-control ng-pristine ng-untouched ng-valid ng-empty"
											id="inpName" placeholder="Nội dung thông báo">
									</div>

									<div class="form-group text-right" style="padding-top: 60px;">
										<div class="col-sm-offset-2 col-sm-10">

											<input type="submit"
												class="btn btn-primary btn-primary-extra "
												value="Thêm thông báo">



										</div>
									</div>
								</div>
							</form>

							<div class="form-group row">
								<div class="clear-bordered"></div>
								<div class="heading-block">
									<!-- ngIf: vm.teamId == 0 -->
									<p class="title-box ng-scope">
										<i class="fa fa-map-marker"></i>Các thông báo đã đăng
									</p>
									<!-- end ngIf: vm.teamId == 0 -->
									<!-- ngIf: vm.teamId > 0 -->
								</div>
								<ul>
								<% ArrayList<Thongbao> dstb= (ArrayList<Thongbao>) request.getAttribute("thongbao");
								
								for(Thongbao tb:dstb){
								%>
									<li>
										<div class="alert alert-success alert-dismissible">

											<a href="Thongbao?mataikhoan=<%=tb.getMataikhoan() %>&mathongbao=<%=tb.getMathongbao() %>" class="close">&times;</a> <strong>Success!</strong>
										<%= tb.getNoidung() %>
										</div>
									</li>
								<%} %>
								
																	</ul>
								
							</div>
						</div>
						<!-- /.tab-content -->
					</div>
					<!-- /.col -->


				</div>
			</div>
		</div>
	</div>
	<!--#top hero box-->
	<jsp:include page="../include/foot.jsp"></jsp:include>
	<!-- modal info -->
	<div id="layout_modal_info" class="modal fade in" tabindex="-1"
		role="dialog" aria-hidden="false" style="display: none;">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title">
						<i class="icon-warning"></i>Tìm đối nhanh thông báo!
					</h4>
				</div>
				<div class="modal-body with-padding">
					<p class="modal-content-info"></p>
				</div>
				<div class="modal-footer">
					<center>
						<button class="btn btn-tertiary" data-dismiss="modal">Ok</button>
					</center>
				</div>
			</div>
		</div>
	</div>
	<!--login-->
	<div id="loginModal" class="modal fade" role="dialog">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Đăng nhập</h4>
				</div>
				<div class="modal-body">
					<form id="frmSignIn" class="modal-forms">
						<div class="login-error"></div>
						<input name="UserName" type="text"
							placeholder="Số điện thoại hoặc email" required id="UserName"
							oninvalid="sport.account.validateControl(this);"
							oninput="sport.account.validateControl(this);"
							data-msg-require="Tài khoản đăng nhập không được để trống">
						<input type="password" name="Password" placeholder="Mật khẩu"
							required id="Password"
							oninvalid="sport.account.validateControl(this);"
							oninput="sport.account.validateControl(this);"
							data-msg-require="Mật khẩu không được để trống"> <input
							type="hidden" id="facebookId" value="930986897045312" /> <input
							type="hidden" id="googleClientId"
							value="894662634145-oge0jk4ofsq4afq81niurkh4potclkl9.apps.googleusercontent.com" />
						<input type="hidden" id="returnUrl" name="returnUrl" value="" />
						<button id="btnSignIn" type="submit">Đăng nhập</button>
					</form>
					<div class="a-btn-modal">
						<div class="social-login-group">
							<p>Hoặc đăng nhập với</p>
							<a class="logon-facebook" href="#"><i
								class="fa fa-facebook-square" aria-hidden="true"></i></a> <a
								class="login-google" href="#"><i
								class="fa fa-google-plus-square" aria-hidden="true"></i></a>
						</div>
						<p class="footer-group" style="margin-top: 15px;">
							<a href="user/forgotpassword.jsp" class="forgot-pass">Quên
								mật khẩu</a> <a href="javascript:location.href='index.jsp'"
								class="register-link pull-right">Tạo tài khoản mới</a>
						</p>
					</div>
				</div>
				<div class="modal-footer"></div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!--#login-->
	<div id="modalNotAuthorize" class="modal modal-styled fade"
		style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 class="modal-title">Thông báo</h3>
				</div>
				<!-- /.modal-header -->
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="col-sm-12">
							<div class="form-group">
								<h3>Bạn phải đăng nhập để sử dụng tính năng</h3>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<a data-dismiss="modal" href="javascript:;"
										onclick="global.showModalLoginPopup();"
										class="btn btn-success">Đăng nhập</a> <a href="#"
										onclick="location.href = 'index.jsp';" class="btn btn-danger">Đăng
										kí</a>
								</div>
							</div>
						</div>
						<!-- /.portlet-body -->
					</form>
				</div>
				<!-- /.modal-body -->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
				</div>
				<!-- /.modal-footer -->
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<div id="gmapModal" class="modal fade" role="dialog">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Bản đồ</h4>
				</div>
				<div class="modal-body">
					<div class="loading-overlay text-center" id="gmap-loading">
						<span> <i
							class="fa fa-spinner fa-pulse fa-3x fa-fw margin-bottom"></i> <br />
							Đang tải dữ liệu...
						</span>
					</div>
					<div id="map-iframe-container">Đang tài bản đồ....</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<div id="commonModal" class="modal fade" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Title</h4>
				</div>
				<div class="modal-body">
					<p class="text-center">
						<span> <i
							class="fa fa-spinner fa-pulse fa-3x fa-fw margin-bottom"></i> <br />
							Đang tải dữ liệu...
						</span>
					</p>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<script src="Angular/libs/fireChat/fireService.js"></script>
	<input type="hidden" id="matchHNTotalHidden" /> <input type="hidden"
		id="matchHCMTotalHidden" /> <input type="hidden"
		id="teamAllTotalHidden" /> <input type="hidden"
		id="stadiumHNTotalHidden" /> <input type="hidden"
		id="stadiumHCMTotalHidden" />
	<div id="isMobileDevice"></div>
	</body>
	<!-- Mirrored from www.timdoinhanh.com/dang-nhap.jsp?returnUrl=/user/profile/3040 by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Oct 2018 03:51:43 GMT -->
</html>