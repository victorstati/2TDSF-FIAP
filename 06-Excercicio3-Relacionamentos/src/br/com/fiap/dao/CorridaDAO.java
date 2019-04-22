package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Corrida;
import br.com.fiap.entity.Motorista;

public interface CorridaDAO extends GenericDAO<Corrida, Integer>{

	List<Corrida> pesquisaPorData(Calendar inicio, Calendar fim);
	
	List<Corrida> pesquisaPorMotorista(Motorista motorista);
	
	List<Corrida> pesquisaPorPassageiro(int passageiro);
	
	List<Corrida> pesquisaPorNomePassageiro(String nome);
}
