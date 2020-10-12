// FUNÇÃO PARA BUSCA DE PREÇOS
function buscarObras(id_cliente) {

	// Verificando Browser
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();

	} else if (window.ActiveXObject) {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}

	// Arquivo PHP juntamente com o valor digitado no campo (método GET)
	var url = "/projeto-jsp/salvarPedido?acao=consultarObra&id_cliente="
			+ id_cliente;

	// alert(url);

	// Chamada do método open para processar a requisição
	req.open("Get", url, true);

	// Quando o objeto recebe o retorno, chamamos a seguinte função;
	req.onreadystatechange = function() {

		// Exibe a mensagem "Buscando Noticias..." enquanto carrega
		if (req.readyState == 1) {
			document.getElementById('id_cliente').innerHTML = 'Buscando Noticias...';
		}

		// Verifica se o Ajax realizou todas as operações corretamente
		if (req.readyState == 4 && req.status == 200) {

			// Resposta retornada pelo busca.php
			var resposta = req.responseText;

			// Abaixo colocamos a(s) resposta(s) na div resultado
			teste = document.getElementById('id_obra').innerHTML = resposta;

		}
	};
	req.send(null);
	
	}



