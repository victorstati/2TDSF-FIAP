package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.dao.impl.VeiculoDAOImpl;
import br.com.fiap.exception.CodigoInexistenteException;
import br.com.fiap.exception.CommitException;

public class RemoverTesteVeiculo {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		VeiculoDAO dao = new VeiculoDAOImpl(em);
		
		try {
			dao.remover(1);
			dao.commit();
		}catch(CodigoInexistenteException e) {
			e.printStackTrace();
			System.err.println("Código inexixtente");
		}catch(CommitException e) {
			e.printStackTrace();
			System.err.println("Erro ao remover veículo");
		}
		
		em.close();
		fabrica.close();
	}

}
