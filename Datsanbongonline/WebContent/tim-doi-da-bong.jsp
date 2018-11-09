

<%@page import="common.Xuli"%>
<%@page import="model.bean.Doibong"%>
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
    <link href="css/plugins079c.css?v=Ahqo92Qjg_5hNgokcNbdDKqsKgb-VMnRUm9SH4imTUk1" rel="stylesheet" />
    <link href="Assets/css/maind533.css?v=rBrNA_Ie8mU1GAAJGmu8FmgLAO4dS0CvaXQu5oBhCF41" rel="stylesheet" />
    <!--Libraries-->
    <script src="scripts/libs5992.js?v=zkvBZ0Y7GXymwX7ixYzy5fOCoH5nHt9_E-mHwnHPCYo1"></script>
    <script src="scripts/firebase78dc.js?v=ViiODJOSSLf5H-KOUXkWltIlSN07oOrFe9X_7VsjhHc1"></script>
    <!--angularjs ui-select-->
    <!--angularjs moment-picker-->
    <!--Common-->
</head>

<body class="page-frontpage ">
 <jsp:include page="include/head.jsp"></jsp:include>
    <div class="breadcrum">
        <div class="container">
            <div class="breadcrum-line">
                <a href="index.jsp">Trang chủ</a>
                <a>T&#236;m đối đ&#225; b&#243;ng</a>
            </div>
        </div>
    </div>
    <style type="text/css">
    .list-search-top button[type=submit] {
        width: 96px;
    }

    .list-search-top input[type=text] {
        width: calc(100% - 100px);
    }
    </style>
    <div class="content-wrap"  id="match-item-list">
        <div class="container">
            <div class="row">
                <div class="p-content">
                    <h1 id="a" class="title-intent title-pages mobile-marginlr-15"><i class="fa fa-futbol-o" aria-hidden="true"></i>TÌM ĐỐI ĐÁ BÓNG</h1>
                    <div class="form-group row mobile-marginlr-15">
                        <form method="get" action="Timdoi">
                            <div class="col-md-9 col-xs-9 margin-b10">
                                <input type="text" name="khuvuc" class="form-control" placeholder="Ví dụ: sân Đại Học Vinh" />
                            </div>
                            <div class="col-md-3 col-xs-3 margin-b10">
                                <button class="btn btn-primary" type="submit">Tìm kiếm</button>
                            </div>
                        </form>
                    </div>
                    <ul class="list-item-san">
                    <% ArrayList<Doibong> ds= (ArrayList<Doibong>) request.getAttribute("danhsach");
                  
                    for(Doibong db:ds){
                    	
                    
                    %>
                        <li class="item-card match-finding-item" id="60000">
                            <div class="row">
                                <div class="col-md-12 right-item-san right-item-doi">
                                    <div class="header-item-doi header-tim-doi ">
                                        <img src="<%=db.getAnh() %>" width="150px" height="150px" style="position: absolute;right: 40px; border-radius: 10px;">
                                        <div class="match-header-texts">
                                            <h2>
                       <span style="font-size: 20px;color: #43a047"><%=db.getTendoi() %></span>
                        <span class="match-taginfo">
                            <i class="fa fa-tag" aria-hidden="true"> <%=Xuli.timdoi(db.getTimdoi()) %> </i>
                       <i class="fa fa-tag" aria-hidden="true"> <%=Xuli.cosan(db.getCosan()) %> </i>
                        </span>
                        <span style="padding: 0px 0px 0px 200px">
                          <i class="fa fa-user" aria-hidden="true">Đội trưởng: <%= db.getDoitruong().getTen() %></i>
                           <i class="fa fa-shirtsinbulk" aria-hidden="true"></i> <strong>SDT : <%=db.getDoitruong().getSdt() %></strong>
                           <i class="fa fa-shirtsinbulk" aria-hidden="true"></i> <strong>Email:<%=db.getDoitruong().getEmail() %></strong>
                          </span>
                    </h2>
                                        </div>
                                    </div>
                                    <p class="tim-doi-time"><i class="fa fa-calendar-check-o" aria-hidden="true"></i><strong>Thời gian:</strong><%=db.getThoigianthuongda() %></p>
                                    <p class="guest-stadium-list">
                                        <i class="fa fa-shirtsinbulk" aria-hidden="true"></i><strong>Khu vực:</strong><span class="label label-success"><%=db.getKhuvuc() %> </span>
                                    </p>
                                    <p class="level-row">
                                        <i class="fa fa-shirtsinbulk" aria-hidden="true"></i><strong>Trình độ:</strong><%=Xuli.trinhdo(db.getTrinhdo()) %>
                                    </p>
                                    
                                    <p class="quost-doi">
                                        <%=db.getGioithieu() %>
                                    </p>
                                    <div class="btn-doi-bottom mobile-only mobile-only">
                                        <button class="btn btn-sm btn-primary pull-right btn-batdoi modal-link-angularjs" data-modal-tpl="match.invitation" login-required="true" data-modal-qs="toTeamId=12943&toUserId=2981&toMatchId=60000&matchId=60000&teamId=12943&toTeamName=Fc t&#226;n ước">
                                            <i class="fa fa-send" aria-hidden="true"></i> Bắt đối
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <% }%>
                    </ul>
                    <div class="col-md-12">
                        <div class="pagination_container">
                            <div class="pagination"><span class="noLinkPager hnpageprev_inactive"><i class="fa fa-angle-left" aria-hidden="true"></i></span><span class="noLinkPager hncurrpage">1</span><a href="tim-doi-da-bongfc45.jsp?pi=2" class="linkPager hnpagelink" title="2"><span class="hnotherpage">2</span></a><a href="tim-doi-da-bongf691.jsp?pi=3" class="linkPager hnpagelink" title="3"><span class="hnotherpage">3</span></a><a href="tim-doi-da-bong7167.jsp?pi=4" class="linkPager hnpagelink" title="4"><span class="hnotherpage">4</span></a><a href="tim-doi-da-bong7893.jsp?pi=5" class="linkPager hnpagelink" title="5"><span class="hnotherpage">5</span></a><span class="noLinkPager dot">...</span><a href="tim-doi-da-bongf3bf.jsp?pi=23" class="linkPager hnpagelink" title="23"><span class="hnotherpage">23</span></a><a href="tim-doi-da-bongbef2.jsp?pi=24" class="linkPager hnpagelink" title="24"><span class="hnotherpage">24</span></a><a href="tim-doi-da-bongfc45.jsp?pi=2" class="linkPager hnpagenext" title="Trang sau"><span class="hnotherpage"><i class="fa fa-angle-right" aria-hidden="true"></i></span></a></div>
                        </div>
                    </div>
                    <div class="form-filter-doi">
                        <div class="title-btn-moi-doi">
                            <span>Team của bạn Không tìm được đối tác phù hợp?</span>
                            <a href="#" class="btn btn-default btn-moi-doi"><i class="fa fa-beer" aria-hidden="true"></i> Mời đối giao lưu</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <!--#top hero box-->
	<style type="text/css">
.sp-autocomplete img {
	display: none;
}
</style>
	<script type="text/javascript">
    function onSearchMatchStadiumSelectedChange(data) {
        $('#searchMatchStadiumId').val(data.params.data.id);
    }
    </script>
<jsp:include page="include/foot.jsp"></jsp:include>
    <!-- modal info -->
    <div id="layout_modal_info" class="modal fade in" tabindex="-1" role="dialog" aria-hidden="false" style="display: none;">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title"><i class="icon-warning"></i>Tìm đối nhanh thông báo!</h4>
                </div>
                <div class="modal-body with-padding">
                    <p class="modal-content-info"></p>
                </div>
                <div class="modal-footer">
                    <center><button class="btn btn-tertiary" data-dismiss="modal">Ok</button></center>
                </div>
            </div>
        </div>
    </div>
    <!--login-->
    <!--#login-->
    </body>
<!-- Mirrored from www.timdoinhanh.com/tim-doi-da-bong by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 12 Oct 2018 02:49:57 GMT -->

</html>