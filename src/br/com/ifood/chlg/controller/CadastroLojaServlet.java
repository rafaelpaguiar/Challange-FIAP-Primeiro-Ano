package br.com.ifood.chlg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifood.chlg.dao.CadastroLojaDAO;
import br.com.ifood.chlg.factory.DAOFactory;
import br.com.ifood.chlg.bean.CadastroLoja;
import br.com.ifood.chlg.exception.DBException;

/**
 * Servlet implementation class CadastroLojaServlet
 */
@WebServlet("/cadastroloja")
public class CadastroLojaServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private CadastroLojaDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getCadastroLojaDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CadastroLoja loja = null;
		try{
			String nomeCompleto = request.getParameter("inputNomeCompleto");
			String email = request.getParameter("inputEmail");
			String celular = request.getParameter("inputCelular");
			
			
			loja = new CadastroLoja(0, nomeCompleto, email, celular); 
			loja = dao.cadastrar(loja);
						
			request.setAttribute("msg", "Produto cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.setAttribute("idLoja", loja.getIdCadastroloja());
		request.getRequestDispatcher("endereco.jsp").forward(request, response);	
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<CadastroLoja> lista = dao.listar();
			request.setAttribute("listaDeLojas", lista);
			request.getRequestDispatcher("lista-lojas.jsp").forward(request, response);	
	}

}
