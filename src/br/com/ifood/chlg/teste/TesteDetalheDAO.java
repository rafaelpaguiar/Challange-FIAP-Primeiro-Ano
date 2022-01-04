package br.com.ifood.chlg.teste;

import java.text.ParseException;
import java.util.List;

import br.com.ifood.chlg.exception.DBException;
import br.com.ifood.chlg.factory.DAOFactory;
import br.com.ifood.chlg.bean.Detalhe;
import br.com.ifood.chlg.dao.DetalheDAO;


public class TesteDetalheDAO {

	public static void main(String[] args) throws ParseException {
		
		DetalheDAO dao = DAOFactory.getDetalheDAO();
		
		//Cadastrar uma loja
				Detalhe detalhe = new Detalhe(0, "Boteco", 3, 14f, 22f, 1f, 10, "De Segunda à Domingo", 44498558000115d);
//				try {
//					dao.cadastrar(detalhe);
//					System.out.println("Detalhe cadastrado.");
//				} catch (DBException e) {
//					e.printStackTrace();
//				}

				//Listar as lojas
				List<Detalhe> lista = dao.listar();
				for (Detalhe detalhe2 : lista) {
					System.out.println(detalhe2.getIdDetalhe() + " " + detalhe2.getCategoria() + " " + detalhe2.getQtddFunc() + " " + detalhe2.getHsInicio() + " " + detalhe2.getHsFim() + " " + detalhe2.getTempoEntrega() + " " + detalhe2.getQtddPedidosHora() + " " + detalhe2.getDiasFuncionamento() + " " + detalhe2.getParceiroCNPJ());
				}
				
				//Buscar uma loja pelo código
				detalhe = dao.buscar(3);
				System.out.println("-------------------------");
				System.out.println(detalhe.getIdDetalhe() + " " + detalhe.getCategoria() + " " + detalhe.getQtddFunc() + " " + detalhe.getHsInicio() + " " + detalhe.getHsFim() + " " + detalhe.getTempoEntrega() + " " + detalhe.getQtddPedidosHora() + " " + detalhe.getDiasFuncionamento() + " " + detalhe.getParceiroCNPJ());
				

	}

}
