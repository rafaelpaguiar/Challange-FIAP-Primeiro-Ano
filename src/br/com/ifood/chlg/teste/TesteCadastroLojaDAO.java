package br.com.ifood.chlg.teste;

import java.text.ParseException;
import java.util.List;

import br.com.ifood.chlg.exception.DBException;
import br.com.ifood.chlg.factory.DAOFactory;
import br.com.ifood.chlg.bean.CadastroLoja;
import br.com.ifood.chlg.dao.CadastroLojaDAO;


public class TesteCadastroLojaDAO {

	public static void main(String[] args) throws ParseException {
		
		CadastroLojaDAO dao = DAOFactory.getCadastroLojaDAO();
		
		//Cadastrar uma loja
				CadastroLoja cadastroLoja = new CadastroLoja(0, "Bar do Zé", "bardoze@gmail.com", "91111-1111");
				try {
					dao.cadastrar(cadastroLoja);
					System.out.println("Loja cadastrada.");
				} catch (DBException e) {
					e.printStackTrace();
				}

				//Listar as lojas
				List<CadastroLoja> lista = dao.listar();
				for (CadastroLoja loja : lista) {
					System.out.println(loja.getIdCadastroloja() + " " + loja.getNomeCompleto() + " " + loja.getEmail() + " " + loja.getCelular());
				}
				
				//Buscar uma loja pelo código
				cadastroLoja = dao.buscar(6);
				System.out.println("-------------------------");
				System.out.println(cadastroLoja.getIdCadastroloja() + " " + cadastroLoja.getNomeCompleto() + " " + cadastroLoja.getEmail() + " " + cadastroLoja.getCelular());
				

	}

}
