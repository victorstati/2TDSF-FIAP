package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Locacao;
import br.com.fiap.entity.LocacaoPK;

public interface LocacaoDAO extends GenericDAO<Locacao, LocacaoPK>{

	List<Locacao> buscarPorData(Calendar inicio, Calendar fim);
	
	long contarPorCliente(int codiCliente);
}
