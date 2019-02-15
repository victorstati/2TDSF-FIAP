package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name="T_PRODUTO")
@SequenceGenerator(name="produto", sequenceName="SQ_T_PROTUDO", allocationSize=1)
public class Produto {
	
	@Id
	@Column(name="cd_produto")
	@GeneratedValue(generator="produto",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_produto", nullable=false, length=50)
	private String nome;
	
	@Column(name="qt_produto", nullable=false)
	private int quantidade;

	@Column(name="ds_estado")
	@Enumerated(EnumType.STRING)//STRING = nome da constante
	private Estado estado;
	
	@Column(name="dt_validade")
	@Temporal(value=TemporalType.DATE)
	private Calendar dataValidade;
	
	@Column(name="dt_fabricacao")
	@Temporal(value=TemporalType.DATE)//somete a data
	private Calendar dataFabricacao;
	
	@Column(updatable=false)
	@Temporal(value=TemporalType.TIMESTAMP)//data e hora
	@CreationTimestamp//cria automaticamente a data do cadastro 
	private Calendar dataCadastro;
	
	@Column(name="vl_produto", nullable=false)
	private float preco;
	
	@Transient//n�o ser� coluna na base de dados
	private int idade;
	
	@Lob
	private byte[] imagem;
	
	
	public Produto(int codigo, String nome, int quantidade, Estado estado, Calendar dataValidade,
			Calendar dataFabricacao, float preco, byte[] imagem) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.quantidade = quantidade;
		this.estado = estado;
		this.dataValidade = dataValidade;
		this.dataFabricacao = dataFabricacao;
		this.preco = preco;
		this.imagem = imagem;
	}


	public Produto(String nome, int quantidade, Estado estado, Calendar dataValidade, Calendar dataFabricacao,
			float preco, byte[] imagem) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.estado = estado;
		this.dataValidade = dataValidade;
		this.dataFabricacao = dataFabricacao;
		this.preco = preco;
		this.imagem = imagem;
	}
	

	public Produto() {
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Calendar dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	
	
}
