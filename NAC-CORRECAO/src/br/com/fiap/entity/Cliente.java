package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_NAC_CLIENTE")
@SequenceGenerator(name="cliente", sequenceName="SEQ_NAC_CLIENTE", allocationSize=1)
public class Cliente {

	@Id
	@Column(name="cd_cliente")
	@GeneratedValue(generator="cliente", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_cliente", length=50, nullable=false)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero")
	private Genero genero;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@OneToMany(mappedBy="cliente")
	private List<Locacao> locacoes;
	

	public Cliente(String nome, Genero genero, Calendar dataNascimento) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
	}

	public Cliente() {
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}
	
	
}
