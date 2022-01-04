package br.com.ifood.chlg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifood.chlg.bean.Endereco;
import br.com.ifood.chlg.dao.EnderecoDAO;
import br.com.ifood.chlg.exception.DBException;
import br.com.ifood.chlg.factory.DAOFactory;

/**
 * Servlet implementation class EnderecoServlet
 */
@WebServlet("/endereco")
public class EnderecoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private EnderecoDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getEnderecoDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			float cep = Float.parseFloat(request.getParameter("inputCEP"));
			String logradouro = request.getParameter("inputLogradouro");
			int numero = Integer.parseInt(request.getParameter("inputNumero"));
			String cidade = request.getParameter("inputCidade");
			String estado = request.getParameter("inputEstado");
			String complemento = request.getParameter("inputComplemento");
			String regiao = request.getParameter("inputRegiao");
			int idLoja = Integer.parseInt(request.getParameter("inputIdLoja"));
			
			
			Endereco endereco = new Endereco(0, cep, logradouro, numero, cidade, estado, complemento, regiao, idLoja);
			dao.cadastrar(endereco);
			
			request.setAttribute("msg", "Endereço cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.setAttribute("idLoja", request.getParameter("inputIdLoja"));
		request.getRequestDispatcher("parceiro.jsp").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Endereco> lista = dao.listar();
			request.setAttribute("listaDeEnderecos", lista);
			request.getRequestDispatcher("lista-endereco.jsp").forward(request, response);	
	}

}
