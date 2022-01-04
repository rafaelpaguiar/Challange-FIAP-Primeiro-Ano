package br.com.ifood.chlg.dao;


import java.util.List;
import br.com.ifood.chlg.bean.Cardapio;
import br.com.ifood.chlg.exception.DBException;

public interface CardapioDAO {
	
	void cadastrar(Cardapio cardapio) throws DBException;
	Cardapio buscar(int id);
	List<Cardapio> listar();
}