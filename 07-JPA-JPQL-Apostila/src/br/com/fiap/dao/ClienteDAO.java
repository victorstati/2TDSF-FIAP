package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	List<Cliente> pesquisar();
	
	List<Cliente> pesquisar(String nome);
	
	List<Cliente> pesquisa(String estado);
	
	List<Cliente> pesquisarPorDiaReserva(int dias);
	
	List<Cliente> buscar(String nome, String cidade);
	
	List<Cliente> buscarPorEstados(List<String>estados);
}
