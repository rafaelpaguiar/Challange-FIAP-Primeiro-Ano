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

public class Dashboard {

	int idDashboard;
	float cnpj;
	String nomefantasia;
	String parceiro;
	String categoria;
	String cidade;
	String regiao;
	int qntDefuncs;
	int pedidosPorHora;
	String pratoMaisVendido;

	public Dashboard() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Dashboard(int idDashboard, float cnpj, String nomefantasia, String parceiro, String categoria, String cidade,
			String regiao, int qntDefuncs, int pedidosPorHora, String pratoMaisVendido) {
		super();
		this.idDashboard = idDashboard;
		this.cnpj = cnpj;
		this.nomefantasia = nomefantasia;
		this.parceiro = parceiro;
		this.categoria = categoria;
		this.cidade = cidade;
		this.regiao = regiao;
		this.qntDefuncs = qntDefuncs;
		this.pedidosPorHora = pedidosPorHora;
		this.pratoMaisVendido = pratoMaisVendido;
	}

	
	public int getIdDashboard() {
		return idDashboard;
	}


	public void setIdDashboard(int idDashboard) {
		this.idDashboard = idDashboard;
	}


	public float getCnpj() {
		return cnpj;
	}


	public void setCnpj(float cnpj) {
		this.cnpj = cnpj;
	}


	public String getNomefantasia() {
		return nomefantasia;
	}

	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}

	public String getParceiro() {
		return parceiro;
	}

	public void setParceiro(String parceiro) {
		this.parceiro = parceiro;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public int getQntDefuncs() {
		return qntDefuncs;
	}

	public void setQntDefuncs(int qntDefuncs) {
		this.qntDefuncs = qntDefuncs;
	}

	public int getPedidosPorHora() {
		return pedidosPorHora;
	}

	public void setPedidosPorHora(int pedidosPorHora) {
		this.pedidosPorHora = pedidosPorHora;
	}


	public String getPratoMaisVendido() {
		return pratoMaisVendido;
	}


	public void setPratoMaisVendido(String pratoMaisVendido) {
		this.pratoMaisVendido = pratoMaisVendido;
	}

	

}
