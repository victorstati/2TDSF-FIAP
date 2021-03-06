package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public abstract class GenericDAOImpl<Tabela, Chave> implements GenericDAO<Tabela, Chave>{

	private EntityManager em;
	
	private Class<Tabela> clazz;
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<Tabela>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void cadastar(Tabela entidade) {
		em.persist(entidade);
	}

	@Override
	public void atualizar(Tabela entidade) {
		em.merge(entidade);
	}

	@Override
	public void excluir(Chave id) throws CodigoInexistenteException {
		Tabela entidade = pesquisar(id);
		em.remove(entidade);
	}

	@Override
	public Tabela pesquisar(Chave id) throws CodigoInexistenteException {
		Tabela entidade = em.find(clazz, id);
		if(entidade == null) {
			throw new CodigoInexistenteException();
		}
		return entidade;
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}


	
	

}
