<%@page import="model.bean.Taikhoan"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<link href="../Assets/css/font-awesome.min.css" rel="stylesheet" />

<!--Stylesheets-->
<link
	href="../css/plugins079c.css?v=Ahqo92Qjg_5hNgokcNbdDKqsKgb-VMnRUm9SH4imTUk1"
	rel="stylesheet" />

<link
	href="../Assets/css/maind533.css?v=rBrNA_Ie8mU1GAAJGmu8FmgLAO4dS0CvaXQu5oBhCF41"
	rel="stylesheet" />

<!--Libraries-->
<script
	src="../scripts/libs5992.js?v=zkvBZ0Y7GXymwX7ixYzy5fOCoH5nHt9_E-mHwnHPCYo1"></script>

<script
	src="../scripts/firebase78dc.js?v=ViiODJOSSLf5H-KOUXkWltIlSN07oOrFe9X_7VsjhHc1"></script>


<!--angularjs ui-select-->



<!--angularjs moment-picker-->


<!--Common-->





</head>
<body class="page-frontpage ">




	<header class="n-nav navbar" role="banner">
	<div class="container">
		<div class="navbar-header">
			<span id="btn-left-sidebar" class="only-mobile-btn"><i
				class="fa fa-bars" aria-hidden="true"></i></span> <a
				class="rounded border border-success" href="Index"
				style="font-size: 30px; color: white">Sân Bóng Vinh</a> <span
				id="btn-right-sidebar" class="only-mobile-btn btn-right-user">
				<i class="fa fa-user" aria-hidden="true"></i>

			</span>
		</div>
		<!-- /.navbar-header -->
		<nav class="mobi-none" role="navigation">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="Doibong"
				title="Tìm đối đá bóng sân 7 người, sân 5 người">Tìm đối nhanh</a>
				<ul class="navbar-nav-dropdown">
					<li class="navbar-match-finding"><a href="Timdoi"
						title="Tìm đối đá bóng "> <i class="fa fa-futbol-o"
							aria-hidden="true"></i> Đối đang chờ
					</a></li>
					<li class="navbar-match-finding"><a href="Doibong"
						title="Danh sách đội bóng "> <i class="fa fa-futbol-o"
							aria-hidden="true"></i> Danh sách đội bóng
					</a></li>


				</ul></li>
			<li style="display: none"></li>
			<li class="navbar-stadium"><a href="Datsannhanh"
				title="Sân cỏ nhân tạo Vinh"><i class="fa fa-futbol-o"
					aria-hidden="true"></i>Đặt sân nhanh</a>
			</li>
			<li class="navbar-stadium">
				<%
					 
					if (null != session.getAttribute("taikhoan")) {
				%> <a href="DangXuat" id="loginBtn"> Đăng Xuất </a>
				<%
					} else {
				%> <a href="javascript:;" id="loginBtn" data-toggle="modal"
				data-target="#loginModal"> Đăng nhập </a> <%
 	}
 %>
			</li>
		</ul>
		</nav>
	</div>
	<!-- /.container --> </header>

 <div id="loginModal" class="modal fade" role="dialog">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Đăng nhập</h4>
                </div>
                <div class="modal-body">
                    
<form id="frmSignIn" class="modal-forms" action="Dangnhap" method="post">
    <div class="login-error">
        
            
    </div>
    <input name="UserName" type="text" placeholder="Số điện thoại hoặc email" required id="UserName"data-msg-require="Tài khoản đăng nhập không được để trống">
    <input type="password" name="Password" placeholder="Mật khẩu" required id="Password"data-msg-require="Mật khẩu không được để trống">


    <button id="btnSignIn" type="submit" >Đăng nhập</button>
</form>
    <div class="a-btn-modal">
        <div class="social-login-group">
            <p>Hoặc đăng nhập với</p>
            <a class="logon-facebook" href="#"><i class="fa fa-facebook-square" aria-hidden="true"></i></a>
            <a class="login-google" href="#"><i class="fa fa-google-plus-square" aria-hidden="true"></i></a>
            
        </div>
        <p class="footer-group" style="margin-top:15px;">
            <a href="user/forgotpassword.html" class="forgot-pass">Quên mật khẩu</a>
            <a href="javascript:location.href='Index'" class="register-link pull-right">Tạo tài khoản mới</a>
        </p>
    </div>

                </div>
                <div class="modal-footer">

                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <!--#login-->
    <div id="modalNotAuthorize" class="modal modal-styled fade" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 class="modal-title">Thông báo</h3>
                </div> <!-- /.modal-header -->
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <h3>Bạn phải đăng nhập để sử dụng tính năng</h3>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <a data-dismiss="modal" href="javascript:;" onclick="global.showModalLoginPopup();" class="btn btn-success">Đăng nhập</a>
                                    <a href="#" onclick="location.href = 'index.jsp';" class="btn btn-danger">Đăng kí</a>
                                </div>
                            </div>
                        </div> <!-- /.portlet-body -->
                    </form>
                </div> <!-- /.modal-body -->
                <div class="modal-footer">

                    <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
                </div> <!-- /.modal-footer -->
            </div> <!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div>

<!-- /.modal -->
</body>
</html>