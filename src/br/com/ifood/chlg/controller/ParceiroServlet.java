package br.com.ifood.chlg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifood.chlg.bean.Parceiro;
import br.com.ifood.chlg.dao.ParceiroDAO;
import br.com.ifood.chlg.exception.DBException;
import br.com.ifood.chlg.factory.DAOFactory;

/**
 * Servlet implementation class ParceiroServlet
 */
@WebServlet("/parceiro")
public class ParceiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private ParceiroDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getParceiroDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			float cnpj = Float.parseFloat(request.getParameter("inputNomeCNPJ"));
			String razaoSocial = request.getParameter("inputRazaoSocial");
			String nomeFantasia = request.getParameter("inputNomeFantasia");
			String emailDaLoja = request.getParameter("inputEmailDaLoja");
			String categoria = request.getParameter("inputCategoria");
			int idLoja = Integer.parseInt(request.getParameter("inputIdLoja"));
			System.out.println(cnpj);
			
			Parceiro parceiro = new Parceiro(cnpj, razaoSocial, nomeFantasia, emailDaLoja, idLoja, categoria);
			dao.cadastrar(parceiro);
			
			request.setAttribute("msg", "Endereço cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.setAttribute("cnpjLoja", request.getParameter("inputNomeCNPJ"));
		request.getRequestDispatcher("detalhe.jsp").forward(request, response);
	}
	
	
}
