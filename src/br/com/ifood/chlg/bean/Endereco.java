package br.com.ifood.chlg.bean;

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

public class Endereco {

	int idEndereco;
	double cep;
	String logradouro;
	int numero;
	String cidade;
	String estado;
	String complemento;
	String regiao;
	int idLoja;

	/**
	 * 
	 */
	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idEndereco
	 * @param cep
	 * @param logradouro
	 * @param numero
	 * @param cidade
	 * @param estado
	 * @param complemento
	 * @param regiao
	 */
	public Endereco(int idEndereco, double cep, String logradouro, int numero, String cidade, String estado,
			String complemento, String regiao, int idLoja) {
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
		this.regiao = regiao;
		this.idLoja = idLoja;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public double getCep() {
		return cep;
	}

	public void setCep(double cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public int getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(int idLoja) {
		this.idLoja = idLoja;
	}
	
	

}
