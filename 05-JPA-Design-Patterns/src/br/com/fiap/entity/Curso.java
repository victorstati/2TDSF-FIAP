package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 * @author victor
 *T_CURSO(SQ_T_CURSO)
 *	*cd_curso	NUMBER (PK)
 *	*nm_curso	VARCHAR(15)
 *	*dt_lancamento 	DATE
 *	*ds_categoria	VARCHAR	(Enum: tecnico, bacharel, pos)
 */

@Entity
@Table(name="T_CURSO")
@SequenceGenerator(allocationSize=1, name="curso", sequenceName="SQ_T_CURSO")
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="curso")
	@Column(name="cd_curso")
	private int codigo;
	
	@Column(name="nm_curso", length=15, nullable=false)
	private String nome;
	
	@Column(name="dt_lancamento", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar lancamento;
	
	@Column(name="ds_categoria", nullable=false)
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	
	public Curso(String nome, Calendar lancamento, Categoria categoria) {
		super();
		this.nome = nome;
		this.lancamento = lancamento;
		this.categoria = categoria;
	}
	
	
	public Curso(int codigo, String nome, Calendar lancamento, Categoria categoria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.lancamento = lancamento;
		this.categoria = categoria;
	}

	public Curso() {
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

	public Calendar getLancamento() {
		return lancamento;
	}

	public void setLancamento(Calendar lancamento) {
		this.lancamento = lancamento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

}
