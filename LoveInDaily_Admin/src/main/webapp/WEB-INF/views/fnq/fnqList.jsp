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
#test4{
	position: absolute;
	left:73%;
}
</style>
<script>
	$(function() {
		$("form[id]").each(function(){
			$(this).on("click",function(){
				var fno = $(this).attr("id");
				console.log("fno : " + fno);
				
				$.ajax({
					url : "${pageContext.request.contextPath}/fnq/fnqView.do",
					data : {fno : fno},
					type : "POST",
					dataType : "json",
					success : function(data){
						console.log(data.fTitle);
						console.log(data.fCategory);
						if(data.fCategory == 1) {
							$('#category').val("결제 문의");
						}
						if(data.fCategory == 2) {
							$('#category').val("환불 문의");
						}
						if(data.fCategory == 3) {
							$('#category').val("이용 문의");
						}
						$('#title').val(data.fTitle);
						$('#editor').html(data.fContent);
						$('#fno').val(fno);
					},
					error : function(error){
						console.log(error);
					}
				})
			});
		});
	});

	function fn_delete(){
		var fno = $('#fno').val();
		console.log(fno);
		location.href="${pageContext.request.contextPath}/fnq/fnqDelete.do?fno="+fno;
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
									<br /> View
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<!-- /btn-group -->
									
									<div class="btn-group">
										<select class="btn btn-outline-info dropdown-toggle btn-sm"
												data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
												
											<option class="dropdown-item" value="0">ALL</option>
											<option class="dropdown-item" value="1">결제 문의</option>
											<option class="dropdown-item" value="2">환불 문의</option> 
											<option class="dropdown-item" value="3">이용 문의</option>
										</select>
									</div>
								</h4>

							</div>
							<div id="tt" class="comment-widgets scrollable">
								<c:forEach items="${list }" var="f">
									<form id="${f.fno }">
										<div class="d-flex flex-row comment-row m-t-0" id="${f.fno }">
											<div class="comment-text w-100">
												<h6 class="font-medium">제목 : ${f.fTitle }</h6>
											</div>
											<div class="comment-footer">
												<span class="text-muted float-right">
												<c:if test="${f.fCategory eq 1 }">
												결제문의
												</c:if>
												<c:if test="${f.fCategory eq 2 }">
												환불문의
												</c:if>
												<c:if test="${f.fCategory eq 3 }">
												이용문의
												</c:if>
												</span>
											</div>
										</div>
									</form>
								</c:forEach>
							</div>
							<c:out value="${pageBar}" escapeXml="false" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="card">
							<form class="form-horizontal" id="update"
								action="${pageContext.request.contextPath}/fnq/fnqUpdate.do" method="post">
								<div class="card-body" id="ff">
									<h4 class="card-title"></h4>
									<input id="fno" type="hidden" name="fno">
									
									<div class="form-group row">
										<label for="fname"
											class="col-sm-3 text-right control-label col-form-label">Title</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="title"
												name="fTitle">
										</div>
									</div>
									<div class="form-group row">
										<label for="fname"
											class="col-sm-3 text-right control-label col-form-label">Category</label>
										<div class="col-sm-9">
											<div class="btn-group">
												<select style="width: 350px;"
													class="btn btn-outline-info dropdown-toggle"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false" name="fCategory" id="category">
													<option class="dropdown-item" value="1">결제 문의</option>
													<option class="dropdown-item" value="2">환불 문의</option> 
													<option class="dropdown-item" value="3">이용 문의</option>
												</select>
											</div>
										</div>
									</div>
									<div class="form-group row">
										<label for="cono1"
											class="col-sm-3 text-right control-label col-form-label">Contents</label>
										<div class="col-sm-9">
											<div id="editor" style="height: 307px;"></div>
											<textarea name="fContent" style="display: none"
												id="hiddenArea"></textarea>
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
				<div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <form id="insert" action="${pageContext.request.contextPath}/fnq/fnqInsert.do" method="post">
                                <h4 class="card-title">
                                	Insert FNQ
                                </h4>
                                	<button type="submit" class="btn btn-success" id="test2">Submit</button>
                                <div class="btn-group" id="test4">
									<select style="width: 200px;"
											class="btn btn-outline-info dropdown-toggle"
											data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false" name="fCategory" id="category">
										<option class="dropdown-item" value="1">결제 문의</option>
										<option class="dropdown-item" value="2">환불 문의</option> 
										<option class="dropdown-item" value="3">이용 문의</option>
									</select>
								</div>
                                <!-- Create the editor container -->
                                <div class="row mb-3 align-items-center" id="test3">
                                    <div class="col-lg-4 col-md-12 text-right">
                                        <span>Title</span>
                                    </div>
                                    <div class="col-lg-8 col-md-12">
                                        <input type="text" data-toggle="tooltip" title="A Tooltip for the input !" class="form-control" id="validationDefault05" placeholder="Hover For tooltip" name="fTitle" required>
                                    </div>
                                </div>
                                <div id="editor2" style="height: 300px;">
                                </div>
									<textarea name="fContent" style="display:none" id="hiddenArea2"></textarea>
                                </form>
                            </div>
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