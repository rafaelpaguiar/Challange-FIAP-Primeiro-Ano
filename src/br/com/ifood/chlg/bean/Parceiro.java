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

public class Parceiro {

	double cnpj;
	String razaoSocial;
	String nomeFantasia;
	String lojaEmail;
	int idLoja;
	String categoria;

	/**
	 * 
	 */
	public Parceiro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cnpj
	 * @param razaoSocial
	 * @param nomeFantasia
	 * @param categoria
	 */
	public Parceiro(double cnpj, String razaoSocial, String nomeFantasia, String lojaEmail, int idLoja, String categoria) {
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.lojaEmail = lojaEmail;
		this.idLoja = idLoja;
		this.categoria = categoria;
	}
	

	public double getCnpj() {
		return cnpj;
	}

	public void setCnpj(double cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getLojaEmail() {
		return lojaEmail;
	}

	public void setLojaEmail(String lojaEmail) {
		this.lojaEmail = lojaEmail;
	}
	
	public int getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(int idLoja) {
		this.idLoja = idLoja;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
