<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice</title>
<c:import url="../common/header.jsp" />
<style>

</style>
</head>
<body>

	<div id="main-wrapper">
		<c:import url="../common/menubar.jsp" />
		<c:import url="../common/sidebar.jsp" />

		<div class="page-wrapper">
			<div class="container-fluid">

				<div class="row">
					<div class="col-md-6">
						<div class="card" id="test1">
							<div class="card-body">
								<h4 class="card-title m-b-0">
								<br />
									Notice
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;
									<button type="button" class="btn btn-success btn-sm"
										onclick="fn_insertNotice();">Publish</button>
								</h4>

							</div>
							<div class="comment-widgets scrollable">
								<c:forEach items="${list }" var="n">
									<div class="d-flex flex-row comment-row m-t-0">
										<div class="comment-text w-100">
											<h6 class="font-medium">${n.adminId }</h6>
											<span class="m-b-15 d-block">${n.nName }</span>
											<div class="comment-footer">
												<span class="text-muted float-right">${n.nDate }</span>
												<button type="button" class="btn btn-cyan btn-sm">Edit</button>
												<button type="button" class="btn btn-danger btn-sm">Delete</button>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
					<div class="col-md-6">
                        <div class="card">
                            <form class="form-horizontal">
                                <div class="card-body">
                                    <h4 class="card-title">Personal Info</h4>
                                    <div class="form-group row">
                                        <label for="fname" class="col-sm-3 text-right control-label col-form-label">First Name</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="fname" placeholder="First Name Here">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="lname" class="col-sm-3 text-right control-label col-form-label">Last Name</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="lname" placeholder="Last Name Here">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="lname" class="col-sm-3 text-right control-label col-form-label">Password</label>
                                        <div class="col-sm-9">
                                            <input type="password" class="form-control" id="lname" placeholder="Password Here">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="email1" class="col-sm-3 text-right control-label col-form-label">Company</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="email1" placeholder="Company Name Here">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="cono1" class="col-sm-3 text-right control-label col-form-label">Contact No</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="cono1" placeholder="Contact No Here" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="cono1" class="col-sm-3 text-right control-label col-form-label">Message</label>
                                        <div class="col-sm-9">
                                            <textarea class="form-control" style="height: 149px" readonly="readonly"></textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="border-top">
                                    <div class="card-body">
                                        <button type="button" class="btn btn-primary">Submit</button>
                                    </div>
                                </div>
                            </form>
                        </div>
				</div>


			</div>
		</div>
	</div>
	<c:import url="../common/footer.jsp" />
</body>
</html>