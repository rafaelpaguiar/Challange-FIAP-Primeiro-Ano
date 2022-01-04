package br.com.ifood.chlg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifood.chlg.bean.Detalhe;
import br.com.ifood.chlg.dao.DetalheDAO;
import br.com.ifood.chlg.exception.DBException;
import br.com.ifood.chlg.factory.DAOFactory;

/**
 * Servlet implementation class DetalheServlet
 */
@WebServlet("/detalhes")
public class DetalheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private DetalheDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getDetalheDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			float parceiroCNPJ = Float.parseFloat(request.getParameter("inputCnpjLoja"));
			String categoria = request.getParameter("inputCategoria");
			int QtddFunc = Integer.parseInt(request.getParameter("inputQuantidadeDeFuncs"));
			float hsInicio = Float.parseFloat(request.getParameter("inputHoraInicio"));
			float hsFim = Float.parseFloat(request.getParameter("inputHoraFim"));
			float tempoEntrega = Float.parseFloat(request.getParameter("inputTempoEntrega"));
			int qtddPedidosHora = Integer.parseInt(request.getParameter("inputQuantidadeHora"));
			String diasFuncionamento = request.getParameter("inputDiasFuncionamento");
			System.out.println(parceiroCNPJ);
			
		
			
			
			Detalhe detalhe = new Detalhe(0, categoria, QtddFunc, hsInicio, hsFim, tempoEntrega,
					qtddPedidosHora, diasFuncionamento, parceiroCNPJ);
			dao.cadastrar(detalhe);
			
			request.setAttribute("msg", "Endereço cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.setAttribute("cnpjLoja", request.getParameter("inputCnpjLoja"));
		request.getRequestDispatcher("cardapio.jsp").forward(request, response);
	}
	
	
}
