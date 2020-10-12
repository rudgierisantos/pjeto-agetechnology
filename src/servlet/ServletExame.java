package servlet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.codec.binary.Base64;

import beans.Exame;
import dao.DaoExame;

/**
 * Servlet implementation class ServletExame
 */
@WebServlet("/salvarExame")
@MultipartConfig
public class ServletExame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoExame daoExame = new DaoExame();

	public ServletExame() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String id_exame = request.getParameter("id_exame");
		String id_paciente = request.getParameter("id_paciente");

		try {

			RequestDispatcher view = request
					.getRequestDispatcher("/pages/cad_exame.jsp");

			if (acao != null && acao.equalsIgnoreCase("listartodos")) {
				request.setAttribute("paciente", daoExame.listarPaciente());
				request.setAttribute("exames", daoExame.listarExames());
				request.setAttribute("qtd_exames", daoExame.listarExames()
						.size());

			} else if (acao != null && acao.equalsIgnoreCase("editarExame")) {
				Exame exame = daoExame.consultarExame(id_exame);
				request.setAttribute("exam", exame);
				request.setAttribute("paciente", daoExame.listarPaciente());
				request.setAttribute("qtd_exames", daoExame.listarExames()
						.size());
			}

			else if (acao != null && acao.equalsIgnoreCase("delete")) {
				daoExame.delete(id_exame);
				request.setAttribute("msg", "Exame excluído com Sucesso!");
				// Tipo de mensagem
				request.setAttribute("tipo", "success");

				request.setAttribute("paciente", daoExame.listarPaciente());
				request.setAttribute("exames", daoExame.listarExames());
				request.setAttribute("qtd_exames", daoExame.listarExames()
						.size());

			}
			
			
			else if (acao != null && acao.equalsIgnoreCase("download")) {

				Exame exame = daoExame.consultarExame(id_exame);
				if (exame != null) {
					String contentType = "";
					byte[] fileBytes = null;
					String tipo = request.getParameter("tipo");

					
					    if (tipo.equalsIgnoreCase("exame")) {
						contentType = exame.getContentTypeExame();
						fileBytes = new Base64().decodeBase64(exame
								.getExameBase64());
					}

					response.setHeader(
							"Content-Disposition",
							"attachment;filename=arquivo."
									+ contentType.split("\\/")[1]);

					/* Coloca os bytes em um objeto de entrada para processar */
					InputStream is = new ByteArrayInputStream(fileBytes);

					/* Inicio da resposta para o navegador */
					int read = 0;
					byte[] bytes = new byte[1024];
					OutputStream os = response.getOutputStream();

					while ((read = is.read(bytes)) != -1) {
						os.write(bytes, 0, read);

					}
					os.flush();
					os.close();
				}
			}

			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String id_exame = request.getParameter("id_exame");

		boolean podeInserir = true;

		try {

			RequestDispatcher view = request
					.getRequestDispatcher("/pages/cad_exame.jsp");

			String id = request.getParameter("id");
			String id_paciente = request.getParameter("id_paciente");
			String nome_exame = request.getParameter("nome_exame");
			String data_exame = request.getParameter("data");
			String observacao = request.getParameter("observacao");

			Exame exame = new Exame();
			exame.setId(!id.isEmpty() ? Long.parseLong(id) : null);
			exame.setId_paciente(Long.parseLong(id_paciente));
			exame.setNome_exame(nome_exame);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date data = sdf.parse(data_exame);
			exame.setData(data);
			exame.setObservacao(observacao);
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			Date data_atual = sdf2.parse(exame.getDateTime());
			
			
			/* Processa PDF */
			Part examePdf = request.getPart("exame");
			if (examePdf != null
					&& examePdf.getInputStream().available() > 0) {
				String exameBase64 = new Base64()
						.encodeBase64String(convertStremParabyte(examePdf
								.getInputStream()));

				exame.setExameBase64(exameBase64);
				exame.setContentTypeExame(examePdf
						.getContentType());
			} else {
				exame.setAtualizarPdf(false);
			}
		

			if (id == null || id.isEmpty()
					&& !daoExame.validarPaciente(id_paciente)) {

				request.setAttribute("msg", "Paciente já Cadastrado!");
				// Tipo de mensagem
				request.setAttribute("tipo", "info");
				podeInserir = false;

				request.setAttribute("paciente", daoExame.listarPaciente());
				request.setAttribute("exames", daoExame.listarExames());
				request.setAttribute("qtd_exames", daoExame.listarExames()
						.size());

			}

			else if (data.before(data_atual) || data.compareTo(data_atual) == 0) {

				request.setAttribute("msg", "Selecione data maior que atual!");
				// Tipo de mensagem
				request.setAttribute("tipo", "info");
				podeInserir = false;

				request.setAttribute("paciente", daoExame.listarPaciente());
				request.setAttribute("exames", daoExame.listarExames());
				request.setAttribute("qtd_exames", daoExame.listarExames()
						.size());

			}

			else if (id == null || id.isEmpty()
					&& daoExame.validarPaciente(id_paciente) && podeInserir) {

				daoExame.salvar(exame);

				request.setAttribute("msg", "Exame salvo com Sucesso!");
				// Tipo de mensagem
				request.setAttribute("tipo", "success");

				request.setAttribute("paciente", daoExame.listarPaciente());
				request.setAttribute("exames", daoExame.listarExames());
				request.setAttribute("qtd_exames", daoExame.listarExames()
						.size());

			} else if (id != null && !id.isEmpty() && podeInserir) {

				daoExame.atualizarExame(exame);
				request.setAttribute("msg", "Exame alterado com Sucesso!");
				// Tipo de mensagem
				request.setAttribute("tipo", "success");
				request.setAttribute("paciente", daoExame.listarPaciente());
				request.setAttribute("exames", daoExame.listarExames());
				request.setAttribute("qtd_exames", daoExame.listarExames()
						.size());

			}

			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* Converte a entrada de fluxo de dados da imagem para um array de byte */

	private byte[] convertStremParabyte(InputStream pdf) throws Exception {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		int reads = pdf.read();
		while (reads != -1) {
			baos.write(reads);
			reads = pdf.read();
		}

		return baos.toByteArray();
	}

}
