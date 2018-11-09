<%@page import="model.bean.Sanbong"%>
<%@page import="common.Xuli"%>
<%@page import="model.bean.Datsan"%>
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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!--angularjs ui-select-->



<!--angularjs moment-picker-->


<!--Common-->





</head>
<body class="page-frontpage ">





	<!--0.nav-mobile-->

	<!--#0.nav-mobile-->
	<jsp:include page="../include/head.jsp"></jsp:include>
	<div class="breadcrum ng-scope">

		<div class="container">
			<div class="breadcrum-line">
				<a href="/">Trang chủ</a><a href="/stadium/management">Danh sách
					sân</a>
			</div>
		</div>
	</div>
	<div class="content-wrap ng-scope">
		<div class="container">
			<ul class="nav nav-tabs" role="tablist">
				<li class="nav-item"><a class="nav-link active"
					data-toggle="tab" href="#home"> <i class="fa fa-list"
						aria-hidden="true"></i>Yêu cầu đặt sân
				</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#menu1"><i class="fa fa-list" aria-hidden="true"></i>
						Thông tin sân bóng</a></li>

			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div id="home" class="container tab-pane active">
					<br>
					<div id="stadiumBookingRequests"
						style="min-height: 250px; position: relative">
						<!-- ngIf: overlayLoading -->
						<table
							class="table table-striped table-booking-requests table-responsive">
							<thead>
								<tr>
									<th>#</th>

									<th>Người đặt</th>
									<th>Ngày</th>
									<th>Thời gian</th>
									<th>Số điện thoại hoặc email</th>
									<th>Nội dung</th>
									<th class="text-right" width="250">Tác vụ</th>
								</tr>
							</thead>
							<tbody>
								<!-- ngRepeat: item in bookingRequests -->
								<%
									ArrayList<Datsan> ds = (ArrayList<Datsan>) request.getAttribute("dsdatsan");
									for (int i = 0; i < ds.size(); i++) {
								%>
								<tr>
									<td><%=(i + 1)%></td>
									<td><%=ds.get(i).getTennguoidat()%></td>
									<td><%=ds.get(i).getNgay()%></td>
									<td><%=Xuli.batdau(ds.get(i).getBatdau())%></td>
									<td><%=ds.get(i).getLienhe()%></td>
									<td><%=ds.get(i).getGhichu()%></td>


									<td><a
										href="Quanlisan?mataikhoan=<%=ds.get(i).getMataikhoan()%>&masanbong=<%=ds.get(i).getMasanbong()%>&ngay=<%=ds.get(i).getNgay()%>&batdau=<%=ds.get(i).getBatdau()%>"
										style="font-size: 24px"
										class="btn btn-primary btn-primary-extra dropdown-toggle"><i
											class="fa fa-close"></i></a></td>
								</tr>
								<%
									}
								%>
								<!-- ngIf: bookingRequestsCount==0 -->
								<%
									if (ds.isEmpty()) {
								%>
								<tr class="ng-scope">
									<td colspan="6">Không có yêu cầu đặt sân nào</td>
								</tr>
								<!-- end ngIf: bookingRequestsCount==0 -->
								<%
									}
								%>
							</tbody>

						</table>
					</div>
				</div>
				<div id="menu1" class="container tab-pane fade">
					<br>
					<div id="listStadium" style="min-height: 250px; position: relative">
						<div class="profile-edit col-md-9 right-item-san" style="">
							<form action="abc.html" method="get">
								<%
									Sanbong sb = (Sanbong) request.getAttribute("sanbong");
								%>
								<div class="row"></div>
								<div class="row form-group">
									<div class="col-sm-6 col-xs-6">
										<input data-val="true"
											data-val-number="The field Id must be a number."
											data-val-required="The Id field is required." id="Id"
											name="Id" type="hidden" value="<%=sb.getMasanbong()%>">
									</div>
								</div>
								<div class="row form-group">
									<div class="col-sm-3 col-xs-6">
										<label class="control-label ">Loại sân</label>
									</div>
									<div class="col-sm-6 col-xs-6">
										<select class="form-control" id="loaisan" name="loaisan">
											
											<option value="1">Sân cỏ nhân tạo</option>
											<option value="2">Sân cỏ tự nhiên</option>
											<option value="3">Sân cát</option>
										</select>
										<script type="text/javascript">
                                            $(function() {
                                            	  $("loaisan select").val("<%=sb.getLoaisan()%>");

											});
										</script>
									</div>

								</div>
								<div class="row form-group">
									<div class="col-sm-3 col-xs-6">
										<label class="control-label ">Tên sân</label>
									</div>
									<div class="col-sm-6 col-xs-6">
										<span class="field-validation-valid"
											data-valmsg-for="UserEmail" data-valmsg-replace="true"></span>
										<input class="form-control" id="UserEmail" name="ten"
											type="text" value="<%=sb.getTensan()%>">
									</div>
								</div>
								<div class="row form-group">
									<div class="col-sm-3 col-xs-6">
										<label class="control-label">Khu vực</label>
									</div>
									<div class="col-sm-6 col-xs-6">
										<span class="field-validation-valid"
											data-valmsg-for="UserMobile" data-valmsg-replace="true"></span>
										<input class="form-control" id="UserMobile" name="khuvuc"
											type="text" value="<%=sb.getKhuvuc()%>">
									</div>
								</div>
								<div class="row form-group">
									<div class="col-sm-3 col-xs-6">
										<label class="control-label">Ảnh đại diện</label>
									</div>
									<div class="col-sm-6 col-xs-6">
										<span class="field-validation-valid"
											data-valmsg-for="UserMobile" data-valmsg-replace="true"></span>
										<input class="form-control" id="UserMobile" name="anhdaidien"
											type="text" value="<%=sb.getAnh()%>">
									</div>
								</div>
								<div class="row form-group">
									<div class="col-sm-3 col-xs-6">
										<label class="control-label">Giá</label>
									</div>
									<div class="col-sm-6 col-xs-6" style="display: flex;">
										<input type="text" class="form-control" name="gia1"
											placeholder="6h-16h" value="<%=sb.getGia1()%>"> <input
											type="text" name="gia2" class="form-control"
											placeholder="16h-17h30" value="<%=sb.getGia2()%>"> <input
											type="text" name="gia3" placeholder="17h30-19h"
											class="form-control" value="<%=sb.getGia3()%>"> <input
											type="text" name="gia4" placeholder="19h-20h30"
											class="form-control" value="<%=sb.getGia4()%>"> <input
											type="text" name="gia5" placeholder="20h30-22h"
											class="form-control" value="<%=sb.getGia5()%>">
									</div>
								</div>
								<div class="row form-group">
									<div class="col-sm-3 col-xs-6">
										<label class="control-label">Số sân chính</label>
									</div>
									<div class="col-sm-6 col-xs-6">
										<span class="field-validation-valid"
											data-valmsg-for="UserMobile" data-valmsg-replace="true"></span>
										<input class="form-control" id="UserMobile" name="sosan"
											type="text" value="<%=sb.getSosan()%>">
									</div>
								</div>
								<div class="row form-group">
									<div class="col-sm-3 col-xs-6">
										<label class="control-label">Thông tin</label>
									</div>
									<div class="col-sm-6 col-xs-6">
										<span class="field-validation-valid"
											data-valmsg-for="UserMobile" data-valmsg-replace="true"></span>
										<textarea class="form-control" rows="5" id="comment"
											name="gioithieu" value=""><%=sb.getThongtin()%></textarea>
									</div>
								</div>
								<div class="row form-group">
									<input type="submit" class="btn mb20 btn-small btn-primary"
										value="Lưu thay đổi">
								</div>
							</form>
						</div>
					</div>
				</div>
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
					<h4 class="modal-title">Tạo sân mới</h4>
				</div>
				<div class="modal-body">

					<form id="frmSignIn" class="modal-forms">
						<div class="login-error"></div>
						<select class="form-control" id="sel1" name="loaisan">
							<option label="--Loại sân--"></option>
							<option value="1">Sân cỏ nhân tạo</option>
							<option value="2">Sân cỏ tự nhiên</option>
							<option value="3">Sân cát</option>
						</select> <input name="tensan" type="text" placeholder="Tên sân" required
							id="UserName" oninvalid="sport.account.validateControl(this);"
							oninput="sport.account.validateControl(this);"
							data-msg-require="Không được để trống"> <input
							type="text" name="anhdaidien" placeholder="Link ảnh đại diện">
						<input type="text" name="gia" placeholder="Giá dự kiến/Giờ">
						<input type="text" name="khuvuc" placeholder="Khu vực">

						<div class="form-group">
							<label for="comment">Thông tin sân</label>
							<textarea class="form-control" rows="5" id="comment"
								name="gioithieu"></textarea>
						</div>


						<button id="btnSignIn" type="submit">Tạo mới</button>
					</form>

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
	<div id="suathongtin" class="modal fade" role="dialog">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Sửa thông tin</h4>
				</div>
				<div class="modal-body">

					<form id="frmSignIn" action="abc.jsp" class="modal-forms">
						<div class="login-error"></div>
						<select class="form-control" id="sel1" name="loaisan">
							<option label="--Loại sân--"></option>
							<option>Sân cỏ nhân tạo</option>
							<option>Sân cỏ tự nhiên</option>
							<option>Sân cát</option>
						</select> <input name="tensan" type="text" placeholder="Tên sân" required
							id="tensan" data-msg-require="Không được để trống"> <input
							type="text" name="anhdaidien" id="anhdaidien"
							placeholder="Link ảnh đại diện"> <input type="text"
							name="gia" placeholder="Giá dự kiến/Giờ" id="gia"> <input
							type="text" name="khuvuc" placeholder="Giá dự kiến/Giờ"
							id="khuvuc">
						<div class="form-group">
							<label for="comment">Thông tin sân</label> <input
								class="form-control" type="text" id="gioithieu" name="gioithieu">
						</div>


						<button id="btnSignIn" type="submit">Lưu</button>
					</form>

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



</body>

<!-- Mirrored from www.timdoinhanh.com/dang-nhap.jsp?returnUrl=/user/profile/3040 by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Oct 2018 03:51:43 GMT -->
</html>