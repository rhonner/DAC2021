package br.com.ufpr.dac.response;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class VeiculoResponse {

	private int id;
	private String renavam;
	private String chassi;
	private String anoFabricacao;
	private String anoModelo;
	private String combustivel;
	private String cor;
	private String placa;
	
	private PessoaResponse pessoa;
	private CarroResponse carro;
	private List<TransferenciaResponse> transferencia;
	
	public VeiculoResponse(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public PessoaResponse getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaResponse pessoa) {
		this.pessoa = pessoa;
	}

	public CarroResponse getCarro() {
		return carro;
	}

	public void setCarro(CarroResponse carro) {
		this.carro = carro;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object==this) return true;
		if (!(object instanceof VeiculoResponse)) return false;
		
		VeiculoResponse other = (VeiculoResponse) object;
		return Objects.equals(id, other.id)
		&& Objects.equals(renavam, other.renavam)
		&& Objects.equals(chassi, other.chassi)
		&& Objects.equals(anoFabricacao, other.anoFabricacao)
		&& Objects.equals(anoModelo, other.anoModelo)
		&& Objects.equals(combustivel, other.combustivel)
		&& Objects.equals(cor, other.cor)
		&& Objects.equals(placa, other.placa)
		&& Objects.equals(pessoa, other.pessoa)
		&& Objects.equals(carro, other.carro)
		&& Objects.equals(transferencia, other.transferencia);
	}
    public int hashCode() {
        return Objects.hash(id, renavam, chassi, anoFabricacao,anoModelo,combustivel,cor,placa,pessoa,carro,transferencia);
    }
	
}
