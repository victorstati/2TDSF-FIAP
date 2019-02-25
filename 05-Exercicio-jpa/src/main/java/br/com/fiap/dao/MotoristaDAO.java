package br.com.fiap.dao;

import br.com.fiap.entity.Motorista;

public interface MotoristaDAO {

	void cadastrar(Motorista motorista);
	
	void atualizar(Motorista motorista);
	
	void remover(int codigo);
	
	Motorista pesquisar(int codigo);
}
