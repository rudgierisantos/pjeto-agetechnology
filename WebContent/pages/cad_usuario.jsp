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
			<h1>
				Usuários <small>Preview</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
				<li><a href="#">Administrativo</a></li>
				<li class="active">Usuários</li>
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
						<form role="form" action="salvarUsuario" method="post"
							id="formUser">
							<!-- Seta usuário da sessão -->
							<input type="text" name="usuarioSessao" hidden="hidden"
								value="<%out.print(usuarioSessao);%>">
							<div class="box-body">
								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Código</label> <input
										type="text" readonly="readonly" name="id" class="form-control"
										id="id" placeholder="codigo" value="${user.id}"
										required="required">

								</div>
								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Login</label> <input
										type="text" name="login" class="form-control" id="login"
										placeholder="Login" value="${user.login}" required="required">
								</div>
								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Nome</label> <input type="text"
										name="nome" class="form-control" id="login" placeholder="Nome"
										value="${user.nome}" required="required">
								</div>
								<div class="form-group col-md-4">
									<label for="exampleInputPassword1">Senha</label> <input
										type="password" name="senha" class="form-control"
										id="exampleInputPassword1" placeholder="Password"
										value="${user.senha}" required="required">
								</div>
								
										<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Perfil</label> <select
										class="form-control select2" style="width: 100%;"
										id="id_permissao" name="id_permissao">
										<option value="">Selecione</option>
										<c:forEach items="${restricao}" var="perm">
											<option value="${perm.id}" id="${user.id_permissao}"
												<c:if test="${perm.id == user.id_permissao}">
						 					<c:out value = "selected=selected" />
						 	</c:if>>
												${perm.descricao} </option>
										</c:forEach>
									</select>
								</div>
								
									<input type="hidden" name="user_sessao" id="user_sessao"
									value="${id_user}">
								
							</div>
							
						<div class="box-footer">
								<button type="submit" id="enviar" class="btn btn-primary">Cadastrar</button>
							</div>
						</form>

					</div>

				</div>
				<div class="col-md-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">Lista de Usuários</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<table id="example1" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>Login</th>
										<th>Nome</th>
										<th>Editar</th>
										<th>Excluir</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${usuarios}" var="user">
										<tr>
											<td><c:out value="${user.login}"></c:out></td>
											<td><c:out value="${user.nome}"></c:out></td>
											<td><a href="salvarUsuario?acao=editar&user=${user.id}"><img
													src="resources/img/editar.png" alt="Editar" title="Editar"
													width="20px" height="20px"></a></td>
											<td><a href="salvarUsuario?acao=delete&user=${user.id}"
												onclick="return confirm('Confirmar a exclusão?');"><img
													src="resources/img/excluir.png" alt="Excluir"
													title="Excluir" width="20px" height="20px"></a></td>
										</tr>
									</c:forEach>
							</table>
						</div>
					</div>
				</div>
				
				<script type="text/javascript">
					function mostraDialogo(mensagem, tipo, tempo) {

						// se houver outro alert desse sendo exibido, cancela essa requisição
						if ($("#message").is(":visible")) {
							return false;
						}

						// se não setar o tempo, o padrão é 3 segundos
						if (!tempo) {
							var tempo = 3000;
						}

						// se não setar o tipo, o padrão é alert-info
						if (!tipo) {
							var tipo = "";
						}

						// monta o css da mensagem para que fique flutuando na frente de todos elementos da página
						var cssMessage = "display: block; position: fixed; top: 0; left: 20%; right: 20%; width: 60%; padding-top: 10px; z-index: 9999";
						var cssInner = "margin: 0 auto; box-shadow: 1px 1px 5px black;";

						// monta o html da mensagem com Bootstrap
						var dialogo = "";
						dialogo += '<div id="message" style="'+cssMessage+'">';
						dialogo += '    <div class="alert alert-'+tipo+' alert-dismissable" style="'+cssInner+'">';
						dialogo += '    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>';
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
