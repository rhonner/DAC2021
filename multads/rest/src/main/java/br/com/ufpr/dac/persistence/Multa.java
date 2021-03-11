package br.com.ufpr.dac.persistence;

import java.sql.Timestamp;
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


@Entity
@Table(name = "multa")
public class Multa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "renavam")
	private String renavam;
	@Column(name = "documento")
	private String documento;
	@Column(name = "datamulta")
	private Timestamp datamulta;
	@Column(name = "descricao")
	private String descricao;
	
	@ManyToOne()
	@JoinColumn(name = "idinfracao")
	private Infracao infracao;
	
	@OneToOne(mappedBy = "multa",cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	public Multa() {}

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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Timestamp getDatamulta() {
		return datamulta;
	}

	public void setDatamulta(Timestamp datamulta) {
		this.datamulta = datamulta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Infracao getInfracao() {
		return infracao;
	}

	public void setInfracao(Infracao infracao) {
		this.infracao = infracao;
	}

	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof Multa)) return false;

        // Property checks.
        Multa other = (Multa) object;
        return Objects.equals(id, other.id)
            && Objects.equals(renavam, other.renavam)
            && Objects.equals(documento, other.documento)
            && Objects.equals(datamulta, other.datamulta)
            && Objects.equals(descricao, other.descricao)
            && Objects.equals(infracao, other.infracao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, renavam, documento, datamulta, descricao, infracao);
    }
	
}
