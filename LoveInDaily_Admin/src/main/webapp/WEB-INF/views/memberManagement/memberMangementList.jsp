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
    <script src="${pageContext.request.contextPath }/resources/js/jquery-3.4.1.min.js"></script>
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath }/resources/assets/images/favicon.png">
    <title>Love In Daily</title>
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/assets/libs/quill/dist/quill.snow.css">
    <link href="${pageContext.request.contextPath }/resources/dist/css/style.min.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
 
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
</style>
<script>
	$(function() {
		$("form[id]").each(function(){
			$(this).on("click",function(){
				var nno = $(this).attr("id");
				console.log("nno : " + nno);
				
				$.ajax({
					url : "${pageContext.request.contextPath}/notice/noticeView.do",
					data : {nno : nno},
					type : "POST",
					dataType : "json",
					success : function(data){
						console.log(data.nTitle);
						$('#writer').val(data.adminId);
						$('#title').val(data.nTitle);
						$('#editor').html(data.nContent);
						$('#nno').val(nno);
					},
					error : function(error){
						console.log(error);
					}
				})
			});
		});
	});
	function fn_delete(){
		var nno = $('#nno').val();
		console.log(nno);
		location.href="${pageContext.request.contextPath}/notice/noticeDelete.do?nno="+nno;
	}
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
		<div class="page-wrapper">
		<div class="page-breadcrumb">
                <div class="row">
                    <div class="col-12 d-flex no-block align-items-center">
                        <h4 class="page-title">회원관리</h4>
                        <div class="ml-auto text-right">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="main.do">Home</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">Notice</li>
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
                                        <label for="fname" class="col-sm-3 text-right control-label col-form-label">Title</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="title" name="nTitle">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="cono1" class="col-sm-3 text-right control-label col-form-label">Contents</label>
                                        <div class="col-sm-9" >
                                   <div id="editor" style="height: 262px;">
                                	</div>
									<textarea name="nContent" style="display:none" id="hiddenArea"></textarea>

                                        </div>
                                    </div>
                                </div>
                                <div class="border-top">
                                    <div class="card-body" id="btn">
                                        <button type="submit" class="btn btn-primary">Update</button>
                                        <button type="button" class="btn btn-danger" onclick="fn_delete();">Delete</button>
                                    </div>
                                </div>
                            </form>
                        </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
	var quill2 = new Quill('#editor2', {
        theme: 'snow'
    });
	var quill = new Quill('#editor', {
        theme: 'snow'
    });
	$('#insert').on('submit',function(e){
		$("#hiddenArea2").text($("#editor2").html());
	})
	$('#update').on('submit',function(e){
		$("#hiddenArea").text($("#editor").html());
	})
	</script>
</body>
</html>