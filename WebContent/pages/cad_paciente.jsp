<%@page import="beans.Paciente"%>
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


<!--- Mascara JavaScript -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.js"></script>

<script type="text/javascript">
	$("#telcel").mask("00(00)0000-00009");
</script>
<script type="text/javascript">
	$("#telfixo").mask("(00)0000-0000");
</script>
<script type="text/javascript">
	$("#rg").mask("00.000.000-000");
</script>


</head>
<body class="hold-transition skin-blue sidebar-mini">


	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>Pacientes</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i>Dashboard</a></li>
				<li><a href="#">Cadastro</a></li>
				<li class="active">Pacientes</li>
			</ol>
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="row">
				<!-- left column -->
				<div class="col-md-12">
					<!-- general form elements -->
					<div class="box collapsed-box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">Cadastro</h3>
							<div class="pull-right box-tools">
								<button type="button" class="btn btn-info btn-sm"
									data-widget="collapse" data-toggle="tooltip" title="Expandir">
									<i class="fa fa-plus"></i>
								</button>
							</div>

						</div>

						<!-- /.box-header -->
						<!-- form start -->
						<form role="form" action="salvarPaciente" method="post"
							id="formUser" enctype="multipart/form-data">
							<div class="box-body">
								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Código</label> <input
										type="text" readonly="readonly" name="id" class="form-control"
										id="id" placeholder="codigo" value="${pacient.id}">
								</div>
								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Paciente</label> <input
										type="text" name="nome" class="form-control" id="nome"
										placeholder="Nome" value="${pacient.nome}" required="required">
								</div>


								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">CPF</label> <input
										type="text" name="cpf" class="form-control" id="cpf"
										maxlength="18" placeholder="CPF" value="${pacient.cpf}"
										required="required">
								</div>


								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">RG</label> <input
										type="text" name="rg" class="form-control" id="rg"
										placeholder="RG" value="${pacient.rg}">
								</div>


								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Telefone</label> <input
										type="text" name="telfixo" class="form-control" id="telfixo"
										placeholder="Telefone" value="${pacient.telfixo}">
								</div>

								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Celular</label> <input
										type="text" name="telcel" class="form-control" id="telcel"
										placeholder="Celular" value="${pacient.telcel}"
										required="required">
								</div>

								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">E-mail</label> <input
										type="email" name="email" class="form-control" id="email"
										placeholder="E-mail" value="${pacient.email}">
								</div>

								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">CEP</label> <input type="text"
										name="cep" class="form-control" id="cep" placeholder="CEP"
										onblur="consultaCep();" value="${pacient.cep}"
										required="required">
								</div>
								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Rua</label> <input type="text"
										name="rua" class="form-control" id="rua" placeholder="Rua"
										value="${pacient.rua}" required="required">
								</div>

								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Número</label> <input
										type="text" name="numero" class="form-control" id="numero"
										placeholder="Número" value="${pacient.numero}"
										required="required">
								</div>

								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Bairro</label> <input
										type="text" name="bairro" class="form-control" id="bairro"
										placeholder="Bairro" value="${pacient.bairro}"
										required="required">
								</div>

								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Cidade</label> <input
										type="text" name="cidade" class="form-control" id="cidade"
										placeholder="Cidade" value="${pacient.cidade}"
										required="required">
								</div>

								<div class="form-group col-md-4">
									<label for="exampleInputEmail1">Estado</label> <input
										type="text" name="estado" class="form-control" id="estado"
										placeholder="Estado" value="${pacient.estado}"
										required="required">
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
				<div class="col-md-12">
					<div class="box">
						<div class="box-header">
							<h3 class="box-title">Lista de Pacientes</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<table id="example1" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>Nome</th>
										<th>CPF / CNPJ</th>
										<th>Consultar</th>
										<th>Whatsapp</th>
										<th>Editar</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pacientes}" var="paciente">
										<tr>
											<td><c:out value="${paciente.nome}"></c:out></td>
											<td><c:out value="${paciente.cpf}"></c:out></td>
											<td><a
												href="salvarPaciente?acao=visualizar&paciente=${paciente.id}"><img
													src="resources/img/visualizar.png" alt="Visualizar"
													title="Visualizar" width="22px" height="22px"></a></td>
											<td><a
												href="https://api.whatsapp.com/send?phone=${paciente.telcel}"
												target="_blank"><img src="resources/img/whats.png"
													alt="Whats" title="Whatsapp" width="22px" height="22px"></a></td>

											<td><a
												href="salvarPaciente?acao=editar&paciente=${paciente.id}"><img
													src="resources/img/editar.png" alt="Editar" title="Editar"
													width="20px" height="20px"></a></td>
										</tr>
									</c:forEach>
							</table>
						</div>
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

			<script type="text/javascript">
				var options = {
					onKeyPress : function(cpf, ev, el, op) {
						var masks = [ '000.000.000-000', '00.000.000/0000-00' ];
						$('#cpf').mask((cpf.length > 14) ? masks[1] : masks[0],
								op);
					}
				}

				$('#cpf').length > 11 ? $('#cpf').mask('00.000.000/0000-00',
						options) : $('#cpf').mask('000.000.000-00#', options);
			</script>


			<script type="text/javascript">
				function consultaCep() {

					var cep = $("#cep").val();

					//Consulta o webservice viacep.com.br/
					$.getJSON("https://viacep.com.br/ws/" + cep
							+ "/json/?callback=?", function(dados) {

						if (!("erro" in dados)) {
							//Atualiza os campos com os valores da consulta.
							$("#rua").val(dados.logradouro);
							$("#bairro").val(dados.bairro);
							$("#cidade").val(dados.localidade);
							$("#estado").val(dados.uf);
						} //end if.
						else {
							//CEP pesquisado não foi encontrado.
							$("#cep").val('');
							$("#rua").val('');
							$("#bairro").val('');
							$("#cidade").val('');
							$("#estado").val('');
							alert("CEP não encontrado.");
						}
					});
				}
			</script>

			<script type="text/javascript">
				$(document)
						.ready(
								function() {

									// Adicionamos o evento onclick ao botão com o ID "pesquisar"
									$('#pesquisar')
											.on(
													'click',
													function(e) {

														// Apesar do botão estar com o type="button", é prudente chamar essa função para evitar algum comportamento indesejado
														e.preventDefault();

														// Aqui recuperamos o cnpj preenchido do campo e usamos uma expressão regular para limpar da string tudo aquilo que for diferente de números
														var cnpj = $('#cpf')
																.val()
																.replace(
																		/[^0-9]/g,
																		'');

														// Fazemos uma verificação simples do cnpj confirmando se ele tem 14 caracteres
														if (cnpj.length == 14) {

															// Aqui rodamos o ajax para a url da API concatenando o número do CNPJ na url
															$
																	.ajax({
																		url : 'https://www.receitaws.com.br/v1/cnpj/'
																				+ cnpj,
																		method : 'GET',
																		dataType : 'jsonp', // Em requisições AJAX para outro domínio é necessário usar o formato "jsonp" que é o único aceito pelos navegadores por questão de segurança
																		complete : function(
																				xhr) {

																			// Aqui recuperamos o json retornado
																			response = xhr.responseJSON;

																			// Na documentação desta API tem esse campo status que retorna "OK" caso a consulta tenha sido efetuada com sucesso
																			if (response.status == 'OK') {

																				// Agora preenchemos os campos com os valores retornados
																				$(
																						'#fantasia')
																						.val(
																								response.fantasia);
																				$(
																						'#nome')
																						.val(
																								response.nome);
																				$(
																						'#rua')
																						.val(
																								response.logradouro);
																				$(
																						'#bairro')
																						.val(
																								response.bairro);
																				$(
																						'#numero')
																						.val(
																								response.numero);

																				$(
																						'#cep')
																						.val(
																								response.cep);

																				$(
																						'#cidade')
																						.val(
																								response.municipio);

																				$(
																						'#estado')
																						.val(
																								response.uf);

																				$(
																						'#email')
																						.val(
																								response.email);

																				$(
																						'#telfixo')
																						.val(
																								response.telefone);

																				// Aqui exibimos uma mensagem caso tenha ocorrido algum erro
																			} else {
																				alert(response.message); // Neste caso estamos imprimindo a mensagem que a própria API retorna
																			}
																		}
																	});

															// Tratativa para caso o CNPJ não tenha 14 caracteres
														} else {
															alert('CNPJ inválido');
														}
													});
								});
			</script>
</body>
</html>