package br.com.ifood.chlg.dao;


import java.util.List;
import br.com.ifood.chlg.bean.Detalhe;
import br.com.ifood.chlg.exception.DBException;

public interface DetalheDAO {
	
	void cadastrar(Detalhe detalhe) throws DBException;
	Detalhe buscar(int id);
	List<Detalhe> listar();
}