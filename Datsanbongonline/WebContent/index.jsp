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
    

    
    
    

    <title>Tìm đối đá bóng, đặt sân trực tuyến - Tìm Đối Nhanh - Tìm đối nhanh, đặt sân rẻ</title>
    <!-- Google Font -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800' rel="stylesheet" type="text/css">
    <link href="Assets/css/font-awesome.min.css" rel="stylesheet" />

    <!--Stylesheets-->
    <link href="css/plugins079c.css?v=Ahqo92Qjg_5hNgokcNbdDKqsKgb-VMnRUm9SH4imTUk1" rel="stylesheet"/>

    <link href="Assets/css/maind533.css?v=rBrNA_Ie8mU1GAAJGmu8FmgLAO4dS0CvaXQu5oBhCF41" rel="stylesheet"/>

    <!--Libraries-->
    <script src="scripts/libs5992.js?v=zkvBZ0Y7GXymwX7ixYzy5fOCoH5nHt9_E-mHwnHPCYo1"></script>

    <script src="scripts/firebase78dc.js?v=ViiODJOSSLf5H-KOUXkWltIlSN07oOrFe9X_7VsjhHc1"></script>


    <!--angularjs ui-select-->
    


    <!--angularjs moment-picker-->
    
    
    <!--Common-->



    
    
</head>
<body  class="page-frontpage ">
   
<jsp:include page="include/head.jsp"></jsp:include>
    



        <div class="top-hero-box">
  <div class="container">
    <div class="row">
    
                        <div class="col-md-7">
                    <div class="fp-banner-text">
                        <h1 class="title">
                            Quản lý sân, tìm đối giao lưu
                            <br>
                            đặt sân trực tuyến
                        </h1>
                        <p class="description">
                            <i class="fa fa-quote-left"></i>
                            Tập hợp hàng ngàn câu lạc bộ thể thao tại Hà Nội, Hồ Chí Minh và các Tỉnh / Thành phố khác.
                            Tại đây, bạn dễ dàng tìm được các đối chơi cùng trình độ cũng như tìm sân chơi chất lượng cao với khung thời gian, giá cả hợp lý nhất.
                        </p>
                        <ul id="feature-list">
                            <li class="free-text">
                                <em class="glyphicon glyphicon-ok-sign"></em>
                                Hoàn toàn <strong>miễn phí</strong>!
                            </li>
                            <li>
                                <em class="glyphicon glyphicon-ok-sign"></em>
                                <strong>Tìm đối</strong> giao lưu, kết bạn dễ dàng.
                            </li>
                            <li>
                                <em class="glyphicon glyphicon-ok-sign"></em>
                                <strong>Quản lý sân</strong>, lịch biểu hiệu quả, tiết kiệm tối đa thời gian
                            </li>
                            <li>
                                <em class="glyphicon glyphicon-ok-sign"></em>
                                Giảm thiểu tối đa tình trạng <strong>trống sân, cháy đối</strong>!
                            </li>
                            <li class="view-more">
                                <a class="btn btn-primary" title="Toàn bộ tính năng của TìmĐốiNhanh.com" href="tien-ich.jsp">
                                    <em class="glyphicon glyphicon-hand-right"></em>
                                    XEM CHI TIẾT
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div class="fp-quick-buttons">
                        <div class="fp-btn-group">
                            <a href="tim-doi-da-bong.jsp" title="Tìm đối đá bóng tại Hà Nội" class="btn btn-info" id="fp-btn-match-hanoi">
                                <span class="count" id="matchHNCount"></span> Đối tại Hà Nội
                            </a>
                            <a href="tim-doi-da-bong-tai-ho-chi-minh.jsp" title="Tìm đối đá bóng tại Hồ Chí Minh" class="btn btn-info" id="fp-btn-match-hcm">
                                <span class="count" id="matchHCMCount"></span> Đối tại Hồ Chí Minh
                            </a>
                            <!--<a href="/tim-doi-da-bong-tai-da-nang" title="Tìm đối đá bóng tại Đà Nẵng" class="btn btn-info btn-sm" id="fp-btn-match-danang">
                                <span class="count" id="fp-btn-match-danang-count"></span> Đối tại Đà Nẵng
                            </a>-->
                            <a href="doi-bong.jsp" title="Danh sách đội bóng tại Hà Nội, Hồ Chí Minh, Đà Nẵng..." class="btn btn-info" id="fp-btn-match-team">
                                <span class="count" id="teamAllCount"></span> Đội bóng
                                
                            </a>
                        </div>
                        <div class="fp-btn-group">
                            <a href="san-bong-tai-ha-noi.jsp" title="Sân bóng tại Hà Nội" class="btn btn-info" id="fp-btn-stadium-hanoi">
                                <span class="count" id="stadiumHNCount"></span>
                                Sân bóng tại Hà Nội
                            </a>
                            <a href="san-bong-tai-ho-chi-minh.jsp" title="Sân bóng tại Hồ Chí Minh" class="btn btn-info" id="fp-btn-stadium-hcm">
                                <span class="count" id="stadiumHCMCount"></span>
                                Sân bóng tại Hồ Chí Minh
                            </a>
                            <!--<a href="/san-bong-tai-da-nang" title="Sân bóng tại Đà Nẵng" class="btn btn-info btn-sm" id="fp-btn-stadium-danang">
                                <span class="count" id="stadiumDNCount"></span>
                                Sân bóng tại Đà Nẵng
                            </a>-->
                        </div>
                    </div>
                    <div class="alert alert-danger">
   <marquee><%ArrayList<Thongbao> ds= (ArrayList<Thongbao>) request.getAttribute("thongbao");
   for (Thongbao tb:ds){
   %>
   <span style="padding-left: 30px; padding-right: 30px;">  <%=tb.getNoidung() %></span> 
   <%} %>
  </marquee>
