<%@page import="common.Xuli"%>
<%@page import="model.bean.Sanbong"%>
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

<!--angularjs ui-select-->
<!--angularjs moment-picker-->
<!--Common-->

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
					<div class="p-content">
						<h1 id="a" class="title-intent title-pages  mobile-padlr-15">
							<i class="fa fa-futbol-o" aria-hidden="true"></i> Tìm sân trống
						</h1>
						<form method="get" action="Datsannhanh">
							<div class="form-group row mobile-padlr-15">
								<div class="col-md-3 margin-b10">
									<input type="text" class="form-control" name="khuvuc"
										placeholder="Nhập khu vực" required="required">
								</div>
								<div class="col-md-5  margin-b10">
									<input class="form-control" id="date" name="ngay" type="date"
										placeholder="dd/MM/y" title="format : dd/MM/y"
										required="required"
										value="<%=java.time.LocalDate.now().toString()%>" />
								</div>
								<div class="col-md-2">
									<button type="submit" class="btn btn-primary">Kiểm tra
									</button>
									<span hidden="hidden"><%=request.getAttribute("thongbao")%></span>
								</div>
							</div>
						</form>
						<ul class="list-item-san" id="table">
							<%
								ArrayList<Sanbong> dssb = (ArrayList<Sanbong>) request.getAttribute("dssb");
								for (Sanbong sb : dssb) {
							%>

							<li class="item-card">
								<div class="row">
									<div class="col-md-5 item-preview-image">
										<a href="#" title="Logo sân"> <img class="img-responsive"
											src="<%=sb.getAnh()%>" align="thumbnail" title="Logo sân"
											style="border-radius: 20px; margin: auto; width: auto; height: auto;">
										</a>

									</div>
									<div class="col-md-7 right-item-san">
										<div style="float: right;">
											<a
												href="Chitietsanbong?masanbong=<%=sb.getMasanbong()%>&ngay=<%=java.time.LocalDate.now().toString()%>"
												class="btn btn-primary">Chi tiết sân bóng</a>
										</div>
										<p class="phone-numb">
											<i class="fa fa-info-circle" style="font-size: 24px"></i>Thông
											tin sân <span style="color: red; font-size: 20px"><%=sb.getTensan()%>
											</span> <span id="idsan" hidden="hidden"><%=sb.getMasanbong()%></span>
										</p>


										<p>
											<span class="alert alert-info">Đây là <strong>#<%=Xuli.loaisan(sb.getLoaisan())%>
											</strong></span>
											<%=sb.getThongtin()%>
										</p>



										<p>
											<i class="fa fa-map-o" aria-hidden="true"></i>
											<%=sb.getKhuvuc()%>
										</p>
										<p class="phone-numb">
											<i class="fa fa-phone-square" aria-hidden="true"></i><%=sb.getChusan().getSdt()%>
											&nbsp; &nbsp; <i class="fa fa-mail-forward"><%=sb.getChusan().getEmail()%></i>
										</p>

										<p class="phone-numb">
											<i class="fa fa-calendar-times-o">Gồm <%=sb.getSosan()%>
												sân chính
											</i><span class="text-warning"> <%=sb.getSosantrong()%>
												sân trống
											</span>

										</p>
									</div>
								</div>
							</li>
							<%
								}
							%>
						</ul>
						<!--End list-item-san-->
					</div>
				</div>
			</div>

			<div class="col-md-12">
				<div class="pagination_container">
					<div class="pagination">
						<span class="noLinkPager hnpageprev_inactive"><i
							class="fa fa-angle-left" aria-hidden="true"></i></span><span
							class="noLinkPager hncurrpage">1</span><a
							href="tim-doi-da-bongfc45.html?pi=2" class="linkPager hnpagelink"
							title="2"><span class="hnotherpage">2</span></a><a
							href="tim-doi-da-bongf691.html?pi=3" class="linkPager hnpagelink"
							title="3"><span class="hnotherpage">3</span></a><a
							href="tim-doi-da-bong7167.html?pi=4" class="linkPager hnpagelink"
							title="4"><span class="hnotherpage">4</span></a><a
							href="tim-doi-da-bong7893.html?pi=5" class="linkPager hnpagelink"
							title="5"><span class="hnotherpage">5</span></a><span
							class="noLinkPager dot">...</span><a
							href="tim-doi-da-bongf3bf.html?pi=23"
							class="linkPager hnpagelink" title="23"><span
							class="hnotherpage">23</span></a><a
							href="tim-doi-da-bongbef2.html?pi=24"
							class="linkPager hnpagelink" title="24"><span
							class="hnotherpage">24</span></a><a
							href="tim-doi-da-bongfc45.html?pi=2" class="linkPager hnpagenext"
							title="Trang sau"><span class="hnotherpage"><i
								class="fa fa-angle-right" aria-hidden="true"></i></span></a>
					</div>
				</div>
			</div>
			<!--End row-->
		</div>
		<!--End container-->
	</div>
	<!--End content-wrap-->
	<jsp:include page="include/foot.jsp"></jsp:include>
	
</body>
<!-- Mirrored from www.timdoinhanh.com/dat-san-nhanh by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Oct 2018 02:50:03 GMT -->

</html>