package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_GERENTE")
@SequenceGenerator(name="gerente", sequenceName="SQ_T_GERENTE", allocationSize=1)
public class Gerente {

	@Id
	@Column(name="cd_gerente")
	private int codigo;
	
	@OneToOne(mappedBy="gerente")
	private Departamento departamento;
	
	@Column(name="nm_gerente")
	private String nome;
	
	@Column(name="ds_nivel")
	@Enumerated(EnumType.STRING)
	private Nivel nivel;
}
