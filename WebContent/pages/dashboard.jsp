<%@page import="beans.Dashboard"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="menu.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="resources/dist/css/skins/_all-skins.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">

	<%
		String usuarioSessao = (String) session.getAttribute("login");
	%>


	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>Dashboard</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
				<li class="active">Dashboard</li>
			</ol>
		</section>

		<!-- Main content -->
		<section class="content">
			<!-- Info boxes -->
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box">
						<span class="info-box-icon bg-aqua"><i
							class="ion ion-ios-people-outline"></i></span>

						<div class="info-box-content">
							<c:forEach items="${pacientes}" var="pacient">
								<span class="info-box-text">PACIENTES</span>
								<span class="info-box-text">CADASTRADOS</span>
								<span class="info-box-number"><c:out
										value="${pacient.total_pacientes}"></c:out><small></small></span>
							</c:forEach>
						</div>
						<!-- /.info-box-content -->
					</div>
					<!-- /.info-box -->
				</div>
				<!-- /.col -->
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box">
						<span class="info-box-icon bg-red"><i
							class="fa fa-files-o"></i></span>

						<div class="info-box-content">
							<c:forEach items="${exames}" var="exam">
								<span class="info-box-text">EXAMES</span>
								<span class="info-box-text">CADASTRADOS</span>
								<span class="info-box-number"><c:out
										value="${exam.total_exames}"></c:out><small></small></span>
							</c:forEach>
						</div>
						<!-- /.info-box-content -->
					</div>
					<!-- /.info-box -->
				</div>
				<!-- /.col -->

			


				<!-- jQuery 2.2.3 -->
				<script src="resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
				<!-- Bootstrap 3.3.6 -->
				<script src="resources/bootstrap/js/bootstrap.min.js"></script>
				<!-- FastClick -->
				<script src="resources/plugins/fastclick/fastclick.js"></script>
				<!-- AdminLTE App -->
				<script src="resources/dist/js/app.min.js"></script>
				<!-- AdminLTE for demo purposes -->
				<script src="resources/dist/js/demo.js"></script>
				<!-- DataTables -->
				<script
					src="resources/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
				<script
					src="resources/bower_components/datatables.net/js/dataTables.bootstrap.min.js"></script>

				<script>
					$(function() {
						$('#example1').DataTable()
						$('#example2').DataTable({
							'paging' : true,
							'lengthChange' : false,
							'searching' : false,
							'ordering' : true,
							'info' : true,
							'autoWidth' : false
						});
					});
				</script>
</body>
</html>
