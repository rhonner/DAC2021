package br.com.ufpr.dac.persistence;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "pagamento")
public class Pagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "datapagamento")
	private Timestamp datapagamento;
	@Column(name = "atrasodias")
	private int atrasodias;
	@Column(name = "valor")
	private float valor;
	
	@OneToOne
	@JoinColumn(name = "idmulta")
	private Multa multa;
	
	public Pagamento() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDatapagamento() {
		return datapagamento;
	}

	public void setDatapagamento(Timestamp datapagamento) {
		this.datapagamento = datapagamento;
	}

	public int getAtrasodias() {
		return atrasodias;
	}

	public void setAtrasodias(int atrasodias) {
		this.atrasodias = atrasodias;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Multa getMulta() {
		return multa;
	}

	public void setMulta(Multa multa) {
		this.multa = multa;
	}

	
}