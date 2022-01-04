package br.com.ifood.chlg.teste;

import java.text.ParseException;
import java.util.List;

import br.com.ifood.chlg.exception.DBException;
import br.com.ifood.chlg.factory.DAOFactory;
import br.com.ifood.chlg.bean.Endereco;
import br.com.ifood.chlg.dao.EnderecoDAO;


public class TesteEnderecoDAO {

	public static void main(String[] args) throws ParseException {
		
		EnderecoDAO dao = DAOFactory.getEnderecoDAO();
		
		//Cadastrar uma loja
				Endereco endereco = new Endereco(0, 09999333d, "Rua Vinte e Oito de Janeiro", 354, "São Paulo", "SP", "", "Zona Norte", 55);
				try {
					dao.cadastrar(endereco);
					System.out.println("Endereço cadastrado.");
				} catch (DBException e) {
					e.printStackTrace();
				}

				//Listar as lojas
				List<Endereco> lista = dao.listar();
				for (Endereco endereco2 : lista) {
					System.out.println(endereco2.getIdEndereco() + " " + endereco2.getCep() + " " + endereco2.getLogradouro() + " " + endereco2.getNumero() + " " + endereco2.getCidade() + " " + endereco2.getIdEndereco() + " " + endereco2.getComplemento() + " " + endereco2.getRegiao() + " " + endereco2.getIdLoja());
				}
				
				//Buscar uma loja pelo código
				endereco = dao.buscar(56);
				System.out.println("-------------------------");
				System.out.println(endereco.getIdEndereco() + " " + endereco.getCep() + " " + endereco.getLogradouro() + " " + endereco.getNumero() + " " + endereco.getCidade() + " " + endereco.getIdEndereco() + " " + endereco.getComplemento() + " " + endereco.getRegiao() + " " + endereco.getIdLoja());
				

	}

}
