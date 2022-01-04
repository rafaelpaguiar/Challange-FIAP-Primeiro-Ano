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

public class Detalhe {
	int idDetalhe;
	String Categoria;
	int QtddFunc;
	float hsInicio;
	float hsFim;
	float tempoEntrega;
	int qtddPedidosHora;
	String diasFuncionamento;
	double parceiroCNPJ;

	/**
	 * 
	 */
	public Detalhe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Detalhe(int idDetalhe, String categoria, int qtddFunc, float hsInicio, float hsFim, float tempoEntrega,
			int qtddPedidosHora, String diasFuncionamento, double parceiroCNPJ) {
		super();
		this.idDetalhe = idDetalhe;
		this.Categoria = categoria;
		this.QtddFunc = qtddFunc;
		this.hsInicio = hsInicio;
		this.hsFim = hsFim;
		this.tempoEntrega = tempoEntrega;
		this.qtddPedidosHora = qtddPedidosHora;
		this.diasFuncionamento = diasFuncionamento;
		this.parceiroCNPJ = parceiroCNPJ;
	}

	public int getIdDetalhe() {
		return idDetalhe;
	}

	public void setIdDetalhe(int idDetalhe) {
		this.idDetalhe = idDetalhe;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategora(String categoria) {
		Categoria = categoria;
	}

	public int getQtddFunc() {
		return QtddFunc;
	}

	public void setQtddFunc(int qtddFunc) {
		QtddFunc = qtddFunc;
	}

	public float getHsInicio() {
		return hsInicio;
	}

	public void setHsInicio(float hsInicio) {
		this.hsInicio = hsInicio;
	}

	public float getHsFim() {
		return hsFim;
	}

	public void setHsFim(float hsFim) {
		this.hsFim = hsFim;
	}

	public float getTempoEntrega() {
		return tempoEntrega;
	}

	public void setTempoEntrega(float tempoEntrega) {
		this.tempoEntrega = tempoEntrega;
	}

	public int getQtddPedidosHora() {
		return qtddPedidosHora;
	}

	public void setQtddPedidosHora(int qtddPedidosHora) {
		this.qtddPedidosHora = qtddPedidosHora;
	}

	public String getDiasFuncionamento() {
		return diasFuncionamento;
	}

	public void setDiasFuncionamento(String diasFuncionamento) {
		this.diasFuncionamento = diasFuncionamento;
	}

	public double getParceiroCNPJ() {
		return parceiroCNPJ;
	}

	public void setParceiroCNPJ(double parceiroCNPJ) {
		this.parceiroCNPJ = parceiroCNPJ;
	}

}
