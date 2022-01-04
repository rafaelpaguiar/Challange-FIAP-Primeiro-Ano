package br.com.ifood.chlg.dao;


import java.util.List;
import br.com.ifood.chlg.bean.Parceiro;
import br.com.ifood.chlg.exception.DBException;

public interface ParceiroDAO {
	
	void cadastrar(Parceiro parceiro) throws DBException;
	Parceiro buscar(double id);
	List<Parceiro> listar();
}