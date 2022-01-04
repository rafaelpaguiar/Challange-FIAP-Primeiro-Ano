package br.com.ifood.chlg.factory;

import br.com.ifood.chlg.dao.*;
import br.com.ifood.chlg.dao.impl.*;

public class DAOFactory {

	public static CadastroLojaDAO getCadastroLojaDAO() {
		return new OracleCadastroLojaDAO();
	}
	
	public static CardapioDAO getCardapioDAO() {
		return new OracleCardapioDAO();
	}
	
	public static DetalheDAO getDetalheDAO() {
		return new OracleDetalheDAO();
	}
	
	public static EnderecoDAO getEnderecoDAO() {
		return new OracleEnderecoDAO();
	}
	
	public static ParceiroDAO getParceiroDAO() {
		return new OracleParceiroDAO();
	}
	
	public static DashboardDAO getDashboardDAO() {
		return new OracleDashboardDAO();
	}
	
}