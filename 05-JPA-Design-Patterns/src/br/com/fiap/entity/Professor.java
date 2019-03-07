package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PROFESSOR")
@SequenceGenerator(allocationSize=1, sequenceName="SQ_T_PROFESSOR", name="professor")
public class Professor {
	
	@Id
	@Column(name="cd_professor")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="professor")
	private int id;

	@Column(name="nm_professor", nullable=false)
	private String nome;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Column(name="nr_cpf", length=11)
	private String cpf;
	

	public Professor(int id, String nome, byte[] foto, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.foto = foto;
		this.cpf = cpf;
	}

	public Professor(String nome, byte[] foto, String cpf) {
		super();
		this.nome = nome;
		this.foto = foto;
		this.cpf = cpf;
	}

	public Professor() {
		super();
	}

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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
