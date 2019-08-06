<%@ page language="java" contentType="text/jsp; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE jsp>
<aside class="left-sidebar" data-sidebarbg="skin5">
	<!-- Sidebar scroll-->
	<div class="scroll-sidebar">
		<!-- Sidebar navigation-->
		<nav class="sidebar-nav">
			<ul id="sidebarnav" class="p-t-30">
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="${pageContext.request.contextPath}" aria-expanded="false"><i
						class="mdi mdi-view-dashboard"></i><span class="hide-menu">Dashboard</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="${pageContext.request.contextPath}/memberManagement/mmForm.do"
					aria-expanded="false"><i class="mdi mdi-chart-bar"></i><span
						class="hide-menu">Member management</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="${pageContext.request.contextPath }/inquiry/"
					aria-expanded="false"><i class="mdi mdi-chart-bubble"></i><span
						class="hide-menu">Inquiry</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="${pageContext.request.contextPath }/notice/noticeList.do"
					aria-expanded="false"><i class="mdi mdi-border-inside"></i><span
						class="hide-menu">Notice</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="${pageContext.request.contextPath }/faq/faqList.do"
					aria-expanded="false"><i class="mdi mdi-chart-bubble"></i><span
						class="hide-menu">FNQ</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="${pageContext.request.contextPath }/memberManagement/mmChart.do"
					aria-expanded="false"><i class="mdi mdi-blur-linear"></i><span
						class="hide-menu">Chart</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="${pageContext.request.contextPath }/sales/salesChart.do"
					aria-expanded="false"><i class="mdi mdi-blur-linear"></i><span
						class="hide-menu">Sales management</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="${pageContext.request.contextPath }/admin/insertAdmin.do"
					aria-expanded="false"><i class="mdi mdi-blur-linear"></i><span
						class="hide-menu">Admin Create</span></a></li>		

			</ul>
		</nav>
		<!-- End Sidebar navigation -->
	</div>
	<!-- End Sidebar scroll-->
</aside>