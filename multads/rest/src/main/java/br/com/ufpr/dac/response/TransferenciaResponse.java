package br.com.ufpr.dac.response;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



public class TransferenciaResponse {

	private int id;
	private VeiculoResponse veiculo;
	private PessoaResponse pessoaOrigem;
	private PessoaResponse pessoaDestino;
	private Date dataTransferencia;
	private float valor;
	
	public TransferenciaResponse(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public VeiculoResponse getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoResponse veiculo) {
		this.veiculo = veiculo;
	}

	public PessoaResponse getPessoaOrigem() {
		return pessoaOrigem;
	}

	public void setPessoaOrigem(PessoaResponse pessoaOrigem) {
		this.pessoaOrigem = pessoaOrigem;
	}

	public PessoaResponse getPessoaDestino() {
		return pessoaDestino;
	}

	public void setPessoaDestino(PessoaResponse pessoaDestino) {
		this.pessoaDestino = pessoaDestino;
	}

	public Date getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(Date dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof TransferenciaResponse)) return false;

        // Property checks.
        TransferenciaResponse other = (TransferenciaResponse) object;
        return Objects.equals(id, other.id)
            && Objects.equals(veiculo, other.veiculo)
            && Objects.equals(pessoaOrigem, other.pessoaOrigem)
            && Objects.equals(pessoaDestino, other.pessoaDestino)
            && Objects.equals(dataTransferencia, other.dataTransferencia)
            && Objects.equals(valor, other.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, veiculo, pessoaOrigem, pessoaDestino,dataTransferencia,valor);
    }
	
}
