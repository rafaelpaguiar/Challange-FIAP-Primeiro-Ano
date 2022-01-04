package br.com.ifood.chlg.dao;


import java.util.List;
import br.com.ifood.chlg.bean.Endereco;
import br.com.ifood.chlg.exception.DBException;

public interface EnderecoDAO {
	
	void cadastrar(Endereco endereco) throws DBException;
	Endereco buscar(int id);
	List<Endereco> listar();
}