package br.com.fiap.entity;

import java.io.Serializable;

public class LocacaoPK implements Serializable{

	private int codigo;
	
	private int cliente;
	
	private int imovel;
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public int getImovel() {
		return imovel;
	}

	public void setImovel(int imovel) {
		this.imovel = imovel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cliente;
		result = prime * result + codigo;
		result = prime * result + imovel;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocacaoPK other = (LocacaoPK) obj;
		if (cliente != other.cliente)
			return false;
		if (codigo != other.codigo)
			return false;
		if (imovel != other.imovel)
			return false;
		return true;
	}
	
	
}
