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
		<c:import url="../common/menubar.jsp" />
		<c:import url="../common/sidebar.jsp" />

		<div class="page-wrapper">
		<div class="page-breadcrumb">
                <div class="row">
                    <div class="col-12 d-flex no-block align-items-center">
                        <h4 class="page-title">FNQ</h4>
                        <div class="ml-auto text-right">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">FNQ</li>
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
									View
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<div class="btn-group">
                                        <button type="button" class="btn btn-outline-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">ALL</button>
                                        <div class="dropdown-menu">
                                            <a class="dropdown-item" href="#">결제 문의</a>
                                            <a class="dropdown-item" href="#">환불 문의</a>
                                            <a class="dropdown-item" href="#">이용 문의</a>
                                        </div>
                                    </div><!-- /btn-group -->
								</h4>

							</div>
							<div id="tt" class="comment-widgets scrollable">
								<c:forEach items="${list }" var="f">
								<form id="${f.fno }">
									<div class="d-flex flex-row comment-row m-t-0" id="${f.fno }">
										<div class="comment-text w-100">
											<h6 class="font-medium">제목 : ${f.fTitle }</h6>
											<span class="m-b-15 d-block">작성자 : ${f.fWriter }</span>
											<div class="comment-footer">
												<span class="text-muted float-right">${f.fDate }</span>
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
                                            <input type="text" class="form-control" id="writer" readonly="readonly">
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
                                   <div id="editor" style="height: 307px;">
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
	
	<c:import url="../common/footer.jsp" />
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