package br.com.ifood.chlg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifood.chlg.bean.CadastroLoja;
import br.com.ifood.chlg.dao.CadastroLojaDAO;
import br.com.ifood.chlg.exception.DBException;
import br.com.ifood.chlg.singleton.ConnectionManager;

public class OracleCadastroLojaDAO implements CadastroLojaDAO {

	private Connection conexao;

	@Override
	public CadastroLoja cadastrar(CadastroLoja cadastroLoja) throws DBException {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO CADASTRO_LOJA (IDLOJA, NMCOMPLETO, CELULAR, EMAIL) VALUES (SQ_CADASTRO_LOJA.NEXTVAL, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cadastroLoja.getNomeCompleto());
			stmt.setString(2, cadastroLoja.getCelular());
			stmt.setString(3, cadastroLoja.getEmail());
			System.out.println();
			stmt.executeUpdate();

			stmt = conexao.prepareStatement("SELECT * FROM CADASTRO_LOJA WHERE NMCOMPLETO = ?");
			stmt.setString(1, cadastroLoja.getNomeCompleto());
			rs = stmt.executeQuery();

			if (rs.next()) {
				int idCadastroLoja = rs.getInt("IDLOJA");
				String nmCompleto = rs.getString("NMCOMPLETO");
				String celular = rs.getString("CELULAR");
				String email = rs.getString("EMAIL");

				cadastroLoja = new CadastroLoja(idCadastroLoja, nmCompleto, email, celular);

				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastradar.");
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cadastroLoja;
	}

	@Override
	public CadastroLoja buscar(int id) {
		CadastroLoja cadastroLoja = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM CADASTRO_LOJA WHERE IDLOJA = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int idCadastroLoja = rs.getInt("IDLOJA");
				String nmCompleto = rs.getString("NMCOMPLETO");
				String celular = rs.getString("CELULAR");
				String email = rs.getString("EMAIL");

				cadastroLoja = new CadastroLoja(idCadastroLoja, nmCompleto, email, celular);
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
		return cadastroLoja;
	}

	@Override
	public List<CadastroLoja> listar() {
		List<CadastroLoja> lista = new ArrayList<CadastroLoja>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM CADASTRO_LOJA");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados
			while (rs.next()) {
				int idCadastroLoja = rs.getInt("IDLOJA");
				String nmCompleto = rs.getString("NMCOMPLETO");
				String celular = rs.getString("CELULAR");
				String email = rs.getString("EMAIL");

				CadastroLoja cadastroLoja = new CadastroLoja(idCadastroLoja, nmCompleto, email, celular);
				lista.add(cadastroLoja);
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