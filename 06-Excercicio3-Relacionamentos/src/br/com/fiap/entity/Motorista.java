package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_MOTORISTA")
@SequenceGenerator(name="motorista", sequenceName="SQ_T_MOTORISTA", allocationSize=1)
public class Motorista {

	@Id
	@Column(name="nr_carteira")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="motorista")
	private int numCarteira;
	
	@Column(name="nm_motorista", length=150, nullable=false)
	private String nome;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@Lob
	@Column(name="fl_carteira")
	private byte[] foto;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero")
	private Genero genero;
	
	@OneToMany(mappedBy="motorista")
	private List<Corrida> corridas;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="T_VEICULO_MOTORISTA",
	joinColumns = @JoinColumn(name="cd_motorista"),
	inverseJoinColumns = @JoinColumn(name="cd_veiculo"))
	private List<Veiculo> veiculos;
	
	public Motorista() {
		super();
	}
	
	public Motorista(int numCarteira, String nome, Calendar dataNascimento, byte[] foto, Genero genero,
			List<Veiculo> veiculos) {
		super();
		this.numCarteira = numCarteira;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.foto = foto;
		this.genero = genero;
		this.veiculos = veiculos;
	}

	public Motorista(long numeroCarteira, String nome, Calendar dataNascimento, byte[] foto, Genero genero) {
		super();
		this.numCarteira = numCarteira;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.foto = foto;
		this.genero = genero;
	}

	public int getNumCarteira() {
		return numCarteira;
	}

	public void setNumCarteira(int numCarteira) {
		this.numCarteira = numCarteira;
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

	public List<Corrida> getCorridas() {
		return corridas;
	}

	public void setCorridas(List<Corrida> corridas) {
		this.corridas = corridas;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	
	
}
