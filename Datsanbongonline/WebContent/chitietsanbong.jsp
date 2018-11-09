<%@page import="java.util.ArrayList"%>
<%@page import="common.Xuli"%>
<%@page import="model.bean.Sanbong"%>
<%@page import="model.bean.Taikhoan"%>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

</head>

<body class="page-frontpage ">
	<jsp:include page="include/head.jsp"></jsp:include>
	<div class="breadcrum">
		<div class="container">
			<div class="breadcrum-line">
				<a href="index.html">Trang chủ</a> <a href="san-bong.html" class=""
					title="Sân bóng">Sân bóng</a> <a>Tìm sân nhanh</a>
			</div>
		</div>
	</div>
	<div class="content-wrap">
		<div class="container">
			<div class="row">

				<div class="col-md-9" id="stadium-list">
					<%
						Sanbong sb = (Sanbong) request.getAttribute("sanbong");
					%>
					<div class="p-content">
						<h1 id="a" class="title-intent title-pages  mobile-padlr-15">
							<i class="fa fa-futbol-o" aria-hidden="true"></i>
							<%=sb.getTensan()%>
						</h1>

						<ul class="list-item-san" id="table">

							<li class="item-card">

								<div class="row">
									<div class="col-md-5 item-preview-image">
										<a href="#" title="Logo sân"> <img class="img-responsive"
											src="<%=sb.getAnh()%>" align="thumbnail" title="Logo sân"
											style="border-radius: 20px; margin: auto; width: auto; height: auto;">
										</a>
										<!-- dung jquery lay id tu list gủi sang modal de gui di -->


										<!-- hoac chuyen sang trang moi-->
									</div>
									<div class="col-md-7 right-item-san">
										<div style="float: right;">
											<a href="javascript:;" class="btn btn-primary"
												data-toggle="modal" data-target="#datsan"> Đặt sân </a>
										</div>
										<p class="phone-numb">
											<i class="fa fa-info-circle" style="font-size: 24px"></i>Thông
											tin sân <span style="color: red; font-size: 20px"><%=sb.getTensan()%>
											</span> <span id="idsan" hidden="hidden"><%=sb.getMasanbong()%></span>
										</p>


										<p>
											<span class="alert alert-info">Đây là <strong>#<%=Xuli.loaisan(sb.getLoaisan())%>
											</strong></span><%=sb.getThongtin()%></p>



										<p>
											<i class="fa fa-map-o" aria-hidden="true"></i>
											<%=sb.getKhuvuc()%>
										</p>
										<p class="phone-numb">
											<i class="fa fa-phone-square" aria-hidden="true"></i><%=sb.getChusan().getSdt()%>
											&nbsp; &nbsp; <i class="fa fa-mail-forward"><%=sb.getChusan().getEmail()%></i>
										</p>
										<form action="Chitietsanbong" method="get">
											<input type="text" name="masanbong" id="idsan2"
												hidden="hidden"> <input class="form-control"
												id="date" name="ngay" type="date" title="format : dd/MM/y"
												required="required"
												value="<%=request.getAttribute("ngay")%>" /> <input
												type="submit" class="btn btn-primary" value="Thay đổi">
										</form>
										<p class="phone-numb">
											<i class="fa fa-calendar-times-o">Gồm <%=sb.getSosan()%>
												sân chính
											</i><span class="text-warning"> <%=sb.getSosantrong()%>
												sân trống
											</span>

										</p>
									</div>
								</div> <%
 	ArrayList<Integer> trong = (ArrayList<Integer>) request.getAttribute("santrong");
 %>
								<table class="table table-hover">
									<thead>
										<tr>
											<th>Khung giờ</th>
											<th>Giá sân</th>
											<th>Đã đặt</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>6h-16h</td>
											<td><%=sb.getGia1()%></td>
											<td><%=trong.get(0)%>/<%=sb.getSosan()%></td>
										</tr>
										<tr>
											<td>16h-17h30</td>
											<td><%=sb.getGia2()%></td>
											<td><%=trong.get(1)%>/<%=sb.getSosan()%></td>
										</tr>
										<tr>
											<td>17h30-19h</td>
											<td><%=sb.getGia3()%></td>
											<td><%=trong.get(2)%>/<%=sb.getSosan()%></td>
										</tr>
										<tr>
											<td>19h-20h30</td>
											<td><%=sb.getGia4()%></td>
											<td><%=trong.get(3)%>/<%=sb.getSosan()%></td>
										</tr>
										<tr>
											<td>20h30-22h</td>
											<td><%=sb.getGia5()%></td>
											<td><%=trong.get(4)%>/<%=sb.getSosan()%></td>
										</tr>
									</tbody>
								</table>
							</li>
						</ul>
						<!--End list-item-san-->
					</div>
				</div>
			</div>
			<script>
				$(function() {
					$('#idsan2').val($('#idsan').text());
					$('#table a').click(
							function(e) {
								e.preventDefault();
								$('#khuvuc').val(
										$(this).closest('li')
												.find('span:first').text()); //Lấy value cột thứ nhất
								$('#idsan1').val(
										$(this).closest('li').find('#idsan')
												.text());
								//Hoặc lấy giá trị cột thứ 2
							});
				});
			</script>

			<!--End row-->
		</div>
		<!--End container-->
	</div>
	<!--End content-wrap-->
	<jsp:include page="include/foot.jsp"></jsp:include>
	
	
	<!--datsan-->
	<div id="datsan" class="modal fade" role="dialog">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Đặt sân</h4>
				</div>
				<div class="modal-body">
					<h4 class="alert alert-success">Gọi điện cho chủ sân để xác
						nhận sau khi đặt sân</h4>
					<form id="frmSignIn" class="modal-forms" method="post"
						action="Chitietsanbong">
						<input type="text" name="idsan" id="idsan1" hidden="hidden">
						<%
							Taikhoan a = (Taikhoan) session.getAttribute("taikhoan");
							if (null != a.getMataikhoan()) {
						%>
						<div class="login-error"></div>

						<input type="text" id="khuvuc" readonly="readonly"> <input
							type="text" name="ten" readonly="readonly"
							value="<%=a.getTen()%>"> <input name="sdt" type="text"
							readonly="readonly" value="<%=a.getSdt()%>"> <input
							type="text" name="idtk" hidden="hidden"
							value="<%=a.getMataikhoan()%>">

						<%
							} else {
						%>
						<input type="text" id="khuvuc" readonly="readonly"> <input
							type="text" name="ten" required="required"
							data-msg-require="Không được để trống"
							placeholder="Nhập tên người đặt"> <input name="sdt"
							type="text" placeholder="Số điện thoại hoặc email" required
							id="UserName" oninvalid="sport.account.validateControl(this);"
							oninput="sport.account.validateControl(this);"
							data-msg-require="Số điện điện không được để trống"> <input
							type="text" name="idtk" hidden="hidden">

						<%
							}
						%>
						<div class="form-group form-group-sm">
							<label class="control-label col-sm-3">Ngày </label>
							<div class="col-sm-9">
								<input type="date" name="ngay"
									class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
									data-msg-require="không được để trống"
									value="<%=java.time.LocalDate.now().toString()%>">

							</div>
						</div>
						<div class="form-group form-group-sm">
							<label class="control-label col-sm-3">Thời gian:</label>
							<div class="col-sm-9">
								<select name="batdau"
									class="form-control ng-pristine ng-untouched ng-valid ng-not-empty">

									<option value="1" selected="selected">6h-16h</option>
									<option value="2">16h-17h30</option>
									<option value="3">17h30-19h</option>
									<option value="4">19h-20h30</option>
									<option value="5">20h30-22h</option>

								</select>
							</div>
						</div>

						<input type="text" name="ghichu" placeholder="Ghi Chú">
						<button id="btnSignIn" type="submit">Đặt sân</button>
					</form>
				</div>
				<div class="modal-footer"></div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!--#datsan-->
	
</body>
<!-- Mirrored from www.timdoinhanh.com/dat-san-nhanh by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Oct 2018 02:50:03 GMT -->

</html>