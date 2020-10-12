package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import beans.Usuario;
import dao.DaoUsuario;

@WebServlet("/salvarUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario daoUsuario = new DaoUsuario();

	public ServletUsuario() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			RequestDispatcher view = request
					.getRequestDispatcher("/pages/cad_usuario.jsp");

			String acao = request.getParameter("acao") != null ? request
					.getParameter("acao") : "listartodos";
			String user = request.getParameter("user");

			if (acao != null && acao.equalsIgnoreCase("listartodos")) {
				request.setAttribute("usuarios", daoUsuario.listar());
			}

			else if (acao != null && acao.equalsIgnoreCase("delete")
					&& user != null) {
				daoUsuario.delete(user);
				request.setAttribute("msg", "Usuário excluído com Sucesso!");
				// Tipo de mensagem
				request.setAttribute("tipo", "success");
				request.setAttribute("usuarios", daoUsuario.listar());

			} else if (acao != null && acao.equalsIgnoreCase("editar")
					&& user != null) {
				Usuario usuario = daoUsuario.consultar(user);
				request.setAttribute("user", usuario);

			}

			if (!acao.equalsIgnoreCase("visualizar")) {
				request.setAttribute("restricao", daoUsuario.listarPermissao());
				view.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = ("SalvarUsuario");
		String usuarioSessao = request.getParameter("usuarioSessao");

		boolean podeInserir = true;
		String msg = null;

		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String senha2 = passwordEncoder.encode((senha));
		String id_permissao = request.getParameter("id_permissao");
		String usuario_alteracao = request.getParameter("user_sessao");

		Usuario usuario = new Usuario();
		usuario.setId(!id.isEmpty() ? Long.parseLong(id) : null);
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setSenha(senha2);
		usuario.setId_permissao(Long.parseLong(id_permissao));
		usuario.setUsuario_alteracao(Long.parseLong(usuario_alteracao));

		try {

			RequestDispatcher view = request
					.getRequestDispatcher("/pages/cad_usuario.jsp");

			if (id == null || id.isEmpty() && podeInserir) {
				daoUsuario.salvar(usuario);
				// Mensagem salvo com sucesso
				request.setAttribute("msg", "Usuário salvo com Sucesso!");
				// Tipo de mensagem
				request.setAttribute("tipo", "success");
				request.setAttribute("usuarios", daoUsuario.listar());

			} else if (id != null && !id.isEmpty()) {
				daoUsuario.atualizar(usuario);
				request.setAttribute("msg", "Usuário editado com Sucesso!");
				// Tipo de mensagem
				request.setAttribute("tipo", "success");
				request.setAttribute("usuarios", daoUsuario.listar());

			}

			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
