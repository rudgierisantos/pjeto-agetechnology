<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="resources/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="resources/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="resources/plugins/iCheck/square/blue.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<title>Age Technology</title>
</head>
<body class="hold-transition login-page">

	<div class="login-box">
		<div class="login-logo">
			<a href=""><b>Age</b>Technology</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<div class="form-group has-feedback">
				<span class="badge badge-info" style="width: 26%;">Vers�o
					0.1</span>
			</div>
			<p class="login-box-msg">Insira os dados para inicio na sess�o</p>


			<form action="ServletAutenticacao" method="post">

				<input readonly="readonly" type="hidden" id="url" name="url"
					value="<%=request.getParameter("url")%>">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" placeholder="Login"
						name="login" id="login" required="required"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" placeholder="Password"
						name="senha" id="senha" required="required"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label> <input type="checkbox"> Lembrar
							</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Logar
						</button>
					</div>
					<!-- /.col -->
				</div>
			</form>
		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 3 -->
	<script src="resources/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="resources//bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script src="resources/plugins/iCheck/icheck.min.js"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' /* optional */
			});
		});
	</script>

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

</body>
</html>