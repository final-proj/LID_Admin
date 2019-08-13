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
					href="${pageContext.request.contextPath}/main.do" aria-expanded="false"><i
						class="mdi mdi-view-dashboard"></i><span class="hide-menu">Dashboard</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="${pageContext.request.contextPath}/memberManagement/mmForm.do"
					aria-expanded="false"><i class="mdi mdi-chart-bar"></i><span
						class="hide-menu">회원 관리</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="${pageContext.request.contextPath }/notice/noticeList.do"
					aria-expanded="false"><i class="mdi mdi-border-inside"></i><span
						class="hide-menu">공지 사항</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="${pageContext.request.contextPath }/inquiry/"
					aria-expanded="false"><i class="mdi mdi-chart-bubble"></i><span
						class="hide-menu">문의 사항</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"

					href="${pageContext.request.contextPath }/faq/faqList.do"
					aria-expanded="false"><i class="mdi mdi-chart-bubble"></i><span
						class="hide-menu">자주 묻는 질문들</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="${pageContext.request.contextPath }/payment/paymentView.do"
					aria-expanded="false"><i class="mdi mdi-blur-linear"></i><span
						class="hide-menu">결제 관리</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="${pageContext.request.contextPath }/payment/paymentView.do"
					aria-expanded="false"><i class="mdi mdi-blur-linear"></i><span
						class="hide-menu">Payment</span></a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="${pageContext.request.contextPath }/admin/insertAdmin.do"
					aria-expanded="false"><i class="mdi mdi-blur-linear"></i><span

						class="hide-menu">계정 생성</span></a></li>

			</ul>
		</nav>
		<!-- End Sidebar navigation -->
	</div>
	<!-- End Sidebar scroll-->
</aside>