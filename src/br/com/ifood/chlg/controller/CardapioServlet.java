package br.com.ifood.chlg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifood.chlg.bean.Cardapio;
import br.com.ifood.chlg.bean.Parceiro;
import br.com.ifood.chlg.dao.CardapioDAO;
import br.com.ifood.chlg.dao.ParceiroDAO;
import br.com.ifood.chlg.exception.DBException;
import br.com.ifood.chlg.factory.DAOFactory;

/**
 * Servlet implementation class ParceiroServlet
 */
@WebServlet("/cardapio")
public class CardapioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private CardapioDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getCardapioDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
			String dsAlimento = request.getParameter("inputAlimento");
			String tipoAlimento = request.getParameter("inputTipoAlimento");
			float valorUnit = Float.parseFloat(request.getParameter("inputValorUnitario"));
			float unidadeMedida = Float.parseFloat(request.getParameter("inputUnidadeMedida"));
			float idLoja = Float.parseFloat(request.getParameter("inputIdLoja"));
			System.out.println("Sysout do CardapioServlet" + idLoja);
			
			
			Cardapio cardapio = new Cardapio(0, dsAlimento, tipoAlimento, valorUnit, unidadeMedida, idLoja);
			dao.cadastrar(cardapio);
			
			request.setAttribute("msg", "Endereço cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.setAttribute("cnpjLoja", request.getParameter("inputIdLoja"));
		System.out.println(request.getParameter("inputIdLoja"));
		request.getRequestDispatcher("cardapio.jsp").forward(request, response);
	}
	
	
}
