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
import javax.persistence.OneToOne;
import javax.persistence.Table;



public class PessoaResponse {
		

	private int id;
	private String nome;
	private String email;
	private String logradouro;
	private String cep;
	private String complemento;
	private String documento;
	
	private CidadeResponse cidade;
	private UsuarioResponse usuario;
	private TransferenciaResponse transferencia;
	private List<VeiculoResponse> veiculos;
	
	public PessoaResponse() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public CidadeResponse getCidade() {
		return cidade;
	}

	public void setCidade(CidadeResponse cidade) {
		this.cidade = cidade;
	}

	public UsuarioResponse getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioResponse usuario) {
		this.usuario = usuario;
	}
	
	public TransferenciaResponse getTransferencia() {
		return transferencia;
	}

	public void setTransferencia(TransferenciaResponse transferencia) {
		this.transferencia = transferencia;
	}

	public List<VeiculoResponse> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<VeiculoResponse> veiculos) {
		this.veiculos = veiculos;
	}

	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof PessoaResponse)) return false;

        // Property checks.
        PessoaResponse other = (PessoaResponse) object;
        return Objects.equals(id, other.id)
            && Objects.equals(documento, other.documento)
            && Objects.equals(nome, other.nome)
            && Objects.equals(email, other.email)
            && Objects.equals(usuario, other.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documento, nome, email, usuario);
    }

	
	
}

