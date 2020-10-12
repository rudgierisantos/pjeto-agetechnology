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
<script src="resources/js/pedido/pedido.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="resources/js/pedido/pedido.js"></script>
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
<!-- Select2 -->
<link rel="stylesheet"
	href="resources/bower_components/select2/dist/css/select2.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

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
			<h1>Pedido</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i>Dashboard</a></li>
				<li><a href="#">Exames</a></li>
				<li class="active">Consultar</li>
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
						<form role="form" action="salvarExame" method="post" id="formUser"
							enctype="multipart/form-data">
							<div class="box-body">

								<div class="form-group col-md-2">
									<label for="exampleInputEmail1">N∫ Exame</label> <input
										type="text" readonly="readonly" name="id" class="form-control"
										id="id" placeholder="codigo" value="${exam.id}">
								</div>

								<div class="form-group col-md-5">
									<label for="exampleInputEmail1">Paciente</label> <select
										class="form-control select" style="width: 100%;"
										id="id_paciente" name="id_paciente" required>
										<option value="nao_informado" disabled selected>Selecione</option>
										<c:forEach items="${paciente}" var="pacient">
											<option value="${pacient.id}" id="${pacient.id}"
												<c:if test="${pacient.id == exam.id_paciente}">
						 					<c:out value = "selected=selected" />
						 	</c:if>>
												${pacient.nome}</option>
										</c:forEach>
									</select>
								</div>

								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Nome Exame</label> <input
										type="text" name="nome_exame" class="form-control"
										id="nome_exame" required="required" placeholder="Nome Exame"
										value="${exam.nome_exame}">
								</div>


								<div class="form-group col-md-3">
									<label for="exampleInputEmail1">Data Exame</label><input
										class="form-control" id="date1" type="date"
										required="required" name="data" value="${exam.data}">
								</div>


								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">ObservaÁ„o/Resultado</label> <input
										type="text" name="observacao" class="form-control"
										id="observacao" required="required" placeholder="ObservaÁ„o"
										value="${exam.observacao}">
								</div>

								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Resultado</label> <input
										type="file" id="exame" name="exame">
								</div>

								<input type="hidden" name="user_sessao" id="user_sessao"
									value="${id_user}">

							</div>
							<!-- /.box-body -->
							<div class="box-footer">
								<button type="submit" class="btn btn-primary">Cadastrar</button>
							</div>
						</form>
					</div>
				</div>


				<!-- Custom Tabs -->
				<div class="nav-tabs-custom">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab_1" data-toggle="tab">Exames
								<span class="badge badge-warning"><span id="alugados">${qtd_exames}</span></span>
						</a></li>

					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tab_1">


							<div class="box">
								<div class="box-header">
									<h3 class="box-title">Lista de Exames</h3>
								</div>


								<!-- /.box-header -->
								<div class="box-body">
									<script
										src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
									<table id="example1" class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>Data Exame</th>
												<th>Nro Exame</th>
												<th>Paciente</th>
												<th>Nome Exame</th>
												<th>Obs/Resultado</th>
												<th>Resultado</th>
												<th>Editar</th>
												<th>Excluir</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${exames}" var="exam">


												<tr>
													<td><fmt:formatDate pattern="dd/MM/yyyy"
															value="${exam.data}" /></td>
													<td><c:out value="${exam.id}"></c:out></td>
													<td><c:out value="${exam.nome_paciente}"></c:out></td>
													<td><c:out value="${exam.nome_exame}"></c:out></td>
													<td><c:out value="${exam.observacao}"></c:out></td>
													<c:choose>
														<c:when test="${exam.exameBase64.isEmpty() == false }">
															<td><a
																href="salvarExame?acao=download&tipo=exame&id_exame=${exam.id}">CONCLUÕDO</a></td>

														</c:when>
														<c:otherwise>
															<td><c:out value="PENDENTE"></c:out></td>
														</c:otherwise>
													</c:choose>




													<td><a
														href="salvarExame?acao=editarExame&id_exame=${exam.id}&id_paciente=${exam.id_paciente}"><img
															src="resources/img/editar.png" alt="Editar"
															title="Editar" width="20px" height="20px"></a></td>

													<td><a
														href="salvarExame?acao=delete&id_exame=${exam.id}"
														onclick="return confirm('Confirmar a exclus„o?');"><img
															src="resources/img/excluir.png" alt="Excluir"
															title="Excluir" width="20px" height="20px"></a></td>

												</tr>
											</c:forEach>
									</table>
								</div>

							</div>
						</div>

					</div>
				</div>
			</div>

			<script type="text/javascript">
				function mostraDialogo(mensagem, tipo, tempo) {

					// se houver outro alert desse sendo exibido, cancela essa requisi√ß√£o
					if ($("#message").is(":visible")) {
						return false;
					}

					// se n√£o setar o tempo, o padr√£o √© 3 segundos
					if (!tempo) {
						var tempo = 3000;
					}

					// se n√£o setar o tipo, o padr√£o √© alert-info
					if (!tipo) {
						var tipo = "";
					}

					// monta o css da mensagem para que fique flutuando na frente de todos elementos da p√°gina
					var cssMessage = "display: block; position: fixed; top: 0; left: 20%; right: 20%; width: 60%; padding-top: 10px; z-index: 9999";
					var cssInner = "margin: 0 auto; box-shadow: 1px 1px 5px black;";

					// monta o html da mensagem com Bootstrap
					var dialogo = "";
					dialogo += '<div id="message" style="'+cssMessage+'">';
					dialogo += '    <div class="alert alert-'+tipo+' alert-dismissable" style="'+cssInner+'">';
					dialogo += '    <a href="#" class="close" data-dismiss="alert" aria-label="close">√ó</a>';
					dialogo += mensagem;
					dialogo += '    </div>';
					dialogo += '</div>';

					// adiciona ao body a mensagem com o efeito de fade
					$("body").append(dialogo);
					$("#message").hide();
					$("#message").fadeIn(200);

					// contador de tempo para a mensagem sumir
					setTimeout(function() {
						$('#message').fadeOut(300, function() {
							$(this).remove();
						});
					}, tempo); // milliseconds

				}
				var mensagem = "${msg}";
				var tipo = "${tipo}";
				mostraDialogo(mensagem, tipo, 2500);
			</script>

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
			<script
				src="resources/bower_components/select2/dist/js/select2.full.min.js"></script>
			<!-- DataTables -->
			<script
				src="resources/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
			<script
				src="resources/bower_components/datatables.net/js/dataTables.bootstrap.min.js"></script>

			<script type="text/javascript">
				$(function() {
					//Initialize Select2 Elements
					$('.select2').select2();
				});
			</script>

			<script>
				$(function() {
					$('#example1').DataTable({
						'paging' : true,
						'lengthChange' : false,
						'searching' : true,
						'ordering' : false,
						'info' : true,
						'autoWidth' : false
					});
				});
			</script>
</html>
