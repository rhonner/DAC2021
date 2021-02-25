package br.com.ufpr.dac.persistence;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipoinfracao")
public class TipoInfracao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "pontuacao")
	private int pontuacao;
	@Column(name = "valor")
	private float valor;
	
	@OneToMany(mappedBy = "tipoinfracao",fetch = FetchType.LAZY)
	private List<Infracao> infracoes;
	

	public List<Infracao> getInfracoes() {
		return infracoes;
	}

	public void setInfracoes(List<Infracao> infracoes) {
		this.infracoes = infracoes;
	}

	public TipoInfracao() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
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
        if (!(object instanceof TipoInfracao)) return false;

        // Property checks.
        TipoInfracao other = (TipoInfracao) object;
        return Objects.equals(id, other.id)
            && Objects.equals(descricao, other.descricao)
            && Objects.equals(pontuacao, other.pontuacao)
            && Objects.equals(valor, other.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, pontuacao, valor);
    }
	
	
	
}
