package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_NAC_IMOVEL")
@SecondaryTable(name="T_NAC-ENDERECO")
@SequenceGenerator(name="imovel", sequenceName="SEQ_NAC_IMOVEL", allocationSize=1)
public class Imovel {

	@Id
	@Column(name="cd_imovel")
	@GeneratedValue(generator="imovel", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Column(name="ds_detalhes", nullable=false, length=500)
	private String descricao;
	
	@Column(name="ds_logradouro", table="T_NAC_ENDERECO", nullable=false, length=100)
	private String logradouro;
	
	@Column(name="nr_cep", table="T_NAC_ENDERECO", nullable=false)
	private int cep;
	
	@OneToMany(mappedBy="imovel")
	private List<Locacao> locacoes;
	

	public Imovel(byte[] foto, String descricao, String logradouro, int cep) {
		super();
		this.foto = foto;
		this.descricao = descricao;
		this.logradouro = logradouro;
		this.cep = cep;
	}

	public Imovel() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}
	
	
}
