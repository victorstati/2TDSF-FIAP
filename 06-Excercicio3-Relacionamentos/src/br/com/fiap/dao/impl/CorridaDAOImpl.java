package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CorridaDAO;
import br.com.fiap.entity.Corrida;
import br.com.fiap.entity.Motorista;

public class CorridaDAOImpl extends GenericDAOImpl<Corrida, Integer> implements CorridaDAO{

	public CorridaDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Corrida> pesquisaPorData(Calendar inicio, Calendar fim) {
		return em.createQuery("from Corrida c where c.data between :i and :f", Corrida.class)
				.setParameter("i", inicio)
				.setParameter("f", fim)
				.getResultList();
	}

	@Override
	public List<Corrida> pesquisaPorMotorista(Motorista motorista) {
		return em.createQuery("select m.corridas from Motorista m where m.codigo = :c", Corrida.class)
				.setParameter("c", motorista)
				.getResultList();
	}

	@Override
	public List<Corrida> pesquisaPorPassageiro(int passageiro) {
		return em.createQuery("select p.corridas from Passageiro p where p.codigo = :c", Corrida.class)
				.setParameter("c", passageiro)
				.getResultList();
	}

	@Override
	public List<Corrida> pesquisaPorNomePassageiro(String nome) {
		return em.createQuery("select p.corridas from Passageiro p where p.nome like :n", Corrida.class)
				.setParameter("n", "%"+nome+"%")
				.getResultList();
	}

}
