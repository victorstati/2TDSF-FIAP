package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.dao.impl.VeiculoDAOImpl;
import br.com.fiap.entity.Veiculo;
import br.com.fiap.exception.CommitException;

public class AtualizaTesteVeiculo {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		VeiculoDAO dao = new VeiculoDAOImpl(em);
		
		Veiculo veiculo = new Veiculo(1, "dao-123", "branco", 2010);
		
		try {
			dao.atualizar(veiculo);
			dao.commit();
		}catch(CommitException e) {
			e.printStackTrace();
			System.err.println("Erro ao atualizar");
		}

		em.close();
		fabrica.close();
	}

}
