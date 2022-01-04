package br.com.ifood.chlg.teste;

import java.text.ParseException;
import java.util.List;

import br.com.ifood.chlg.factory.DAOFactory;
import br.com.ifood.chlg.bean.Dashboard;
import br.com.ifood.chlg.dao.DashboardDAO;


public class TesteDashboardDAO {

	public static void main(String[] args) throws ParseException {
		
		DashboardDAO dao = DAOFactory.getDashboardDAO();
		
		

				//Listar as lojas
				List<Dashboard> lista = dao.listar();
				for (Dashboard linha : lista) {
					System.out.println(linha.toString());
				}
				
				

	}

}
