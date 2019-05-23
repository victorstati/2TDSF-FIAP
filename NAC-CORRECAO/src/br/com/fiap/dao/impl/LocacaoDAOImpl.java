package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LocacaoDAO;
import br.com.fiap.entity.Locacao;
import br.com.fiap.entity.LocacaoPK;

public class LocacaoDAOImpl extends GenericDAOImpl<Locacao, LocacaoPK> implements LocacaoDAO{

	public LocacaoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Locacao> buscarPorData(Calendar inicio, Calendar fim) {
		return em.createQuery("from Locacao l where l.data between :i and :f", Locacao.class)
				.setParameter("i", inicio)
				.setParameter("f", fim)
				.getResultList();
	}

	@Override
	public long contarPorCliente(int codiCliente) {
		return em.createQuery("select count(l) from Locacao l where l.cliente.codigo = :c", Long.class)
				.setParameter("c", codiCliente)
				.getSingleResult();
	}

}
