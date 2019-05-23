package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_NAC_LOCACAO")
@IdClass(value=LocacaoPK.class)
public class Locacao {

	@Id
	@Column(name="cd_locacao")
	@GeneratedValue(generator="locacao", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="locacao", sequenceName="SEQ_NAC_LOCACAO", allocationSize=1)
	private int codigo;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cd_cliente")
	private Cliente cliente;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cd_imovel")
	private Imovel imovel;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_locacao", nullable=false)
	private Calendar data;
	
	@Column(name="vl_locacao", nullable=false)
	private double valor;
	
	

	public Locacao(Cliente cliente, Imovel imovel, Calendar data, double valor) {
		super();
		this.cliente = cliente;
		this.imovel = imovel;
		this.data = data;
		this.valor = valor;
	}

	public Locacao() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
