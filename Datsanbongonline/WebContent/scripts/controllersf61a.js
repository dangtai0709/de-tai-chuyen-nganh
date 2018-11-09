sportApp.controller("NotificationCtrl",["$scope","$firebaseObject","$rootScope","NotificationService",function(n,t,i,r){n.notiItemListObj=[];n.notiItemListDisplay=[];n.notiItemCount="";n.onShowed=!1;n.notiRef=null;n.pageIndex=1;n.pageSize=25;n.notiItemHistoryList=[];n.notiHistoryLoaded=!1;n.loadNotificationHistory=function(t,i){t&&(n.pageIndex=t);i&&$(i.toElement).button("loading");r.getNotificationHistory(n.pageIndex,n.pageSize).then(function(t){t.isSuccessful&&(n.notiItemHistoryList=n.notiItemHistoryList.concat(t.data),n.hasMoreData=t.data.length>=n.pageSize);n.notiHistoryLoaded=!0;i&&$(i.toElement).button("reset")})};n.onLoadNotifications=function(){n.notiRef=(new firebase.database).ref("notifications/"+global.authen.getUserID());n.notiRef.limitToLast(5).on("value",function(t){var i=t.val(),r=n.$$phase;r!="$apply"&&r!="$digest"?n.$apply(function(){n.notiItemListObj=i==null?[]:i;n.calculateNotiItemCount()}):(n.notiItemListObj=i==null?[]:i,n.calculateNotiItemCount());n.onShowed=!1;n.isNotificationLoaded=!0})};n.calculateNotiItemCount=function(){var u,t,i;n.notiItemListDisplay=[];var f=[],e=[],r=0,o=Object.keys(n.notiItemListObj);for(u=0;u<o.length;u++)t=n.notiItemListObj[o[u]],t.image&&(t.image=t.image.replace("http://","https://")),i=jQuery.extend(!0,{},t),i.url=n.getNotiUrl(t.itemType,t.itemId),e.push(i),i.isRead==!1&&(r++,$.inArray(i,f)==-1&&f.length<=5&&f.push(i));n.notiItemCount=r==0?"":r>=5?"5+":r;n.notiItemListDisplay=e};n.onShowNotifications=function(){var i,t,r;if(n.onShowed||n.notiItemCount.length==0)return!1;for(n.notiItemCount="",i=Object.keys(n.notiItemListObj),t=0;t<i.length;t++)r=n.notiItemListObj[i[t]],r.isRead=!0;n.notiRef.update(n.notiItemListObj);n.onShowed=!0};n.calTimeAgo=function(n){return calcuateTimeAgo(n)};n.getNotiUrl=function(n,t){var r="javascript:void();";switch(n){case common.config.notificationItemType.matchRecipient_PartnerCreate:case 20:r=i.getMatchFindingOnPageUrl(t);break;case common.config.notificationItemType.matchRecipient_PartnerCancel:r=i.getMatchFindingOnPageUrl(t);break;case common.config.notificationItemType.matchRecipient_OwnerCancel:r=i.getMatchFindingOnPageUrl(t);break;case common.config.notificationItemType.matchRecipient_OwnerConfirm:r=i.getMatchFindingOnPageUrl(t);break;case common.config.notificationItemType.requestApproveBooking:r=i.getReviewBookingListingUrl(t,n);break;case common.config.notificationItemType.responseApproveBooking:r=i.getReviewBookingListingUrl(t,n);break;case common.config.notificationItemType.requestApproveRepeatBooking:r=i.getReviewBookingListingUrl(t,n);break;case common.config.notificationItemType.responseApproveRepeatBooking:r=i.getReviewBookingListingUrl(t,n)}return r};global.authen.isAuthenticated()&&n.onLoadNotifications()}]);sportApp.controller("UserCommentController",["$scope","$http","$timeout","$interval","CommentService",function(n,t,i,r,u){function f(n,t){for(var i in n)if(n[i].id==t)return n[i];return null}function e(){return{toItemId:n.toItemId,toItemType:n.toItemType,toUserId:n.toUserId,toTeamId:n.toTeamId,message:n.commentPost.message}}n.commentAuthor={userId:common.config.userId,avatar:common.config.avatar!==""?common.config.avatar:"/Images/user/default-user.png",userName:common.config.name};n.recipientStatusList=common.config.matchRecipientStatuss;n.loadComments=function(t,i,r,f){n.toItemId=i;n.toItemType=t;n.toUserId=r;n.toTeamId=f;u.getList(t,i).then(function(t){n.commentList=t.data})};n.showHtml=function(n){return n.replace(/(?:\r\n|\r|\n)/g,"<br />")};n.addNewComment=function(){var t=e();n.addComment(t,function(){n.commentPost.message=""})};n.addComment=function(t,i){common.ui.showLoading();u.add(t).then(function(t){var r=t.data,u;r.parentId>0?(u=f(n.commentList,r.parentId),u.children.push(r),u.relatedItemStatus=r.relatedItemStatus,u.relatedItemStatusText=r.relatedItemStatusText,u.extraIconCssClass=r.extraIconCssClass):n.commentList.push(r);i&&i();common.ui.hideLoading()})};n.onReply=function(t){if(!global.authen.isAuthenticated()){global.showModalNotAuthorize();return}common.ui.showLoading();u.getReplyModel(t.id).then(function(i){if(t.reply=i.data,t.reply.confirmMatchInvitionEnabled){var r=t.reply.relatedItemStatus;r==5&&(r=1);t.reply.selectedRelatedItemStatus=f(n.recipientStatusList,r)}common.ui.hideLoading()})};n.addCommentReply=function(t){if(t.reply.confirmMatchInvitation&&t.reply.relatedItemStatus){var i=t.reply.relatedItemStatus==2?"Đồng ý":"Từ chối";if(!confirm("Bạn có chắc chắn "+i+" đối tác này?")){t.reply.relatedItemStatus=null;return}}t.reply.confirmMatchInvitionEnabled&&(t.reply.relatedItemStatus=t.reply.selectedRelatedItemStatus.id);n.addComment(t.reply,function(){t.reply=null})};n.checkAuthentication=function(){if(console.log("called checkAuthentication!"),!global.authen.isAuthenticated()){global.showModalNotAuthorize();return}}}]);var MatchFindingHelper={onSearchStadiumSelectedChange:function(n){console.log("onSearchStadiumSelectedChange: "+n)}};sportApp.controller("matchFindingCtrl",["$scope","$rootScope","CommonService","MatchFindingService","StadiumService","$compile",function(n,t,i,r,u){function f(n,t,i,u){$(n.toElement).button("loading");r.confirmMatchInvitation(t,i,u).then(function(){$(n.toElement).button("reset");common.ui.notification.success("Xác nhận đối thành công");setTimeout(function(){location.reload()},1e3)})}n.filter={};n.filter.teamId=0;n.filter.typeId=1;n.filter.pageIndex=1;n.filter.pageSize=30;n.filter.countryId=1;n.filter.provinceId="3";n.filter.ageGroupIds=[];n.filter.countyIds=[];n.filter.stadiumIds=[];n.filter.levelIds=[];n.filter.startTime=null;n.filter.endTime=null;n.listMatchFindingRequest=[];n.countryId=1;n.listAgeGroups=[];n.listLevels=[];n.listProvinces=[];n.listCounties=[];n.listStadiums=[];n.myLeadTeams=t.getMyLeadTeams();n.myLeadTeams.length>0&&(n.matchFindingRecipient={teamId:n.myLeadTeams[0].Id});n.isSearchingMatchFindingRequests=!0;n.loadCounties=function(t){i.getAllCounties(t).then(function(t){n.listCounties=t.records})};n.loadStadiums=function(){var t={provinceId:n.filter.provinceId,key:"",countyIdList:n.filter.countyIds,sportType:n.filter.typeId};u.searchStadiums(t).then(function(t){n.listStadiums=t.records})};n.searchMatchFindingRequests=function(){common.ui.showLoading();n.isSearchingMatchFindingRequests=!0;r.searchMatchFindingRequest(n.filter).then(function(t){n.listMatchFindingRequest=t.records;common.ui.hideLoading();n.isSearchingMatchFindingRequests=!1})};n.acceptMatchInvitation=function(n,t,i){confirm("Đội bạn chắc chắn tham gia được trận này?")&&f(n,t,i,2)};n.rejectMatchInvitation=function(n,t,i){confirm("Đội bạn chắc chắn Không muốn tham gia trận này?")&&f(n,t,i,3)};n.isShowFilter=!0;n.toggleFilter=function(){n.isShowFilter=!n.isShowFilter};n.updateMatchStatus=function(n,t){confirm("Bạn có chắc chắn muốn thay đổi trạng thái trận đấu này?")&&r.updateMatchStatus(n,t).then(function(){common.ui.notification.success("Cập nhật thông tin thành công");setTimeout(function(){location.reload()},1e3)})}}]);sportApp.controller("MatchCreationController",["$scope","CommonService","MatchFindingService","StadiumService","$timeout",function(n,t,i,r,u){var f=this,e,o,s,h,c;f.momentPickerLocale="vi";f.momentPickerFormat="LLLL";f.isFormReady=!1;f.errorMessage=undefined;f.listContracts=["Sân nước","Thỏa thuận"];f.listNumberOfWeeksRepeat=[{id:0,name:"Không lặp"},{id:1,name:"1 Tuần"},{id:2,name:"2 Tuần"},{id:3,name:"3 Tuần"},{id:4,name:"4 Tuần"},{id:5,name:"5 Tuần"},{id:6,name:"6 Tuần"},{id:7,name:"7 Tuần"},{id:8,name:"8 Tuần"},{id:9,name:"9 Tuần"},{id:10,name:"10 Tuần"}];f.selectedTeam={};f.selectedProvince={id:3,name:"Hà Nội"};f.selectedAreas=[];f.selectedStadium={};f.selectedStadiumNumber={};f.matchRequest={typeId:1,countryId:1,provinceId:"3",countyId:null,stadiumIds:[],startTime:null,endTime:null,numberOfWeeksRepeat:"0",contract:"",ageGroupIds:[],levelIds:[],message:""};e=new Date;e.setHours(17,30,0);f.matchRequest.startTimeText=moment(e).locale(f.momentPickerLocale).format(f.momentPickerFormat);f.stadiumFilterText="";o="";n.$watch("vm.stadiumSearchText",function(n){s&&u.cancel(s);o=n;s=u(function(){f.stadiumFilterText=o},500)});f.onSelectStadium=function(){common.ui.modal.show("modalSelectStadium");f.refreshStadium()};f.selectStadium=function(n){f.selectedStadium=n;f.refreshStadiumNumbers();common.ui.modal.hide("modalSelectStadium")};f.areaFilterText="";h="";n.$watch("vm.areaSearchText",function(n){c&&u.cancel(c);h=n;c=u(function(){f.areaFilterText=h},500)});f.onSelectArea=function(){common.ui.modal.show("modalSelectArea")};f.selectArea=function(n){n.checked=!n.checked};f.addNewArea=function(n){f.listAreas.push(n)};f.updateAreaSelections=function(){f.selectedAreas=f.listAreas.filter(function(n){return n.checked});common.ui.modal.hide("modalSelectArea")};f.removeSelectedArea=function(n){var t=f.selectedAreas.indexOf(n);f.selectedAreas.splice(t,1);f.listAreas.filter(function(t){return n.id==t.id})[0].checked=!1};f.refreshAreas=function(n){n||(n="search_all");t.searchAreas(f.selectedProvince.id,n).then(function(n){f.listAreas=n.data.map(function(n){return{id:n.id,name:n.text}})})};f.refreshStadium=function(n){n||(n="search_all");r.searchStadiumAutoComplete(f.selectedProvince.id,n).then(function(n){f.listStadiums=n.data.map(function(n){return{id:n.id,name:n.text,address:n.text2}})})};f.refreshStadiumNumbers=function(){if(f.selectedStadium.id!==0&&f.selectedStadium.id){var n={stadiumId:f.selectedStadium.id};r.searchStadiumNumbers(n).then(function(n){f.listStadiumNumbers=n.records.map(function(n){return{id:n.id,name:n.name}});f.listStadiumNumbers.length>0&&(f.selectedStadiumNumber=f.listStadiumNumbers[0])})}};f.init=function(n){n||(n=0);f.refreshStadium();f.refreshAreas();i.getMatchCreationFormData(n).then(function(n){if(f.myTeams=n.teams,f.selectedTeam=n.teams[0],f.listLevels=n.levels,f.listProvinces=n.provinces,f.matchRequest.partnerTeamLevel=n.levels[0],f.matchRequest.status=$("#matchStatusTemp").val()!==""?2:1,f.selectedLevel=f.listLevels[0],f.isFormReady=!0,n.matchRecord!=undefined&&n.matchRecord.id>0){f.matchRequest=n.matchRecord;var t=n.matchRecord;f.matchRequest.startTimeText=moment(t.startTime).locale(f.momentPickerLocale).format(f.momentPickerFormat);f.selectedTeam={id:t.teamId,name:t.teamName};f.selectedProvince={id:t.provinceId,name:t.provinceName};f.selectedAreas=t.clientAreaList?t.clientAreaList.map(function(n){return{id:n.id,name:n.text}}):null;f.matchRequest.hasStadium=t.stadiumId>0;f.selectedStadium={id:t.stadiumId,name:t.stadiumName};f.selectedStadiumNumber={id:t.stadiumNumberId,name:t.stadiumNumberName};t.levelList!=null&&t.levelList.length>0&&(f.selectedLevel=t.levelList[0]);f.refreshStadium();f.refreshStadiumNumbers();f.refreshAreas()}})};f.createMatch=function(n,t){if(angular.forEach(t.$error.required,function(n){n.$setDirty()}),!t.$valid){alert("Vui lòng nhập đủ thông tin!");return}f.matchRequest.teamId=f.selectedTeam.id;f.matchRequest.teamName=f.selectedTeam.name;f.selectedTeam.id==0&&(f.matchRequest.teamName=f.selectedTeam.name2);f.matchRequest.provinceId=f.selectedProvince.id;f.selectedStadium!=undefined&&(f.matchRequest.stadiumId=isNaN(f.selectedStadium.id)?null:f.selectedStadium.id,f.matchRequest.stadiumName=f.selectedStadium.name);f.selectedStadiumNumber!=undefined&&(f.matchRequest.stadiumNumberId=f.selectedStadiumNumber.id);f.matchRequest.levelList=[f.selectedLevel];f.matchRequest.ageGroupIds=[];f.matchRequest.contractList=[f.contract];f.matchRequest.clientAreaList=f.selectedAreas?f.selectedAreas.map(function(n){return{id:n.id,text:n.name}}):null;f.matchRequest.startTime=moment(f.matchRequest.startTimeText,f.momentPickerFormat,f.momentPickerLocale).toISOString();f.errorMessage="";$(n.toElement).button("loading");i.makeMatchFindingRequest(f.matchRequest).then(function(t){if(t.isSuccessful)common.ui.modal.hide("commonModal"),f.matchRequest={},common.ui.notification.success("Mời đối thành công.!"),location.href="/match/"+t.id;else{var i=t.errors[0].message;i==""&&(i="Không tạo được lời mời đối.!");common.ui.notification.error(i)}$(n.toElement).button("reset")})}}]);sportApp.controller("MatchInvitationController",["$scope","$rootScope","MatchFindingService","TeamService",function(n,t,i,r){n.inviteTeamId=0;n.hasMatchFindingRequest=!1;n.listMatchFindingRequest=[];n.isReady=!1;n.matchDisplaySettings={showFullInfo:!1,hideStatus:!0,showBtnDoi:!0};n.filter={isOwner:!0,typeId:1,pageIndex:1,pageSize:3,countryId:1};n.init=function(){n.goToPage(1);var t=$("#hidInviteFromMatchFindingId").val()!==""?parseInt($("#hidInviteFromMatchFindingId").val()):0;t>0?i.getMobileNumbers(t).then(function(t){n.activeMatchRequestMobileNo=t.data}):r.getTeamMobileNo($("#hidInviteTeamId").val()).then(function(t){n.activeMatchRequestMobileNo=t.data})};n.goToPage=function(t){n.filter.pageIndex=t;common.ui.showLoading();i.getMyMatchFindingRequests(n.filter).then(function(t){t!==null&&(n.listMatchFindingRequest=t.records.filter(function(n){return n.hasStadium}),n.hasMatchFindingRequest=n.listMatchFindingRequest.length>0);common.ui.hideLoading();n.isReady=!0})};n.createNewMatch=function(n){showAngularJsModalByBtn(n.toElement)};n.selectMatchToInvite=function(t){n.inviteTeamId=parseInt($("#hidInviteTeamId").val());var r={matchFindingRequestIdList:[t.id],teamId:n.inviteTeamId,toMatchFindingId:$("#hidInviteFromMatchFindingId").val()!==""?parseInt($("#hidInviteFromMatchFindingId").val()):0,message:"isOwnerInvite",isOwnerInvite:!0};common.ui.showLoading();i.makeMatchInvitation(r).then(function(i){common.ui.hideLoading();i.isSuccessful?(t.activeInvitedTeamIds.push(n.inviteTeamId),common.ui.notification.success("Đã gửi lời mờ, vui lòng đợi đối xác nhận.")):common.ui.notification.error("Lỗi. Vui lòng gửi lại.")})};n.isBtnInviteVisible=function(n){var i=parseInt($("#hidInviteTeamId").val()),t=$("#hidInviteFromMatchFindingId").val()!==""?parseInt($("#hidInviteFromMatchFindingId").val()):0;return n.activeInvitedTeamIds.indexOf(i)>=0?!1:t>0&&n.activeToMatchRequestIds.indexOf(t)>=0?!1:!0}}]);sportApp.controller("MatchInvitationMultiPartnersController",["$scope","$rootScope","MatchFindingService","TeamService","CommonService",function(n,t,i,r,u){var f=this,e;f.teamDisplaySettings={hideChat:!0};e={id:0,name:"Tất cả trình độ"};f.matchFindingRequestId=0;f.teamList=[];f.matchRequestList=[];f.isReady=!1;f.fromTeamId=0;f.filter={typeId:1,pageIndex:1,pageSize:5,countryId:1,ReturnTeamsCreatedByOwnersOnly:!0,selectedLevel:e,loadInvitedMatchRequestIds:!0};f.init=function(n,t,i){u.getAllCommonItems("level").then(function(n){f.listLevels=n.records;f.listLevels.splice(0,0,e)});f.matchFindingRequestId=t;f.filter.inviteToMatchRequestId=t;f.filter.provinceId=i;f.fromTeamId=n;r.searchTeams(f.filter).then(function(n){f.teamList=n.records;f.isReady=!0})};f.searchTeams=function(){typeof f.filter.selectedLevel!="undefined"&&(f.filter.levelId=f.filter.selectedLevel.id);r.searchTeams(f.filter).then(function(n){f.teamList=n.records;f.isReady=!0})};f.goToPage=function(n){f.filter.pageIndex=n;f.searchTeams()};f.inviteTeam=function(n){var t={matchFindingRequestIdList:[f.matchFindingRequestId],teamId:n.id,message:"isOwnerInvite",isOwnerInvite:!0};common.ui.showLoading();i.makeMatchInvitation(t).then(function(){n.activeInvitedFromTeamIds.push(f.fromTeamId);common.ui.hideLoading();common.ui.notification.success("Đã gửi lời mờ, vui lòng đợi đối xác nhận.")})};f.onQuickChat=function(n){t.onQuickChat(n)}}]);sportApp.controller("MatchRecipientMakerController",["$scope","CommonService","MatchFindingService","TeamService",function(n,t,i){n.activeMatchRequestToRecipientId=null;n.matchFindingRecipient={id:0,teamId:null,message:null};n.init=function(t){n.myLeadTeams=angular.copy(common.config.myTeams);n.myLeadTeams.push({id:"0",name:"Thêm đội mới..."});i.getMobileNumbers(t).then(function(t){n.matchMobileNo=t.data});common.ui.showLoading();i.getUserMatchFindingRecipient(t).then(function(i){i.data!=null&&(n.matchFindingRecipient=i.data);n.activeMatchRequestToRecipientId=t;i.data!=null&&i.data.toTeamId!=null?n.matchFindingRecipient.teamId=i.data.toTeamId+"":n.myLeadTeams.length>0&&(n.matchFindingRecipient.teamId=n.myLeadTeams[0].id+"");n.isReady=!0;common.ui.hideLoading()})};n.onMakeMatchFindingRecipient=function(t){var r,f,u;if(formValid("formMatchFindingRecipientCreate")){if(n.matchFindingRecipient.teamId=$("#modalMakerSltTeam").val(),n.activeMatchRequestToRecipientId!=null)n.matchFindingRecipient.matchFindingRequestIdList=[n.activeMatchRequestToRecipientId];else if(r=n.getCheckedMatchFindingList(),r!=null&&r.length>0){for(f=[],u=0;u<r.length;u++)f.push(r[u].id);n.matchFindingRecipient.matchFindingRequestIdList=f}else{alert("Check vào Chọn đặt kèo để chọn nhanh hơn.");return}$(t.toElement).button("loading");i.makeMatchInvitation(n.matchFindingRecipient).then(function(n){n.isSuccessful?(common.ui.notification.success("Gửi nhận kèo thành công "+n.totalRecord+" đối. Vui lòng đợi đối xác nhận."),location.reload()):common.ui.notification.error(n.message)})}}}]);sportApp.controller("MatchFindingQueueController",["$scope","$rootScope","$http","$timeout","$interval","MatchFindingQueueService",function(n,t,i,r,u,f){function o(){$(".q-container .queue-timer").each(function(){var n=$(this),t=parseFloat(n.attr("remaining-minutes")),i=n.attr("waiting-minutes");t>0&&startTimer(t*60,n,function(){n.html("Đối không trả lời sau "+i+" phút")})})}var e=this;e.queueOfMatchInProgress=!0;e.queueOfTeamInProgress=!0;e.matchDisplaySettings={showFullInfo:!1,hideStatus:!0,showBtnDoi:!0};e.matchDisplaySettings2={showFullInfo:!1,showBtnDoi:!0};e.teamDisplaySettings={hideBtnInvite:!0,hideAbout:!0};e.loadQueuesOfMatchItems=function(){f.getQueuesOfMatchItems().then(function(n){e.queuesOfMatchItems=n.data;e.queueOfMatchInProgress=!1;setTimeout(function(){o()},1e3)})};e.loadQueuesOfTeamItems=function(){f.getQueuesOfTeamItems().then(function(n){e.queuesOfTeamItems=n.data;e.queueOfTeamInProgress=!1;setTimeout(function(){o()},1e3)})};e.onQuickChat=function(n){t.onQuickChat(n)};e.loadQueuesOfMatchItems();e.loadQueuesOfTeamItems()}])