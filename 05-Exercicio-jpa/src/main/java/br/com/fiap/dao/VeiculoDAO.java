package br.com.fiap.dao;

import br.com.fiap.entity.Veiculo;

public interface VeiculoDAO {

	void cadastrar(Veiculo veiculo);
	
	void atualizar(Veiculo veiculo);
	
	void remover(int codigo);
	
	Veiculo pesquisar(int codigo); 
}