</div>
                </div>
    
        <div class="col-md-5">
    <div id="account-creation-form">
    <h3>Tạo tài khoản mới</h3>
  <%= request.getAttribute("loi") %>
    <form id="frmRegister" action="Index" method="get" class="form account-form">
        <div class="form-group">
          
        </div>
        <div class="form-group">
            <div class="row">
               
                
                    <input name="Name" class="form-control" type="text"
                           placeholder="Tên" required id="LastName"data-msg-require="Tên bạn là gì?">
              
            </div>
        </div>
        <div class="form-group">
            <input name="sdt" class="form-control" type="text"
                   placeholder="Số di động hoặc email" required id="UserName" data-msg-require="Vui lòng nhập số điện thoại " data-msg-username-invalid="Vui lòng nhập 1 số điện thoại hoặc địa chỉ email hợp lệ!">
        </div>
        <div class="input-group form-group-password">
            <input name="Password" class="form-control" type="Password"
                   placeholder="Mật khẩu mới" required id="Password"data-msg-require="Vui lòng điền mật khẩu của bạn?">
            <span class="input-group-btn">
                <button class="btn btn-default btn-showhide-password" type="button"><i class="glyphicon glyphicon-eye-open"></i></button>
            </span>
        </div>
        <div class="btn-form-reg">
            <div class="row">
                <div class="col-xs-12 col-md-6 col-md-6">
                    <button class="btn btn-primary btn-block btn-lg" id="btnRegister" type="submit" >Đăng ký</button>
                </div>
                <div class="col-xs-12 col-md-6 col-md-6">
                    <div class="form-group social-login-group">
                        <div class="div-logisn">Hoặc đăng nhập với:</div>

                        <div class="login-social">
                            <a class="logon-facebook" href="javascript:void(0)"><i class="fa fa-facebook-square"></i></a>
                            <a class="login-google" href="javascript:void(0)"><i class="fa fa-google-plus-square"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <a href="user/forgotpassword.jsp">Lấy lại mật khẩu</a>
                </div>
            </div>
            <div class="form-control-note text-justify">
                Bằng cách nhấn vào nút "Đăng ký", Bạn đồng ý với
                <a href="dieu-khoan-su-dung.jsp" target="_blank">điều khoản sử dụng</a> và
                <a href="chinh-sach-bao-mat.jsp" target="_blank">chính sách bảo mật</a> của chúng tôi.
            </div>
        </div>
    </form>
</div> <!-- /.account-form -->

        </div>
    
        </div> <!--End container-->
</div> <!--End fp-banner-->
</div>
    <jsp:include page="include/foot.jsp"></jsp:include>

        

</body>


</html>