package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Paciente;
import dao.DaoPaciente;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/salvarPaciente")
@MultipartConfig
public class ServletPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoPaciente daoPaciente = new DaoPaciente();

	public ServletPaciente() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao") != null ? request
				.getParameter("acao") : "listartodos";
		String pacient = request.getParameter("paciente");

		try {

			RequestDispatcher view = request
					.getRequestDispatcher("/pages/cad_paciente.jsp");

			if (acao != null && acao.equalsIgnoreCase("listartodos")) {
				request.setAttribute("pacientes", daoPaciente.listar());

			} else if (acao != null && acao.equalsIgnoreCase("editar")) {
				Paciente paciente = daoPaciente.consultar(pacient);
				request.setAttribute("pacient", paciente);
			}

			else if (acao != null && acao.equalsIgnoreCase("delete")) {
				daoPaciente.delete(pacient);
				request.setAttribute("msg", "Cliente excluído com Sucesso!");
				// Tipo de mensagem
				request.setAttribute("tipo", "success");	
				request.setAttribute("pacientes", daoPaciente.listar());

			} else if (acao != null && acao.equalsIgnoreCase("visualizar")) {
				Paciente paciente = daoPaciente.consultar(pacient);
				RequestDispatcher view2 = request
						.getRequestDispatcher("/pages/view_paciente.jsp");
				request.setAttribute("pacient", paciente);
				view2.forward(request, response);

			}

			if (!acao.equalsIgnoreCase("visualizar")) {

				view.forward(request, response);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");

		boolean podeInserir = true;

		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String cpf2 = request.getParameter("cpf");
		String cpf = cpf2.replace(".", "").replace("/", "").replace("-", "");
		String cep = request.getParameter("cep");
		String rua = request.getParameter("rua");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String rg2 = request.getParameter("rg");
		String rg = rg2.replace(".", "").replace("-", "");
		String telcel2 = request.getParameter("telcel");
		String telcel = telcel2.replaceAll("[^0-9]", "");
		String telfixo2 = request.getParameter("telfixo");
		String telfixo = telfixo2.replaceAll("[^0-9]", "");
		String email = request.getParameter("email");
		String numero = request.getParameter("numero");
		String usuario_alteracao = request.getParameter("user_sessao");


		Paciente paciente = new Paciente();
		paciente.setId(!id.isEmpty() ? Long.parseLong(id) : null);
		paciente.setNome(nome);
		paciente.setCpf(cpf);
		paciente.setCep(cep);
		paciente.setRua(rua);
		paciente.setBairro(bairro);
		paciente.setCidade(cidade);
		paciente.setEstado(estado);
		paciente.setRg(rg);
		paciente.setTelcel(telcel);
		paciente.setTelfixo(telfixo);
		paciente.setEmail(email);
		paciente.setNumero(numero);
		paciente.setUsuario_alteracao(Long.parseLong(usuario_alteracao));

		try {

			RequestDispatcher view = request
					.getRequestDispatcher("/pages/cad_paciente.jsp");

			if (id == null || id.isEmpty() && !daoPaciente.validarCPF(cpf)) {

				request.setAttribute("msg", "Paciente já Cadastrado!");
				// Tipo de mensagem
				request.setAttribute("tipo", "info");
				podeInserir = false;

			}

			else if (id == null || id.isEmpty() && daoPaciente.validarCPF(cpf)
					&& podeInserir) {

				daoPaciente.salvar(paciente);
				request.setAttribute("msg", "Paciente salvo com Sucesso!");
				// Tipo de mensagem
				request.setAttribute("tipo", "success");
				
				request.setAttribute("pacientes", daoPaciente.listar());

			} else if (id != null && !id.isEmpty() && podeInserir) {
				daoPaciente.atualizar(paciente);
				request.setAttribute("msg", "Paciente alterado com Sucesso!");
				// Tipo de mensagem
				request.setAttribute("tipo", "success");
				
				request.setAttribute("pacientes", daoPaciente.listar());
			}
			if (!podeInserir) {
				request.setAttribute("pacient", paciente);
			}

			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
