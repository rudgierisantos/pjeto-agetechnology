function consultarPreco2() {
	var produto = document.getElementById("id_produto").value;
	alert(produto);
}

function consultarPreco() {
	var produto = document.getElementById("id_produto").value;
	location.href = "http://localhost:8080/projeto-jsp/salvarOrcamento?acao=consultarPreco&id_produto="
			+ (produto);
}

var req;

// FUNÇÃO PARA BUSCA DE PREÇOS
function buscarPrecos(id_produto) {

	// Verificando Browser
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();

	} else if (window.ActiveXObject) {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}

	// Arquivo PHP juntamente com o valor digitado no campo (método GET)
	var url = "/projeto-jsp/BuscarPrecosOrcamento?acao=consultarPreco&id_produto="
			+ id_produto;

	// alert(url);

	// Chamada do método open para processar a requisição
	req.open("Get", url, true);

	// Quando o objeto recebe o retorno, chamamos a seguinte função;
	req.onreadystatechange = function() {

		// Exibe a mensagem "Buscando Noticias..." enquanto carrega
		if (req.readyState == 1) {
			document.getElementById('id_produto').innerHTML = 'Buscando Noticias...';
		}

		// Verifica se o Ajax realizou todas as operações corretamente
		if (req.readyState == 4 && req.status == 200) {

			// Resposta retornada pelo busca.php
			var resposta = req.responseText;

			// Abaixo colocamos a(s) resposta(s) na div resultado
			teste = document.getElementById('id_preco').innerHTML = resposta;

		}
	};
	req.send(null);

	// Buscar valor do produto e insere na tabela de Produtos Orçamento
	$('#id_preco').change(function() {
		var option = $('#id_preco').find(":selected").text();
		var valor = option.replace(/[^0-9.]/g, '');
		//alert(valor);
		document.getElementById("valor").value=valor;
		//document.getElementById('valor').innerHTML = valor;

	});
	
}
