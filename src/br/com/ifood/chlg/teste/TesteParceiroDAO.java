package br.com.ifood.chlg.teste;

import java.text.ParseException;
import java.util.List;

import br.com.ifood.chlg.exception.DBException;
import br.com.ifood.chlg.factory.DAOFactory;
import br.com.ifood.chlg.bean.Parceiro;
import br.com.ifood.chlg.dao.ParceiroDAO;


public class TesteParceiroDAO {

	public static void main(String[] args) throws ParseException {
		
		ParceiroDAO dao = DAOFactory.getParceiroDAO();
		
		//Cadastrar uma loja
				Parceiro parceiro = new Parceiro(44498558000115d, "BAR E LANCHES GRACIOSA", "Bar do Zé", "bardoze@gmail.com", 6, "Boteco");
				try {
					dao.cadastrar(parceiro);
					System.out.println("Parceiro cadastrado.");
				} catch (DBException e) {
					e.printStackTrace();
				}

				//Listar as lojas
				List<Parceiro> lista = dao.listar();
				for (Parceiro parceiro2 : lista) {
					System.out.println(parceiro2.getCnpj() + " " + parceiro2.getRazaoSocial() + " " + parceiro2.getNomeFantasia() + " " + parceiro2.getLojaEmail() + " " + parceiro2.getIdLoja() + " " + parceiro2.getCategoria());
				}
				
				//Buscar uma loja pelo código
				parceiro = dao.buscar(44498558000114d);
				System.out.println("-------------------------");
				System.out.println(parceiro.getCnpj() + " " + parceiro.getRazaoSocial() + " " + parceiro.getNomeFantasia() + " " + parceiro.getLojaEmail() + " " + parceiro.getIdLoja() + " " + parceiro.getCategoria());
				

	}

}
