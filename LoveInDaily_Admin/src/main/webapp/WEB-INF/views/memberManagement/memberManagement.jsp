
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html dir="ltr">
<head>
<meta charset="UTF-8">
<title>Love In Daily</title>
<c:import url="../common/header.jsp" />
</head>
<body>
	<div class="preloader">
		<div class="lds-ripple">
			<div class="lds-pos"></div>
			<div class="lds-pos"></div>
		</div>
	</div>
	<div id="main-wrapper">
		<c:import url="../common/menubar.jsp" />
		<c:import url="../common/sidebar.jsp" />

		<div class="page-wrapper">
			<!-- ============================================================== -->
			<!-- Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<div class="page-breadcrumb">
				<div class="row">
					<div class="col-12 d-flex no-block align-items-center">
						<h4 class="page-title">Member Management</h4>
						<div class="ml-auto text-right">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="#">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">Member
										Management</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>
			<!-- ============================================================== -->
			<!-- End Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- Container fluid  -->
			<!-- ============================================================== -->
			<div class="container-fluid">
				<!-- ============================================================== -->
				<!-- Start Page Content -->
				<!-- ============================================================== -->
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title" style="margin-left: 10px;">회원 리스트</h5>
								<div class="table-responsive">


									<table id="zero_config"
										class="table table-striped table-bordered"
										style="text-align: center; font-size: 13px;">
										<thead>
											<tr>
												<th>회원번호</th>
												<th>이메일</th>
												<th>이름</th>
												<th>연락처</th>
												<th>가입일</th>
												<th>회원상태</th>
												<th>프로필 확인</th>
												<th>신고</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach items="${memList}" var="m">
												<tr id="${m.mNo}">
													<td>${m.mNo}</td>
													<td>${m.mEmail}</td>
													<td>${m.mName}</td>
													<td>${m.mPhone}</td>
													<td>${m.mDate}</td>
													<td>${m.mLevel}</td>
													<td>
														<button class="btn btn-outline-secondary btn-sm"
															id="${m.mNo}" onclick="DeleteMem('${m.mNo}');">
															<i class="mdi mdi-account-check"></i> 프로필 확인
														</button>
													</td>
													<td>
													<c:forEach items="${reportList}" var="r">
														<c:if test="${r.rMemberName eq m.mName }">O</c:if>
													</c:forEach>
													</td>
												</tr>
											</c:forEach>
									</table>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


				<div class="modal fade memberDetail" id="memberDetail" tabindex="-1"
					role="dialog" aria-hidden="true">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<!-- 게시물 작성 모달 내용 부분 -->
							<div class="modal-header">
								<h5 class="modal-title">회원 관리</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body" style="float:left; rigth-margin:300px;">
								<c:import url="memberDetail.jsp"></c:import>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
	<script>
		/****************************************
		 *       Basic Table                   *
		 ****************************************/
		$('#zero_config').DataTable();
		$(function(){
			
			if(${list ne null}){
				
				$('#memberDetail').modal();
				
			}
			
			$("table td").not("#zero_config td:eq(6)").click(function(){
				
				var mNo = $(this).parent().children().eq(0).text();
				
				$.ajax({
					url : "${pageContext.request.contextPath}/memberManagement/memberReport.do",
					data : {mNo : mNo},
					type : "POST",
					dataType : "json",
					success : function(data){
						location.reload();
					},
					error : function(error){
						alert("eroro");
					}
				});
			
			});
			
			$('#memberDetail').on('hide.bs.modal', function(){
				
				$.ajax({
					url : "${pageContext.request.contextPath}/memberMangement/sessionOut.do",
					dataType : "json",
					success : function(data){
					},
					error : function(error){
					}
				});
				
			});
		});
	</script>
	<script>
		$(function(){
			<c:forEach items="${reportList}" var="r">
				<c:forEach items="${memList}" var="m">
				if("${r.rMemberName}" == "${m.mName}"){
					$('#${m.mNo}').css("background","red").css("color","white");
					$('#${m.mNo} td').eq(5).text("신고");
				}
				</c:forEach>
			</c:forEach>
		});
	

		
	</script>



	<c:import url="../common/footer.jsp" />
	
</body>

</html>