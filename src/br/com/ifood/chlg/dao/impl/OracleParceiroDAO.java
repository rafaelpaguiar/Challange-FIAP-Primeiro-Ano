package br.com.ifood.chlg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifood.chlg.bean.Parceiro;
import br.com.ifood.chlg.dao.ParceiroDAO;
import br.com.ifood.chlg.exception.DBException;
import br.com.ifood.chlg.singleton.ConnectionManager;

public class OracleParceiroDAO implements ParceiroDAO {
	
	private Connection conexao;

	@Override
	public void cadastrar(Parceiro parceiro) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO PARCEIRO (CNPJ, RAZAOSOCIAL, NMFANTASIA, CADASTRO_LOJA_EMAIL, IDLOJA, CATEGORIA) VALUES (?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1, parceiro.getCnpj());
			stmt.setString(2, parceiro.getRazaoSocial());
			stmt.setString(3, parceiro.getNomeFantasia());
			stmt.setString(4, parceiro.getLojaEmail());
			stmt.setInt(5, parceiro.getIdLoja());
			stmt.setString(6, parceiro.getCategoria());
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
	public Parceiro buscar(double id) {
		Parceiro parceiro = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM PARCEIRO WHERE CNPJ = ?");
			stmt.setDouble(1, id);
			rs = stmt.executeQuery();

			if (rs.next()){
				double cnpj = rs.getDouble("CNPJ");
				String razaoSocial = rs.getString("RAZAOSOCIAL");
				String nomeFantasia = rs.getString("NMFANTASIA");
				String lojaEmail = rs.getString("CADASTRO_LOJA_EMAIL");
				int idLoja = rs.getInt("IDLOJA");
				String categoria = rs.getString("CATEGORIA");
				
				parceiro = new Parceiro(cnpj, razaoSocial, nomeFantasia, lojaEmail, idLoja, categoria);
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
		return parceiro;
	}

	@Override
	public List<Parceiro> listar() {
		List<Parceiro> lista = new ArrayList<Parceiro>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM PARCEIRO");
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				double cnpj = rs.getDouble("CNPJ");
				String razaoSocial = rs.getString("RAZAOSOCIAL");
				String nomeFantasia = rs.getString("NMFANTASIA");
				String lojaEmail = rs.getString("CADASTRO_LOJA_EMAIL");
				int idLoja = rs.getInt("IDLOJA");
				String categoria = rs.getString("CATEGORIA");
				
				 Parceiro parceiro = new Parceiro(cnpj, razaoSocial, nomeFantasia, lojaEmail, idLoja, categoria);
				lista.add(parceiro);
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
