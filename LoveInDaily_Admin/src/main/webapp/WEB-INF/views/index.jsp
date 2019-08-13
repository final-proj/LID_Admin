<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<c:import url="common/header.jsp"/>
<style>

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
#selectBoard{
	margin: 10px;
}
</style>
</head>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script>
$(function(){
	$.ajax({
	    url: '${pageContext.request.contextPath}/chart/salesThdData.do',
	    type: 'post',
	    async: false,
	    success: function(list3) {
	    	google.charts.load('current', {packages: ['corechart', 'line']});
	    	google.charts.setOnLoadCallback(drawBasic);

	    	function drawBasic() {

	    	      var data = new google.visualization.DataTable();
	    	      data.addColumn('number', 'X');
	    	      data.addColumn('number', '월별 매출');
	    	      data.addColumn('number', '총 매출');
	    	      if(list3.length != 0) {
	                  $.each(list3, function(i, item3){
	                      data.addRow([item3.month, item3.amount, item3.total]);
	                  });
	              }

	    	      var options = {
	    	        hAxis: {
	    	          title: '월'
	    	        },
	    	        vAxis: {
	    	          title: '매출액(원)'
	    	        },
	    	        height: 450,
	    	      };

	    	      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

	    	      chart.draw(data, options);
	    	    }
	    }
	});
});
function selectB(){
	var select = $('#selectBoard').val();
	console.log(select)
	if(select == 1) {
		$('#test4').remove();
		
	} else {
		var str = "";
		str += "<div class='btn-group' id='test4'>";
		str += "<select style='width: 200px;' class='btn btn-light' name='fCategory' id='category'>";
		str += "<option value='1'>결제 문의</option>";
		str += "<option value='2'>환불 문의</option>";
		str += "<option value='3'>이용 문의</option>";
		str += "</select> </div>";
		$('#selectDiv').append(str);
	}
}
function selectC(){
	var select = $('#selectChart').val();
	console.log(select);
	if(select == 1) {
		$.ajax({
		    url: '${pageContext.request.contextPath}/chart/salesThdData.do',
		    type: 'post',
		    async: false,
		    success: function(list3) {
		    	google.charts.load('current', {packages: ['corechart', 'line']});
		    	google.charts.setOnLoadCallback(drawBasic);

		    	function drawBasic() {

		    	      var data = new google.visualization.DataTable();
		    	      data.addColumn('number', 'X');
		    	      data.addColumn('number', '월별 매출');
		    	      data.addColumn('number', '총 매출');
		    	      if(list3.length != 0) {
		                  $.each(list3, function(i, item3){
		                      data.addRow([item3.month, item3.amount, item3.total]);
		                  });
		              }

		    	      var options = {
		    	        hAxis: {
		    	          title: '월'
		    	        },
		    	        vAxis: {
		    	          title: '매출액(원)'
		    	        },
		    	        height: 450,
		    	      };

		    	      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

		    	      chart.draw(data, options);
		    	    }
		    }
		});
	} else {
		$.ajax({
		    url: '${pageContext.request.contextPath}/chart/genderChart.do',
		    type: 'post',
		    type: 'post',
		    async: false,
		    success: function(list2) {
		    	google.charts.load('current', {packages: ['corechart', 'line']});
		    	google.charts.setOnLoadCallback(drawBasic);

		    	function drawBasic() {

		    	      var data = new google.visualization.DataTable();
		    	      data.addColumn('number', 'X');
		    	      data.addColumn('number', '월 가입 회원(남)');
		    	      data.addColumn('number', '월 가입 회원(녀)');
		    	      data.addColumn('number', '총 회원');
		    	      if(list2.length != 0) {
		                  $.each(list2, function(i, item2){
		                      data.addRow([item2.element, item2.amount, item2.month, item2.total]);
		                  });
		              }

		    	      var options = {
		    	        hAxis: {
		    	          title: '월'
		    	        },
		    	        vAxis: {
		    	          title: '회원수(명)'
		    	        },
		    	        height: 450,
		    	      };

		    	      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

		    	      chart.draw(data, options);
		    	    }
		    }
		});
	}
	
}
</script>
<body>
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <div id="main-wrapper">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <c:import url="common/menubar.jsp"/>
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <c:import url="common/sidebar.jsp"/>
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
                        <h4 class="page-title">Dashboard</h4>
                        <div class="ml-auto text-right">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
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
                <!-- Sales Cards  -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Sales chart -->
                <!-- ============================================================== -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">
									<select class="btn btn-light" id="selectChart" onchange="selectC()">
                                		<option value="1">총 매출액</option>
                                		<option value="2">총 회원수</option>
                                	</select>
								</h5>
									<div id="chart_div"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- Sales chart -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Recent comment and chats -->
                <!-- ============================================================== -->
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <form id="insert" action="${pageContext.request.contextPath}/faq/insert.do" method="post">
                                <h4 class="card-title">
                                	
                                	<select class="btn btn-light" id="selectBoard" name="selectBoard" onchange="selectB()">
                                		<option value="1">공지사항</option>
                                		<option value="2">FAQ</option>
                                	</select>
                                </h4>
                                	<button type="submit" class="btn btn-success" id="test2">등록</button>
                                	<input type="hidden" name="writer" value="admin" required>
                                	<div id="selectDiv">
	                                	
                                	</div>
                                <!-- Create the editor container -->
                                <div class="row mb-3 align-items-center" id="test3">
                                    <div class="col-lg-4 col-md-12 text-right">
                                        <span>제목</span>
                                    </div>
                                    <div class="col-lg-8 col-md-12">
                                        <input type="text" data-toggle="tooltip" title="A Tooltip for the input !" class="form-control" id="validationDefault05" placeholder="Hover For tooltip" name="title" required>
                                    </div>
                                </div>
                                	<div>
                                		<div id="editor" style="height: 300px;"></div>
										<textarea name="content" style="display:none" id="hiddenArea"></textarea>
									</div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>                    
                <!-- ============================================================== -->
                <!-- Recent comment and chats -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
            <c:import url="common/footer.jsp"/>
            <!-- ============================================================== -->
            <!-- End footer -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
    </div>
  <script>
  var quill2 = new Quill('#editor', {
      theme: 'snow'
  });
  $('#insert').on('submit',function(e){
		$("#hiddenArea").text($("#editor").html());
	});
  </script>

</body>

</html>