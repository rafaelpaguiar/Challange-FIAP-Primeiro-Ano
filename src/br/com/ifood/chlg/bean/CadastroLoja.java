package br.com.ifood.chlg.bean;

import java.io.Serializable;

/**
 * 
 * @author Caian Henrique Nunes França - caianhnf2@hotmail.com
 * @author Caroline Maki Nagata - caroline.nagata@gmail.com
 * @author Cilene Alves Silva - eusouaci@yahoo.com.br
 * @author Rafael Pereira de Aguiar - rafaelpaguiar@gmail.com
 * @author Vinícius Paschoalin Campos de Castro -
 *         vinicius.castro@eldoradobrasil.com.br
 * @version 1.0
 */

public class CadastroLoja implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int idCadastroloja;
	String nomeCompleto;
	String email;
	String celular;

	/**
	 * 
	 */
	public CadastroLoja() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idCadastroloja
	 * @param nomeCompleto
	 * @param email
	 * @param celular
	 */
	public CadastroLoja(int idCadastroloja, String nomeCompleto, String email, String celular) {
		this.idCadastroloja = idCadastroloja;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.celular = celular;
	}

	public int getIdCadastroloja() {
		return idCadastroloja;
	}

	public void setIdCadastroloja(int idCadastroloja) {
		this.idCadastroloja = idCadastroloja;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

}
