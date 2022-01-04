package br.com.ifood.chlg.dao;


import java.util.List;
import br.com.ifood.chlg.bean.CadastroLoja;
import br.com.ifood.chlg.exception.DBException;

public interface CadastroLojaDAO {
	
	CadastroLoja cadastrar(CadastroLoja cadastroLoja) throws DBException;
	CadastroLoja buscar(int id);
	List<CadastroLoja> listar();
}