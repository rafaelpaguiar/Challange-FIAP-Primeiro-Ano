package br.com.ifood.chlg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifood.chlg.bean.Detalhe;
import br.com.ifood.chlg.dao.DetalheDAO;
import br.com.ifood.chlg.exception.DBException;
import br.com.ifood.chlg.singleton.ConnectionManager;

public class OracleDetalheDAO implements DetalheDAO {
	private Connection conexao;
	
	@Override
	public void cadastrar(Detalhe detalhe) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO DETALHE (ID_DETALHE, CATEGORIA, QTDDFUNC, HSINICIO, HSFIM, TEMPOENTREGA, QTDDPEDIDOHORA, DIASFUNCSEMANA, PARCEIRO_CNPJ) VALUES (SQ_DETALHE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, detalhe.getCategoria());
			stmt.setInt(2, detalhe.getQtddFunc());
			stmt.setFloat(3, detalhe.getHsInicio());
			stmt.setFloat(4, detalhe.getHsFim());
			stmt.setFloat(5, detalhe.getTempoEntrega());
			stmt.setInt(6, detalhe.getQtddPedidosHora());
			stmt.setString(7, detalhe.getDiasFuncionamento());
			stmt.setDouble(8, detalhe.getParceiroCNPJ());
			System.out.println();
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastradar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Detalhe buscar(int id) {
		Detalhe detalhe = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM DETALHE WHERE ID_DETALHE = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()){
				int idDetalhe = rs.getInt("ID_DETALHE");
				String categoria = rs.getString("CATEGORIA");
				int QtddFunc= rs.getInt("QTDDFUNC");
				float hsInicio = rs.getFloat("HSINICIO");
				float hsFim = rs.getFloat("HSFIM");
				float tempoEntrega = rs.getFloat("TEMPOENTREGA");
				int qtddPedidosHora = rs.getInt("QTDDPEDIDOHORA");
				String diasFuncionamento = rs.getString("DIASFUNCSEMANA");
				double parceiroCNPJ = rs.getDouble("PARCEIRO_CNPJ");

				detalhe = new Detalhe(idDetalhe, categoria, QtddFunc, hsInicio, hsFim, tempoEntrega,
						qtddPedidosHora, diasFuncionamento, parceiroCNPJ);
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
		return detalhe;
	}

	@Override
	public List<Detalhe> listar() {
		List<Detalhe> lista = new ArrayList<Detalhe>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM DETALHE");
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int idDetalhe = rs.getInt("ID_DETALHE");
				String categoria = rs.getString("CATEGORIA");
				int QtddFunc= rs.getInt("QTDDFUNC");
				float hsInicio = rs.getFloat("HSINICIO");
				float hsFim = rs.getFloat("HSFIM");
				float tempoEntrega = rs.getFloat("TEMPOENTREGA");
				int qtddPedidosHora = rs.getInt("QTDDPEDIDOHORA");
				String diasFuncionamento = rs.getString("DIASFUNCSEMANA");
				double parceiroCNPJ = rs.getDouble("PARCEIRO_CNPJ");

				Detalhe detalhe = new Detalhe(idDetalhe, categoria, QtddFunc, hsInicio, hsFim, tempoEntrega,
						qtddPedidosHora, diasFuncionamento, parceiroCNPJ);
				lista.add(detalhe);
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
