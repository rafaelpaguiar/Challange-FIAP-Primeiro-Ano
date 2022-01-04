package br.com.ifood.chlg.teste;

import java.text.ParseException;
import java.util.List;

import br.com.ifood.chlg.exception.DBException;
import br.com.ifood.chlg.factory.DAOFactory;
import br.com.ifood.chlg.bean.Cardapio;
import br.com.ifood.chlg.dao.CardapioDAO;

public class TesteCardapioDAO {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		CardapioDAO dao = DAOFactory.getCardapioDAO();

		// Cadastrar uma loja

		Cardapio cardapio = new Cardapio(0, "Torresminho", "Salgado", 55.5f, 100.1f, 66567065000121f);
		try {
			dao.cadastrar(cardapio);
			System.out.println("Cardapio cadastrado.");
		} catch (DBException e) {
			e.printStackTrace();
		}

		// Listar as lojas
		List<Cardapio> lista = dao.listar();
		for (Cardapio item : lista) {
			System.out.println(item.getIdAlimento() + " " + item.getDsAlimento() + " " + item.getTipoAlimento() + " "
					+ item.getValorUnit() + " " + item.getUnidadeMedida() +  " "
					+ item.getIdLoja());
		}

		// Buscar uma loja pelo código
				Cardapio item = dao.buscar(14);
				System.out.println("-------------------------");
				System.out.println(item.getIdAlimento() + " " + item.getDsAlimento() + " " + item.getTipoAlimento() + " "
						+ item.getValorUnit() + " " + item.getUnidadeMedida() + " " 
						+  String.format("%.2f",item.getIdLoja()));

	}

}
