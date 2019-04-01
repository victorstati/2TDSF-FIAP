package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_SISTEMA")
@SequenceGenerator(name="sistema", sequenceName="SQ_T_SISTEMA", allocationSize=1)
public class Sistema {

	@Id
	@Column(name="cd_sistema")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sistema")
	private int codigo;
	
	@Column(name="nm_sistema")
	private String nome;
	
	@OneToMany(mappedBy="sistema", cascade=CascadeType.PERSIST)
	private List<CasoTeste> casoTestes;
	
	

	public Sistema() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CasoTeste> getCasoTestes() {
		return casoTestes;
	}

	public void setCasoTestes(List<CasoTeste> casoTestes) {
		this.casoTestes = casoTestes;
	}
	
	
}
