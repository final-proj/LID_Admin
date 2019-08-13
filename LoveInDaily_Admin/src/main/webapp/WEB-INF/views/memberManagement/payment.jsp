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
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script>
	$(document).ready(function(){
		$.ajax({
		    url: '${pageContext.request.contextPath}/chart/salesData.do',
		    type: 'post',
		    async: false,
		    success: function(list) {
		        google.charts.load('current', {'packages':['corechart']});
		        google.charts.setOnLoadCallback(drawChart);
		        function drawChart() {
		            var dataChart = [['정기권 이름', '구매 횟수']];
		            if(list.length != 0) {
		                $.each(list, function(i, item){
		                    dataChart.push([item.item, item.amount]);
		                });
		                for(var i = 1; i < list[0].month + 1; i++){
		                	$('#month').append("<option value='" + i + "' id='month" + i + "'>" + i + "월 </option>");
		                	if(i == list[0].month) {
		                		$('#month' + i).prop('selected',true);
		                	}
		                }
		            }
		            var data2 = google.visualization.arrayToDataTable(dataChart);
		            var view = new google.visualization.DataView(data2);
		            var options2 = {
		            	width: 542, 
		            	height: 450,
		            };
		            var chart = new google.visualization.PieChart(document.getElementById('piechart'));
		            chart.draw(view, options2);
		        }
		    }
		});
		 $.ajax({
		    url: '${pageContext.request.contextPath}/chart/salesScdData.do',
		    type: 'post',
		    async: false,
		    success: function(list2) {
		        google.charts.load('current', {'packages':['corechart']});
		        google.charts.setOnLoadCallback(drawChart2);
		        function drawChart2() {
		            var dataChart2 = [['구매 비율', '연령']];
		            if(list2.length != 0) {
		                $.each(list2, function(i, item2){
		                    dataChart2.push([item2.item, item2.amount]);
		                });
		                for(var i = 1; i < list2[0].month + 1; i++){
		                	$('#monthScd').append("<option value='" + i + "' id='monthScd" + i + "'>" + i + "월 </option>");
		                	if(i == list2[0].month) {
		                		$('#monthScd' + i).prop('selected',true);
		                	}
		                }
		            }
		            var data2 = google.visualization.arrayToDataTable(dataChart2);
		            var view2 = new google.visualization.DataView(data2);
		            var options2 = {
		            	width: 542, 
		            	height: 450,
		            };
		            var chart = new google.visualization.PieChart(document.getElementById('piechart2'));
		            chart.draw(view2, options2);
		        }
		    }
		});
});
	function changeLangSelect(){
		var element = $('#month').val();
		$.ajax({
			url: '${pageContext.request.contextPath}/chart/salesMonthData.do',
			data: {element : element},
			type : "POST",
			dataType : "json",
			success: function(list){
				 google.charts.load('current', {'packages':['corechart']});
			     google.charts.setOnLoadCallback(drawChart);
			     function drawChart() {
			          var dataChart = [['정기권 이름', '구매 횟수']];
			          if(list.length != 0) {
			              $.each(list, function(i, item){
			                  dataChart.push([item.item, item.amount]);
			              });
			          }
		           var data2 = google.visualization.arrayToDataTable(dataChart);
		           var view = new google.visualization.DataView(data2);
		           var options2 = {
			           	width: 542, 
			           	height: 450,
			           };
			           var chart = new google.visualization.PieChart(document.getElementById('piechart'));
			           chart.draw(view, options2);
		        }
			}
		});
	}
	function changeLangSelect2(){
		var category = $('#selectCa').val();
		var element = $('#monthScd').val();
		$.ajax({
			url: '${pageContext.request.contextPath}/chart/salesMonthCaData.do',
			data: {category:category, element : element},
			type : "POST",
			dataType : "json",
			success: function(list2){
				 google.charts.load('current', {'packages':['corechart']});
			     google.charts.setOnLoadCallback(drawChart2);
			     function drawChart2() {
		          var dataChart2 = [['구매 비율', '연령']];
		          if(list2.length != 0) {
		                $.each(list2, function(i, item2){
		                dataChart2.push([item2.item, item2.amount]);
			              });
			         }
			          var data2 = google.visualization.arrayToDataTable(dataChart2);
			          var view2 = new google.visualization.DataView(data2);
			          var options2 = {
			          	width: 542, 
		            	height: 450,
		            };
		            var chart = new google.visualization.PieChart(document.getElementById('piechart2'));
			        chart.draw(view2, options2);
				}
			}
		});
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
			<!-- ============================================================== -->
			<!-- Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<div class="page-breadcrumb">
				<div class="row">
					<div class="col-12 d-flex no-block align-items-center">
						<h4 class="page-title">Payment</h4>
						<div class="ml-auto text-right">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="#">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">Payment</li>
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
								<h5 class="card-title" style="margin-left: 10px;">결제 리스트</h5>
								<div class="table-responsive">


									<table id="zero_config"
										class="table table-striped table-bordered"
										style="text-align: center; font-size: 13px;">
										<thead>
											<tr>
												<th>결제 번호</th>
												<th>회원 이름</th>
												<th>정기권 종류</th>
												<th>결제일</th>
												<th>만료일</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach items="${paymentList}" var="p">
												<tr id="${p.pNo}">
													<td>${p.pNo}</td>
													<td>${p.pName}</td>
													<td>${p.pTicket}</td>
													<td>${p.pDate}</td>
													<td>${p.pODate}</td>
												</tr>
											</c:forEach>
									</table>

								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="card">
							<div class="card-body">
							<h5 class="card-title">정기권 구매 비율
							 <select class="btn btn-light" id="month" onchange="changeLangSelect()">
							</select>
							</h5>
								<div id="piechart"></div>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="card">
							<div class="card-body">
							<h5 class="card-title">
								<select class="btn btn-light" id="selectCa" onchange="changeLangSelect2()">
									<option value="age">연령대별 결제 비율</option>
									<option value="gender">성별 결제 비율</option>
								</select>
								<select class="btn btn-light" id="monthScd" onchange="changeLangSelect2()">
							</select>
							</h5>
								<div id="piechart2"></div>
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
	<c:import url="../common/footer.jsp" />
	
</body>
</html>