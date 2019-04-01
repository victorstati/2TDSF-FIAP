package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_FUNCIONARIO")
@SequenceGenerator(name="funcionario", sequenceName="SQ_T_FUNCIONARIO", allocationSize=1)
public class Funcionario {

	@Id
	@Column(name="cd_funcionario")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="funcionario")
	private int codigo;
	@Column(name="nm_funcionario", nullable=false, length=50)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@Column(name="vl_salario")
	private float salario;
	
	@ManyToOne
	@JoinColumn(name="cd_departamento")
	private Departamento departamento;
	
	//cadastrar os projetos
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="T_FUNCIONARIO_PROJETO", 
	joinColumns=@JoinColumn(name="cd_funcionario"),
	inverseJoinColumns = @JoinColumn(name="cd_projeto"))
	private List<Projeto> projetos;
	
	

	public Funcionario(String nome, Calendar dataNascimento, float salario) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
	}

	public Funcionario() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	
	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
}
