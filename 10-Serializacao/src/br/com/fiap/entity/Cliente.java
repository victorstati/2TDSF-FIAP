package br.com.fiap.entity;

import java.io.Serializable;

public class Cliente implements Serializable{


	private static final long serialVersionUID = 6810028347124104302L;

	private String nome;
	
	private String cpf;
	
	private double saldo;
	
	public Cliente(String nome, String cpf, double saldo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.saldo = saldo;
	}

	public Cliente() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
