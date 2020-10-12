package servlet;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import dao.DaoDashboard;
import dao.DaoLogin;
import dao.DaoOcorrenciaAcesso;
import beans.OcorrenciaAcesso;
import beans.Permissao;
import beans.Usuario;

@WebServlet("/ServletAutenticacao")
public class ServletAutenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private boolean isPasswordMatch;
	private DaoLogin daoLogin = new DaoLogin();
	DaoDashboard daoDashboard = new DaoDashboard();

	public ServletAutenticacao() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (Boolean.parseBoolean(request.getParameter("deslogar"))) {
			// adicionar usuario logado na sessao
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			session.invalidate();
			isPasswordMatch = false; // Define a senha inicial como false
			// redireciona para login novamente
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String ipDaMaquina = InetAddress.getLocalHost().getHostAddress();
		// System.out.println(usuario.getSenha());
		// nome da maquina.
		String nomeDaMaquina = InetAddress.getLocalHost().getHostName();
		// System.out.println(nomeDaMaquina);

		String url = request.getParameter("url");

		// neste momento pode ser feito uma validação no banco de dados
		try {
			// Valida Login
			if (login != null && !login.isEmpty() && senha != null
					&& !senha.isEmpty() && daoLogin.validarLogin(login) != null) {

				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				isPasswordMatch = passwordEncoder.matches(senha, daoLogin
						.validarLogin(login).getSenha()); // descriptografa a
															// senha do usuário
													

			}

			// Valida Senha
			if (isPasswordMatch == true) { // se senha de usuário for
											// igual a true permite o
											// acesso ao sistema

				Permissao permissao = daoLogin.consultarPermissao(login);
				// request.setAttribute("permissao", permissao);

				// se o login foi bem sucedido

				Usuario usuario = new Usuario();
				usuario.setLogin(login);
				usuario.setSenha(senha);
				// permissao.setDescricao(permissao.getDescricao());

				OcorrenciaAcesso ocorrenciaAcesso = new OcorrenciaAcesso();
				ocorrenciaAcesso.setLogin(login);
				ocorrenciaAcesso.setIpDaMaquina(ipDaMaquina);
				ocorrenciaAcesso.setNomeDaMaquina(nomeDaMaquina);

				DaoOcorrenciaAcesso daoOcorrenciaAcesso = new DaoOcorrenciaAcesso();

				daoOcorrenciaAcesso.salvarOcorrenciaAcesso(ocorrenciaAcesso);

				// adiciona usuário logado na sessão
				HttpServletRequest req = (HttpServletRequest) request;
				HttpSession session = req.getSession();
				session.setAttribute("usuario", usuario.getLogin());
				session.setAttribute("id_user", permissao.getId_user());
				session.setAttribute("permissao", permissao.getDescricao());

				// redireciona para o sistema e autoriza
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("pages/dashboard.jsp");
				request.setAttribute("pacientes", daoDashboard.listarPacientes());
				request.setAttribute("exames", daoDashboard.listarExames());

				dispatcher.forward(request, response);


			} else {// acesso negado
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("index.jsp");
				// Mensagem salvo com sucesso
				request.setAttribute("msg", "Usuário e/ou senha inválido!");
				// Tipo de mensagem
				request.setAttribute("tipo", "danger");
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
