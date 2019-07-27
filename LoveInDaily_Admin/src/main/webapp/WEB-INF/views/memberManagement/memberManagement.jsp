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
												<th></th>

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
														<button class="btn btn-warning btn-sm" id="${m.mNo}"
															onclick="DisableMem('${m.mNo}', '${m.mLevel}');">
															<c:choose>
																<c:when test="${m.mLevel eq '정지'}">
														 			해제
														 		</c:when>
														 		<c:otherwise>
														 			정지
														 		</c:otherwise>
															</c:choose>
															
															
															</button>
															<%-- <button class="btn btn-warning btn-sm" id="${m.mNo}"
															onclick="DisableMem('${m.mNo}');">
															</button> --%>
														<button class="btn btn-danger btn-sm" id="${m.mNo}"
															onclick="DeleteMem('${m.mNo}');">삭제</button>
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
	<script>
		/****************************************
		 *       Basic Table                   *
		 ****************************************/
		$('#zero_config').DataTable();
	</script>

	<script>
		function DisableMem(mNo, mLevel) {
			
			if(mLevel == '정지')	location.href = "${pageContext.request.contextPath}/memberManagement/mmAble.do?mNo=" + mNo;
			else location.href = "${pageContext.request.contextPath}/memberManagement/mmDisable.do?mNo=" + mNo;
			
		}

		function DeleteMem(mNo, mLevel) {
			
			location.href = "${pageContext.request.contextPath}/memberManagement/mmDelete.do?mNo=" + mNo;

		}
	</script>

</body>

</html>