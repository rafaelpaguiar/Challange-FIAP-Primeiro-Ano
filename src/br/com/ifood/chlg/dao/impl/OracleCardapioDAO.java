package br.com.ifood.chlg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifood.chlg.bean.Cardapio;
import br.com.ifood.chlg.dao.CardapioDAO;
import br.com.ifood.chlg.exception.DBException;
import br.com.ifood.chlg.singleton.ConnectionManager;

public class OracleCardapioDAO implements CardapioDAO {

	private Connection conexao;

	@Override
	public void cadastrar(Cardapio cardapio) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO CARDAPIO (IDALIMENTO, DSALIMENTO, TIPOALIMENTO, VALORUNIT, UNIDADEMEDIDA, CNPJ_LOJA) VALUES (SQ_CARDAPIO.NEXTVAL, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cardapio.getDsAlimento());
			stmt.setString(2, cardapio.getTipoAlimento());
			stmt.setFloat(3, cardapio.getValorUnit());
			stmt.setFloat(4, cardapio.getUnidadeMedida());
			stmt.setDouble(5, cardapio.getIdLoja());

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
	public Cardapio buscar(int id) {
		Cardapio cardapio = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM CARDAPIO WHERE IDALIMENTO = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {

				int idAlimento = rs.getInt("IDALIMENTO");
				String dsAlimento = rs.getString("DSALIMENTO");
				String tipoAlimento = rs.getString("TIPOALIMENTO");
				float valorUnit = rs.getFloat("VALORUNIT");
				float unidadeMedida = rs.getFloat("UNIDADEMEDIDA");
				double idLoja = rs.getDouble("CNPJ_LOJA");

				cardapio = new Cardapio(idAlimento, dsAlimento, tipoAlimento, valorUnit, unidadeMedida, idLoja);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cardapio;
	}

	@Override
	public List<Cardapio> listar() {
		List<Cardapio> lista = new ArrayList<Cardapio>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM CARDAPIO");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados
			while (rs.next()) {
				int idAlimento = rs.getInt("IDALIMENTO");
				String dsAlimento = rs.getString("DSALIMENTO");
				String tipoAlimento = rs.getString("TIPOALIMENTO");
				float valorUnit = rs.getFloat("VALORUNIT");
				float unidadeMedida = rs.getFloat("UNIDADEMEDIDA");
				float idLoja = rs.getFloat("CNPJ_LOJA");

				Cardapio cardapio = new Cardapio(idAlimento, dsAlimento, tipoAlimento, valorUnit, unidadeMedida, idLoja);

				lista.add(cardapio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
