package br.com.ifood.chlg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifood.chlg.bean.CadastroLoja;
import br.com.ifood.chlg.bean.Dashboard;
import br.com.ifood.chlg.dao.DashboardDAO;
import br.com.ifood.chlg.factory.DAOFactory;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DashboardDAO dao;


	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getDashboardDAO();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			int inputParceiroMais = 0;
			int inputParceiroMenos = 0;
			int inputFuncMais = 0;
			int inputFuncMenos = 0;
			int inputPedidoMais = 0;
			int inputPedidoMenos = 0;

			if (request.getParameter("inputParceiroMais") != "") {
				inputParceiroMais = Integer.parseInt(request.getParameter("inputParceiroMais"));
			}
			if (request.getParameter("inputParceiroMenos") != "") {
				inputParceiroMenos = Integer.parseInt(request.getParameter("inputParceiroMenos"));
			}
			if (request.getParameter("inputFuncMais") != "") {
				inputFuncMais = Integer.parseInt(request.getParameter("inputFuncMais"));
			}
			if (request.getParameter("inputFuncMenos") != "") {
				inputFuncMenos = Integer.parseInt(request.getParameter("inputFuncMenos"));
			}
			if (request.getParameter("inputPedidoMais") != "") {
				inputPedidoMais = Integer.parseInt(request.getParameter("inputPedidoMais"));
			}
			if (request.getParameter("inputPedidoMenos") != "") {
				inputPedidoMenos = Integer.parseInt(request.getParameter("inputPedidoMenos"));
			}

//			String parceiroMais = request.getParameter("parceiro-mais");
//			String parceiroMenos = request.getParameter("parceiro-menos");
//			String funcMais = request.getParameter("func-mais");
//			String funcMenos = request.getParameter("func-menos");
//			String pedidoMais = request.getParameter("pedidos-mais");
//			String pedidoMenos = request.getParameter("pedidos-menos");
//			String regiao = request.getParameter("regiao");
			

			List<Dashboard> lista = dao.listar();
			request.setAttribute("dashboard", lista);

			request.getRequestDispatcher("dashboard.jsp").forward(request, response);

			request.setAttribute("msg", "Produto cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

}
