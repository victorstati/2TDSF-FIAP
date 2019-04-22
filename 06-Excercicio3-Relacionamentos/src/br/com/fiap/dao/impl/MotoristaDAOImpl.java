package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.entity.Motorista;

public class MotoristaDAOImpl extends GenericDAOImpl<Motorista, Integer> implements MotoristaDAO {

	public MotoristaDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Motorista> pesquisaPorNome(String nome) {
		return em.createQuery("from Motorista m where m.nome like :n", Motorista.class)
				.setParameter("n", "%"+nome+"%")
				.getResultList();
	}

	
}