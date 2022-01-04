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

public class Cardapio {

	int idAlimento;
	String dsAlimento;
	String tipoAlimento;
	float valorUnit;
	float unidadeMedida;
	double idLoja;

	/**
	 * 
	 */
	public Cardapio() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idAlimento
	 * @param dsALimento
	 * @param tipoAlimento
	 * @param valorUnit
	 * @param unidadeMedida
	 * * @param idLoja
	 */
	public Cardapio(int idAlimento, String dsAlimento, String tipoAlimento, float valorUnit, float unidadeMedida, double idLoja) {
		super();
		this.idAlimento = idAlimento;
		this.dsAlimento = dsAlimento;
		this.tipoAlimento = tipoAlimento;
		this.valorUnit = valorUnit;
		this.unidadeMedida = unidadeMedida;
		this.idLoja = idLoja;
	}

	public int getIdAlimento() {
		return idAlimento;
	}

	public void setIdAlimento(int idAlimento) {
		this.idAlimento = idAlimento;
	}

	public String getDsAlimento() {
		return dsAlimento;
	}

	public void setDsAlimento(String dsAlimento) {
		this.dsAlimento = dsAlimento;
	}

	public String getTipoAlimento() {
		return tipoAlimento;
	}

	public void setTipoAlimento(String tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
	}

	public float getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(float valorUnit) {
		this.valorUnit = valorUnit;
	}

	public float getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(float unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public double getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(double idLoja) {
		this.idLoja = idLoja;
	}

}
