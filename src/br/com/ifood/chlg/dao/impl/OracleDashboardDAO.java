package br.com.ifood.chlg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifood.chlg.bean.Dashboard;
import br.com.ifood.chlg.dao.DashboardDAO;
import br.com.ifood.chlg.singleton.ConnectionManager;

public class OracleDashboardDAO implements DashboardDAO {
	
	private Connection conexao;

	@Override
	public List<Dashboard> listar() {
		List<Dashboard> lista = new ArrayList<Dashboard>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT DISTINCT\r\n"
					+ "    cadastro_loja.idloja     AS idloja,\r\n"
					+ "    parceiro.cnpj            AS cnpj,\r\n"
					+ "    endereco.cidade          AS cidade,\r\n"
					+ "    detalhe.qtddpedidohora   AS qtddpedidohora,\r\n"
					+ "    cardapio.dsalimento      AS dsalimento,\r\n"
					+ "    parceiro.categoria       AS categoria,\r\n"
					+ "    endereco.regiao          AS regiao,\r\n"
					+ "    detalhe.qtddfunc         AS qtddfunc,\r\n"
					+ "    parceiro.nmfantasia      AS nmfantasia,\r\n"
					+ "    cadastro_loja.nmcompleto AS nmcompleto\r\n"
					+ "FROM\r\n"
					+ "    cadastro_loja,\r\n"
					+ "    parceiro,\r\n"
					+ "    endereco,\r\n"
					+ "    detalhe,\r\n"
					+ "    cardapio\r\n"
					+ "WHERE\r\n"
					+ "        cadastro_loja.idloja = parceiro.idloja (+)\r\n"
					+ "    AND parceiro.idloja = endereco.idloja (+)\r\n"
					+ "    AND parceiro.cnpj = detalhe.parceiro_cnpj (+)\r\n"
					+ "    AND cardapio.cnpj_loja (+) = detalhe.parceiro_cnpj");
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int idDashboard = rs.getInt("idloja");
				float cnpj = rs.getFloat("cnpj");
				String nomefantasia =rs.getString("nmfantasia");
				String parceiro = rs.getString("nmcompleto");
				String categoria = rs.getString("categoria");
				String cidade = rs.getString("cidade");
				String regiao = rs.getString("regiao");
				int qntDefuncs = rs.getInt("qtddfunc");
				int pedidosPorHora  = rs.getInt("qtddpedidohora");
				String pratoMaisVendido = rs.getString("dsalimento");
				
				 Dashboard dashboard = new Dashboard(idDashboard, cnpj, nomefantasia, parceiro, categoria, cidade, regiao, qntDefuncs, pedidosPorHora, pratoMaisVendido);
				lista.add(dashboard);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

}
