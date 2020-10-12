package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/salvarCliente", "/Dashboard", "/salvarExame",
		"/salvarPaciente", "/salvarUsuario" })
public class FilterAutenticacao implements Filter {

	// faz alguma coisa quando a aplicação é derrubada
	@Override
	public void destroy() {

	}

	// intercepta todas as requisições
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		String urlParaAutenticar = req.getServletPath();
		// retorna null caso não esteja logado
		String usuarioLogado = (String) session.getAttribute("usuario");
		String permissao = (String) session.getAttribute("permissao");

		if (usuarioLogado == null
				&& !urlParaAutenticar.equalsIgnoreCase("/ServletAutenticacao")) { // usuário
																					// não
																					// logado
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
			dispatcher.forward(request, response);
			return;// para o processo para redirecionar
		}

		// executa as ações do request e response
		chain.doFilter(request, response);

	}

	// executa alguma coisa quando a aplicação é iniciada
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
