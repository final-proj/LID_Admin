<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<div class="page-wrapper" style="margin-left: 0px;">
	<div class="page-breadcrumb">
		<div class="row">
			<div class="col-12 d-flex no-block align-items-center">
				<h4 class="page-title">회원명( ${member.mName} )</h4>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6">
				<div class="card">
					<div class="card-body" id="ff" style="height: 573px">
						<h4 class="card-title">Personal Info</h4>
						<div class="form-group row">
							<label for="fname"
								class="col-sm-3 text-right control-label col-form-label">이메일</label>
							<div class="col-sm-9">
								<label for="cono1"
									class="col-sm-15 text-right control-label col-form-label"">${ member.mEmail }</label>
							</div>
						</div>
						<div class="form-group row">
							<label for="lname"
								class="col-sm-3 text-right control-label col-form-label">이름</label>
							<div class="col-sm-9">
								<label for="cono1"
									class="col-sm-15 text-right control-label col-form-label">${ member.mName }</label>
							</div>
						</div>
						<div class="form-group row">
							<label for="lname"
								class="col-sm-3 text-right control-label col-form-label">닉네임</label>
							<div class="col-sm-9">
								<label for="cono1"
									class="col-sm-15 text-right control-label col-form-label">${ mp.mpNickname }</label>
							</div>
						</div>
						<div class="form-group row">
							<label for="email1"
								class="col-sm-3 text-right control-label col-form-label">나이</label>
							<div class="col-sm-9">
								<label for="cono1"
									class="col-sm-15 text-right control-label col-form-label">${ mp.mpAge }</label>
							</div>
						</div>
						<div class="form-group row">
							<label for="cono1"
								class="col-sm-3 text-right control-label col-form-label">성별
							</label>
							<div class="col-sm-9">
								<label for="cono1"
									class="col-sm-15 text-right control-label col-form-label">${ mp.mpGender }</label>
							</div>
						</div>
						<div class="form-group row">
							<label for="cono1"
								class="col-sm-3 text-right control-label col-form-label">전화번호</label>
							<div class="col-sm-9">
								<label for="cono1"
									class="col-sm-15 text-right control-label col-form-label">${ member.mPhone }</label>
							</div>
						</div>
						<div class="form-group row">
							<label for="cono1"
								class="col-sm-3 text-right control-label col-form-label">주소</label>
							<div class="col-sm-9">
								<label for="cono1"
									class="col-sm-15 text-right control-label col-form-label">${ mp.mpAddress }</label>
							</div>
						</div>
						<div class="form-group row">
							<label for="cono1"
								class="col-sm-3 text-right control-label col-form-label">회원상태</label>
							<div class="col-sm-9">
								<label for="cono1"
									class="col-sm-15 text-right control-label col-form-label">${ member.mLevel }</label>
							</div>
						</div>
						<div class="form-group row">
							<label for="cono1"
								class="col-sm-3 text-right control-label col-form-label">가입일</label>
							<div class="col-sm-9">
								<label for="cono1"
									class="col-sm-15 text-right control-label col-form-label">${ member.mDate }</label>
							</div>
						</div>
						<div>
							<div class="form-group row">
								<label for="cono1"
									class="col-sm-3 text-right control-label col-form-label">회원상태</label>
								<div class="col-sm-9">
									<select name="" id="" style="margin-top: 4px;">
										<option value="1">1일정지</option>
										<option value="15">15일정지</option>
										<option value="30">30일정지</option>
										<option value="10000">영구정지</option>
									</select>
									<button class="btn btn-outline-danger btn-sm"
										style="margin-bottom: 4px; margin-left: 5px;">정지하기</button>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title m-b-0">
							신고 목록 <br />
						</h4>
					</div>
					<div id="tt" class="comment-widgets scrollable ps-container ps-theme-default ps-active-y" style="height: 501.5px;">
						<c:forEach items="${list}" var="r">
							<form id="${r.rNo}">
								<button type="button" class="btn btn-outline-info col-md-11"
									data-toggle="popover" title="신고 내용"
									data-content="${r.rContent }" style="margin: 6px 5px 5px 14px;">
									
										    <span class="m-b-15 d-block">신고자 : ${r.rReporterName}</span>
													<div class="comment-footer">
													<span class="text-muted float-right"> ${r.rDate}</span>
												</div>
									</button>
									

							</form>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div class="card">
			<div class="card-body">
				<h5 class="card-title" style="margin-left: 10px;">결제 내역</h5>
				<div class="table-responsive scrollable ps-container ps-theme-default ps-active-y"  style="height : 310px;">
					<table id="poyment" class="table table-striped table-bordered"
						style="text-align: center; font-size: 13px;">
						<thead>
							<tr>
								<th>결제번호</th>
								<th>정기권 종류</th>
								<th>구매일</th>
								<th>만료일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${payment}" var="p">
								<tr id="${p.pNo}">
									<td>${p.pNo}</td>
									<td>${p.pTicket}</td>
									<td>${p.pDate}</td>
									<td>${p.poDate}</td>
								</tr>
							</c:forEach>
					</table>

				</div>
			</div>
		</div>
	</div>
	<script>
		function mmDisable(){
		
			var date = $("#selectReport").val();

			var mNo = '${member.mNo}';
			
			
			location.href="<%=request.getContextPath()%>
		/memberManagement/mmDisable.do?mNo="
					+ mNo + "&date=" + date;

		}
	</script>