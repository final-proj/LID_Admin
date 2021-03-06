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
	    url: '${pageContext.request.contextPath}/sales/salesThdData.do',
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
	
	
 $.ajax({
	    url: '${pageContext.request.contextPath}/memberManagement/membergenderData.do',
	    type: 'post',
	    async: false,
	    success: function(list) {
	        google.charts.load('current', {'packages':['corechart']});
	        google.charts.setOnLoadCallback(drawChart);
	        function drawChart() {
	            var dataChart = [['멤버', '성별']];
	            if(list.length != 0) {
	            	console.log(list);
	                $.each(list, function(i, item){
	                    dataChart.push([item.item, item.amount]);
	                });
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
 $.ajax({
	    url: '${pageContext.request.contextPath}/memberManagement/memberScdData.do',
	    type: 'post',
	    async: false,
	    success: function(list2) {
	        google.charts.load('current', {'packages':['corechart']});
	        google.charts.setOnLoadCallback(drawChart2);
	        function drawChart2() {
	            var dataChart2 = [['멤버', '연령']];
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
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">총 매출액</h5>
									<div id="chart_div"></div>
                            </div>
                        </div>
                    </div>
                </div>
				<div class="row">
					<div class="col-md-6">
						<div class="card">
							<div class="card-body">
							<h5 class="card-title">회원 성별 비율
							</h5>
								<div id="piechart"></div>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="card">
							<div class="card-body">
							<h5 class="card-title">연령별 회원 정보
							</h5>
									<div id="piechart2"></div>
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