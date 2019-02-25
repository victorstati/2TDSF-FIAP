package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_MOTORISTA")
public class Motorista {

	@Id
	@Column(name="nr_carteira", nullable=false)
	private int numeroCarteira;
	
	@Column(name="nm_motorista", length=150, nullable=false)
	private String nome;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar nascimento;
	
	@Lob
	@Column(name="fl_carteira")
	private byte[] foto;
	
	@Enumerated
	@Column(name="ds_genero")
	private Genero genero;

	
	public Motorista(int numeroCarteira, String nome, Calendar nascimento, byte[] foto, Genero genero) {
		super();
		this.numeroCarteira = numeroCarteira;
		this.nome = nome;
		this.nascimento = nascimento;
		this.foto = foto;
		this.genero = genero;
	}

	public Motorista() {
		super();
	}

	public int getNumeroCarteira() {
		return numeroCarteira;
	}

	public void setNumeroCarteira(int numeroCarteira) {
		this.numeroCarteira = numeroCarteira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
}
