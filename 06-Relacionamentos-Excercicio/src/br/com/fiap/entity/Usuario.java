package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_USUARIO")
@SequenceGenerator(name="usuario", sequenceName="SQ_T_USUARIO", allocationSize=1)
public class Usuario {

	@Id
	@Column(name="cd_usuario")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuario")
	private int codigo;
	
	@Column(name="nm_usuario")
	private String nome;
	
	@ManyToMany(mappedBy="usuarios")
	private List<ItemTeste> itemTestes;
	
	

	public Usuario() {
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

	public List<ItemTeste> getItemTestes() {
		return itemTestes;
	}

	public void setItemTestes(List<ItemTeste> itemTestes) {
		this.itemTestes = itemTestes;
	}
	
	
}
