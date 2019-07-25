<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css"	rel="stylesheet">
<script	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
	<form action="${pageContext.request.contextPath }/notice/noticeInsert.do" method="post">
	<input type="hidden" value="작성자" name="adminId"> <br />
	<input type="text" name="nName">
	<input type="text" name="nContent">

	<div id="test" style="margin-left: 20px; margin-top: 100px;">
		<textarea id="summernote" name="nContent"></textarea>
	</div>
	<input type="submit" value="submit" class="btn btn-primary">
	</form>

	<script>
		$(document).ready(function() {
			$('#summernote').summernote();
		});

		var $note = $("#summernote");

		$('#summernote').summernote(
				{
					width : 900,
					height : 700, //set editor height
					minHeight : null, // set minimum height of editor
					maxHeight : null, // set maximum height of editor
					focus : true,
					callbacks : {
						onImageUpload : function(files, editor, welEditorble) {
							console.log(files);
							console.log(files[0]);
							data = new FormData();
							data.append("file", files[0]);

							$.ajax({
								data : data,
								type : "post",
								url : '/lida/Image.do', // servlet url
								cache : false,
								contentType : false,
								processData : false,
								success : function(url) {
									//alert(url);
									console.log($note);
									$note.summernote('insertImage', url);
								},
								error : function(request, status, error) {
									alert("code:" + request.status + "\n"
											+ "message:" + request.responseText
											+ "\n" + "error:" + error);
								}
							});
						}
					}

				});
	</script>
</body>
</html>