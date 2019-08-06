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
<style type="text/css">
#btn{
	margin-left: 69%;
}
#ff{
	margin-right: 15%;
}
#test3{
	position: relative;
	right: 29%;
}
#test2{
	position: absolute;
	left: 92%;
}
#btnReport {
	margin-left : 35%;
}
.border-top {
	width : 100%;
	height: 70px;
}

#selectReport {
	margin: 15% 10%;
}

/* select css */
.btn-outline-info {
	color: #000;
	background-color: transparent;
	background-image: none;
	border-color: #eee;
	width : 150px;
}

.btn-outline-info:hover {
	color: #000;
	background-color: #eee;
	border-color: #ccc;
}
</style>
<script>
	$(function() {
		$("form[id]").each(function(){
			$(this).on("click",function(){
				var rno = $(this).attr("id");
				console.log("rno : " + rno);
				
				$.ajax({
					url : "${pageContext.request.contextPath}/memberManagement/reportView.do",
					data : {rno : rno},
					type : "POST",
					dataType : "json",
					success : function(data){
						$('#writer').val(data.rReporterName);
						$('#to').val(data.rMemberName);
						$('#contents').html(data.rContent);
					},
					error : function(error){
						console.log(error);
					}
				})
			});
		});
	});



</script>
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
		<div class="page-breadcrumb">
                <div class="row">
                    <div class="col-12 d-flex no-block align-items-center">
                        <h4 class="page-title">회원 관리</h4>
                        <div class="ml-auto text-right">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">회원관리</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
			<div class="container-fluid">

				<div class="row">
					<div class="col-md-6">
						<div class="card">
							<div class="card-body">
								<h4 class="card-title m-b-0">
								<br />
									신고 목록
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
								<c:forEach items="${list}" var="r">
								<form id="${r.rNo}">
									<div class="d-flex flex-row comment-row m-t-0" id="${r.rNo}">
									<div class="p-2">
										<img src="${pageContext.request.contextPath }/resources/assets/images/users/1.jpg" alt="user" width="50" class="rounded-circle">
									</div>
										<div class="comment-text w-100">
											<span class="m-b-15 d-block">작성자 : ${r.rReporterName}</span>
											
											<div class="comment-footer" >
												<span class="text-muted float-right">${r.rDate}</span>
											</div>
										</div>
									</div>
									</form>
								</c:forEach>
							</div>
                <c:out value="${pageBar}" escapeXml="false"/>
						</div>
					</div>
					<div class="col-md-6">
					<div class="card">
                            <form class="form-horizontal" id="update" action="${pageContext.request.contextPath}/notice/noticeUpdate.do" method="post">
                                <div class="card-body" id="ff">
                                    <h4 class="card-title"></h4>
                                    <input id="nno" type="hidden" name="nno">
                                    <div class="form-group row">
                                        <label for="lname" class="col-sm-3 text-right control-label col-form-label" >Writer</label>
                                        <div class="col-sm-9" >
                                            <input type="text" class="form-control" id="writer" readonly="readonly" placeholder="Please Select Content">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="fname" class="col-sm-3 text-right control-label col-form-label">To</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="to" name="to" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="cono1" class="col-sm-3 text-right control-label col-form-label">Contents</label>
                                        <div class="col-sm-9" >
                                   <div id="contents" style="height: 305.6px; border : 1px solid #e9ecef;">
                                	</div>
									<textarea name="nContent" style="display:none" id="hiddenArea"></textarea>

                                        </div>
                                    </div>
                                </div>
                                <div class="border-top">
                                    <div class="btn-group">
												<select 
													class="btn btn-outline-info dropdown-toggle" id="selectReport"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false" name="fCategory" id="category">
													<option id="category1" class="dropdown-item" value="1">1일 정지</option>
													<option id="category2" class="dropdown-item" value="2">7일 정지</option> 
													<option id="category3" class="dropdown-item" value="3">15일 정지</option>
													<option id="category3" class="dropdown-item" value="4">30일 정지</option>
												</select>
											</div> 
											
											<button type="submit" class="btn btn-success" id="btnReport">회원 정지 시키기</button>
                                </div>
                            </form>
                        </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<c:import url="../common/footer.jsp" />
	<script>
// 	var quill2 = new Quill('#editor2', {
//         theme: 'snow'
//     });
// 	var quill = new Quill('#editor', {
//         theme: 'snow'
//     });
	</script>
</body>
</html>