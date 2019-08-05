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
<c:import url="../common/header.jsp" />
<style type="text/css">
#piechart{
	margin-left: 40px;
}
</style>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script>
$(document).ready(function(){

	$.ajax({
        url: '${pageContext.request.contextPath}/sales/salesData.do',
        type: 'post',
        async: false,
        success: function(list) {
            google.charts.load('current', {'packages':['corechart']});
            google.charts.setOnLoadCallback(drawChart);
            function drawChart() {
                var dataChart = [['Language', 'Speakers (in millions)']];
                if(list.length != 0) {
                    $.each(list, function(i, item){
                        dataChart.push([item.item, item.ticket]);
                    });
                    for(var i = 1; i < list[0].month + 1; i++){
                    	$('#month').append("<option value='" + i + "' id='month" + i + "'>" + i + "월 </option>");
                    	if(i == list[0].month) {
                    		$('#month' + i).prop('selected',true);
                    	}
                    }
                }
                var data = google.visualization.arrayToDataTable(dataChart);
                var view = new google.visualization.DataView(data);
                var options = {
                	width: 542, 
                	height: 450,
                };
                var chart = new google.visualization.PieChart(document.getElementById('piechart'));
                chart.draw(view, options);
            }
        }
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
						<h4 class="page-title">Charts</h4>
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
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-6">
						<div class="card">
							<div class="card-body">
							<h5 class="card-title">정기권 구매 비율
							 <select id="month">
							</select>
							</h5>
								<div id="piechart"></div>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="card">
							<div class="card-body">
							<h5 class="card-title">정기권 구매 비율</h5>
								<div id="donutchart" style="width: 580px; height: 450px;"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<footer class="footer text-center">
			   All Rights Reserved by Matrix-admin. Designed and Developed by <a href="https://wrappixel.com">WrapPixel</a>.
			</footer>
		</div>
	</div>
	<c:import url="../common/footer.jsp" />
</body>
</html>