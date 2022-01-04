package br.com.ifood.chlg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifood.chlg.bean.Endereco;
import br.com.ifood.chlg.dao.EnderecoDAO;
import br.com.ifood.chlg.exception.DBException;
import br.com.ifood.chlg.singleton.ConnectionManager;

public class OracleEnderecoDAO implements EnderecoDAO {

	private Connection conexao;

	@Override
	public void cadastrar(Endereco endereco) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO ENDERECO (ENDERECO_ID, CEP, LOGRADOURO, NUMERO, CIDADE, ESTADO, COMPLEMENTO, REGIAO, IDLOJA) VALUES (SQ_ENDERECO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, endereco.getCep());
			stmt.setString(2, endereco.getLogradouro());
			stmt.setInt(3, endereco.getNumero());
			stmt.setString(4, endereco.getCidade());
			stmt.setString(5, endereco.getEstado());
			stmt.setString(6, endereco.getComplemento());
			stmt.setString(7, endereco.getRegiao());
			stmt.setInt(8, endereco.getIdLoja());
			System.out.println(endereco.getIdLoja());
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
	public Endereco buscar(int id) {
		Endereco endereco = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM ENDERECO WHERE ENDERECO_ID = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int idEndereco = rs.getInt("ENDERECO_ID");
				double cep = rs.getDouble("CEP");
				String logradouro = rs.getString("LOGRADOURO");
				int numero = rs.getInt("NUMERO");
				String cidade = rs.getString("CIDADE");
				String estado = rs.getString("ESTADO");
				String complemento = rs.getString("COMPLEMENTO");
				String regiao = rs.getString("REGIAO");
				int idLoja = rs.getInt("IDLOJA");

				endereco = new Endereco(idEndereco, cep, logradouro, numero, cidade, estado, complemento, regiao, idLoja);
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
		return endereco;
	}

	@Override
	public List<Endereco> listar() {
		List<Endereco> lista = new ArrayList<Endereco>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM ENDERECO");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados
			while (rs.next()) {
				int idEndereco = rs.getInt("ENDERECO_ID");
				double cep = rs.getDouble("CEP");
				String logradouro = rs.getString("LOGRADOURO");
				int numero = rs.getInt("NUMERO");
				String cidade = rs.getString("CIDADE");
				String estado = rs.getString("ESTADO");
				String complemento = rs.getString("COMPLEMENTO");
				String regiao = rs.getString("REGIAO");
				int idLoja = rs.getInt("IDLOJA");

				Endereco endereco = new Endereco(idEndereco, cep, logradouro, numero, cidade, estado, complemento, regiao, idLoja);
				lista.add(endereco);
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
