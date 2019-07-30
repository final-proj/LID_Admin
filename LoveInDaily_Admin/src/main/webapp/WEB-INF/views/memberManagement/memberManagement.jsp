<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Love In Daily</title>
<c:import url="../common/header.jsp" />
<!-- jQuery Modal -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<!-- <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" /> -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/assets/libs/jquery-modal/jquery.modal.css" />


</head>
<body>
	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper">
		<c:import url="../common/menubar.jsp" />
		<c:import url="../common/sidebar.jsp" />

		<!-- ============================================================== -->
		<!-- End Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper  -->
		<!-- ============================================================== -->
		<div class="page-wrapper">
			<!-- ============================================================== -->
			<!-- Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<div class="page-breadcrumb">
				<div class="row">
					<div class="col-12 d-flex no-block align-items-center">
						<h4 class="page-title">Tables</h4>
						<div class="ml-auto text-right">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="#">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">Library</li>
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
								<h5 class="card-title">회원 리스트</h5>
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
												<!-- <th>신고</th> -->
												<th>프로필 확인</th>

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


	<div class="modal" id="testModal" tabindex="-1" role="dialog">

		<div class="modal-dialog modal-lg" >

			<div class="modal-content" style="width:1000px; float:right;">


				<div class="modal-body" ></div>
					
					
                    <div class="col-12 d-flex no-block align-items-center">
                        <h4 class="page-title">회원관리</h4>
                    </div>
                    
                    <div class="container-fluid">

				<div class="row">
					<div class="col-md-6"  style="background:gray;">
						<div class="card" style="background:gray;">
							<div class="card-body">
								<h4 class="card-title m-b-0">
								<br />
									신고 리스트
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									
								</h4>

							</div>
							<div id="tt" class="comment-widgets scrollable">
								<c:forEach items="${list}" var="n">
								<form id="${n.nno }">
									<div class="d-flex flex-row comment-row m-t-0" id="${n.nno }">
										<div class="comment-text w-100">
											<h6 class="font-medium">제목 : ${n.nTitle }</h6>
											<span class="m-b-15 d-block">작성자 : ${n.adminId }</span>
											<div class="comment-footer">
												<span class="text-muted float-right">${n.nDate }</span>
											</div>
										</div>
									</div>
									</form>
								</c:forEach>
							</div>
						</div>
					</div>
					</div>
					
</div>
				<div class="modal-footer">

					<button type="button" class="btn" data-dismiss="modal">닫기</button>

				</div>



			</div>

		</div>

	</div>



	<script>
		/****************************************
		 *       Basic Table                   *
		 ****************************************/
		$('#zero_config').DataTable();
	</script>



	<script>
		function DisableMem(mNo, mLevel) {

			location.href = "${pageContext.request.contextPath}/memberManagement/mmDisable.do?mNo="
					+ mNo;

		}

		function DeleteMem(mNo, mLevel) {

			location.href = "${pageContext.request.contextPath}/memberManagement/mmDelete.do?mNo="
					+ mNo;

		}

		$("#zero_config td").click(function() {

			var mno = $(this).parent().children().eq(0).text();

			$("#testModal").modal();
			
			

		});
	</script>

</body>

</html>