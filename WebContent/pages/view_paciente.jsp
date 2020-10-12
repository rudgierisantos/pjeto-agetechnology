<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  
  <!-- Adicionando JQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">

	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				Pacientes <small>Preview</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
				<li><a href="#">Forms</a></li>
				<li class="active">Pacientes</li>
			</ol>
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="row">
				<!-- left column -->
				<div class="col-md-12">
					<!-- general form elements -->
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">Cadastro</h3>
						</div>
						<!-- /.box-header -->
						<!-- form start -->
						<form role="form" action="salvarPaciente" method="post"
							id="formUser" enctype="multipart/form-data">
							<div class="box-body">
								
								<div class="form-group col-md-2">
									<label for="exampleInputEmail1">Código</label> <input
										type="text" readonly="readonly" name="id" class="form-control"
										id="id" placeholder="codigo" value="${pacient.id}">
								</div>
								<div class="form-group col-md-5">
									<label for="exampleInputEmail1">Nome</label> <input
										type="text" readonly="readonly" name="nome" class="form-control" id="nome"
										placeholder="Nome" value="${pacient.nome}">
								</div>
								
								
								<div class="form-group col-md-2">
									<label for="exampleInputEmail1">CPF</label> <input type="text"
										name="cpf" readonly="readonly" class="form-control" id="cpf" placeholder="CPF"
										value="${pacient.cpf}">
								</div>
								
								<div class="form-group col-md-2">
									<label for="exampleInputEmail1">RG</label> <input
										type="text" readonly="readonly" name="rg" class="form-control" id="rg"
											placeholder="RG" value="${pacient.rg}">
								</div>
								
								<div class="form-group col-md-2">
									<label for="exampleInputEmail1">Telefone</label> <input
										type="text" readonly="readonly" name="telfixo" class="form-control" id="telfixo"
											placeholder="telfixo" value="${pacient.telfixo}">
								</div>
								
								<div class="form-group col-md-2">
									<label for="exampleInputEmail1">Celular</label> <input
										type="text" readonly="readonly" name="telcel" class="form-control" id="telcel"
											placeholder="telfixo" value="${pacient.telcel}">
								</div>
								
									<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Email</label> <input
										type="text" readonly="readonly" name="email" class="form-control" id="email"
											placeholder="email" value="${pacient.email}">
								</div>
								
								
								<div class="form-group col-md-2">
									<label for="exampleInputEmail1">CEP</label> <input type="text"
										name="cep" readonly="readonly" class="form-control" id="cep" placeholder="CEP"
										onblur="consultaCep();" value="${pacient.cep}">
								</div>
								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Rua</label> <input type="text"
										name="rua" readonly="readonly" class="form-control" id="rua" placeholder="Rua"
										value="${pacient.rua}">
								</div>
								
								<div class="form-group col-md-2">
									<label for="exampleInputEmail1">Numero</label> <input type="text"
										name="numero" readonly="readonly" class="form-control" id="numero" placeholder="Numero"
										value="${pacient.numero}">
								</div>
								
								<div class="form-group col-md-2">
									<label for="exampleInputEmail1">Bairro</label> <input type="text"
										name="bairro" readonly="readonly" class="form-control" id="bairro"" placeholder="Bairro"
										value="${pacient.bairro}">
								</div>
								
								<div class="form-group col-md-2">
									<label for="exampleInputEmail1">Cidade</label> <input type="text"
										name="cidade" readonly="readonly" class="form-control" id="cidade" placeholder="Cidade"
										value="${pacient.cidade}">
								</div>
								
								<div class="form-group col-md-2">
									<label for="exampleInputEmail1">Estado</label> <input type="text"
										name="estado" readonly="readonly" class="form-control" id="estado" placeholder="Estado"
										value="${pacient.estado}">
								</div>
							</div>
						</form>
					</div>

				</div>
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
				
</body>
</html>
