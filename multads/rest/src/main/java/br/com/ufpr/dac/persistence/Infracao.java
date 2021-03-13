package br.com.ufpr.dac.persistence;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "infracao")
public class Infracao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "descricao")
	private String descricao;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idtipo")
	private TipoInfracao tipoinfracao;

	@JsonIgnore
	@OneToMany(mappedBy = "infracao")
	private List<Multa> multas;

	public Infracao() {
	}

	public List<Multa> getMultas() {
		return multas;
	}

	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}

	public TipoInfracao getTipoinfracao() {
		return tipoinfracao;
	}

	public void setTipoinfracao(TipoInfracao tipoinfracao) {
		this.tipoinfracao = tipoinfracao;
	}

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

	@Override
	public boolean equals(Object object) {
		// Basic checks.
		if (object == this)
			return true;
		if (!(object instanceof Infracao))
			return false;

		// Property checks.
		Infracao other = (Infracao) object;
		return Objects.equals(id, other.id) && Objects.equals(tipoinfracao, other.tipoinfracao)
				&& Objects.equals(descricao, other.descricao);

	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tipoinfracao, descricao);
	}

}
