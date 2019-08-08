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
#btn1{
	position: relative;
	left: 85%;
}
#ff{
	margin-right: 15%;
}
#test2{
	position: absolute;
	left: 92%;
}
#test3{
	position: relative;
	right: 29%;
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
					url : "${pageContext.request.contextPath}/faq/faqView.do",
					data : {fno : fno},
					type : "POST",
					dataType : "json",
					success : function(data){
						if(data.fCategory == 1) {
							$('#category1').prop('selected',true);
						}
						if(data.fCategory == 2) {
							$('#category2').prop('selected',true);
						}
						if(data.fCategory == 3) {
							$('#category3').prop('selected',true);
						}
						$('#title').val(data.fTitle);
						$('.ql-toolbar').remove();
						$('#editor').remove();
						$('#editor2').remove();
						$('#removeEditor').append("<div id='editor' style='height: 332px;'></div>");
						$('#removeEditor2').append("<div id='editor2' style='height: 300px;'></div>");
						$('#editor').html(data.fContent);
						new Quill('#editor', {
					  		theme: 'snow'
					    });
						
						new Quill('#editor2', {
					  		theme: 'snow'
					    });
						$('#fno').val(fno);
					},
					error : function(error){
						console.log(error);
					}
				})
			});
		});
	});
	
	function fn_filter(){
				var fCategory = $('#filter').val();
				location.href="${pageContext.request.contextPath}/faq/faqList.do?fCategory="+fCategory;
				/* $.ajax({
					url : "${pageContext.request.contextPath}/faq/faqList.do",
					data : {fCategory : fCategory},
					type : "POST",
					dataType : "json",
					success : function(data){
						$('#deleteDiv').remove();
						var str = "";
						$each(data,function(i,v){
							str += "<div id='deleteDiv'>";
							str += "<form id=" + v.fno + ">";
							str += "<div class='d-flex flex-row comment-row m-t-0' id=" + v.fno + ">";
							str += "<div class='comment-text w-100'>";
							str += "<h6 class='font-medium'>제목 :" + v.fTitle + "</h6>";
							str += "</div>";
							str += "<div class='comment-footer'>";
							str += "<span class='text-muted float-right'>";
							str += "<c:if test='"+v.fCategory +"eq 1'>환불문의</c:if>";
							str += "<c:if test='"+v.fCategory +"eq 2'>결제문의</c:if>";
							str += "<c:if test='"+v.fCategory +"eq 3'>이용문의</c:if>";
							str += "</span></div></div></div>";
						}) 
						$('#tt').append(str);
					},
					error : function(error){
						console.log(error);
					}
				}) */
	}
				
	function fn_delete(){
		var fno = $('#fno').val();
		console.log(fno);
		location.href="${pageContext.request.contextPath}/faq/faqDelete.do?fno="+fno;
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
						<h4 class="page-title">FAQ</h4>
						<div class="ml-auto text-right">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="#">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">FAQ</li>
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
									<div class="btn-group" id="btn1">
										<select class="btn btn-outline-info dropdown-toggle btn-sm"
												data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" id="filter" onchange="fn_filter()">
												
											<option id="searchC" class="dropdown-item">ALL</option>
											<option id="searchC" class="dropdown-item" value="1">결제 문의</option>
											<option id="searchC" class="dropdown-item" value="2">환불 문의</option> 
											<option id="searchC" class="dropdown-item" value="3">이용 문의</option>
										</select>
									</div>
									
								</h4>

							</div>
							<div id="tt" class="comment-widgets scrollable">
							<div id="deleteDiv">
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
							</div>
							<c:out value="${pageBar}" escapeXml="false" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="card">
							<form class="form-horizontal" id="update"
								action="${pageContext.request.contextPath}/faq/faqUpdate.do" method="post">
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
												<select style="width: 300%;"
													class="btn btn-outline-info dropdown-toggle"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false" name="fCategory" id="category">
													<option id="category1" class="dropdown-item" value="1">결제 문의</option>
													<option id="category2" class="dropdown-item" value="2">환불 문의</option> 
													<option id="category3" class="dropdown-item" value="3">이용 문의</option>
												</select>
											</div>
										</div>
									</div>
									<div class="form-group row">
										<label for="cono1"
											class="col-sm-3 text-right control-label col-form-label">Contents</label>
										<div class="col-sm-9" id="removeEditor">
											<div id="editor" style="height: 332px;"></div>
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
                                <form id="insert" action="${pageContext.request.contextPath}/faq/faqInsert.do" method="post">
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
                                	<div id="removeEditor2">
                                		<div id="editor2" style="height: 300px;"></div>
										<textarea name="fContent" style="display:none" id="hiddenArea2"></textarea>
									</div>
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