package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Dashboard;
import dao.DaoDashboard;

@WebServlet("/Dashboard")
public class ServletDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoDashboard daoDashboard = new DaoDashboard();
	private Dashboard dashboard = new Dashboard();

	public ServletDashboard() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao") != null ? request
				.getParameter("acao") : "listartodos";

		try {
			
			RequestDispatcher view = request
					.getRequestDispatcher("/pages/dashboard.jsp");

			if (acao != null && acao.equalsIgnoreCase("listartodos")) {
				request.setAttribute("pacientes", daoDashboard.listarPacientes());
				request.setAttribute("exames", daoDashboard.listarExames());
				
			}
			
			view.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
